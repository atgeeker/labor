package com.busi.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busi.domain.SystemLog;
import com.busi.domain.User;
import com.busi.mapper.SystemLogMapper;

/**
 * @Transactional 默认配置下，spring只有在抛出的异常为运行时unchecked异常时才回滚该事务，
 * 也就是抛出的异常为RuntimeException的子类(Errors也会导致事务回滚)，而抛出checked异常则不会导致事务回滚。
 * 可以明确的配置在抛出那些异常时回滚事务，包括checked异常。也可以明确定义那些异常抛出时不回滚事务。
 * spring事务管理与<aop:aspectj-autoproxy proxy-target-class="true"/>是否配置没有关系，
 * 该配置只是在单纯的使用aop时才有用。
 * 
 * 记录系统日志
 * @author zzy
 *
 */
@Service
public class SystemLogServiceImpl implements SystemLogService{

	/**
	 * 默认ip地址
	 */
	private final static String defaultIpAddress = "127.0.0.1";

	/**
	 * 默认用户名称
	 */
	private final static String defaultUser = "dufaule_user";

	@Autowired
	private SystemLogMapper systemLogMapper;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	//@Transactional(rollbackFor=Exception.class)   //可以指定异常类型
	@Transactional
	public void saveLog(String message) throws Exception{
		User user = null;
		try{
			Subject subject = SecurityUtils.getSubject();
			user = (User)subject.getPrincipal();
		}catch(Exception e){
			log.error("获取登录用户信息异常->",e);
		}
			
		if(user == null){
			user = new User();
			user.setUsername(defaultUser);
			user.setIpaddress(defaultIpAddress);
		}
		if(log.isDebugEnabled()){
			log.debug("记录了日志!");
		}
		SystemLog systemLog = new SystemLog();
		systemLog.setUserName(user.getUsername());
		systemLog.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		systemLog.setIpAddress(user.getIpaddress());
		systemLog.setMessage(message);
		systemLog.setLogLevel("");
		try{
			systemLogMapper.insert(systemLog);
			//throw new Exception("声明事务异常回滚测试");
			}catch(Exception e){
				log.error("记录系统日志异常",e);
				e.printStackTrace();
				//throw new Exception("数据库错误");
				throw new RuntimeException("@Transactional默认值， 异常为RuntimeException 触发事务");
		}

	}

}
