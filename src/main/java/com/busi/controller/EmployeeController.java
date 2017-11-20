package com.busi.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.busi.service.EmployeeService;
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
import com.busi.domain.Employee;
import com.busi.domain.EmployeeExample;
import com.busi.domain.EmployeeExample.Criteria;
import com.busi.log.LOG;
import com.busi.mapper.EmployeeMapper;
import com.busi.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/manemp")
public class EmployeeController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    /**
     * 添加员工
     *
     * @param request
     * @return
     */
    @LOG(message = "添加员工")
    @RequiresRoles("admin")
    @RequestMapping(value = "/addemployee", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData addEmployee(Employee employee, HttpServletRequest request) {
        ReturnData returnData = new ReturnData();
        String name = employee.getName();
        log.info("添加员工：" + name);
        EmployeeExample example = new EmployeeExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        if (employeeMapper.countByExample(example) > 0) {
            log.info("员工已经存在");
            returnData.setErrorMsg("员工已经存在");
            return returnData;
        }
        employeeService.addEmployee(employee, returnData);
        return returnData;
    }
    
    /**
     * 删除员工
     *
     * @param request
     * @param response
     * @return
     */
    @LOG(message = "删除了员工")
    @RequiresPermissions("del")
    @RequestMapping(value = "/delemployee", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData delUserById(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String result = "删除失败";


        ReturnData returnData = new ReturnData();
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        if (null != employee) {
        	EmployeeExample example = new EmployeeExample();
            Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            int re = employeeMapper.deleteByExample(example);
            if (1 == re) {
                result = "刪除成功";
            }
        }else{
        	result = "刪除失败，员工信息不存在";
        }
        returnData.setErrorMsg(result);
        return returnData;
    }

    /**
     * 修改员工信息
     *
     * @param request
     * @param map
     * @return
     */
    @LOG(message = "修改员工信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/editemployee", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ReturnData editEmp(HttpServletRequest request, Employee employee, ModelMap map, HttpServletResponse response) {
    	ReturnData returnData = new ReturnData();
        log.info("修改员工信息");
        
        //根据id查询工资信息
        Employee eEmployee = employeeService.queryEmployee(employee.getId());
        if(null == eEmployee) {
        	returnData.setErrorMsg("员工信息不存在");
        	return returnData;
        }
        
        //非空检验
        if(employee.getName() != null && employee.getName().length()>0){
        	eEmployee.setName(employee.getName());
        }else {
        	log.info("姓名为空");
        	returnData.setErrorMsg("姓名为空");
        	return returnData;
        }
        if(employee.getGender() != null && employee.getGender().length()>0){
        	eEmployee.setGender(employee.getGender());
        }else {
        	returnData.setErrorMsg("性别为空");
        	return returnData;
        }
        if(employee.getNation() != null && employee.getNation().length()>0){
        	eEmployee.setNation(employee.getNation());
        }else {
        	log.info("民族为空");
        	returnData.setErrorMsg("民族为空");
        	return returnData;
        }
        if(employee.getDegree() != null && employee.getDegree().length()>0){
        	eEmployee.setDegree(employee.getDegree());
        }else {
        	log.info("文化程度为空");
        	returnData.setErrorMsg("文化程度为空");
        	return returnData;
        }
        if(employee.getIdcardno() != null && employee.getIdcardno().length()>0){
        	eEmployee.setIdcardno(employee.getIdcardno());
        }else {
        	log.info("身份证为空");
        	returnData.setErrorMsg("身份证为空");
        	return returnData;
        }
        if(employee.getBirthday() != null){
        	eEmployee.setBirthday(employee.getBirthday());
        }else {
        	log.info("出生日期为空");
        	returnData.setErrorMsg("出生日期为空");
        	return returnData;
        }
        if(employee.getAddress() != null && employee.getAddress().length()>0){
        	eEmployee.setAddress(employee.getAddress());
        }else {
        	log.info("家庭住址为空");
        	returnData.setErrorMsg("家庭住址为空");
        	return returnData;
        }
        if(employee.getTel() != null && employee.getTel().length()>0){
        	eEmployee.setTel(employee.getTel());
        }else {
        	log.info("电话为空");
        	returnData.setErrorMsg("电话为空");
        	return returnData;
        }
        if(employee.getState() != null && employee.getState().length()>0){
        	eEmployee.setState(employee.getState());
        }else {
        	returnData.setErrorMsg("状态为空");
        	return returnData;
        }
        if(employee.getOrgname() != null){
        	eEmployee.setOrgname(employee.getOrgname());
        }else {
        	log.info("所属用功单位为空");
        	returnData.setErrorMsg("所属用功单位为空");
        	return returnData;
        }

        employeeService.editEmployee(eEmployee,returnData);
        
        return returnData;
    }

    /**
     * 查询员工列表
     * @return
     */
    @RequestMapping("/queryemployeepage")
    public String queryEmployeeListPage() {
        return "/busi/employee/employeeList";
    }

    /**
     * 查询员工信息
     * 需要用解析为jackson的jar包
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryemployee", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> queryEmployeeList(HttpServletRequest request, HttpServletResponse response,
                                             Model model) {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String name = request.getParameter("name");
        log.info("pageSize:" + pageSize + ";pageNumber:" + pageNumber + ";name:" + name);
        Page<Employee> page = PageHelper.startPage(pageNumber, pageSize);
        EmployeeExample example = new EmployeeExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }

        page = (Page<Employee>) employeeMapper.selectByExample(example);

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
    @RequestMapping("/queryempbyid/{id}")
    @ResponseBody
    public Msg queryEmployeeById(@PathVariable("id")Long id, Model model) {
    	Employee employee = employeeService.queryEmployee(id);
    	return Msg.success().add("emp", employee);
    }

}
