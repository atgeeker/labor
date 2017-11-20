package com.busi.domain;

import java.io.Serializable;

public class Role implements Serializable {
    private Long id;

    private String roleName;

    private String status;

    private String discription;

    private String code;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", status="
				+ status + ", discription=" + discription + ", code=" + code
				+ "]";
	}
    
    
}