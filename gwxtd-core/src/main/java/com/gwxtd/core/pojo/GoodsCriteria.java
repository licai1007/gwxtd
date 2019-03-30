package com.gwxtd.core.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;
    
    protected String gclass;
    
    protected String gname;

    public GoodsCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    public String getGclass() {
		return gclass;
	}
    
    public void setGclass(String gclass) {
		this.gclass = gclass;
	}
    
	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
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

        public Criteria andGnameIsNull() {
            addCriterion("gName is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gName is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gName =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gName <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gName >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gName >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gName <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gName <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gName like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gName not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gName in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gName not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gName between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gName not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGpriceIsNull() {
            addCriterion("gPrice is null");
            return (Criteria) this;
        }

        public Criteria andGpriceIsNotNull() {
            addCriterion("gPrice is not null");
            return (Criteria) this;
        }

        public Criteria andGpriceEqualTo(Double value) {
            addCriterion("gPrice =", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotEqualTo(Double value) {
            addCriterion("gPrice <>", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceGreaterThan(Double value) {
            addCriterion("gPrice >", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("gPrice >=", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceLessThan(Double value) {
            addCriterion("gPrice <", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceLessThanOrEqualTo(Double value) {
            addCriterion("gPrice <=", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceIn(List<Double> values) {
            addCriterion("gPrice in", values, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotIn(List<Double> values) {
            addCriterion("gPrice not in", values, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceBetween(Double value1, Double value2) {
            addCriterion("gPrice between", value1, value2, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotBetween(Double value1, Double value2) {
            addCriterion("gPrice not between", value1, value2, "gprice");
            return (Criteria) this;
        }

        public Criteria andGclassIsNull() {
            addCriterion("gClass is null");
            return (Criteria) this;
        }

        public Criteria andGclassIsNotNull() {
            addCriterion("gClass is not null");
            return (Criteria) this;
        }

        public Criteria andGclassEqualTo(String value) {
            addCriterion("gClass =", value, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassNotEqualTo(String value) {
            addCriterion("gClass <>", value, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassGreaterThan(String value) {
            addCriterion("gClass >", value, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassGreaterThanOrEqualTo(String value) {
            addCriterion("gClass >=", value, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassLessThan(String value) {
            addCriterion("gClass <", value, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassLessThanOrEqualTo(String value) {
            addCriterion("gClass <=", value, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassLike(String value) {
            addCriterion("gClass like", value, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassNotLike(String value) {
            addCriterion("gClass not like", value, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassIn(List<String> values) {
            addCriterion("gClass in", values, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassNotIn(List<String> values) {
            addCriterion("gClass not in", values, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassBetween(String value1, String value2) {
            addCriterion("gClass between", value1, value2, "gclass");
            return (Criteria) this;
        }

        public Criteria andGclassNotBetween(String value1, String value2) {
            addCriterion("gClass not between", value1, value2, "gclass");
            return (Criteria) this;
        }

        public Criteria andGamountIsNull() {
            addCriterion("gAmount is null");
            return (Criteria) this;
        }

        public Criteria andGamountIsNotNull() {
            addCriterion("gAmount is not null");
            return (Criteria) this;
        }

        public Criteria andGamountEqualTo(Integer value) {
            addCriterion("gAmount =", value, "gamount");
            return (Criteria) this;
        }

        public Criteria andGamountNotEqualTo(Integer value) {
            addCriterion("gAmount <>", value, "gamount");
            return (Criteria) this;
        }

        public Criteria andGamountGreaterThan(Integer value) {
            addCriterion("gAmount >", value, "gamount");
            return (Criteria) this;
        }

        public Criteria andGamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("gAmount >=", value, "gamount");
            return (Criteria) this;
        }

        public Criteria andGamountLessThan(Integer value) {
            addCriterion("gAmount <", value, "gamount");
            return (Criteria) this;
        }

        public Criteria andGamountLessThanOrEqualTo(Integer value) {
            addCriterion("gAmount <=", value, "gamount");
            return (Criteria) this;
        }

        public Criteria andGamountIn(List<Integer> values) {
            addCriterion("gAmount in", values, "gamount");
            return (Criteria) this;
        }

        public Criteria andGamountNotIn(List<Integer> values) {
            addCriterion("gAmount not in", values, "gamount");
            return (Criteria) this;
        }

        public Criteria andGamountBetween(Integer value1, Integer value2) {
            addCriterion("gAmount between", value1, value2, "gamount");
            return (Criteria) this;
        }

        public Criteria andGamountNotBetween(Integer value1, Integer value2) {
            addCriterion("gAmount not between", value1, value2, "gamount");
            return (Criteria) this;
        }

        public Criteria andGdateIsNull() {
            addCriterion("gDate is null");
            return (Criteria) this;
        }

        public Criteria andGdateIsNotNull() {
            addCriterion("gDate is not null");
            return (Criteria) this;
        }

        public Criteria andGdateEqualTo(Date value) {
            addCriterion("gDate =", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotEqualTo(Date value) {
            addCriterion("gDate <>", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateGreaterThan(Date value) {
            addCriterion("gDate >", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateGreaterThanOrEqualTo(Date value) {
            addCriterion("gDate >=", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLessThan(Date value) {
            addCriterion("gDate <", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLessThanOrEqualTo(Date value) {
            addCriterion("gDate <=", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateIn(List<Date> values) {
            addCriterion("gDate in", values, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotIn(List<Date> values) {
            addCriterion("gDate not in", values, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateBetween(Date value1, Date value2) {
            addCriterion("gDate between", value1, value2, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotBetween(Date value1, Date value2) {
            addCriterion("gDate not between", value1, value2, "gdate");
            return (Criteria) this;
        }

        public Criteria andGimgurlIsNull() {
            addCriterion("gImgUrl is null");
            return (Criteria) this;
        }

        public Criteria andGimgurlIsNotNull() {
            addCriterion("gImgUrl is not null");
            return (Criteria) this;
        }

        public Criteria andGimgurlEqualTo(String value) {
            addCriterion("gImgUrl =", value, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlNotEqualTo(String value) {
            addCriterion("gImgUrl <>", value, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlGreaterThan(String value) {
            addCriterion("gImgUrl >", value, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("gImgUrl >=", value, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlLessThan(String value) {
            addCriterion("gImgUrl <", value, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlLessThanOrEqualTo(String value) {
            addCriterion("gImgUrl <=", value, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlLike(String value) {
            addCriterion("gImgUrl like", value, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlNotLike(String value) {
            addCriterion("gImgUrl not like", value, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlIn(List<String> values) {
            addCriterion("gImgUrl in", values, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlNotIn(List<String> values) {
            addCriterion("gImgUrl not in", values, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlBetween(String value1, String value2) {
            addCriterion("gImgUrl between", value1, value2, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGimgurlNotBetween(String value1, String value2) {
            addCriterion("gImgUrl not between", value1, value2, "gimgurl");
            return (Criteria) this;
        }

        public Criteria andGlookIsNull() {
            addCriterion("gLook is null");
            return (Criteria) this;
        }

        public Criteria andGlookIsNotNull() {
            addCriterion("gLook is not null");
            return (Criteria) this;
        }

        public Criteria andGlookEqualTo(Integer value) {
            addCriterion("gLook =", value, "glook");
            return (Criteria) this;
        }

        public Criteria andGlookNotEqualTo(Integer value) {
            addCriterion("gLook <>", value, "glook");
            return (Criteria) this;
        }

        public Criteria andGlookGreaterThan(Integer value) {
            addCriterion("gLook >", value, "glook");
            return (Criteria) this;
        }

        public Criteria andGlookGreaterThanOrEqualTo(Integer value) {
            addCriterion("gLook >=", value, "glook");
            return (Criteria) this;
        }

        public Criteria andGlookLessThan(Integer value) {
            addCriterion("gLook <", value, "glook");
            return (Criteria) this;
        }

        public Criteria andGlookLessThanOrEqualTo(Integer value) {
            addCriterion("gLook <=", value, "glook");
            return (Criteria) this;
        }

        public Criteria andGlookIn(List<Integer> values) {
            addCriterion("gLook in", values, "glook");
            return (Criteria) this;
        }

        public Criteria andGlookNotIn(List<Integer> values) {
            addCriterion("gLook not in", values, "glook");
            return (Criteria) this;
        }

        public Criteria andGlookBetween(Integer value1, Integer value2) {
            addCriterion("gLook between", value1, value2, "glook");
            return (Criteria) this;
        }

        public Criteria andGlookNotBetween(Integer value1, Integer value2) {
            addCriterion("gLook not between", value1, value2, "glook");
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