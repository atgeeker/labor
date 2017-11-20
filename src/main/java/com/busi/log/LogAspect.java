package com.busi.log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 日志切面类，在控制器层使用@LOG,拦截该注解记录日志
 *
 * @author zzy
 */
@Component
@Aspect
public class LogAspect {

    @Autowired
    private SystemLogService systemLogService;

    private Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.busi.log.LOG)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        if (log.isDebugEnabled()) {
            log.debug("LogAspect.doBefore()");
        }

    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        if (null == joinPoint) {
            if (log.isDebugEnabled()) {
                log.debug("joinPoint is null!");
            }
            return;
        }
        if (log.isDebugEnabled()) {
            log.debug("LogAspect.doAfter()");
        }

        String message = "";
        try {
            MethodInvocationProceedingJoinPoint methodJoint = (MethodInvocationProceedingJoinPoint) joinPoint;
            Field proxy = methodJoint.getClass().getDeclaredField("methodInvocation");
            proxy.setAccessible(true);
            ReflectiveMethodInvocation j = (ReflectiveMethodInvocation) proxy.get(methodJoint);

            Method method = j.getMethod();
            if (method.isAnnotationPresent(LOG.class)) {
                LOG l = method.getAnnotation(LOG.class);
                if (null != l) {
                    message = l.message();
                }
            }
            if(log.isDebugEnabled()){
                log.debug("record message: "+message);
            }
            systemLogService.saveLog(message);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("记录日志异常-->", e);
        }
    }
}
