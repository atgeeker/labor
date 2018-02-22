package com.busi.domain.vo;

import com.busi.util.excelutil.ExcelAnnotation;

/**
 * 导出 导入使用
 * @ClassName UserVo
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author zhuyangyong
 * @Date 2018年1月26日 上午11:49:18
 * @version 1.0.0
 */
public class UserVo {
	
	@ExcelAnnotation(name = "用户ID", column = "A", isExport = true)
	private Long id;

	@ExcelAnnotation(name = "用户名", column = "B", isExport = true)
    private String username;

	@ExcelAnnotation(name = "密码", column = "C", isExport = true)
    private String password;

	@ExcelAnnotation(name = "IP地址", column = "D", isExport = true)
    private String ipaddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	
}
