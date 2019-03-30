package com.gwxtd.core.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderGoodsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public OrderGoodsCriteria() {
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

        public Criteria andOgidIsNull() {
            addCriterion("oGid is null");
            return (Criteria) this;
        }

        public Criteria andOgidIsNotNull() {
            addCriterion("oGid is not null");
            return (Criteria) this;
        }

        public Criteria andOgidEqualTo(Integer value) {
            addCriterion("oGid =", value, "ogid");
            return (Criteria) this;
        }

        public Criteria andOgidNotEqualTo(Integer value) {
            addCriterion("oGid <>", value, "ogid");
            return (Criteria) this;
        }

        public Criteria andOgidGreaterThan(Integer value) {
            addCriterion("oGid >", value, "ogid");
            return (Criteria) this;
        }

        public Criteria andOgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oGid >=", value, "ogid");
            return (Criteria) this;
        }

        public Criteria andOgidLessThan(Integer value) {
            addCriterion("oGid <", value, "ogid");
            return (Criteria) this;
        }

        public Criteria andOgidLessThanOrEqualTo(Integer value) {
            addCriterion("oGid <=", value, "ogid");
            return (Criteria) this;
        }

        public Criteria andOgidIn(List<Integer> values) {
            addCriterion("oGid in", values, "ogid");
            return (Criteria) this;
        }

        public Criteria andOgidNotIn(List<Integer> values) {
            addCriterion("oGid not in", values, "ogid");
            return (Criteria) this;
        }

        public Criteria andOgidBetween(Integer value1, Integer value2) {
            addCriterion("oGid between", value1, value2, "ogid");
            return (Criteria) this;
        }

        public Criteria andOgidNotBetween(Integer value1, Integer value2) {
            addCriterion("oGid not between", value1, value2, "ogid");
            return (Criteria) this;
        }

        public Criteria andOidIsNull() {
            addCriterion("OId is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("OId is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Integer value) {
            addCriterion("OId =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Integer value) {
            addCriterion("OId <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Integer value) {
            addCriterion("OId >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OId >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Integer value) {
            addCriterion("OId <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Integer value) {
            addCriterion("OId <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Integer> values) {
            addCriterion("OId in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Integer> values) {
            addCriterion("OId not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Integer value1, Integer value2) {
            addCriterion("OId between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Integer value1, Integer value2) {
            addCriterion("OId not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uId is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uId is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uId =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uId <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uId >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uId >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uId <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uId <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uId in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uId not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uId between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uId not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("gId is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gId is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gId =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gId <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gId >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gId >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gId <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gId <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gId in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gId not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gId between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gId not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andOgamountIsNull() {
            addCriterion("oGamount is null");
            return (Criteria) this;
        }

        public Criteria andOgamountIsNotNull() {
            addCriterion("oGamount is not null");
            return (Criteria) this;
        }

        public Criteria andOgamountEqualTo(Integer value) {
            addCriterion("oGamount =", value, "ogamount");
            return (Criteria) this;
        }

        public Criteria andOgamountNotEqualTo(Integer value) {
            addCriterion("oGamount <>", value, "ogamount");
            return (Criteria) this;
        }

        public Criteria andOgamountGreaterThan(Integer value) {
            addCriterion("oGamount >", value, "ogamount");
            return (Criteria) this;
        }

        public Criteria andOgamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("oGamount >=", value, "ogamount");
            return (Criteria) this;
        }

        public Criteria andOgamountLessThan(Integer value) {
            addCriterion("oGamount <", value, "ogamount");
            return (Criteria) this;
        }

        public Criteria andOgamountLessThanOrEqualTo(Integer value) {
            addCriterion("oGamount <=", value, "ogamount");
            return (Criteria) this;
        }

        public Criteria andOgamountIn(List<Integer> values) {
            addCriterion("oGamount in", values, "ogamount");
            return (Criteria) this;
        }

        public Criteria andOgamountNotIn(List<Integer> values) {
            addCriterion("oGamount not in", values, "ogamount");
            return (Criteria) this;
        }

        public Criteria andOgamountBetween(Integer value1, Integer value2) {
            addCriterion("oGamount between", value1, value2, "ogamount");
            return (Criteria) this;
        }

        public Criteria andOgamountNotBetween(Integer value1, Integer value2) {
            addCriterion("oGamount not between", value1, value2, "ogamount");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceIsNull() {
            addCriterion("oGtotalprice is null");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceIsNotNull() {
            addCriterion("oGtotalprice is not null");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceEqualTo(Double value) {
            addCriterion("oGtotalprice =", value, "ogtotalprice");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceNotEqualTo(Double value) {
            addCriterion("oGtotalprice <>", value, "ogtotalprice");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceGreaterThan(Double value) {
            addCriterion("oGtotalprice >", value, "ogtotalprice");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("oGtotalprice >=", value, "ogtotalprice");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceLessThan(Double value) {
            addCriterion("oGtotalprice <", value, "ogtotalprice");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceLessThanOrEqualTo(Double value) {
            addCriterion("oGtotalprice <=", value, "ogtotalprice");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceIn(List<Double> values) {
            addCriterion("oGtotalprice in", values, "ogtotalprice");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceNotIn(List<Double> values) {
            addCriterion("oGtotalprice not in", values, "ogtotalprice");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceBetween(Double value1, Double value2) {
            addCriterion("oGtotalprice between", value1, value2, "ogtotalprice");
            return (Criteria) this;
        }

        public Criteria andOgtotalpriceNotBetween(Double value1, Double value2) {
            addCriterion("oGtotalprice not between", value1, value2, "ogtotalprice");
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