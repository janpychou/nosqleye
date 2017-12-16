package cn.org.openwork.nosql.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlertConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public AlertConfigExample() {
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

        public Criteria andServerTypeIsNull() {
            addCriterion("server_type is null");
            return (Criteria) this;
        }

        public Criteria andServerTypeIsNotNull() {
            addCriterion("server_type is not null");
            return (Criteria) this;
        }

        public Criteria andServerTypeEqualTo(String value) {
            addCriterion("server_type =", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotEqualTo(String value) {
            addCriterion("server_type <>", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeGreaterThan(String value) {
            addCriterion("server_type >", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("server_type >=", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeLessThan(String value) {
            addCriterion("server_type <", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeLessThanOrEqualTo(String value) {
            addCriterion("server_type <=", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeLike(String value) {
            addCriterion("server_type like", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotLike(String value) {
            addCriterion("server_type not like", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeIn(List<String> values) {
            addCriterion("server_type in", values, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotIn(List<String> values) {
            addCriterion("server_type not in", values, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeBetween(String value1, String value2) {
            addCriterion("server_type between", value1, value2, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotBetween(String value1, String value2) {
            addCriterion("server_type not between", value1, value2, "serverType");
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

        public Criteria andPhoneNumbersIsNull() {
            addCriterion("phone_numbers is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersIsNotNull() {
            addCriterion("phone_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersEqualTo(String value) {
            addCriterion("phone_numbers =", value, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersNotEqualTo(String value) {
            addCriterion("phone_numbers <>", value, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersGreaterThan(String value) {
            addCriterion("phone_numbers >", value, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersGreaterThanOrEqualTo(String value) {
            addCriterion("phone_numbers >=", value, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersLessThan(String value) {
            addCriterion("phone_numbers <", value, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersLessThanOrEqualTo(String value) {
            addCriterion("phone_numbers <=", value, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersLike(String value) {
            addCriterion("phone_numbers like", value, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersNotLike(String value) {
            addCriterion("phone_numbers not like", value, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersIn(List<String> values) {
            addCriterion("phone_numbers in", values, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersNotIn(List<String> values) {
            addCriterion("phone_numbers not in", values, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersBetween(String value1, String value2) {
            addCriterion("phone_numbers between", value1, value2, "phoneNumbers");
            return (Criteria) this;
        }

        public Criteria andPhoneNumbersNotBetween(String value1, String value2) {
            addCriterion("phone_numbers not between", value1, value2, "phoneNumbers");
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

        public Criteria andLastAlertTimeIsNull() {
            addCriterion("last_alert_time is null");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeIsNotNull() {
            addCriterion("last_alert_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeEqualTo(Date value) {
            addCriterion("last_alert_time =", value, "lastAlertTime");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeNotEqualTo(Date value) {
            addCriterion("last_alert_time <>", value, "lastAlertTime");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeGreaterThan(Date value) {
            addCriterion("last_alert_time >", value, "lastAlertTime");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_alert_time >=", value, "lastAlertTime");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeLessThan(Date value) {
            addCriterion("last_alert_time <", value, "lastAlertTime");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_alert_time <=", value, "lastAlertTime");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeIn(List<Date> values) {
            addCriterion("last_alert_time in", values, "lastAlertTime");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeNotIn(List<Date> values) {
            addCriterion("last_alert_time not in", values, "lastAlertTime");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeBetween(Date value1, Date value2) {
            addCriterion("last_alert_time between", value1, value2, "lastAlertTime");
            return (Criteria) this;
        }

        public Criteria andLastAlertTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_alert_time not between", value1, value2, "lastAlertTime");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterIsNull() {
            addCriterion("realert_seconds_later is null");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterIsNotNull() {
            addCriterion("realert_seconds_later is not null");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterEqualTo(Long value) {
            addCriterion("realert_seconds_later =", value, "realertSecondsLater");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterNotEqualTo(Long value) {
            addCriterion("realert_seconds_later <>", value, "realertSecondsLater");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterGreaterThan(Long value) {
            addCriterion("realert_seconds_later >", value, "realertSecondsLater");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterGreaterThanOrEqualTo(Long value) {
            addCriterion("realert_seconds_later >=", value, "realertSecondsLater");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterLessThan(Long value) {
            addCriterion("realert_seconds_later <", value, "realertSecondsLater");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterLessThanOrEqualTo(Long value) {
            addCriterion("realert_seconds_later <=", value, "realertSecondsLater");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterIn(List<Long> values) {
            addCriterion("realert_seconds_later in", values, "realertSecondsLater");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterNotIn(List<Long> values) {
            addCriterion("realert_seconds_later not in", values, "realertSecondsLater");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterBetween(Long value1, Long value2) {
            addCriterion("realert_seconds_later between", value1, value2, "realertSecondsLater");
            return (Criteria) this;
        }

        public Criteria andRealertSecondsLaterNotBetween(Long value1, Long value2) {
            addCriterion("realert_seconds_later not between", value1, value2, "realertSecondsLater");
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