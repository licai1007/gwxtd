package com.gwxtd.core.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdminCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public AdminCriteria() {
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

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andAidIsNull() {
            addCriterion("aId is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aId is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aId =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aId <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aId >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aId >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aId <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aId <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aId in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aId not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aId between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aId not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAnameIsNull() {
            addCriterion("aName is null");
            return (Criteria) this;
        }

        public Criteria andAnameIsNotNull() {
            addCriterion("aName is not null");
            return (Criteria) this;
        }

        public Criteria andAnameEqualTo(String value) {
            addCriterion("aName =", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotEqualTo(String value) {
            addCriterion("aName <>", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameGreaterThan(String value) {
            addCriterion("aName >", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameGreaterThanOrEqualTo(String value) {
            addCriterion("aName >=", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLessThan(String value) {
            addCriterion("aName <", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLessThanOrEqualTo(String value) {
            addCriterion("aName <=", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLike(String value) {
            addCriterion("aName like", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotLike(String value) {
            addCriterion("aName not like", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameIn(List<String> values) {
            addCriterion("aName in", values, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotIn(List<String> values) {
            addCriterion("aName not in", values, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameBetween(String value1, String value2) {
            addCriterion("aName between", value1, value2, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotBetween(String value1, String value2) {
            addCriterion("aName not between", value1, value2, "aname");
            return (Criteria) this;
        }

        public Criteria andApwdIsNull() {
            addCriterion("aPwd is null");
            return (Criteria) this;
        }

        public Criteria andApwdIsNotNull() {
            addCriterion("aPwd is not null");
            return (Criteria) this;
        }

        public Criteria andApwdEqualTo(String value) {
            addCriterion("aPwd =", value, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdNotEqualTo(String value) {
            addCriterion("aPwd <>", value, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdGreaterThan(String value) {
            addCriterion("aPwd >", value, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdGreaterThanOrEqualTo(String value) {
            addCriterion("aPwd >=", value, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdLessThan(String value) {
            addCriterion("aPwd <", value, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdLessThanOrEqualTo(String value) {
            addCriterion("aPwd <=", value, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdLike(String value) {
            addCriterion("aPwd like", value, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdNotLike(String value) {
            addCriterion("aPwd not like", value, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdIn(List<String> values) {
            addCriterion("aPwd in", values, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdNotIn(List<String> values) {
            addCriterion("aPwd not in", values, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdBetween(String value1, String value2) {
            addCriterion("aPwd between", value1, value2, "apwd");
            return (Criteria) this;
        }

        public Criteria andApwdNotBetween(String value1, String value2) {
            addCriterion("aPwd not between", value1, value2, "apwd");
            return (Criteria) this;
        }

        public Criteria andAlevelIsNull() {
            addCriterion("aLevel is null");
            return (Criteria) this;
        }

        public Criteria andAlevelIsNotNull() {
            addCriterion("aLevel is not null");
            return (Criteria) this;
        }

        public Criteria andAlevelEqualTo(String value) {
            addCriterion("aLevel =", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelNotEqualTo(String value) {
            addCriterion("aLevel <>", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelGreaterThan(String value) {
            addCriterion("aLevel >", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelGreaterThanOrEqualTo(String value) {
            addCriterion("aLevel >=", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelLessThan(String value) {
            addCriterion("aLevel <", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelLessThanOrEqualTo(String value) {
            addCriterion("aLevel <=", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelLike(String value) {
            addCriterion("aLevel like", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelNotLike(String value) {
            addCriterion("aLevel not like", value, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelIn(List<String> values) {
            addCriterion("aLevel in", values, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelNotIn(List<String> values) {
            addCriterion("aLevel not in", values, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelBetween(String value1, String value2) {
            addCriterion("aLevel between", value1, value2, "alevel");
            return (Criteria) this;
        }

        public Criteria andAlevelNotBetween(String value1, String value2) {
            addCriterion("aLevel not between", value1, value2, "alevel");
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