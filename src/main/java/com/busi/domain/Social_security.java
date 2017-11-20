package com.busi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Social_security implements Serializable {
    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date insuredtime;

    private String idcardno;

    private BigDecimal base;

    private BigDecimal endowment;

    private BigDecimal nemployment;

    private BigDecimal maternity;

    private BigDecimal injury;

    private BigDecimal medical;

    private BigDecimal securitytotal;

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

    public Date getInsuredtime() {
        return insuredtime;
    }

    public void setInsuredtime(Date insuredtime) {
        this.insuredtime = insuredtime;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public BigDecimal getEndowment() {
        return endowment;
    }

    public void setEndowment(BigDecimal endowment) {
        this.endowment = endowment;
    }

    public BigDecimal getNemployment() {
        return nemployment;
    }

    public void setNemployment(BigDecimal nemployment) {
        this.nemployment = nemployment;
    }

    public BigDecimal getMaternity() {
        return maternity;
    }

    public void setMaternity(BigDecimal maternity) {
        this.maternity = maternity;
    }

    public BigDecimal getInjury() {
        return injury;
    }

    public void setInjury(BigDecimal injury) {
        this.injury = injury;
    }

    public BigDecimal getMedical() {
        return medical;
    }

    public void setMedical(BigDecimal medical) {
        this.medical = medical;
    }

    public BigDecimal getSecuritytotal() {
        return securitytotal;
    }

    public void setSecuritytotal(BigDecimal securitytotal) {
//        this.securitytotal = this.endowment.add(this.nemployment).add(this.maternity).add(this.injury).add(this.medical);
        this.securitytotal = securitytotal;
    }
}