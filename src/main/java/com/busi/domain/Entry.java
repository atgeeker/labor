package com.busi.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Entry implements Serializable {
    private Long id;

    private String name;

    private String post;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entrytime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date probationbegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date probationend;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractbegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractend;

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

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Date getProbationbegin() {
        return probationbegin;
    }

    public void setProbationbegin(Date probationbegin) {
        this.probationbegin = probationbegin;
    }

    public Date getProbationend() {
        return probationend;
    }

    public void setProbationend(Date probationend) {
        this.probationend = probationend;
    }

    public Date getContractbegin() {
        return contractbegin;
    }

    public void setContractbegin(Date contractbegin) {
        this.contractbegin = contractbegin;
    }

    public Date getContractend() {
        return contractend;
    }

    public void setContractend(Date contractend) {
        this.contractend = contractend;
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