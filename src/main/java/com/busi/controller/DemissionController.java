package com.busi.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.busi.service.DemissionService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import com.busi.domain.Demission;
import com.busi.domain.DemissionExample;
import com.busi.domain.DemissionExample.Criteria;
import com.busi.log.LOG;
import com.busi.mapper.DemissionMapper;
import com.busi.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/mandemission")
public class DemissionController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DemissionMapper demissionMapper;

    @Autowired
    private DemissionService demissionService;

    /**
     * 添加离职信息
     *
     * @param request
     * @return
     */
    @LOG(message = "添加离职信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/adddemission", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData addDemission(Demission demission, HttpServletRequest request) {
        ReturnData returnData = new ReturnData();
        String name = demission.getName();
        log.info("添加离职信息：" + name);
        DemissionExample example = new DemissionExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        if (demissionMapper.countByExample(example) > 0) {
            log.info("姓名已经存在");
            returnData.setErrorMsg("姓名已经存在");
            return returnData;
        }
        demissionService.addDemission(demission, returnData);
        return returnData;
    }
    
    /**
     * 删除离职信息
     *
     * @param request
     * @param response
     * @return
     */
    @LOG(message = "删除了离职信息")
    @RequiresPermissions("del")
    @RequestMapping(value = "/deldemission", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData delUserById(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String result = "删除失败";


        ReturnData returnData = new ReturnData();
        Demission demission = demissionMapper.selectByPrimaryKey(id);
        if (null != demission) {
        	DemissionExample example = new DemissionExample();
            Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            int re = demissionMapper.deleteByExample(example);
            if (1 == re) {
                result = "刪除成功";
            }
        }else{
        	result = "刪除失败，离职信息信息不存在";
        }
        returnData.setErrorMsg(result);
        return returnData;
    }

    /**
     * 修改离职信息信息
     *
     * @param request
     * @param map
     * @return
     */
    @LOG(message = "修改离职信息信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/editdemission", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ReturnData editDemission(HttpServletRequest request, Demission demission, ModelMap map, HttpServletResponse response) {
    	ReturnData returnData = new ReturnData();
        log.info("修改离职信息信息");
        
        //根据id查询工资信息
        Demission eDemission = demissionService.queryDemission(demission.getId());
        if(null == eDemission) {
        	returnData.setErrorMsg("离职信息信息不存在");
        	return returnData;
        }
        
        //非空检验
        if(demission.getName() != null && demission.getName().length()>0){
        	eDemission.setName(demission.getName());
        }else {
        	log.info("姓名为空");
        	returnData.setErrorMsg("姓名为空");
        	return returnData;
        }
        if(demission.getPost() != null && demission.getPost().length()>0){
        	eDemission.setPost(demission.getPost());
        }else {
        	log.info("工作岗位为空");
        	returnData.setErrorMsg("工作岗位为空");
        	return returnData;
        }
        if(demission.getApplyleavetime() != null){
        	eDemission.setApplyleavetime(demission.getApplyleavetime());
        }else {
        	log.info("申请离职时间为空");
        	returnData.setErrorMsg("申请离职时间为空");
        	return returnData;
        }
        if(demission.getOrgagreeleavetime() != null){
        	eDemission.setOrgagreeleavetime(demission.getOrgagreeleavetime());
        }else {
        	log.info("单位同意离职时间为空");
        	returnData.setErrorMsg("单位同意离职时间为空");
        	return returnData;
        }
        if(demission.getOrgname() != null){
        	eDemission.setOrgname(demission.getOrgname());
        }else {
        	log.info("所属用功单位为空");
        	returnData.setErrorMsg("所属用功单位为空");
        	return returnData;
        }

        demissionService.editDemission(eDemission,returnData);
        
        return returnData;
    }

    /**
     * 查询离职信息列表
     * @return
     */
    @RequestMapping("/querydemissionpage")
    public String queryDemissionListPage() {
        return "/busi/demission/demissionList";
    }

    /**
     * 查询离职信息信息
     * 需要用解析为jackson的jar包
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/querydemission", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> queryDemissionList(HttpServletRequest request, HttpServletResponse response,
                                             Model model) {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String name = request.getParameter("name");
        log.info("pageSize:" + pageSize + ";pageNumber:" + pageNumber + ";name:" + name);
        Page<Demission> page = PageHelper.startPage(pageNumber, pageSize);
        DemissionExample example = new DemissionExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }

        page = (Page<Demission>) demissionMapper.selectByExample(example);

        log.info("size:" + page.getTotal());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());
        map.put("rows", page);
        return map;
    }
    
    
    /**
     * 根据ID查询工资信息
     * @return
     */
    @RequestMapping("/querydemissionbyid/{id}")
    @ResponseBody
    public Msg queryDemissionById(@PathVariable("id")Long id, Model model) {
    	Demission demission = demissionService.queryDemission(id);
    	return Msg.success().add("demission", demission);
    }

}
