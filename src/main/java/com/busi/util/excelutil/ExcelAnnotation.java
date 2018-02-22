package com.busi.util.excelutil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @ClassName ExcelAnnotation
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author zhuyangyong
 * @Date 2018年1月26日 上午11:49:18
 * @version 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAnnotation {
	// excel导出时标题显示的名字，如果没有设置Annotation属性，将不会被导出和导入
	//public String exportName();
	/** 
     * 导出到Excel中的名字. 
     */  
    public abstract String name();  
  
    /** 
     * 配置列的名称,对应A,B,C,D.... 
     */  
    public abstract String column();  
  
    /** 
     * 提示信息 
     */  
    public abstract String prompt() default "";  
  
    /** 
     * 设置只能选择不能输入的列内容. 
     */  
    public abstract String[] combo() default {};  
  
    /** 
     * 是否导出数据,应对需求:有时我们需要导出一份模板,这是标题需要但内容需要用户手工填写. 
     */  
    public abstract boolean isExport() default true;  
}