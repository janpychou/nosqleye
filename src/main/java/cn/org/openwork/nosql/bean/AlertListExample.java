package cn.org.openwork.nosql.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlertListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public AlertListExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setPageSize(int pageSize) {
        this.pageSize=pageSize;
    }

    public int getPageSize() {
        return pageSize;
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

        public Criteria andServerIdIsNull() {
            addCriterion("server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(Long value) {
            addCriterion("server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(Long value) {
            addCriterion("server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(Long value) {
            addCriterion("server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(Long value) {
            addCriterion("server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(Long value) {
            addCriterion("server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<Long> values) {
            addCriterion("server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<Long> values) {
            addCriterion("server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(Long value1, Long value2) {
            addCriterion("server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(Long value1, Long value2) {
            addCriterion("server_id not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andAlertLevelIsNull() {
            addCriterion("alert_level is null");
            return (Criteria) this;
        }

        public Criteria andAlertLevelIsNotNull() {
            addCriterion("alert_level is not null");
            return (Criteria) this;
        }

        public Criteria andAlertLevelEqualTo(String value) {
            addCriterion("alert_level =", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelNotEqualTo(String value) {
            addCriterion("alert_level <>", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelGreaterThan(String value) {
            addCriterion("alert_level >", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelGreaterThanOrEqualTo(String value) {
            addCriterion("alert_level >=", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelLessThan(String value) {
            addCriterion("alert_level <", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelLessThanOrEqualTo(String value) {
            addCriterion("alert_level <=", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelLike(String value) {
            addCriterion("alert_level like", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelNotLike(String value) {
            addCriterion("alert_level not like", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelIn(List<String> values) {
            addCriterion("alert_level in", values, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelNotIn(List<String> values) {
            addCriterion("alert_level not in", values, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelBetween(String value1, String value2) {
            addCriterion("alert_level between", value1, value2, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelNotBetween(String value1, String value2) {
            addCriterion("alert_level not between", value1, value2, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertContentIsNull() {
            addCriterion("alert_content is null");
            return (Criteria) this;
        }

        public Criteria andAlertContentIsNotNull() {
            addCriterion("alert_content is not null");
            return (Criteria) this;
        }

        public Criteria andAlertContentEqualTo(String value) {
            addCriterion("alert_content =", value, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentNotEqualTo(String value) {
            addCriterion("alert_content <>", value, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentGreaterThan(String value) {
            addCriterion("alert_content >", value, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentGreaterThanOrEqualTo(String value) {
            addCriterion("alert_content >=", value, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentLessThan(String value) {
            addCriterion("alert_content <", value, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentLessThanOrEqualTo(String value) {
            addCriterion("alert_content <=", value, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentLike(String value) {
            addCriterion("alert_content like", value, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentNotLike(String value) {
            addCriterion("alert_content not like", value, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentIn(List<String> values) {
            addCriterion("alert_content in", values, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentNotIn(List<String> values) {
            addCriterion("alert_content not in", values, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentBetween(String value1, String value2) {
            addCriterion("alert_content between", value1, value2, "alertContent");
            return (Criteria) this;
        }

        public Criteria andAlertContentNotBetween(String value1, String value2) {
            addCriterion("alert_content not between", value1, value2, "alertContent");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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