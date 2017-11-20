####一、使用注解方式实现日志记录--AOP。
使用注解的方式记录系统日志，在spring mvc的控制器层添加注解，达到记录日志的功能。
重要：需要在springmvc-servlet.xml配置文件中启用aop的功能，<aop:aspectj-autoproxy proxy-target-class="true"/>，
如果不在spring mvc中加入该配置，日志记录是不会起作用的，主要应该还是spring和spring mvc的容器不一样的原因。

####二、