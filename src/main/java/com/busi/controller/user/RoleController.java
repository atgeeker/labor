package com.busi.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/management")
public class RoleController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/loadrolepage")
	public String loadPage(){
		log.info("加载页面");
		return "/busi/userman/addRole";
	}
	
	
	@RequestMapping("/queryrolepage")
	public String queryUserListPage(HttpServletRequest requst,HttpServletResponse response,Model model){
		return "/busi/userman/roleList";
	}
}
