package com.busi.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Social_securityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Social_securityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeIsNull() {
            addCriterion("insuredtime is null");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeIsNotNull() {
            addCriterion("insuredtime is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeEqualTo(Date value) {
            addCriterionForJDBCDate("insuredtime =", value, "insuredtime");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("insuredtime <>", value, "insuredtime");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("insuredtime >", value, "insuredtime");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insuredtime >=", value, "insuredtime");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeLessThan(Date value) {
            addCriterionForJDBCDate("insuredtime <", value, "insuredtime");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insuredtime <=", value, "insuredtime");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeIn(List<Date> values) {
            addCriterionForJDBCDate("insuredtime in", values, "insuredtime");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("insuredtime not in", values, "insuredtime");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insuredtime between", value1, value2, "insuredtime");
            return (Criteria) this;
        }

        public Criteria andInsuredtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insuredtime not between", value1, value2, "insuredtime");
            return (Criteria) this;
        }

        public Criteria andIdcardnoIsNull() {
            addCriterion("idcardno is null");
            return (Criteria) this;
        }

        public Criteria andIdcardnoIsNotNull() {
            addCriterion("idcardno is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardnoEqualTo(String value) {
            addCriterion("idcardno =", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoNotEqualTo(String value) {
            addCriterion("idcardno <>", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoGreaterThan(String value) {
            addCriterion("idcardno >", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoGreaterThanOrEqualTo(String value) {
            addCriterion("idcardno >=", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoLessThan(String value) {
            addCriterion("idcardno <", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoLessThanOrEqualTo(String value) {
            addCriterion("idcardno <=", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoLike(String value) {
            addCriterion("idcardno like", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoNotLike(String value) {
            addCriterion("idcardno not like", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoIn(List<String> values) {
            addCriterion("idcardno in", values, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoNotIn(List<String> values) {
            addCriterion("idcardno not in", values, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoBetween(String value1, String value2) {
            addCriterion("idcardno between", value1, value2, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoNotBetween(String value1, String value2) {
            addCriterion("idcardno not between", value1, value2, "idcardno");
            return (Criteria) this;
        }

        public Criteria andBaseIsNull() {
            addCriterion("base is null");
            return (Criteria) this;
        }

        public Criteria andBaseIsNotNull() {
            addCriterion("base is not null");
            return (Criteria) this;
        }

        public Criteria andBaseEqualTo(BigDecimal value) {
            addCriterion("base =", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotEqualTo(BigDecimal value) {
            addCriterion("base <>", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseGreaterThan(BigDecimal value) {
            addCriterion("base >", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("base >=", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseLessThan(BigDecimal value) {
            addCriterion("base <", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("base <=", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseIn(List<BigDecimal> values) {
            addCriterion("base in", values, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotIn(List<BigDecimal> values) {
            addCriterion("base not in", values, "base");
            return (Criteria) this;
        }

        public Criteria andBaseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base between", value1, value2, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base not between", value1, value2, "base");
            return (Criteria) this;
        }

        public Criteria andEndowmentIsNull() {
            addCriterion("endowment is null");
            return (Criteria) this;
        }

        public Criteria andEndowmentIsNotNull() {
            addCriterion("endowment is not null");
            return (Criteria) this;
        }

        public Criteria andEndowmentEqualTo(BigDecimal value) {
            addCriterion("endowment =", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentNotEqualTo(BigDecimal value) {
            addCriterion("endowment <>", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentGreaterThan(BigDecimal value) {
            addCriterion("endowment >", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("endowment >=", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentLessThan(BigDecimal value) {
            addCriterion("endowment <", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("endowment <=", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentIn(List<BigDecimal> values) {
            addCriterion("endowment in", values, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentNotIn(List<BigDecimal> values) {
            addCriterion("endowment not in", values, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("endowment between", value1, value2, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("endowment not between", value1, value2, "endowment");
            return (Criteria) this;
        }

        public Criteria andNemploymentIsNull() {
            addCriterion("nemployment is null");
            return (Criteria) this;
        }

        public Criteria andNemploymentIsNotNull() {
            addCriterion("nemployment is not null");
            return (Criteria) this;
        }

        public Criteria andNemploymentEqualTo(BigDecimal value) {
            addCriterion("nemployment =", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentNotEqualTo(BigDecimal value) {
            addCriterion("nemployment <>", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentGreaterThan(BigDecimal value) {
            addCriterion("nemployment >", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("nemployment >=", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentLessThan(BigDecimal value) {
            addCriterion("nemployment <", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("nemployment <=", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentIn(List<BigDecimal> values) {
            addCriterion("nemployment in", values, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentNotIn(List<BigDecimal> values) {
            addCriterion("nemployment not in", values, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nemployment between", value1, value2, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nemployment not between", value1, value2, "nemployment");
            return (Criteria) this;
        }

        public Criteria andMaternityIsNull() {
            addCriterion("maternity is null");
            return (Criteria) this;
        }

        public Criteria andMaternityIsNotNull() {
            addCriterion("maternity is not null");
            return (Criteria) this;
        }

        public Criteria andMaternityEqualTo(BigDecimal value) {
            addCriterion("maternity =", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityNotEqualTo(BigDecimal value) {
            addCriterion("maternity <>", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityGreaterThan(BigDecimal value) {
            addCriterion("maternity >", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("maternity >=", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityLessThan(BigDecimal value) {
            addCriterion("maternity <", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("maternity <=", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityIn(List<BigDecimal> values) {
            addCriterion("maternity in", values, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityNotIn(List<BigDecimal> values) {
            addCriterion("maternity not in", values, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maternity between", value1, value2, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maternity not between", value1, value2, "maternity");
            return (Criteria) this;
        }

        public Criteria andInjuryIsNull() {
            addCriterion("injury is null");
            return (Criteria) this;
        }

        public Criteria andInjuryIsNotNull() {
            addCriterion("injury is not null");
            return (Criteria) this;
        }

        public Criteria andInjuryEqualTo(BigDecimal value) {
            addCriterion("injury =", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryNotEqualTo(BigDecimal value) {
            addCriterion("injury <>", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryGreaterThan(BigDecimal value) {
            addCriterion("injury >", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("injury >=", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryLessThan(BigDecimal value) {
            addCriterion("injury <", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("injury <=", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryIn(List<BigDecimal> values) {
            addCriterion("injury in", values, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryNotIn(List<BigDecimal> values) {
            addCriterion("injury not in", values, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("injury between", value1, value2, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("injury not between", value1, value2, "injury");
            return (Criteria) this;
        }

        public Criteria andMedicalIsNull() {
            addCriterion("medical is null");
            return (Criteria) this;
        }

        public Criteria andMedicalIsNotNull() {
            addCriterion("medical is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalEqualTo(BigDecimal value) {
            addCriterion("medical =", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalNotEqualTo(BigDecimal value) {
            addCriterion("medical <>", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalGreaterThan(BigDecimal value) {
            addCriterion("medical >", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("medical >=", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalLessThan(BigDecimal value) {
            addCriterion("medical <", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("medical <=", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalIn(List<BigDecimal> values) {
            addCriterion("medical in", values, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalNotIn(List<BigDecimal> values) {
            addCriterion("medical not in", values, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medical between", value1, value2, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medical not between", value1, value2, "medical");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalIsNull() {
            addCriterion("securitytotal is null");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalIsNotNull() {
            addCriterion("securitytotal is not null");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalEqualTo(BigDecimal value) {
            addCriterion("securitytotal =", value, "securitytotal");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalNotEqualTo(BigDecimal value) {
            addCriterion("securitytotal <>", value, "securitytotal");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalGreaterThan(BigDecimal value) {
            addCriterion("securitytotal >", value, "securitytotal");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("securitytotal >=", value, "securitytotal");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalLessThan(BigDecimal value) {
            addCriterion("securitytotal <", value, "securitytotal");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("securitytotal <=", value, "securitytotal");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalIn(List<BigDecimal> values) {
            addCriterion("securitytotal in", values, "securitytotal");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalNotIn(List<BigDecimal> values) {
            addCriterion("securitytotal not in", values, "securitytotal");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("securitytotal between", value1, value2, "securitytotal");
            return (Criteria) this;
        }

        public Criteria andSecuritytotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("securitytotal not between", value1, value2, "securitytotal");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}