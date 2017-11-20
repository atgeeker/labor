package com.busi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.busi.service.SalaryService;
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
import com.busi.domain.Salary;
import com.busi.domain.SalaryExample;
import com.busi.domain.SalaryExample.Criteria;
import com.busi.log.LOG;
import com.busi.mapper.SalaryMapper;
import com.busi.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/mansalary")
public class SalaryController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private SalaryService salaryService;

    /**
     * 删除工资信息
     *
     * @param request
     * @param response
     * @return
     */
    @LOG(message = "删除了工资信息")
    @RequiresPermissions("del")
    @RequestMapping(value = "/delsalary", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData delSalaryById(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String result = "删除失败";

        ReturnData returnData = new ReturnData();
        Salary salary = salaryService.querySalary(id);
        if (null != salary) {
        	SalaryExample example = new SalaryExample();
            Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            int re = salaryMapper.deleteByExample(example);
            if (1 == re) {
                result = "刪除成功";
            }
        }else{
        	result = "刪除失败，工资信息不存在";
        }
        returnData.setErrorMsg(result);
        return returnData;
    }

    /**
     * 添加工资信息
     *
     * @param request
     * @return
     */
    @LOG(message = "添加工资信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/addsalary", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData addSalary(Salary salary, HttpServletRequest request) {
        ReturnData returnData = new ReturnData();
        String name = salary.getName();
        log.info("添加工资信息：" + name);
        SalaryExample example = new SalaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        if (salaryMapper.countByExample(example) > 0) {
            log.info("姓名已经存在");
            returnData.setErrorMsg("姓名已经存在");
            return returnData;
        }
        salaryService.addSalary(salary, returnData);
        return returnData;
    }
    
    /**
     * 修改工资信息
     *
     * @param request
     * @param map
     * @return
     */
    @LOG(message = "修改工资信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/editsalary", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData editSalary(HttpServletRequest request, Salary salary, ModelMap map, HttpServletResponse response) {
    	ReturnData returnData = new ReturnData();
        log.info("修改工资信息");
        
        //根据id查询工资信息
        Salary eSalary = salaryService.querySalary(salary.getId());
        if(null == eSalary) {
        	returnData.setErrorMsg("工资信息不存在");
        	return returnData;
        }
        
        //非空检验
        if(salary.getName() != null && salary.getName().length()>0){
        	eSalary.setName(salary.getName());
        }else {
        	log.info("姓名为空");
        	returnData.setErrorMsg("姓名为空");
        	return returnData;
        }
        if(salary.getBase() != null){
        	eSalary.setBase(salary.getBase());
        }else {
        	returnData.setErrorMsg("基本工资为空");
        	return returnData;
        }
        if(salary.getAchievements() != null){
        	eSalary.setAchievements(salary.getAchievements());
        }else {
        	returnData.setErrorMsg("绩效为空");
        	return returnData;
        }
        if(salary.getEndowment() != null){
        	eSalary.setEndowment(salary.getEndowment());
        }else {
        	returnData.setErrorMsg("养老保险为空");
        	return returnData;
        }
        if(salary.getNemployment() != null){
        	eSalary.setNemployment(salary.getNemployment());
        }else {
        	returnData.setErrorMsg("失业保险为空");
        	return returnData;
        }
        if(salary.getMaternity() != null){
        	eSalary.setMaternity(salary.getMaternity());
        }else {
        	returnData.setErrorMsg("生育保险为空");
        	return returnData;
        }
        if(salary.getInjury() != null){
        	eSalary.setInjury(salary.getInjury());
        }else {
        	returnData.setErrorMsg("工伤保险为空");
        	return returnData;
        }
        if(salary.getMedical() != null){
        	eSalary.setMedical(salary.getMedical());
        }else {
        	returnData.setErrorMsg("医疗保险为空");
        	return returnData;
        }
        if(salary.getPayablesalary() != null){
        	eSalary.setPayablesalary(salary.getPayablesalary());
        }else {
        	returnData.setErrorMsg("应发工资为空");
        	return returnData;
        }
        if(salary.getRealsalary() != null){
        	eSalary.setRealsalary(salary.getRealsalary());
        }else {
        	returnData.setErrorMsg("实发工资为空");
        	return returnData;
        }
        if(salary.getState() != null && salary.getState().length()>0){
        	eSalary.setState(salary.getState());
        }else {
        	returnData.setErrorMsg("状态为空");
        	return returnData;
        }

        salaryService.editSalary(eSalary,returnData);
        return returnData;
    }

    /**
     * 返回工资信息列表
     * @return
     */
    @RequestMapping("/querysalarypage")
    public String querySalaryListPage() {
        return "/busi/salaryman/salaryList";
    }
    
    /**
     * 查询工资信息列表
     * @return
     */
    @RequestMapping("/querySalarys")
    @ResponseBody
    public Msg querySalarys(Model model) {
    	List<Salary> list = salaryService.querySalarys();
    	return Msg.success().add("salaryList", list);
    }
    
    /**
     * 根据ID查询工资信息
     * @return
     */
    @RequestMapping("/querysalarybyid/{id}")
    @ResponseBody
    public Msg querySalaryById(@PathVariable("id")Long id, Model model) {
    	Salary salary = salaryService.querySalary(id);
    	return Msg.success().add("salary", salary);
    }

    /**
     * 查询工资信息
     * 需要用解析为jackson的jar包
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/querysalary", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> querySalaryList(HttpServletRequest request, HttpServletResponse response,
                                             Model model) {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String name = request.getParameter("name");
        log.info("pageSize:" + pageSize + ";pageNumber:" + pageNumber + ";name:" + name);

        Page<Salary> page = PageHelper.startPage(pageNumber, pageSize);
        SalaryExample example = new SalaryExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }

        page = (Page<Salary>) salaryMapper.selectByExample(example);

        //model.addAttribute("users", page);
        log.info("size:" + page.getTotal());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());
        map.put("rows", page);
        return map;
    }
    
}
