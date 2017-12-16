package cn.org.openwork.nosql.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MongodbTopHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public MongodbTopHistoryExample() {
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

        public Criteria andNsIsNull() {
            addCriterion("ns is null");
            return (Criteria) this;
        }

        public Criteria andNsIsNotNull() {
            addCriterion("ns is not null");
            return (Criteria) this;
        }

        public Criteria andNsEqualTo(String value) {
            addCriterion("ns =", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsNotEqualTo(String value) {
            addCriterion("ns <>", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsGreaterThan(String value) {
            addCriterion("ns >", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsGreaterThanOrEqualTo(String value) {
            addCriterion("ns >=", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsLessThan(String value) {
            addCriterion("ns <", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsLessThanOrEqualTo(String value) {
            addCriterion("ns <=", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsLike(String value) {
            addCriterion("ns like", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsNotLike(String value) {
            addCriterion("ns not like", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsIn(List<String> values) {
            addCriterion("ns in", values, "ns");
            return (Criteria) this;
        }

        public Criteria andNsNotIn(List<String> values) {
            addCriterion("ns not in", values, "ns");
            return (Criteria) this;
        }

        public Criteria andNsBetween(String value1, String value2) {
            addCriterion("ns between", value1, value2, "ns");
            return (Criteria) this;
        }

        public Criteria andNsNotBetween(String value1, String value2) {
            addCriterion("ns not between", value1, value2, "ns");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNull() {
            addCriterion("total_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNotNull() {
            addCriterion("total_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCountEqualTo(Long value) {
            addCriterion("total_count =", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotEqualTo(Long value) {
            addCriterion("total_count <>", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThan(Long value) {
            addCriterion("total_count >", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThanOrEqualTo(Long value) {
            addCriterion("total_count >=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThan(Long value) {
            addCriterion("total_count <", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThanOrEqualTo(Long value) {
            addCriterion("total_count <=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountIn(List<Long> values) {
            addCriterion("total_count in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotIn(List<Long> values) {
            addCriterion("total_count not in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountBetween(Long value1, Long value2) {
            addCriterion("total_count between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotBetween(Long value1, Long value2) {
            addCriterion("total_count not between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNull() {
            addCriterion("total_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNotNull() {
            addCriterion("total_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeEqualTo(Long value) {
            addCriterion("total_time =", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotEqualTo(Long value) {
            addCriterion("total_time <>", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThan(Long value) {
            addCriterion("total_time >", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("total_time >=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThan(Long value) {
            addCriterion("total_time <", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThanOrEqualTo(Long value) {
            addCriterion("total_time <=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIn(List<Long> values) {
            addCriterion("total_time in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotIn(List<Long> values) {
            addCriterion("total_time not in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeBetween(Long value1, Long value2) {
            addCriterion("total_time between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotBetween(Long value1, Long value2) {
            addCriterion("total_time not between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondIsNull() {
            addCriterion("total_count_persecond is null");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondIsNotNull() {
            addCriterion("total_count_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondEqualTo(String value) {
            addCriterion("total_count_persecond =", value, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondNotEqualTo(String value) {
            addCriterion("total_count_persecond <>", value, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondGreaterThan(String value) {
            addCriterion("total_count_persecond >", value, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("total_count_persecond >=", value, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondLessThan(String value) {
            addCriterion("total_count_persecond <", value, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondLessThanOrEqualTo(String value) {
            addCriterion("total_count_persecond <=", value, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondLike(String value) {
            addCriterion("total_count_persecond like", value, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondNotLike(String value) {
            addCriterion("total_count_persecond not like", value, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondIn(List<String> values) {
            addCriterion("total_count_persecond in", values, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondNotIn(List<String> values) {
            addCriterion("total_count_persecond not in", values, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondBetween(String value1, String value2) {
            addCriterion("total_count_persecond between", value1, value2, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andTotalCountPersecondNotBetween(String value1, String value2) {
            addCriterion("total_count_persecond not between", value1, value2, "totalCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountIsNull() {
            addCriterion("write_lock_count is null");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountIsNotNull() {
            addCriterion("write_lock_count is not null");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountEqualTo(Long value) {
            addCriterion("write_lock_count =", value, "writeLockCount");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountNotEqualTo(Long value) {
            addCriterion("write_lock_count <>", value, "writeLockCount");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountGreaterThan(Long value) {
            addCriterion("write_lock_count >", value, "writeLockCount");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountGreaterThanOrEqualTo(Long value) {
            addCriterion("write_lock_count >=", value, "writeLockCount");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountLessThan(Long value) {
            addCriterion("write_lock_count <", value, "writeLockCount");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountLessThanOrEqualTo(Long value) {
            addCriterion("write_lock_count <=", value, "writeLockCount");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountIn(List<Long> values) {
            addCriterion("write_lock_count in", values, "writeLockCount");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountNotIn(List<Long> values) {
            addCriterion("write_lock_count not in", values, "writeLockCount");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountBetween(Long value1, Long value2) {
            addCriterion("write_lock_count between", value1, value2, "writeLockCount");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountNotBetween(Long value1, Long value2) {
            addCriterion("write_lock_count not between", value1, value2, "writeLockCount");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeIsNull() {
            addCriterion("write_lock_time is null");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeIsNotNull() {
            addCriterion("write_lock_time is not null");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeEqualTo(Long value) {
            addCriterion("write_lock_time =", value, "writeLockTime");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeNotEqualTo(Long value) {
            addCriterion("write_lock_time <>", value, "writeLockTime");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeGreaterThan(Long value) {
            addCriterion("write_lock_time >", value, "writeLockTime");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("write_lock_time >=", value, "writeLockTime");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeLessThan(Long value) {
            addCriterion("write_lock_time <", value, "writeLockTime");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeLessThanOrEqualTo(Long value) {
            addCriterion("write_lock_time <=", value, "writeLockTime");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeIn(List<Long> values) {
            addCriterion("write_lock_time in", values, "writeLockTime");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeNotIn(List<Long> values) {
            addCriterion("write_lock_time not in", values, "writeLockTime");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeBetween(Long value1, Long value2) {
            addCriterion("write_lock_time between", value1, value2, "writeLockTime");
            return (Criteria) this;
        }

        public Criteria andWriteLockTimeNotBetween(Long value1, Long value2) {
            addCriterion("write_lock_time not between", value1, value2, "writeLockTime");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondIsNull() {
            addCriterion("write_lock_count_persecond is null");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondIsNotNull() {
            addCriterion("write_lock_count_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondEqualTo(String value) {
            addCriterion("write_lock_count_persecond =", value, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondNotEqualTo(String value) {
            addCriterion("write_lock_count_persecond <>", value, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondGreaterThan(String value) {
            addCriterion("write_lock_count_persecond >", value, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("write_lock_count_persecond >=", value, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondLessThan(String value) {
            addCriterion("write_lock_count_persecond <", value, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondLessThanOrEqualTo(String value) {
            addCriterion("write_lock_count_persecond <=", value, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondLike(String value) {
            addCriterion("write_lock_count_persecond like", value, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondNotLike(String value) {
            addCriterion("write_lock_count_persecond not like", value, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondIn(List<String> values) {
            addCriterion("write_lock_count_persecond in", values, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondNotIn(List<String> values) {
            addCriterion("write_lock_count_persecond not in", values, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondBetween(String value1, String value2) {
            addCriterion("write_lock_count_persecond between", value1, value2, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andWriteLockCountPersecondNotBetween(String value1, String value2) {
            addCriterion("write_lock_count_persecond not between", value1, value2, "writeLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountIsNull() {
            addCriterion("read_lock_count is null");
            return (Criteria) this;
        }

        public Criteria andReadLockCountIsNotNull() {
            addCriterion("read_lock_count is not null");
            return (Criteria) this;
        }

        public Criteria andReadLockCountEqualTo(Long value) {
            addCriterion("read_lock_count =", value, "readLockCount");
            return (Criteria) this;
        }

        public Criteria andReadLockCountNotEqualTo(Long value) {
            addCriterion("read_lock_count <>", value, "readLockCount");
            return (Criteria) this;
        }

        public Criteria andReadLockCountGreaterThan(Long value) {
            addCriterion("read_lock_count >", value, "readLockCount");
            return (Criteria) this;
        }

        public Criteria andReadLockCountGreaterThanOrEqualTo(Long value) {
            addCriterion("read_lock_count >=", value, "readLockCount");
            return (Criteria) this;
        }

        public Criteria andReadLockCountLessThan(Long value) {
            addCriterion("read_lock_count <", value, "readLockCount");
            return (Criteria) this;
        }

        public Criteria andReadLockCountLessThanOrEqualTo(Long value) {
            addCriterion("read_lock_count <=", value, "readLockCount");
            return (Criteria) this;
        }

        public Criteria andReadLockCountIn(List<Long> values) {
            addCriterion("read_lock_count in", values, "readLockCount");
            return (Criteria) this;
        }

        public Criteria andReadLockCountNotIn(List<Long> values) {
            addCriterion("read_lock_count not in", values, "readLockCount");
            return (Criteria) this;
        }

        public Criteria andReadLockCountBetween(Long value1, Long value2) {
            addCriterion("read_lock_count between", value1, value2, "readLockCount");
            return (Criteria) this;
        }

        public Criteria andReadLockCountNotBetween(Long value1, Long value2) {
            addCriterion("read_lock_count not between", value1, value2, "readLockCount");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeIsNull() {
            addCriterion("read_lock_time is null");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeIsNotNull() {
            addCriterion("read_lock_time is not null");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeEqualTo(Long value) {
            addCriterion("read_lock_time =", value, "readLockTime");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeNotEqualTo(Long value) {
            addCriterion("read_lock_time <>", value, "readLockTime");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeGreaterThan(Long value) {
            addCriterion("read_lock_time >", value, "readLockTime");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("read_lock_time >=", value, "readLockTime");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeLessThan(Long value) {
            addCriterion("read_lock_time <", value, "readLockTime");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeLessThanOrEqualTo(Long value) {
            addCriterion("read_lock_time <=", value, "readLockTime");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeIn(List<Long> values) {
            addCriterion("read_lock_time in", values, "readLockTime");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeNotIn(List<Long> values) {
            addCriterion("read_lock_time not in", values, "readLockTime");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeBetween(Long value1, Long value2) {
            addCriterion("read_lock_time between", value1, value2, "readLockTime");
            return (Criteria) this;
        }

        public Criteria andReadLockTimeNotBetween(Long value1, Long value2) {
            addCriterion("read_lock_time not between", value1, value2, "readLockTime");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondIsNull() {
            addCriterion("read_lock_count_persecond is null");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondIsNotNull() {
            addCriterion("read_lock_count_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondEqualTo(String value) {
            addCriterion("read_lock_count_persecond =", value, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondNotEqualTo(String value) {
            addCriterion("read_lock_count_persecond <>", value, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondGreaterThan(String value) {
            addCriterion("read_lock_count_persecond >", value, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("read_lock_count_persecond >=", value, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondLessThan(String value) {
            addCriterion("read_lock_count_persecond <", value, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondLessThanOrEqualTo(String value) {
            addCriterion("read_lock_count_persecond <=", value, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondLike(String value) {
            addCriterion("read_lock_count_persecond like", value, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondNotLike(String value) {
            addCriterion("read_lock_count_persecond not like", value, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondIn(List<String> values) {
            addCriterion("read_lock_count_persecond in", values, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondNotIn(List<String> values) {
            addCriterion("read_lock_count_persecond not in", values, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondBetween(String value1, String value2) {
            addCriterion("read_lock_count_persecond between", value1, value2, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andReadLockCountPersecondNotBetween(String value1, String value2) {
            addCriterion("read_lock_count_persecond not between", value1, value2, "readLockCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountIsNull() {
            addCriterion("insert_count is null");
            return (Criteria) this;
        }

        public Criteria andInsertCountIsNotNull() {
            addCriterion("insert_count is not null");
            return (Criteria) this;
        }

        public Criteria andInsertCountEqualTo(Long value) {
            addCriterion("insert_count =", value, "insertCount");
            return (Criteria) this;
        }

        public Criteria andInsertCountNotEqualTo(Long value) {
            addCriterion("insert_count <>", value, "insertCount");
            return (Criteria) this;
        }

        public Criteria andInsertCountGreaterThan(Long value) {
            addCriterion("insert_count >", value, "insertCount");
            return (Criteria) this;
        }

        public Criteria andInsertCountGreaterThanOrEqualTo(Long value) {
            addCriterion("insert_count >=", value, "insertCount");
            return (Criteria) this;
        }

        public Criteria andInsertCountLessThan(Long value) {
            addCriterion("insert_count <", value, "insertCount");
            return (Criteria) this;
        }

        public Criteria andInsertCountLessThanOrEqualTo(Long value) {
            addCriterion("insert_count <=", value, "insertCount");
            return (Criteria) this;
        }

        public Criteria andInsertCountIn(List<Long> values) {
            addCriterion("insert_count in", values, "insertCount");
            return (Criteria) this;
        }

        public Criteria andInsertCountNotIn(List<Long> values) {
            addCriterion("insert_count not in", values, "insertCount");
            return (Criteria) this;
        }

        public Criteria andInsertCountBetween(Long value1, Long value2) {
            addCriterion("insert_count between", value1, value2, "insertCount");
            return (Criteria) this;
        }

        public Criteria andInsertCountNotBetween(Long value1, Long value2) {
            addCriterion("insert_count not between", value1, value2, "insertCount");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("insert_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insert_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Long value) {
            addCriterion("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Long value) {
            addCriterion("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Long value) {
            addCriterion("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Long value) {
            addCriterion("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Long value) {
            addCriterion("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Long> values) {
            addCriterion("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Long> values) {
            addCriterion("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Long value1, Long value2) {
            addCriterion("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Long value1, Long value2) {
            addCriterion("insert_time not between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondIsNull() {
            addCriterion("insert_count_persecond is null");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondIsNotNull() {
            addCriterion("insert_count_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondEqualTo(String value) {
            addCriterion("insert_count_persecond =", value, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondNotEqualTo(String value) {
            addCriterion("insert_count_persecond <>", value, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondGreaterThan(String value) {
            addCriterion("insert_count_persecond >", value, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("insert_count_persecond >=", value, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondLessThan(String value) {
            addCriterion("insert_count_persecond <", value, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondLessThanOrEqualTo(String value) {
            addCriterion("insert_count_persecond <=", value, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondLike(String value) {
            addCriterion("insert_count_persecond like", value, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondNotLike(String value) {
            addCriterion("insert_count_persecond not like", value, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondIn(List<String> values) {
            addCriterion("insert_count_persecond in", values, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondNotIn(List<String> values) {
            addCriterion("insert_count_persecond not in", values, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondBetween(String value1, String value2) {
            addCriterion("insert_count_persecond between", value1, value2, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andInsertCountPersecondNotBetween(String value1, String value2) {
            addCriterion("insert_count_persecond not between", value1, value2, "insertCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountIsNull() {
            addCriterion("update_count is null");
            return (Criteria) this;
        }

        public Criteria andUpdateCountIsNotNull() {
            addCriterion("update_count is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateCountEqualTo(Long value) {
            addCriterion("update_count =", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountNotEqualTo(Long value) {
            addCriterion("update_count <>", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountGreaterThan(Long value) {
            addCriterion("update_count >", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountGreaterThanOrEqualTo(Long value) {
            addCriterion("update_count >=", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountLessThan(Long value) {
            addCriterion("update_count <", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountLessThanOrEqualTo(Long value) {
            addCriterion("update_count <=", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountIn(List<Long> values) {
            addCriterion("update_count in", values, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountNotIn(List<Long> values) {
            addCriterion("update_count not in", values, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountBetween(Long value1, Long value2) {
            addCriterion("update_count between", value1, value2, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountNotBetween(Long value1, Long value2) {
            addCriterion("update_count not between", value1, value2, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondIsNull() {
            addCriterion("update_count_persecond is null");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondIsNotNull() {
            addCriterion("update_count_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondEqualTo(String value) {
            addCriterion("update_count_persecond =", value, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondNotEqualTo(String value) {
            addCriterion("update_count_persecond <>", value, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondGreaterThan(String value) {
            addCriterion("update_count_persecond >", value, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("update_count_persecond >=", value, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondLessThan(String value) {
            addCriterion("update_count_persecond <", value, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondLessThanOrEqualTo(String value) {
            addCriterion("update_count_persecond <=", value, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondLike(String value) {
            addCriterion("update_count_persecond like", value, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondNotLike(String value) {
            addCriterion("update_count_persecond not like", value, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondIn(List<String> values) {
            addCriterion("update_count_persecond in", values, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondNotIn(List<String> values) {
            addCriterion("update_count_persecond not in", values, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondBetween(String value1, String value2) {
            addCriterion("update_count_persecond between", value1, value2, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andUpdateCountPersecondNotBetween(String value1, String value2) {
            addCriterion("update_count_persecond not between", value1, value2, "updateCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountIsNull() {
            addCriterion("get_more_count is null");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountIsNotNull() {
            addCriterion("get_more_count is not null");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountEqualTo(Long value) {
            addCriterion("get_more_count =", value, "getMoreCount");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountNotEqualTo(Long value) {
            addCriterion("get_more_count <>", value, "getMoreCount");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountGreaterThan(Long value) {
            addCriterion("get_more_count >", value, "getMoreCount");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountGreaterThanOrEqualTo(Long value) {
            addCriterion("get_more_count >=", value, "getMoreCount");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountLessThan(Long value) {
            addCriterion("get_more_count <", value, "getMoreCount");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountLessThanOrEqualTo(Long value) {
            addCriterion("get_more_count <=", value, "getMoreCount");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountIn(List<Long> values) {
            addCriterion("get_more_count in", values, "getMoreCount");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountNotIn(List<Long> values) {
            addCriterion("get_more_count not in", values, "getMoreCount");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountBetween(Long value1, Long value2) {
            addCriterion("get_more_count between", value1, value2, "getMoreCount");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountNotBetween(Long value1, Long value2) {
            addCriterion("get_more_count not between", value1, value2, "getMoreCount");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeIsNull() {
            addCriterion("get_more_time is null");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeIsNotNull() {
            addCriterion("get_more_time is not null");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeEqualTo(Long value) {
            addCriterion("get_more_time =", value, "getMoreTime");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeNotEqualTo(Long value) {
            addCriterion("get_more_time <>", value, "getMoreTime");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeGreaterThan(Long value) {
            addCriterion("get_more_time >", value, "getMoreTime");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("get_more_time >=", value, "getMoreTime");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeLessThan(Long value) {
            addCriterion("get_more_time <", value, "getMoreTime");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeLessThanOrEqualTo(Long value) {
            addCriterion("get_more_time <=", value, "getMoreTime");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeIn(List<Long> values) {
            addCriterion("get_more_time in", values, "getMoreTime");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeNotIn(List<Long> values) {
            addCriterion("get_more_time not in", values, "getMoreTime");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeBetween(Long value1, Long value2) {
            addCriterion("get_more_time between", value1, value2, "getMoreTime");
            return (Criteria) this;
        }

        public Criteria andGetMoreTimeNotBetween(Long value1, Long value2) {
            addCriterion("get_more_time not between", value1, value2, "getMoreTime");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondIsNull() {
            addCriterion("get_more_count_persecond is null");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondIsNotNull() {
            addCriterion("get_more_count_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondEqualTo(String value) {
            addCriterion("get_more_count_persecond =", value, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondNotEqualTo(String value) {
            addCriterion("get_more_count_persecond <>", value, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondGreaterThan(String value) {
            addCriterion("get_more_count_persecond >", value, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("get_more_count_persecond >=", value, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondLessThan(String value) {
            addCriterion("get_more_count_persecond <", value, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondLessThanOrEqualTo(String value) {
            addCriterion("get_more_count_persecond <=", value, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondLike(String value) {
            addCriterion("get_more_count_persecond like", value, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondNotLike(String value) {
            addCriterion("get_more_count_persecond not like", value, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondIn(List<String> values) {
            addCriterion("get_more_count_persecond in", values, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondNotIn(List<String> values) {
            addCriterion("get_more_count_persecond not in", values, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondBetween(String value1, String value2) {
            addCriterion("get_more_count_persecond between", value1, value2, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andGetMoreCountPersecondNotBetween(String value1, String value2) {
            addCriterion("get_more_count_persecond not between", value1, value2, "getMoreCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountIsNull() {
            addCriterion("queries_count is null");
            return (Criteria) this;
        }

        public Criteria andQueriesCountIsNotNull() {
            addCriterion("queries_count is not null");
            return (Criteria) this;
        }

        public Criteria andQueriesCountEqualTo(Long value) {
            addCriterion("queries_count =", value, "queriesCount");
            return (Criteria) this;
        }

        public Criteria andQueriesCountNotEqualTo(Long value) {
            addCriterion("queries_count <>", value, "queriesCount");
            return (Criteria) this;
        }

        public Criteria andQueriesCountGreaterThan(Long value) {
            addCriterion("queries_count >", value, "queriesCount");
            return (Criteria) this;
        }

        public Criteria andQueriesCountGreaterThanOrEqualTo(Long value) {
            addCriterion("queries_count >=", value, "queriesCount");
            return (Criteria) this;
        }

        public Criteria andQueriesCountLessThan(Long value) {
            addCriterion("queries_count <", value, "queriesCount");
            return (Criteria) this;
        }

        public Criteria andQueriesCountLessThanOrEqualTo(Long value) {
            addCriterion("queries_count <=", value, "queriesCount");
            return (Criteria) this;
        }

        public Criteria andQueriesCountIn(List<Long> values) {
            addCriterion("queries_count in", values, "queriesCount");
            return (Criteria) this;
        }

        public Criteria andQueriesCountNotIn(List<Long> values) {
            addCriterion("queries_count not in", values, "queriesCount");
            return (Criteria) this;
        }

        public Criteria andQueriesCountBetween(Long value1, Long value2) {
            addCriterion("queries_count between", value1, value2, "queriesCount");
            return (Criteria) this;
        }

        public Criteria andQueriesCountNotBetween(Long value1, Long value2) {
            addCriterion("queries_count not between", value1, value2, "queriesCount");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeIsNull() {
            addCriterion("queries_time is null");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeIsNotNull() {
            addCriterion("queries_time is not null");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeEqualTo(Long value) {
            addCriterion("queries_time =", value, "queriesTime");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeNotEqualTo(Long value) {
            addCriterion("queries_time <>", value, "queriesTime");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeGreaterThan(Long value) {
            addCriterion("queries_time >", value, "queriesTime");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("queries_time >=", value, "queriesTime");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeLessThan(Long value) {
            addCriterion("queries_time <", value, "queriesTime");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeLessThanOrEqualTo(Long value) {
            addCriterion("queries_time <=", value, "queriesTime");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeIn(List<Long> values) {
            addCriterion("queries_time in", values, "queriesTime");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeNotIn(List<Long> values) {
            addCriterion("queries_time not in", values, "queriesTime");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeBetween(Long value1, Long value2) {
            addCriterion("queries_time between", value1, value2, "queriesTime");
            return (Criteria) this;
        }

        public Criteria andQueriesTimeNotBetween(Long value1, Long value2) {
            addCriterion("queries_time not between", value1, value2, "queriesTime");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondIsNull() {
            addCriterion("queries_count_persecond is null");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondIsNotNull() {
            addCriterion("queries_count_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondEqualTo(String value) {
            addCriterion("queries_count_persecond =", value, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondNotEqualTo(String value) {
            addCriterion("queries_count_persecond <>", value, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondGreaterThan(String value) {
            addCriterion("queries_count_persecond >", value, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("queries_count_persecond >=", value, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondLessThan(String value) {
            addCriterion("queries_count_persecond <", value, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondLessThanOrEqualTo(String value) {
            addCriterion("queries_count_persecond <=", value, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondLike(String value) {
            addCriterion("queries_count_persecond like", value, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondNotLike(String value) {
            addCriterion("queries_count_persecond not like", value, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondIn(List<String> values) {
            addCriterion("queries_count_persecond in", values, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondNotIn(List<String> values) {
            addCriterion("queries_count_persecond not in", values, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondBetween(String value1, String value2) {
            addCriterion("queries_count_persecond between", value1, value2, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andQueriesCountPersecondNotBetween(String value1, String value2) {
            addCriterion("queries_count_persecond not between", value1, value2, "queriesCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountIsNull() {
            addCriterion("remove_count is null");
            return (Criteria) this;
        }

        public Criteria andRemoveCountIsNotNull() {
            addCriterion("remove_count is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveCountEqualTo(Long value) {
            addCriterion("remove_count =", value, "removeCount");
            return (Criteria) this;
        }

        public Criteria andRemoveCountNotEqualTo(Long value) {
            addCriterion("remove_count <>", value, "removeCount");
            return (Criteria) this;
        }

        public Criteria andRemoveCountGreaterThan(Long value) {
            addCriterion("remove_count >", value, "removeCount");
            return (Criteria) this;
        }

        public Criteria andRemoveCountGreaterThanOrEqualTo(Long value) {
            addCriterion("remove_count >=", value, "removeCount");
            return (Criteria) this;
        }

        public Criteria andRemoveCountLessThan(Long value) {
            addCriterion("remove_count <", value, "removeCount");
            return (Criteria) this;
        }

        public Criteria andRemoveCountLessThanOrEqualTo(Long value) {
            addCriterion("remove_count <=", value, "removeCount");
            return (Criteria) this;
        }

        public Criteria andRemoveCountIn(List<Long> values) {
            addCriterion("remove_count in", values, "removeCount");
            return (Criteria) this;
        }

        public Criteria andRemoveCountNotIn(List<Long> values) {
            addCriterion("remove_count not in", values, "removeCount");
            return (Criteria) this;
        }

        public Criteria andRemoveCountBetween(Long value1, Long value2) {
            addCriterion("remove_count between", value1, value2, "removeCount");
            return (Criteria) this;
        }

        public Criteria andRemoveCountNotBetween(Long value1, Long value2) {
            addCriterion("remove_count not between", value1, value2, "removeCount");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeIsNull() {
            addCriterion("remove_time is null");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeIsNotNull() {
            addCriterion("remove_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeEqualTo(Long value) {
            addCriterion("remove_time =", value, "removeTime");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeNotEqualTo(Long value) {
            addCriterion("remove_time <>", value, "removeTime");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeGreaterThan(Long value) {
            addCriterion("remove_time >", value, "removeTime");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("remove_time >=", value, "removeTime");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeLessThan(Long value) {
            addCriterion("remove_time <", value, "removeTime");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeLessThanOrEqualTo(Long value) {
            addCriterion("remove_time <=", value, "removeTime");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeIn(List<Long> values) {
            addCriterion("remove_time in", values, "removeTime");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeNotIn(List<Long> values) {
            addCriterion("remove_time not in", values, "removeTime");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeBetween(Long value1, Long value2) {
            addCriterion("remove_time between", value1, value2, "removeTime");
            return (Criteria) this;
        }

        public Criteria andRemoveTimeNotBetween(Long value1, Long value2) {
            addCriterion("remove_time not between", value1, value2, "removeTime");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondIsNull() {
            addCriterion("remove_count_persecond is null");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondIsNotNull() {
            addCriterion("remove_count_persecond is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondEqualTo(String value) {
            addCriterion("remove_count_persecond =", value, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondNotEqualTo(String value) {
            addCriterion("remove_count_persecond <>", value, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondGreaterThan(String value) {
            addCriterion("remove_count_persecond >", value, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondGreaterThanOrEqualTo(String value) {
            addCriterion("remove_count_persecond >=", value, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondLessThan(String value) {
            addCriterion("remove_count_persecond <", value, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondLessThanOrEqualTo(String value) {
            addCriterion("remove_count_persecond <=", value, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondLike(String value) {
            addCriterion("remove_count_persecond like", value, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondNotLike(String value) {
            addCriterion("remove_count_persecond not like", value, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondIn(List<String> values) {
            addCriterion("remove_count_persecond in", values, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondNotIn(List<String> values) {
            addCriterion("remove_count_persecond not in", values, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondBetween(String value1, String value2) {
            addCriterion("remove_count_persecond between", value1, value2, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andRemoveCountPersecondNotBetween(String value1, String value2) {
            addCriterion("remove_count_persecond not between", value1, value2, "removeCountPersecond");
            return (Criteria) this;
        }

        public Criteria andCommandsCountIsNull() {
            addCriterion("commands_count is null");
            return (Criteria) this;
        }

        public Criteria andCommandsCountIsNotNull() {
            addCriterion("commands_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommandsCountEqualTo(Long value) {
            addCriterion("commands_count =", value, "commandsCount");
            return (Criteria) this;
        }

        public Criteria andCommandsCountNotEqualTo(Long value) {
            addCriterion("commands_count <>", value, "commandsCount");
            return (Criteria) this;
        }

        public Criteria andCommandsCountGreaterThan(Long value) {
            addCriterion("commands_count >", value, "commandsCount");
            return (Criteria) this;
        }

        public Criteria andCommandsCountGreaterThanOrEqualTo(Long value) {
            addCriterion("commands_count >=", value, "commandsCount");
            return (Criteria) this;
        }

        public Criteria andCommandsCountLessThan(Long value) {
            addCriterion("commands_count <", value, "commandsCount");
            return (Criteria) this;
        }

        public Criteria andCommandsCountLessThanOrEqualTo(Long value) {
            addCriterion("commands_count <=", value, "commandsCount");
            return (Criteria) this;
        }

        public Criteria andCommandsCountIn(List<Long> values) {
            addCriterion("commands_count in", values, "commandsCount");
            return (Criteria) this;
        }

        public Criteria andCommandsCountNotIn(List<Long> values) {
            addCriterion("commands_count not in", values, "commandsCount");
            return (Criteria) this;
        }

        public Criteria andCommandsCountBetween(Long value1, Long value2) {
            addCriterion("commands_count between", value1, value2, "commandsCount");
            return (Criteria) this;
        }

        public Criteria andCommandsCountNotBetween(Long value1, Long value2) {
            addCriterion("commands_count not between", value1, value2, "commandsCount");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeIsNull() {
            addCriterion("commands_time is null");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeIsNotNull() {
            addCriterion("commands_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeEqualTo(Long value) {
            addCriterion("commands_time =", value, "commandsTime");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeNotEqualTo(Long value) {
            addCriterion("commands_time <>", value, "commandsTime");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeGreaterThan(Long value) {
            addCriterion("commands_time >", value, "commandsTime");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("commands_time >=", value, "commandsTime");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeLessThan(Long value) {
            addCriterion("commands_time <", value, "commandsTime");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeLessThanOrEqualTo(Long value) {
            addCriterion("commands_time <=", value, "commandsTime");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeIn(List<Long> values) {
            addCriterion("commands_time in", values, "commandsTime");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeNotIn(List<Long> values) {
            addCriterion("commands_time not in", values, "commandsTime");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeBetween(Long value1, Long value2) {
            addCriterion("commands_time between", value1, value2, "commandsTime");
            return (Criteria) this;
        }

        public Criteria andCommandsTimeNotBetween(Long value1, Long value2) {
            addCriterion("commands_time not between", value1, value2, "commandsTime");
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