package com.core.shiro.entity;

/**
 * 角色实体
 * @author zzy
 *
 */
public class Role {
	private String name;
	private String desc;
	
	public Role(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
