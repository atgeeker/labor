package com.core.shiro.filter;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.busi.domain.User;
import com.busi.log.SystemLogService;
import com.busi.util.SystemUtil;

/**
 * 该过滤器用来处理登录成功时，没有按照shiro.xml文件中配置的successUrl配置的路径跳转URL
 * 
 * @author zzy
 *
 */
public class BaseFormAuthenticationFilter extends FormAuthenticationFilter{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SystemLogService systemLogService;
	
	@Override
	protected boolean isLoginSubmission(ServletRequest request,
			ServletResponse response) {
		// TODO Auto-generated method stub
		return super.isLoginSubmission(request, response);
	}

	/**
	 * 覆盖默认实现，打印日志便于调试，查看具体登录是什么错误。
	 *（可以扩展把错误写入数据库之类的。）
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		if (log.isDebugEnabled()) {
			Class<?> clazz = e.getClass();
			if (clazz.equals(AuthenticationException.class)) {
				log.debug(this.getStackTraceAsString(e));
			}
		}
		return super.onLoginFailure(token, e, request, response);
	}

	/**
	 * 处理登录成功后按照xml文件中配置的successUrl进行跳转
	 */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		String successUrl = this.getSuccessUrl();
		log.info("登陆成功后配置的跳转路径successUrl："+successUrl);
		User user = (User)subject.getPrincipal();
		user.setIpaddress(SystemUtil.getIpAddr(httpServletRequest));
		
		systemLogService.saveLog("登录了系统");
		
		//重定向到successUrl
		httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+this.getSuccessUrl());
		return false;
		//return super.onLoginSuccess(token, subject, request, response);
	}
	
	/**
	 * 将ErrorStack转化为String.
	 * @param e
	 * @return
	 */
	public static String getStackTraceAsString(Exception e) {
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();

	}

}
