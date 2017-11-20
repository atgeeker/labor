package com.busi.task.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.busi.util.ConfigPropertiesUtil;

/**
 * 使用aop环绕通知控制多个tomcat，只执行启动一个定时任务的功能(并不是真的只启动一个定时任务，只是启动了多个任务，让其中的一些任务停止执行)。
 * 以下实现是在config.propters中添加参数scheduled是否=true。如果是在真实环境，为了不修改代码，
 * 应该在tomcat中增加一个特殊文件用以进行控制。
 * ========================================================================================================================
 * 1） 目标方法的调用由环绕通知决定，即你可以决定是否调用目标方法，而前置和后置通知是不能决定的，
 * 他们只是在方法的调用前后执行通知而已，即目标方法肯定是要执行的。
 * 2） 环绕通知可以控制返回对象，即你可以返回一个与目标对象完全不同的返回值，虽然这很危险，但是你却可以办到。
 * 而后置方法是无法办到的，因为他是在目标方法返回值后调用。
 * 
 * @author zzy
 *
 */
@Component
@Aspect
public class ScheduledTaskAspect {
	
	private Logger log = LoggerFactory.getLogger(ScheduledTaskAspect.class);

	private static final String EXCUTE = "true";
	
	/**
	 * 使用环绕通知
	 */
	@Around("@annotation(org.springframework.scheduling.annotation.Scheduled)")
	public void checkIsExcuteTask(ProceedingJoinPoint jp) throws Throwable{
		String flag = ConfigPropertiesUtil.getInstance().getProperty("scheduled");
		
		if(EXCUTE.equals(flag)) {
			log.info("运行定时任务");
			jp.proceed();//执行目标方法
		}else {
			log.info("不运行定时任务");
		}
	}
}
