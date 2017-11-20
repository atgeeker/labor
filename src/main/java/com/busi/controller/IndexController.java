package com.busi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.busi.domain.User;
import com.busi.log.LOG;

/**
 * 首页控制器
 * @author zzy
 *
 */
@Controller
@RequestMapping("/admin")
public class IndexController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value="/index",method={RequestMethod.POST,RequestMethod.GET})
	public String index(HttpServletRequest request,HttpServletResponse response,Model model ){
		log.info("去系统首页");
		//登录完成以后，可以从SecurityUtils获取登录的用户信息
		Subject subject = SecurityUtils.getSubject();
		
		Session session = subject.getSession();
		System.out.println(session.getTimeout());
		System.out.println(session.getId());
		System.out.println(session.getHost());
		
		User user = (User)subject.getPrincipal();
		model.addAttribute("user", user);
		return "/index/index";
	}
	@LOG
	@RequestMapping("/adduser")
	public String loadPage(HttpServletRequest request){
		log.info("加载添加用户页面");
		return "/busi/user/adduser";
	}
}
