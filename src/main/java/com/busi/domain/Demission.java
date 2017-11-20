package com.busi.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Demission implements Serializable {
    private Long id;

    private String name;

    private String post;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applyleavetime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orgagreeleavetime;

    private Long orgid;

    private String orgname;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getApplyleavetime() {
        return applyleavetime;
    }

    public void setApplyleavetime(Date applyleavetime) {
        this.applyleavetime = applyleavetime;
    }

    public Date getOrgagreeleavetime() {
        return orgagreeleavetime;
    }

    public void setOrgagreeleavetime(Date orgagreeleavetime) {
        this.orgagreeleavetime = orgagreeleavetime;
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }
}