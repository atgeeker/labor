package com.busi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.busi.service.OrganizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
import com.busi.domain.Organization;
import com.busi.domain.OrganizationExample;
import com.busi.domain.OrganizationExample.Criteria;
import com.busi.log.LOG;
import com.busi.mapper.OrganizationMapper;
import com.busi.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/manorg")
public class OrgController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrganizationMapper orgMapper;

    @Autowired
    private OrganizationService orgService;

    /**
     * 删除用工单位
     *
     * @param request
     * @param response
     * @return
     */
    @LOG(message = "删除了用工单位")
    @RequiresPermissions("del")
    @RequestMapping(value = "/delOrg", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData delOrgById(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String result = "删除失败";

        ReturnData returnData = new ReturnData();
        Organization org = orgService.queryOrg(id);
        if (null != org) {
        	OrganizationExample example = new OrganizationExample();
            Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            int re = orgMapper.deleteByExample(example);
            if (1 == re) {
                result = "刪除成功";
            }
        }
        returnData.setErrorMsg(result);
        return returnData;
    }

    /**
     * 添加用工单位
     *
     * @param request
     * @return
     */
    @LOG(message = "添加用工单位")
    @RequiresRoles("admin")
    @RequestMapping(value = "/addorg", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData addOrg(Organization org, HttpServletRequest request) {
        ReturnData returnData = new ReturnData();
        String name = org.getName();
        log.info("添加用工单位：" + name);
        OrganizationExample example = new OrganizationExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        if (orgMapper.countByExample(example) > 0) {
            log.info("用工单位名称已经存在");
            returnData.setErrorMsg("用工单位名称已经存在");
            return returnData;
        }
        orgService.addOrg(org, returnData);
        return returnData;
    }
    
    /**
     * 修改用工单位信息
     *
     * @param request
     * @param map
     * @return
     */
    @LOG(message = "修改用工单位信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/editorg", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData editOrg(HttpServletRequest request, Organization org, ModelMap map, HttpServletResponse response) {
    	ReturnData returnData = new ReturnData();
        log.info("修改用工单位信息");
        
        //根据id查询用工单位
        Organization organization = orgService.queryOrg(org.getId());
        if(null == organization) {
        	returnData.setErrorMsg("用工单位不存在");
        	return returnData;
        }
        
        OrganizationExample example = new OrganizationExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(org.getName());
        
        //非空检验
        if(org.getName() != null && org.getName().length()>0){
        	organization.setName(org.getName());
        }else {
        	log.info("用工单位名为空");
        	returnData.setErrorMsg("用工单位名为空");
        	return returnData;
        }
        if(org.getType() != null && org.getType().length()>0){
        	organization.setType(org.getType());
        }else {
        	returnData.setErrorMsg("用工单位类型为空");
        	return returnData;
        }
        if(org.getManager() != null && org.getManager().length()>0){
        	organization.setManager(org.getManager());
        }else {
        	returnData.setErrorMsg("用工单位负责人为空");
        	return returnData;
        }
        if(org.getTel() != null && org.getTel().length()>0){
        	organization.setTel(org.getTel());
        }else {
        	returnData.setErrorMsg("用工单位联系电话为空");
        	return returnData;
        }

        orgService.editOrg(organization,returnData);
        return returnData;
    }

    /**
     * 返回用工单位列表
     * @return
     */
    @RequestMapping("/queryorgpage")
    public String queryOrgListPage() {
        return "/busi/orgman/orgList";
    }
    
    /**
     * 查询用工单位列表
     * @return
     */
    @RequestMapping("/queryOrgs")
    @ResponseBody
    public Msg queryOrgs(Model model) {
    	List<Organization> list = orgService.queryOrgs();
    	return Msg.success().add("orgList", list);
    }
    
    /**
     * 根据ID查询用工单位
     * @return
     */
    @RequestMapping("/queryorgbyid/{id}")
    @ResponseBody
    public Msg queryOrgById(@PathVariable("id")Long id, Model model) {
    	Organization org = orgService.queryOrg(id);
    	return Msg.success().add("org", org);
    }

    /**
     * 查询用工单位信息
     * 需要用解析为jackson的jar包
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryorg", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> queryOrgList(HttpServletRequest request, HttpServletResponse response,
                                             Model model) {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String name = request.getParameter("name");
        log.info("pageSize:" + pageSize + ";pageNumber:" + pageNumber + ";name:" + name);

        Page<Organization> page = PageHelper.startPage(pageNumber, pageSize);
        OrganizationExample example = new OrganizationExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }

        page = (Page<Organization>) orgMapper.selectByExample(example);

        //model.addAttribute("users", page);
        log.info("size:" + page.getTotal());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());
        map.put("rows", page);
        return map;
    }
    
    /**
	 * 检查用工单位名是否可用
	 * @param empName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkorgname")
	public Msg checkOrgName(@RequestParam("name")String name){
		//先判断用工单位名是否是合法的表达式;
		String regx = "(^[a-zA-Z0-9_-]{1,16}$)|(^[\u4e00-\u9fa5]{1,20}$)";
		if(!name.matches(regx)){
			return Msg.fail().add("va_msg", "用工单位名必须是1-16位数字和字母的组合或者1-20位中文");
		}
		
		//数据库用工单位名重复校验
		boolean b = orgService.checkOrgName(name);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "用工单位名已存在");
		}
	}
	
}
