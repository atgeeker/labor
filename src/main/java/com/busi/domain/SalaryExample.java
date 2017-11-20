package com.busi.domain;

import java.util.ArrayList;
import java.util.List;

public class SalaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalaryExample() {
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

        public Criteria andBaseIsNull() {
            addCriterion("base is null");
            return (Criteria) this;
        }

        public Criteria andBaseIsNotNull() {
            addCriterion("base is not null");
            return (Criteria) this;
        }

        public Criteria andBaseEqualTo(Long value) {
            addCriterion("base =", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotEqualTo(Long value) {
            addCriterion("base <>", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseGreaterThan(Long value) {
            addCriterion("base >", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseGreaterThanOrEqualTo(Long value) {
            addCriterion("base >=", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseLessThan(Long value) {
            addCriterion("base <", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseLessThanOrEqualTo(Long value) {
            addCriterion("base <=", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseIn(List<Long> values) {
            addCriterion("base in", values, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotIn(List<Long> values) {
            addCriterion("base not in", values, "base");
            return (Criteria) this;
        }

        public Criteria andBaseBetween(Long value1, Long value2) {
            addCriterion("base between", value1, value2, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotBetween(Long value1, Long value2) {
            addCriterion("base not between", value1, value2, "base");
            return (Criteria) this;
        }

        public Criteria andAchievementsIsNull() {
            addCriterion("achievements is null");
            return (Criteria) this;
        }

        public Criteria andAchievementsIsNotNull() {
            addCriterion("achievements is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementsEqualTo(Long value) {
            addCriterion("achievements =", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsNotEqualTo(Long value) {
            addCriterion("achievements <>", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsGreaterThan(Long value) {
            addCriterion("achievements >", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsGreaterThanOrEqualTo(Long value) {
            addCriterion("achievements >=", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsLessThan(Long value) {
            addCriterion("achievements <", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsLessThanOrEqualTo(Long value) {
            addCriterion("achievements <=", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsIn(List<Long> values) {
            addCriterion("achievements in", values, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsNotIn(List<Long> values) {
            addCriterion("achievements not in", values, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsBetween(Long value1, Long value2) {
            addCriterion("achievements between", value1, value2, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsNotBetween(Long value1, Long value2) {
            addCriterion("achievements not between", value1, value2, "achievements");
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

        public Criteria andEndowmentEqualTo(Long value) {
            addCriterion("endowment =", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentNotEqualTo(Long value) {
            addCriterion("endowment <>", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentGreaterThan(Long value) {
            addCriterion("endowment >", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentGreaterThanOrEqualTo(Long value) {
            addCriterion("endowment >=", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentLessThan(Long value) {
            addCriterion("endowment <", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentLessThanOrEqualTo(Long value) {
            addCriterion("endowment <=", value, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentIn(List<Long> values) {
            addCriterion("endowment in", values, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentNotIn(List<Long> values) {
            addCriterion("endowment not in", values, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentBetween(Long value1, Long value2) {
            addCriterion("endowment between", value1, value2, "endowment");
            return (Criteria) this;
        }

        public Criteria andEndowmentNotBetween(Long value1, Long value2) {
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

        public Criteria andNemploymentEqualTo(Long value) {
            addCriterion("nemployment =", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentNotEqualTo(Long value) {
            addCriterion("nemployment <>", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentGreaterThan(Long value) {
            addCriterion("nemployment >", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentGreaterThanOrEqualTo(Long value) {
            addCriterion("nemployment >=", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentLessThan(Long value) {
            addCriterion("nemployment <", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentLessThanOrEqualTo(Long value) {
            addCriterion("nemployment <=", value, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentIn(List<Long> values) {
            addCriterion("nemployment in", values, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentNotIn(List<Long> values) {
            addCriterion("nemployment not in", values, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentBetween(Long value1, Long value2) {
            addCriterion("nemployment between", value1, value2, "nemployment");
            return (Criteria) this;
        }

        public Criteria andNemploymentNotBetween(Long value1, Long value2) {
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

        public Criteria andMaternityEqualTo(Long value) {
            addCriterion("maternity =", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityNotEqualTo(Long value) {
            addCriterion("maternity <>", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityGreaterThan(Long value) {
            addCriterion("maternity >", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityGreaterThanOrEqualTo(Long value) {
            addCriterion("maternity >=", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityLessThan(Long value) {
            addCriterion("maternity <", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityLessThanOrEqualTo(Long value) {
            addCriterion("maternity <=", value, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityIn(List<Long> values) {
            addCriterion("maternity in", values, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityNotIn(List<Long> values) {
            addCriterion("maternity not in", values, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityBetween(Long value1, Long value2) {
            addCriterion("maternity between", value1, value2, "maternity");
            return (Criteria) this;
        }

        public Criteria andMaternityNotBetween(Long value1, Long value2) {
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

        public Criteria andInjuryEqualTo(Long value) {
            addCriterion("injury =", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryNotEqualTo(Long value) {
            addCriterion("injury <>", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryGreaterThan(Long value) {
            addCriterion("injury >", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryGreaterThanOrEqualTo(Long value) {
            addCriterion("injury >=", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryLessThan(Long value) {
            addCriterion("injury <", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryLessThanOrEqualTo(Long value) {
            addCriterion("injury <=", value, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryIn(List<Long> values) {
            addCriterion("injury in", values, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryNotIn(List<Long> values) {
            addCriterion("injury not in", values, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryBetween(Long value1, Long value2) {
            addCriterion("injury between", value1, value2, "injury");
            return (Criteria) this;
        }

        public Criteria andInjuryNotBetween(Long value1, Long value2) {
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

        public Criteria andMedicalEqualTo(Long value) {
            addCriterion("medical =", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalNotEqualTo(Long value) {
            addCriterion("medical <>", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalGreaterThan(Long value) {
            addCriterion("medical >", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalGreaterThanOrEqualTo(Long value) {
            addCriterion("medical >=", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalLessThan(Long value) {
            addCriterion("medical <", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalLessThanOrEqualTo(Long value) {
            addCriterion("medical <=", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalIn(List<Long> values) {
            addCriterion("medical in", values, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalNotIn(List<Long> values) {
            addCriterion("medical not in", values, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalBetween(Long value1, Long value2) {
            addCriterion("medical between", value1, value2, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalNotBetween(Long value1, Long value2) {
            addCriterion("medical not between", value1, value2, "medical");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryIsNull() {
            addCriterion("payablesalary is null");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryIsNotNull() {
            addCriterion("payablesalary is not null");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryEqualTo(Long value) {
            addCriterion("payablesalary =", value, "payablesalary");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryNotEqualTo(Long value) {
            addCriterion("payablesalary <>", value, "payablesalary");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryGreaterThan(Long value) {
            addCriterion("payablesalary >", value, "payablesalary");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryGreaterThanOrEqualTo(Long value) {
            addCriterion("payablesalary >=", value, "payablesalary");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryLessThan(Long value) {
            addCriterion("payablesalary <", value, "payablesalary");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryLessThanOrEqualTo(Long value) {
            addCriterion("payablesalary <=", value, "payablesalary");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryIn(List<Long> values) {
            addCriterion("payablesalary in", values, "payablesalary");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryNotIn(List<Long> values) {
            addCriterion("payablesalary not in", values, "payablesalary");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryBetween(Long value1, Long value2) {
            addCriterion("payablesalary between", value1, value2, "payablesalary");
            return (Criteria) this;
        }

        public Criteria andPayablesalaryNotBetween(Long value1, Long value2) {
            addCriterion("payablesalary not between", value1, value2, "payablesalary");
            return (Criteria) this;
        }

        public Criteria andRealsalaryIsNull() {
            addCriterion("realsalary is null");
            return (Criteria) this;
        }

        public Criteria andRealsalaryIsNotNull() {
            addCriterion("realsalary is not null");
            return (Criteria) this;
        }

        public Criteria andRealsalaryEqualTo(Long value) {
            addCriterion("realsalary =", value, "realsalary");
            return (Criteria) this;
        }

        public Criteria andRealsalaryNotEqualTo(Long value) {
            addCriterion("realsalary <>", value, "realsalary");
            return (Criteria) this;
        }

        public Criteria andRealsalaryGreaterThan(Long value) {
            addCriterion("realsalary >", value, "realsalary");
            return (Criteria) this;
        }

        public Criteria andRealsalaryGreaterThanOrEqualTo(Long value) {
            addCriterion("realsalary >=", value, "realsalary");
            return (Criteria) this;
        }

        public Criteria andRealsalaryLessThan(Long value) {
            addCriterion("realsalary <", value, "realsalary");
            return (Criteria) this;
        }

        public Criteria andRealsalaryLessThanOrEqualTo(Long value) {
            addCriterion("realsalary <=", value, "realsalary");
            return (Criteria) this;
        }

        public Criteria andRealsalaryIn(List<Long> values) {
            addCriterion("realsalary in", values, "realsalary");
            return (Criteria) this;
        }

        public Criteria andRealsalaryNotIn(List<Long> values) {
            addCriterion("realsalary not in", values, "realsalary");
            return (Criteria) this;
        }

        public Criteria andRealsalaryBetween(Long value1, Long value2) {
            addCriterion("realsalary between", value1, value2, "realsalary");
            return (Criteria) this;
        }

        public Criteria andRealsalaryNotBetween(Long value1, Long value2) {
            addCriterion("realsalary not between", value1, value2, "realsalary");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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