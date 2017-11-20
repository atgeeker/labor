package com.busi.util;

import java.io.IOException;
import java.util.Properties;
/**
 * 内部类实现单例 既能实现延迟加载 又无多线程问题
 * @author zzy
 *
 */
public class ConfigPropertiesUtil {
	private Properties properties;
	
	/**内部类实现单例 既能实现延迟加载 又无多线程问题*/
	private static class SingtonHolder{
		private static ConfigPropertiesUtil config = new ConfigPropertiesUtil();
	}
	
	private ConfigPropertiesUtil(){
		properties = new Properties();
		try {
			properties.load(ConfigPropertiesUtil.class.getResourceAsStream("/config/config.properties"));
		} catch (IOException e) {
			System.out.println("加载/config/config.properties配置文件...");
			e.printStackTrace();
		}
		
	}
	
	public static ConfigPropertiesUtil getInstance(){
		return SingtonHolder.config;
	}
	
	/** 重写clone()方法，禁止通过克隆创建新的对象*/
	@Override
	public ConfigPropertiesUtil clone(){
		return getInstance();
	}
	
	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}
	public String getProperty(String key,String defaultValue)
	{
		return properties.getProperty(key, defaultValue);
	}
	public int getPropertyForInt(String key)
	{
		return Integer.valueOf(properties.getProperty(key)).intValue();
	}
	public int getPropertyForInt(String key,String defaultValue)
	{
		return Integer.valueOf(properties.getProperty(key, defaultValue)).intValue();
	}
}
