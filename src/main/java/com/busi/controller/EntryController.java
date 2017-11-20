package com.busi.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.busi.service.EntryService;
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
import com.busi.domain.Entry;
import com.busi.domain.EntryExample;
import com.busi.domain.EntryExample.Criteria;
import com.busi.log.LOG;
import com.busi.mapper.EntryMapper;
import com.busi.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/manentry")
public class EntryController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EntryMapper entryMapper;

    @Autowired
    private EntryService entryService;

    /**
     * 添加入职信息
     *
     * @param request
     * @return
     */
    @LOG(message = "添加入职信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/addentry", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData addEntry(Entry entry, HttpServletRequest request) {
        ReturnData returnData = new ReturnData();
        String name = entry.getName();
        log.info("添加入职信息：" + name);
        EntryExample example = new EntryExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        if (entryMapper.countByExample(example) > 0) {
            log.info("姓名已经存在");
            returnData.setErrorMsg("姓名已经存在");
            return returnData;
        }
        entryService.addEntry(entry, returnData);
        return returnData;
    }
    
    /**
     * 删除入职信息
     *
     * @param request
     * @param response
     * @return
     */
    @LOG(message = "删除了入职信息")
    @RequiresPermissions("del")
    @RequestMapping(value = "/delentry", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData delUserById(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String result = "删除失败";


        ReturnData returnData = new ReturnData();
        Entry entry = entryMapper.selectByPrimaryKey(id);
        if (null != entry) {
        	EntryExample example = new EntryExample();
            Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            int re = entryMapper.deleteByExample(example);
            if (1 == re) {
                result = "刪除成功";
            }
        }else{
        	result = "刪除失败，入职信息信息不存在";
        }
        returnData.setErrorMsg(result);
        return returnData;
    }

    /**
     * 修改入职信息信息
     *
     * @param request
     * @param map
     * @return
     */
    @LOG(message = "修改入职信息信息")
    @RequiresRoles("admin")
    @RequestMapping(value = "/editentry", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ReturnData editEntry(HttpServletRequest request, Entry entry, ModelMap map, HttpServletResponse response) {
    	ReturnData returnData = new ReturnData();
        log.info("修改入职信息信息");
        
        //根据id查询工资信息
        Entry eEntry = entryService.queryEntry(entry.getId());
        if(null == eEntry) {
        	returnData.setErrorMsg("入职信息信息不存在");
        	return returnData;
        }
        
        //非空检验
        if(entry.getName() != null && entry.getName().length()>0){
        	eEntry.setName(entry.getName());
        }else {
        	log.info("姓名为空");
        	returnData.setErrorMsg("姓名为空");
        	return returnData;
        }
        if(entry.getPost() != null && entry.getPost().length()>0){
        	eEntry.setPost(entry.getPost());
        }else {
        	log.info("工作岗位为空");
        	returnData.setErrorMsg("工作岗位为空");
        	return returnData;
        }
        if(entry.getEntrytime() != null){
        	eEntry.setEntrytime(entry.getEntrytime());
        }else {
        	log.info("入职时间为空");
        	returnData.setErrorMsg("入职时间为空");
        	return returnData;
        }
        if(entry.getProbationbegin() != null){
        	eEntry.setProbationbegin(entry.getProbationbegin());
        }else {
        	log.info("试用期开始时间为空");
        	returnData.setErrorMsg("试用期开始时间为空");
        	return returnData;
        }
        if(entry.getProbationend() != null){
        	eEntry.setProbationend(entry.getProbationend());
        }else {
        	log.info("试用期结束时间为空");
        	returnData.setErrorMsg("试用期结束时间为空");
        	return returnData;
        }
        if(entry.getContractbegin() != null){
        	eEntry.setContractbegin(entry.getContractbegin());
        }else {
        	log.info("合同开始时间为空");
        	returnData.setErrorMsg("合同开始时间为空");
        	return returnData;
        }
        if(entry.getContractend() != null){
        	eEntry.setContractend(entry.getContractend());
        }else {
        	log.info("合同结束时间为空");
        	returnData.setErrorMsg("合同结束时间为空");
        	return returnData;
        }
        if(entry.getOrgname() != null){
        	eEntry.setOrgname(entry.getOrgname());
        }else {
        	log.info("所属用功单位为空");
        	returnData.setErrorMsg("所属用功单位为空");
        	return returnData;
        }

        entryService.editEntry(eEntry,returnData);
        
        return returnData;
    }

    /**
     * 查询入职信息列表
     * @return
     */
    @RequestMapping("/queryentrypage")
    public String queryEntryListPage() {
        return "/busi/entry/entryList";
    }

    /**
     * 查询入职信息信息
     * 需要用解析为jackson的jar包
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryentry", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> queryEntryList(HttpServletRequest request, HttpServletResponse response,
                                             Model model) {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String name = request.getParameter("name");
        log.info("pageSize:" + pageSize + ";pageNumber:" + pageNumber + ";name:" + name);
        Page<Entry> page = PageHelper.startPage(pageNumber, pageSize);
        EntryExample example = new EntryExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }

        page = (Page<Entry>) entryMapper.selectByExample(example);

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
    @RequestMapping("/queryentrybyid/{id}")
    @ResponseBody
    public Msg queryEntryById(@PathVariable("id")Long id, Model model) {
    	Entry entry = entryService.queryEntry(id);
    	return Msg.success().add("entry", entry);
    }

}
