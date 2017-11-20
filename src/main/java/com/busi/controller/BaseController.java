package com.busi.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;

/**
 * 控制器基类
 * Created by zzy on 2017/8/25.
 */
@Controller
public class BaseController {

    /**
     * 想客户端发送响应数据
     * @param obj
     * @param response
     * @throws Exception
     */
    public void sendResponse(Object obj,HttpServletResponse response) throws Exception{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(obj);
    }
}
