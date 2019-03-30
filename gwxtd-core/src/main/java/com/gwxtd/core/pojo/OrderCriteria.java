package com.gwxtd.core.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public OrderCriteria() {
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

        public Criteria andOidIsNull() {
            addCriterion("oId is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oId is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Integer value) {
            addCriterion("oId =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Integer value) {
            addCriterion("oId <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Integer value) {
            addCriterion("oId >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oId >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Integer value) {
            addCriterion("oId <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Integer value) {
            addCriterion("oId <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Integer> values) {
            addCriterion("oId in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Integer> values) {
            addCriterion("oId not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Integer value1, Integer value2) {
            addCriterion("oId between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Integer value1, Integer value2) {
            addCriterion("oId not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOdateIsNull() {
            addCriterion("oDate is null");
            return (Criteria) this;
        }

        public Criteria andOdateIsNotNull() {
            addCriterion("oDate is not null");
            return (Criteria) this;
        }

        public Criteria andOdateEqualTo(Date value) {
            addCriterion("oDate =", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotEqualTo(Date value) {
            addCriterion("oDate <>", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateGreaterThan(Date value) {
            addCriterion("oDate >", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateGreaterThanOrEqualTo(Date value) {
            addCriterion("oDate >=", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLessThan(Date value) {
            addCriterion("oDate <", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLessThanOrEqualTo(Date value) {
            addCriterion("oDate <=", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateIn(List<Date> values) {
            addCriterion("oDate in", values, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotIn(List<Date> values) {
            addCriterion("oDate not in", values, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateBetween(Date value1, Date value2) {
            addCriterion("oDate between", value1, value2, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotBetween(Date value1, Date value2) {
            addCriterion("oDate not between", value1, value2, "odate");
            return (Criteria) this;
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

        public Criteria andOstateIsNull() {
            addCriterion("oState is null");
            return (Criteria) this;
        }

        public Criteria andOstateIsNotNull() {
            addCriterion("oState is not null");
            return (Criteria) this;
        }

        public Criteria andOstateEqualTo(String value) {
            addCriterion("oState =", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateNotEqualTo(String value) {
            addCriterion("oState <>", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateGreaterThan(String value) {
            addCriterion("oState >", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateGreaterThanOrEqualTo(String value) {
            addCriterion("oState >=", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateLessThan(String value) {
            addCriterion("oState <", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateLessThanOrEqualTo(String value) {
            addCriterion("oState <=", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateLike(String value) {
            addCriterion("oState like", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateNotLike(String value) {
            addCriterion("oState not like", value, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateIn(List<String> values) {
            addCriterion("oState in", values, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateNotIn(List<String> values) {
            addCriterion("oState not in", values, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateBetween(String value1, String value2) {
            addCriterion("oState between", value1, value2, "ostate");
            return (Criteria) this;
        }

        public Criteria andOstateNotBetween(String value1, String value2) {
            addCriterion("oState not between", value1, value2, "ostate");
            return (Criteria) this;
        }

        public Criteria andOrecnameIsNull() {
            addCriterion("oRecname is null");
            return (Criteria) this;
        }

        public Criteria andOrecnameIsNotNull() {
            addCriterion("oRecname is not null");
            return (Criteria) this;
        }

        public Criteria andOrecnameEqualTo(String value) {
            addCriterion("oRecname =", value, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameNotEqualTo(String value) {
            addCriterion("oRecname <>", value, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameGreaterThan(String value) {
            addCriterion("oRecname >", value, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameGreaterThanOrEqualTo(String value) {
            addCriterion("oRecname >=", value, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameLessThan(String value) {
            addCriterion("oRecname <", value, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameLessThanOrEqualTo(String value) {
            addCriterion("oRecname <=", value, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameLike(String value) {
            addCriterion("oRecname like", value, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameNotLike(String value) {
            addCriterion("oRecname not like", value, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameIn(List<String> values) {
            addCriterion("oRecname in", values, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameNotIn(List<String> values) {
            addCriterion("oRecname not in", values, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameBetween(String value1, String value2) {
            addCriterion("oRecname between", value1, value2, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecnameNotBetween(String value1, String value2) {
            addCriterion("oRecname not between", value1, value2, "orecname");
            return (Criteria) this;
        }

        public Criteria andOrecadrIsNull() {
            addCriterion("oRecadr is null");
            return (Criteria) this;
        }

        public Criteria andOrecadrIsNotNull() {
            addCriterion("oRecadr is not null");
            return (Criteria) this;
        }

        public Criteria andOrecadrEqualTo(String value) {
            addCriterion("oRecadr =", value, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrNotEqualTo(String value) {
            addCriterion("oRecadr <>", value, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrGreaterThan(String value) {
            addCriterion("oRecadr >", value, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrGreaterThanOrEqualTo(String value) {
            addCriterion("oRecadr >=", value, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrLessThan(String value) {
            addCriterion("oRecadr <", value, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrLessThanOrEqualTo(String value) {
            addCriterion("oRecadr <=", value, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrLike(String value) {
            addCriterion("oRecadr like", value, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrNotLike(String value) {
            addCriterion("oRecadr not like", value, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrIn(List<String> values) {
            addCriterion("oRecadr in", values, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrNotIn(List<String> values) {
            addCriterion("oRecadr not in", values, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrBetween(String value1, String value2) {
            addCriterion("oRecadr between", value1, value2, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrecadrNotBetween(String value1, String value2) {
            addCriterion("oRecadr not between", value1, value2, "orecadr");
            return (Criteria) this;
        }

        public Criteria andOrectelIsNull() {
            addCriterion("oRectel is null");
            return (Criteria) this;
        }

        public Criteria andOrectelIsNotNull() {
            addCriterion("oRectel is not null");
            return (Criteria) this;
        }

        public Criteria andOrectelEqualTo(String value) {
            addCriterion("oRectel =", value, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelNotEqualTo(String value) {
            addCriterion("oRectel <>", value, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelGreaterThan(String value) {
            addCriterion("oRectel >", value, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelGreaterThanOrEqualTo(String value) {
            addCriterion("oRectel >=", value, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelLessThan(String value) {
            addCriterion("oRectel <", value, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelLessThanOrEqualTo(String value) {
            addCriterion("oRectel <=", value, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelLike(String value) {
            addCriterion("oRectel like", value, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelNotLike(String value) {
            addCriterion("oRectel not like", value, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelIn(List<String> values) {
            addCriterion("oRectel in", values, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelNotIn(List<String> values) {
            addCriterion("oRectel not in", values, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelBetween(String value1, String value2) {
            addCriterion("oRectel between", value1, value2, "orectel");
            return (Criteria) this;
        }

        public Criteria andOrectelNotBetween(String value1, String value2) {
            addCriterion("oRectel not between", value1, value2, "orectel");
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

        public Criteria andOtotalpriceIsNull() {
            addCriterion("oTotalPrice is null");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceIsNotNull() {
            addCriterion("oTotalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceEqualTo(Double value) {
            addCriterion("oTotalPrice =", value, "ototalprice");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceNotEqualTo(Double value) {
            addCriterion("oTotalPrice <>", value, "ototalprice");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceGreaterThan(Double value) {
            addCriterion("oTotalPrice >", value, "ototalprice");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("oTotalPrice >=", value, "ototalprice");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceLessThan(Double value) {
            addCriterion("oTotalPrice <", value, "ototalprice");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceLessThanOrEqualTo(Double value) {
            addCriterion("oTotalPrice <=", value, "ototalprice");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceIn(List<Double> values) {
            addCriterion("oTotalPrice in", values, "ototalprice");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceNotIn(List<Double> values) {
            addCriterion("oTotalPrice not in", values, "ototalprice");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceBetween(Double value1, Double value2) {
            addCriterion("oTotalPrice between", value1, value2, "ototalprice");
            return (Criteria) this;
        }

        public Criteria andOtotalpriceNotBetween(Double value1, Double value2) {
            addCriterion("oTotalPrice not between", value1, value2, "ototalprice");
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