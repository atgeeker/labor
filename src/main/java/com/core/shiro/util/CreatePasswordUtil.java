package com.core.shiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import com.busi.domain.User;
/**
 * 密码生成工具类
 * @author zzy
 *
 */
@Component
public class CreatePasswordUtil {
	//@Value("${hashIterations}")
	private String hashIterations="2";
	private static String MD5="md5";
	private static String SHA1="SHA-1";
	/**
	 * 使用shiro的散列算法
	 * 散列算法 支持md5 SHA-1 SHA-2 默认是SHA-512
	 * @param sourcePwd
	 * @param salt
	 * @param hashIterations   //散列次数
	 * @return
	 */
	public String createPassword(String sourcePwd,String salt,int hashIterations){
		//return new SimpleHash(SHA1, sourcePwd, salt, hashIterations).toHex();//16进制
		return new SimpleHash(SHA1, sourcePwd, ByteSource.Util.bytes(salt), hashIterations).toHex();
		//return new SimpleHash(SHA1,sourcePwd).toHex();
	}
	
	/**
	 * 使用shiro的散列算法
	 * 散列算法 支持md5 SHA-1 SHA-2 默认是SHA-512
	 * @param sourcePwd
	 * @param salt
	 * @param hashIterations   //散列次数
	 * @return
	 */
	public String createPassword(User user){
		System.out.println("散列次数："+hashIterations);
		return new SimpleHash(SHA1,user.getPassword(), ByteSource.Util.bytes(user.getSalt()), Integer.parseInt(hashIterations)).toHex();
	}
	public static void main(String[] args) {
		//System.out.println(createPassword("11111111", "1234", 2));
		System.out.println(new CreatePasswordUtil().createPassword("shiro", "4shiro", 2));

	}
}
