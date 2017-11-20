package com.system;

import com.busi.domain.SystemLog;
import com.busi.domain.SystemLogExample;
import com.busi.domain.User;
import com.busi.domain.UserExample;
import com.busi.mapper.SystemLogMapper;
import com.busi.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统操作日志查询
 * Created by zzy on 2017/8/24.
 */
@Controller
public class OperationLogController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SystemLogMapper systemLogMapper;

    @RequestMapping("/operationlogpage")
    public String queryUserListPage() {
        return "/system/systemman/operationlog";
    }

    @RequestMapping(value = "/operationlogquery", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> queryUserList(HttpServletRequest request, HttpServletResponse response,
                                             Model model) {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String username = request.getParameter("username");
        log.info("pageSize:" + pageSize + ";pageNumber:" + pageNumber + ";username:" + username);
        Page<SystemLog> page = PageHelper.startPage(pageNumber, pageSize);
        SystemLogExample example = new SystemLogExample();
        SystemLogExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(username)) {
            criteria.andUserNameLike("%" + username + "%");
        }
        example.setOrderByClause("CREATE_TIME DESC");  //排序处理

        page = (Page<SystemLog>) systemLogMapper.selectByExample(example);

        log.info("size:" + page.getTotal());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());
        map.put("rows", page);
        return map;
    }

    /**
     * 查询日志
     * @return
     */
    @RequestMapping(value = "/log",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> queryLogPage(HttpServletRequest request) {

        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String username = request.getParameter("username");
        log.info("pageSize:" + pageSize + ";pageNumber:" + pageNumber + ";username:" + username);
        Page<SystemLog> page = PageHelper.startPage(pageNumber, pageSize);
        SystemLogExample example = new SystemLogExample();
        SystemLogExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(username)) {
            criteria.andUserNameLike("%" + username + "%");
        }
        example.setOrderByClause("CREATE_TIME DESC");  //排序处理
        page = (Page<SystemLog>) systemLogMapper.selectByExample(example);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());
        map.put("rows", page);
        return map;
    }

}
