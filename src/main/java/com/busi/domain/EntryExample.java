package com.busi.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EntryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EntryExample() {
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

        public Criteria andPostIsNull() {
            addCriterion("post is null");
            return (Criteria) this;
        }

        public Criteria andPostIsNotNull() {
            addCriterion("post is not null");
            return (Criteria) this;
        }

        public Criteria andPostEqualTo(String value) {
            addCriterion("post =", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotEqualTo(String value) {
            addCriterion("post <>", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThan(String value) {
            addCriterion("post >", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThanOrEqualTo(String value) {
            addCriterion("post >=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThan(String value) {
            addCriterion("post <", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThanOrEqualTo(String value) {
            addCriterion("post <=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLike(String value) {
            addCriterion("post like", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotLike(String value) {
            addCriterion("post not like", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostIn(List<String> values) {
            addCriterion("post in", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotIn(List<String> values) {
            addCriterion("post not in", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostBetween(String value1, String value2) {
            addCriterion("post between", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotBetween(String value1, String value2) {
            addCriterion("post not between", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIsNull() {
            addCriterion("entrytime is null");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIsNotNull() {
            addCriterion("entrytime is not null");
            return (Criteria) this;
        }

        public Criteria andEntrytimeEqualTo(Date value) {
            addCriterionForJDBCDate("entrytime =", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("entrytime <>", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("entrytime >", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("entrytime >=", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeLessThan(Date value) {
            addCriterionForJDBCDate("entrytime <", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("entrytime <=", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIn(List<Date> values) {
            addCriterionForJDBCDate("entrytime in", values, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("entrytime not in", values, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("entrytime between", value1, value2, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("entrytime not between", value1, value2, "entrytime");
            return (Criteria) this;
        }

        public Criteria andProbationbeginIsNull() {
            addCriterion("probationbegin is null");
            return (Criteria) this;
        }

        public Criteria andProbationbeginIsNotNull() {
            addCriterion("probationbegin is not null");
            return (Criteria) this;
        }

        public Criteria andProbationbeginEqualTo(Date value) {
            addCriterionForJDBCDate("probationbegin =", value, "probationbegin");
            return (Criteria) this;
        }

        public Criteria andProbationbeginNotEqualTo(Date value) {
            addCriterionForJDBCDate("probationbegin <>", value, "probationbegin");
            return (Criteria) this;
        }

        public Criteria andProbationbeginGreaterThan(Date value) {
            addCriterionForJDBCDate("probationbegin >", value, "probationbegin");
            return (Criteria) this;
        }

        public Criteria andProbationbeginGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("probationbegin >=", value, "probationbegin");
            return (Criteria) this;
        }

        public Criteria andProbationbeginLessThan(Date value) {
            addCriterionForJDBCDate("probationbegin <", value, "probationbegin");
            return (Criteria) this;
        }

        public Criteria andProbationbeginLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("probationbegin <=", value, "probationbegin");
            return (Criteria) this;
        }

        public Criteria andProbationbeginIn(List<Date> values) {
            addCriterionForJDBCDate("probationbegin in", values, "probationbegin");
            return (Criteria) this;
        }

        public Criteria andProbationbeginNotIn(List<Date> values) {
            addCriterionForJDBCDate("probationbegin not in", values, "probationbegin");
            return (Criteria) this;
        }

        public Criteria andProbationbeginBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("probationbegin between", value1, value2, "probationbegin");
            return (Criteria) this;
        }

        public Criteria andProbationbeginNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("probationbegin not between", value1, value2, "probationbegin");
            return (Criteria) this;
        }

        public Criteria andProbationendIsNull() {
            addCriterion("probationend is null");
            return (Criteria) this;
        }

        public Criteria andProbationendIsNotNull() {
            addCriterion("probationend is not null");
            return (Criteria) this;
        }

        public Criteria andProbationendEqualTo(Date value) {
            addCriterionForJDBCDate("probationend =", value, "probationend");
            return (Criteria) this;
        }

        public Criteria andProbationendNotEqualTo(Date value) {
            addCriterionForJDBCDate("probationend <>", value, "probationend");
            return (Criteria) this;
        }

        public Criteria andProbationendGreaterThan(Date value) {
            addCriterionForJDBCDate("probationend >", value, "probationend");
            return (Criteria) this;
        }

        public Criteria andProbationendGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("probationend >=", value, "probationend");
            return (Criteria) this;
        }

        public Criteria andProbationendLessThan(Date value) {
            addCriterionForJDBCDate("probationend <", value, "probationend");
            return (Criteria) this;
        }

        public Criteria andProbationendLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("probationend <=", value, "probationend");
            return (Criteria) this;
        }

        public Criteria andProbationendIn(List<Date> values) {
            addCriterionForJDBCDate("probationend in", values, "probationend");
            return (Criteria) this;
        }

        public Criteria andProbationendNotIn(List<Date> values) {
            addCriterionForJDBCDate("probationend not in", values, "probationend");
            return (Criteria) this;
        }

        public Criteria andProbationendBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("probationend between", value1, value2, "probationend");
            return (Criteria) this;
        }

        public Criteria andProbationendNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("probationend not between", value1, value2, "probationend");
            return (Criteria) this;
        }

        public Criteria andContractbeginIsNull() {
            addCriterion("contractbegin is null");
            return (Criteria) this;
        }

        public Criteria andContractbeginIsNotNull() {
            addCriterion("contractbegin is not null");
            return (Criteria) this;
        }

        public Criteria andContractbeginEqualTo(Date value) {
            addCriterionForJDBCDate("contractbegin =", value, "contractbegin");
            return (Criteria) this;
        }

        public Criteria andContractbeginNotEqualTo(Date value) {
            addCriterionForJDBCDate("contractbegin <>", value, "contractbegin");
            return (Criteria) this;
        }

        public Criteria andContractbeginGreaterThan(Date value) {
            addCriterionForJDBCDate("contractbegin >", value, "contractbegin");
            return (Criteria) this;
        }

        public Criteria andContractbeginGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("contractbegin >=", value, "contractbegin");
            return (Criteria) this;
        }

        public Criteria andContractbeginLessThan(Date value) {
            addCriterionForJDBCDate("contractbegin <", value, "contractbegin");
            return (Criteria) this;
        }

        public Criteria andContractbeginLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("contractbegin <=", value, "contractbegin");
            return (Criteria) this;
        }

        public Criteria andContractbeginIn(List<Date> values) {
            addCriterionForJDBCDate("contractbegin in", values, "contractbegin");
            return (Criteria) this;
        }

        public Criteria andContractbeginNotIn(List<Date> values) {
            addCriterionForJDBCDate("contractbegin not in", values, "contractbegin");
            return (Criteria) this;
        }

        public Criteria andContractbeginBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("contractbegin between", value1, value2, "contractbegin");
            return (Criteria) this;
        }

        public Criteria andContractbeginNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("contractbegin not between", value1, value2, "contractbegin");
            return (Criteria) this;
        }

        public Criteria andContractendIsNull() {
            addCriterion("contractend is null");
            return (Criteria) this;
        }

        public Criteria andContractendIsNotNull() {
            addCriterion("contractend is not null");
            return (Criteria) this;
        }

        public Criteria andContractendEqualTo(Date value) {
            addCriterionForJDBCDate("contractend =", value, "contractend");
            return (Criteria) this;
        }

        public Criteria andContractendNotEqualTo(Date value) {
            addCriterionForJDBCDate("contractend <>", value, "contractend");
            return (Criteria) this;
        }

        public Criteria andContractendGreaterThan(Date value) {
            addCriterionForJDBCDate("contractend >", value, "contractend");
            return (Criteria) this;
        }

        public Criteria andContractendGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("contractend >=", value, "contractend");
            return (Criteria) this;
        }

        public Criteria andContractendLessThan(Date value) {
            addCriterionForJDBCDate("contractend <", value, "contractend");
            return (Criteria) this;
        }

        public Criteria andContractendLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("contractend <=", value, "contractend");
            return (Criteria) this;
        }

        public Criteria andContractendIn(List<Date> values) {
            addCriterionForJDBCDate("contractend in", values, "contractend");
            return (Criteria) this;
        }

        public Criteria andContractendNotIn(List<Date> values) {
            addCriterionForJDBCDate("contractend not in", values, "contractend");
            return (Criteria) this;
        }

        public Criteria andContractendBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("contractend between", value1, value2, "contractend");
            return (Criteria) this;
        }

        public Criteria andContractendNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("contractend not between", value1, value2, "contractend");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNull() {
            addCriterion("orgid is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("orgid is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(Long value) {
            addCriterion("orgid =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(Long value) {
            addCriterion("orgid <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(Long value) {
            addCriterion("orgid >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(Long value) {
            addCriterion("orgid >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(Long value) {
            addCriterion("orgid <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(Long value) {
            addCriterion("orgid <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(List<Long> values) {
            addCriterion("orgid in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(List<Long> values) {
            addCriterion("orgid not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(Long value1, Long value2) {
            addCriterion("orgid between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(Long value1, Long value2) {
            addCriterion("orgid not between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNull() {
            addCriterion("orgname is null");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNotNull() {
            addCriterion("orgname is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnameEqualTo(String value) {
            addCriterion("orgname =", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotEqualTo(String value) {
            addCriterion("orgname <>", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThan(String value) {
            addCriterion("orgname >", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("orgname >=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThan(String value) {
            addCriterion("orgname <", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThanOrEqualTo(String value) {
            addCriterion("orgname <=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLike(String value) {
            addCriterion("orgname like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotLike(String value) {
            addCriterion("orgname not like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameIn(List<String> values) {
            addCriterion("orgname in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotIn(List<String> values) {
            addCriterion("orgname not in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameBetween(String value1, String value2) {
            addCriterion("orgname between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotBetween(String value1, String value2) {
            addCriterion("orgname not between", value1, value2, "orgname");
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