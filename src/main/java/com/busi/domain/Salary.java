package com.busi.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Salary implements Serializable {
    private Long id;

    private String name;

    private BigDecimal base;

    private BigDecimal achievements;

    private BigDecimal endowment;

    private BigDecimal nemployment;

    private BigDecimal maternity;

    private BigDecimal injury;

    private BigDecimal medical;

    private BigDecimal payablesalary;

    private BigDecimal realsalary;

    private String state;

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

	public BigDecimal getBase() {
		return base;
	}

	public void setBase(BigDecimal base) {
		this.base = base;
	}

	public BigDecimal getAchievements() {
		return achievements;
	}

	public void setAchievements(BigDecimal achievements) {
		this.achievements = achievements;
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

	public BigDecimal getPayablesalary() {
		return payablesalary;
	}

	public void setPayablesalary(BigDecimal payablesalary) {
		this.payablesalary = payablesalary;
	}

	public BigDecimal getRealsalary() {
		return realsalary;
	}

	public void setRealsalary(BigDecimal realsalary) {
		this.realsalary = realsalary;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}