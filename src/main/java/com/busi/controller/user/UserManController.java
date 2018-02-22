package com.busi.controller.user;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.busi.controller.BaseController;
import com.busi.controller.Msg;
import com.busi.controller.ReturnData;
import com.busi.service.EntryService;
import com.busi.service.UserService;
import com.busi.util.SystemUtil;
import com.busi.util.excelutil.ExcelUtil;
import com.core.shiro.util.CreatePasswordUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.busi.domain.EntryExample;
import com.busi.domain.User;
import com.busi.domain.UserExample;
import com.busi.domain.UserExample.Criteria;
import com.busi.domain.vo.UserVo;
import com.busi.log.LOG;
import com.busi.mapper.UserMapper;
import com.busi.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/manuser")
public class UserManController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;
    
    @Autowired
    private CreatePasswordUtil createPasswordUtil;
    
    @Autowired
    private EntryService entryService;

    @RequestMapping("/loadadduserpage")
    public String loadPage() {

        log.info("加载添加用户页面");
        return "/busi/userman/adduser";
    }

    /**
     * 添加用户
     *
     * @param request
     * @return
     */
    @LOG(message = "添加用户")
    @RequiresRoles("admin")
    @RequestMapping(value = "/adduser", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData addUser(User user, HttpServletRequest request) {
        ReturnData returnData = new ReturnData();
        String username = user.getUsername();
        log.info("添加用户：" + username);
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        if (userMapper.countByExample(example) > 0) {
            log.info("用户已经存在");
            returnData.setErrorMsg("用户已经存在");
            return returnData;
        }
        user.setIpaddress(SystemUtil.getIpAddr(request));
        userService.addUser(user, returnData);
        return returnData;
    }

    /**
     * 删除用户
     *
     * @param request
     * @param response
     * @return
     */
    @LOG(message = "删除了用户")
    @RequiresPermissions("del")
    @RequestMapping(value = "/delUser", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData delUserById(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String result = "删除失败";

        Subject subject = SecurityUtils.getSubject();
        User loginUser = (User) subject.getPrincipal();
        String loginUserName = loginUser.getUsername();

        ReturnData returnData = new ReturnData();
        User user = userMapper.selectByPrimaryKey(id);
        if (null != user) {
            if (loginUserName.equals(user.getUsername())) {
                result = "用户不能删除自己";
            } else if ("admin".equals(user.getUsername())) {
                result = "不能删除超级用户";
            } else {
                UserExample example = new UserExample();
                Criteria criteria = example.createCriteria();
                criteria.andIdEqualTo(id);
                int re = userMapper.deleteByExample(example);
                if (1 == re) {
                    result = "刪除成功";
                }
            }
        }
        returnData.setErrorMsg(result);
        return returnData;
    }

    /**
     * 修改用户信息
     *
     * @param request
     * @param map
     * @return
     */
    @LOG(message = "修改用户信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/edituser", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ReturnData editUser(HttpServletRequest request, User user, ModelMap map, HttpServletResponse response) {
    	ReturnData returnData = new ReturnData();
    	log.info("修改用户信息");
    	
    	//根据id查询用户
        User eUser = userService.queryUser(user.getId());
        if(null == eUser) {
        	returnData.setErrorMsg("用户信息不存在");
        	return returnData;
        }
        
        //非空检验
        if(user.getUsername()!= null && user.getUsername().length()>0) {
        	eUser.setUsername(user.getUsername());
        }else {
        	log.info("用户名为空");
        	returnData.setErrorMsg("用户名为空");
        	return returnData;
        }
        if(user.getPassword()!= null && user.getPassword().length()>0) {
        	eUser.setPassword(createPasswordUtil.createPassword(eUser));
        }else {
        	log.info("密码为空");
        	returnData.setErrorMsg("密码为空");
        	return returnData;
        }
        userService.editUser(eUser,returnData);
        return returnData;
	}

    @RequestMapping("/queryuserpage")
    public String queryUserListPage(Model model) {
    	EntryExample entryExample = new EntryExample();
        com.busi.domain.EntryExample.Criteria criteriaEntry = entryExample.createCriteria();
        criteriaEntry.andNameLike("%");
        int countEntry = entryService.selectCount(entryExample);
    	model.addAttribute("countEntry", countEntry);
        return "/busi/userman/userList";
    }

    /**
     * 查询用户信息
     * 需要用解析为jackson的jar包
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryuser", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> queryUserList(HttpServletRequest request, HttpServletResponse response,
                                             ModelMap model) {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String username = request.getParameter("username");
        log.info("pageSize:" + pageSize + ";pageNumber:" + pageNumber + ";username:" + username);
//		if("0".equals(offset)){
//			offset = "1";
//		}
        Page<User> page = PageHelper.startPage(pageNumber, pageSize);
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }

        page = (Page<User>) userMapper.selectByExample(example);
        
        //model.addAttribute("users", page);
        log.info("size:" + page.getTotal());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());
        map.put("rows", page);
        return map;
    }
    
    /**
     * 导出用户信息
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/exportUserExcel", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles("admin")
    @ResponseBody
    public void exportUserExcel(HttpServletRequest request, HttpServletResponse response,
    		ModelMap model) {
    	try {
	    	String username = request.getParameter("username");
	    	List<UserVo> userList = new ArrayList<>();
	    	UserExample example = new UserExample();
	    	Criteria criteria = example.createCriteria();
	    	if (!StringUtils.isEmpty(username)) {
	    		criteria.andUsernameLike("%" + username + "%");
	    	}
	    	//查询用户列表
	    	userList = userMapper.exportUserExcel(example);
	    	if(userList != null && userList.size() > 0) {
				OutputStream out = null;
				try {
					String path = request.getRealPath("") + "//userExcel//tempPath//";
					File file = new File(path);// 导出文件存放的位置
					if (!file.exists()) {
						file.mkdirs();
					}
					String name = new String("user.xls".getBytes(), "ISO8859-1");
					out = new FileOutputStream(path + name);
					ExcelUtil<UserVo> util = new ExcelUtil<UserVo>(UserVo.class);
					util.exportExcel(userList, name, 60000, out);
					File file1 = new File(path + name);
					// 以流的形式下载文件。
					InputStream fis = new BufferedInputStream(new FileInputStream(path + name));
					byte[] buffer = new byte[fis.available()];
					fis.read(buffer);
					fis.close();
					// 清空response
					response.reset();
					// 设置response的Header
					response.addHeader("Content-Disposition", "attachment;filename=" + new String("用户信息".getBytes("UTF-8"), "ISO8859-1")+".xls");
					response.addHeader("Content-Length", "" + file1.length());
					OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
					response.setContentType("application/vnd.ms-excel;charset=utf-8");
					toClient.write(buffer);
					toClient.flush();
					toClient.close();
					if (file1.exists()) {
						file1.delete();
					}
				} catch (Exception e) {
					log.error(e.getMessage(),e);
				}finally{
					out.close();
				}
			}
    	} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
    	
    }

    @RequestMapping("/loadupload")
    public String loadUploadFilePage() {
        return "/busi/userman/uploadfile";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {

        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        //        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);

        return "/result";
    }
    
    /**
     * 根据ID查询用工单位
     * @return
     */
    @RequestMapping("/queryuserbyid/{id}")
    @ResponseBody
    public Msg queryUserById(@PathVariable("id")Long id, Model model) {
    	User user = userService.queryUser(id);
    	return Msg.success().add("user", user);
    }
}
