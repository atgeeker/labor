package com.busi.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 定时任务使用参考
 * 是基于注解+xml配置的方式的使用的
 * @author zzy
 *
 */
@Component
public class ScheduledTask {
	
//	@Value("fixedRate")
//	private String fixedRate;
	
	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
	
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        int a = 0;
        log.info("The time is now {}", dateFormat.format(new Date()));
        /*try{
            int b = 1/a;
        }catch (Exception e){
            log.error("异常-->",e);
        }*/
    }
    
    public static void main(String[] args) throws Exception{
		Date date = new Date(System.currentTimeMillis());
		System.out.println(dateFormat.format(date));
		System.out.println("=======================");
		 Calendar calendar = Calendar.getInstance();
         calendar.setTime(date);
         calendar.add(Calendar.MONTH, 2);
         Date newEndTime = calendar.getTime();
         System.out.println(dateFormat.format(newEndTime));

            System.out.println("abcdef\nghi\t\nng");
	}
}
