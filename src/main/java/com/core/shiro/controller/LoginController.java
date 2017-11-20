package com.core.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.busi.util.StringUtils;

/**
 * 通过请求方式来判断是初始请求还是验证(登录)请求
 * 本质是@RequestMapping中的method为GET还是POST
 *
 */

@Controller
public class LoginController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 初始化请求
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginPage(){
        Subject subject = SecurityUtils.getSubject();
        //判断用户是否已经认证（登录）
        if (subject.isAuthenticated()) {
            log.info("用户 [" + subject.getPrincipal().toString() + "] 已经登陆成功，直接进入首页");
            return "redirect:/admin/index";
        }
        log.info("初始化登录页面");
        return "/login";
    }

    /**
     * 登录请求
     * 简单的登陆流程：
     * 1. login.jsp输入用户名和密码，提交url login
     * 2. FormAuthenticationFilter 过滤到login请求，判断是否登录，如果未登录执行executeLogin()方法，核心是调用subject.login(token)方法;
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
        try {

            /**
             * DisabledAccountException （禁用的帐号） LockedAccountException （锁定的帐号）
             * UnknownAccountException（错误的帐号）
             * ExcessiveAttemptsException（登录失败次数过多）
             * IncorrectCredentialsException （错误的凭证） ExpiredCredentialsException （过期的凭证）
             */
            // if("POST".equals(request.getMethod().toUpperCase())){
            // 登陆失败会把异常写入该属性,该属性在FormAuthenticationFilter类中
            String clickOut = request.getParameter("kickout");
            if (null != clickOut && "1".equals(clickOut)) {
                request.setAttribute("shiroLoginFailure", "你已经在其他地方进行登录，请重新登录");
            }

            String exceptionName = (String) request
                    .getAttribute("shiroLoginFailure");
            String errorDesc = null;
            log.info("exceptionName:" + exceptionName);
            if (!StringUtils.isEmpty(exceptionName)) {
                // 无效的凭证异常（密码错误）
                if (IncorrectCredentialsException.class.getName().equals(
                        exceptionName)) {
                    errorDesc = "密码错误";
                } else if (ExcessiveAttemptsException.class.getName().equals(
                        exceptionName)) {
                    errorDesc = "用户连续登录次数超限,锁定10分钟";
                } else if (UnknownAccountException.class.getName().equals(
                        exceptionName)) {
                    errorDesc = "用户不存在";
                } else if ("1".equals(clickOut)) {
                    errorDesc = exceptionName;
                } else {
                    errorDesc = "未知错误";
                }
                log.info("登录错误信息：" + errorDesc);
                model.addAttribute("loginError", errorDesc);
            }

            // }

            log.info("去登陆页面");
        } catch (Exception e) {
            log.error("异常", e);
        }

        return showLoginPage();
    }

/*    *//**
     * 处理登录
     *
     * @return
     *//*
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("dologin()..");
        try {
            // 如果登陆成功
            UsernamePasswordToken token = new UsernamePasswordToken(username,
                    password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (Exception e) {
            log.info("用户名密码错误", e);
            e.printStackTrace();
        }

        return "redirect:/mytest/test";
    }*/

    /**
     * 这里的主动退出问题，当我使用了shiro
     * 自定义的sessionid的时候，在applicationContext-shiro.xml文件中定义了shiro的退出过滤器，并且
     * 配置受保护的资源的级别是<!-- /logout=anon -->
     * ，退出的url【logout】已经被shiro的退出过滤器过滤了，之后又被重定向到 logout方法，再次执行
     * 退出，其实sessionid已经不存在，导致sessionid 找不到报错 异常
     * org.apache.shiro.session.UnknownSessionException。
     * 解决办法：直接使用shiro的logout过滤器进行退出即可,无需自己手动退出。
     */
    // @RequestMapping("/logout")
    // public String logout(RedirectAttributes redirectAttributes ){
    // //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
    // SecurityUtils.getSubject().logout();
    // log.info("用户退出");
    // redirectAttributes.addFlashAttribute("message", "您已安全退出");
    // return "redirect:/login";
    // }

    /**
     * @return
     */
    @RequestMapping("/403")
    public String error() {
        log.info("没有访问权限");
        return "/errors/403";
    }
}
