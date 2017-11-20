package com.busi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.busi.service.Social_securityService;
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
import com.busi.domain.Social_security;
import com.busi.domain.Social_securityExample;
import com.busi.domain.Social_securityExample.Criteria;
import com.busi.log.LOG;
import com.busi.mapper.Social_securityMapper;
import com.busi.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/mansecurity")
public class Social_securityController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Social_securityMapper securityMapper;

    @Autowired
    private Social_securityService securityService;

    /**
     * 删除社保信息
     *
     * @param request
     * @param response
     * @return
     */
    @LOG(message = "删除了社保信息")
    @RequiresPermissions("del")
    @RequestMapping(value = "/delsecurity", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData delSecurityById(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String result = "删除失败";

        ReturnData returnData = new ReturnData();
        Social_security security = securityService.querySecurity(id);
        if (null != security) {
        	Social_securityExample example = new Social_securityExample();
            Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            int re = securityMapper.deleteByExample(example);
            if (1 == re) {
                result = "刪除成功";
            }
        }else{
        	result = "刪除失败，社保信息不存在";
        }
        returnData.setErrorMsg(result);
        return returnData;
    }

    /**
     * 添加社保信息
     *
     * @param request
     * @return
     */
    @LOG(message = "添加社保信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/addsecurity", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData addSecurity(Social_security security, HttpServletRequest request) {
        ReturnData returnData = new ReturnData();
        String name = security.getName();
        log.info("添加社保信息：" + name);
        Social_securityExample example = new Social_securityExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        if (securityMapper.countByExample(example) > 0) {
            log.info("姓名已经存在");
            returnData.setErrorMsg("姓名已经存在");
            return returnData;
        }
        securityService.addSecurity(security, returnData);
        return returnData;
    }
    
    /**
     * 修改社保信息
     *
     * @param request
     * @param map
     * @return
     */
    @LOG(message = "修改社保信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/editsecurity", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData editSecurity(HttpServletRequest request, Social_security security, ModelMap map, HttpServletResponse response) {
    	ReturnData returnData = new ReturnData();
        log.info("修改社保信息");
        
        //根据id查询社保信息
        Social_security eSecurity = securityService.querySecurity(security.getId());
        if(null == eSecurity) {
        	returnData.setErrorMsg("社保信息不存在");
        	return returnData;
        }
        
        //非空检验
        if(security.getName() != null && security.getName().length()>0){
        	eSecurity.setName(security.getName());
        }else {
        	log.info("姓名为空");
        	returnData.setErrorMsg("姓名为空");
        	return returnData;
        }
        if(security.getInsuredtime() != null){
        	eSecurity.setInsuredtime(security.getInsuredtime());
        }else {
        	returnData.setErrorMsg("参保时间为空");
        	return returnData;
        }
        if(security.getIdcardno()!= null || security.getIdcardno().length()>0){
        	eSecurity.setIdcardno(security.getIdcardno());
        }else {
        	returnData.setErrorMsg("身份证号码为空");
        	return returnData;
        }
        if(security.getBase() != null){
        	eSecurity.setBase(security.getBase());
        }else {
        	returnData.setErrorMsg("缴费基数为空");
        	return returnData;
        }
        if(security.getEndowment() != null){
        	eSecurity.setEndowment(security.getEndowment());
        }else {
        	returnData.setErrorMsg("养老保险为空");
        	return returnData;
        }
        if(security.getNemployment() != null){
        	eSecurity.setNemployment(security.getNemployment());
        }else {
        	returnData.setErrorMsg("失业保险为空");
        	return returnData;
        }
        if(security.getMaternity() != null){
        	eSecurity.setMaternity(security.getMaternity());
        }else {
        	returnData.setErrorMsg("生育保险为空");
        	return returnData;
        }
        if(security.getInjury() != null){
        	eSecurity.setInjury(security.getInjury());
        }else {
        	returnData.setErrorMsg("工伤保险为空");
        	return returnData;
        }
        if(security.getMedical() != null){
        	eSecurity.setMedical(security.getMedical());
        }else {
        	returnData.setErrorMsg("医疗保险为空");
        	return returnData;
        }
        eSecurity.setSecuritytotal(security.getSecuritytotal());
        securityService.editSecurity(eSecurity,returnData);
        return returnData;
    }

    /**
     * 返回社保信息列表
     * @return
     */
    @RequestMapping("/querysecuritypage")
    public String querySecurityListPage() {
        return "/busi/securityman/securityList";
    }
    
    /**
     * 查询社保信息列表
     * @return
     */
    @RequestMapping("/querysecuritys")
    @ResponseBody
    public Msg querySecuritys(Model model) {
    	List<Social_security> list = securityService.querySecuritys();
    	return Msg.success().add("securityList", list);
    }
    
    /**
     * 根据ID查询社保信息
     * @return
     */
    @RequestMapping("/querysecuritybyid/{id}")
    @ResponseBody
    public Msg querySecurityById(@PathVariable("id")Long id, Model model) {
    	Social_security security = securityService.querySecurity(id);
    	return Msg.success().add("security", security);
    }

    /**
     * 查询社保信息
     * 需要用解析为jackson的jar包
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/querysecurity", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> querySecurityList(HttpServletRequest request, HttpServletResponse response,
                                             Model model) {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String name = request.getParameter("name");
        log.info("pageSize:" + pageSize + ";pageNumber:" + pageNumber + ";name:" + name);

        Page<Social_security> page = PageHelper.startPage(pageNumber, pageSize);
        Social_securityExample example = new Social_securityExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }

        page = (Page<Social_security>) securityMapper.selectByExample(example);

        //model.addAttribute("users", page);
        log.info("size:" + page.getTotal());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());
        map.put("rows", page);
        return map;
    }
    
}
