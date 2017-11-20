package com.busi.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LOG {
	/**
     * 要执行的操作类型,例如: add操作
     */
    public String operationType() default "";

    /**
     * 要执行的具体操作,例如: 添加用户
     */
    public String message() default "";
}
