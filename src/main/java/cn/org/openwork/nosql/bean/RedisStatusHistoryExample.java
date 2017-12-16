package cn.org.openwork.nosql.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedisStatusHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public RedisStatusHistoryExample() {
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

        public Criteria andConnectedClientsIsNull() {
            addCriterion("connected_clients is null");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsIsNotNull() {
            addCriterion("connected_clients is not null");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsEqualTo(String value) {
            addCriterion("connected_clients =", value, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsNotEqualTo(String value) {
            addCriterion("connected_clients <>", value, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsGreaterThan(String value) {
            addCriterion("connected_clients >", value, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsGreaterThanOrEqualTo(String value) {
            addCriterion("connected_clients >=", value, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsLessThan(String value) {
            addCriterion("connected_clients <", value, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsLessThanOrEqualTo(String value) {
            addCriterion("connected_clients <=", value, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsLike(String value) {
            addCriterion("connected_clients like", value, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsNotLike(String value) {
            addCriterion("connected_clients not like", value, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsIn(List<String> values) {
            addCriterion("connected_clients in", values, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsNotIn(List<String> values) {
            addCriterion("connected_clients not in", values, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsBetween(String value1, String value2) {
            addCriterion("connected_clients between", value1, value2, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andConnectedClientsNotBetween(String value1, String value2) {
            addCriterion("connected_clients not between", value1, value2, "connectedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsIsNull() {
            addCriterion("blocked_clients is null");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsIsNotNull() {
            addCriterion("blocked_clients is not null");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsEqualTo(String value) {
            addCriterion("blocked_clients =", value, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsNotEqualTo(String value) {
            addCriterion("blocked_clients <>", value, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsGreaterThan(String value) {
            addCriterion("blocked_clients >", value, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsGreaterThanOrEqualTo(String value) {
            addCriterion("blocked_clients >=", value, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsLessThan(String value) {
            addCriterion("blocked_clients <", value, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsLessThanOrEqualTo(String value) {
            addCriterion("blocked_clients <=", value, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsLike(String value) {
            addCriterion("blocked_clients like", value, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsNotLike(String value) {
            addCriterion("blocked_clients not like", value, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsIn(List<String> values) {
            addCriterion("blocked_clients in", values, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsNotIn(List<String> values) {
            addCriterion("blocked_clients not in", values, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsBetween(String value1, String value2) {
            addCriterion("blocked_clients between", value1, value2, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andBlockedClientsNotBetween(String value1, String value2) {
            addCriterion("blocked_clients not between", value1, value2, "blockedClients");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryIsNull() {
            addCriterion("used_memory is null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryIsNotNull() {
            addCriterion("used_memory is not null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryEqualTo(String value) {
            addCriterion("used_memory =", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryNotEqualTo(String value) {
            addCriterion("used_memory <>", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryGreaterThan(String value) {
            addCriterion("used_memory >", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryGreaterThanOrEqualTo(String value) {
            addCriterion("used_memory >=", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryLessThan(String value) {
            addCriterion("used_memory <", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryLessThanOrEqualTo(String value) {
            addCriterion("used_memory <=", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryLike(String value) {
            addCriterion("used_memory like", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryNotLike(String value) {
            addCriterion("used_memory not like", value, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryIn(List<String> values) {
            addCriterion("used_memory in", values, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryNotIn(List<String> values) {
            addCriterion("used_memory not in", values, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryBetween(String value1, String value2) {
            addCriterion("used_memory between", value1, value2, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryNotBetween(String value1, String value2) {
            addCriterion("used_memory not between", value1, value2, "usedMemory");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanIsNull() {
            addCriterion("used_memory_human is null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanIsNotNull() {
            addCriterion("used_memory_human is not null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanEqualTo(String value) {
            addCriterion("used_memory_human =", value, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanNotEqualTo(String value) {
            addCriterion("used_memory_human <>", value, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanGreaterThan(String value) {
            addCriterion("used_memory_human >", value, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanGreaterThanOrEqualTo(String value) {
            addCriterion("used_memory_human >=", value, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanLessThan(String value) {
            addCriterion("used_memory_human <", value, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanLessThanOrEqualTo(String value) {
            addCriterion("used_memory_human <=", value, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanLike(String value) {
            addCriterion("used_memory_human like", value, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanNotLike(String value) {
            addCriterion("used_memory_human not like", value, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanIn(List<String> values) {
            addCriterion("used_memory_human in", values, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanNotIn(List<String> values) {
            addCriterion("used_memory_human not in", values, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanBetween(String value1, String value2) {
            addCriterion("used_memory_human between", value1, value2, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryHumanNotBetween(String value1, String value2) {
            addCriterion("used_memory_human not between", value1, value2, "usedMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssIsNull() {
            addCriterion("used_memory_rss is null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssIsNotNull() {
            addCriterion("used_memory_rss is not null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssEqualTo(String value) {
            addCriterion("used_memory_rss =", value, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssNotEqualTo(String value) {
            addCriterion("used_memory_rss <>", value, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssGreaterThan(String value) {
            addCriterion("used_memory_rss >", value, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssGreaterThanOrEqualTo(String value) {
            addCriterion("used_memory_rss >=", value, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssLessThan(String value) {
            addCriterion("used_memory_rss <", value, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssLessThanOrEqualTo(String value) {
            addCriterion("used_memory_rss <=", value, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssLike(String value) {
            addCriterion("used_memory_rss like", value, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssNotLike(String value) {
            addCriterion("used_memory_rss not like", value, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssIn(List<String> values) {
            addCriterion("used_memory_rss in", values, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssNotIn(List<String> values) {
            addCriterion("used_memory_rss not in", values, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssBetween(String value1, String value2) {
            addCriterion("used_memory_rss between", value1, value2, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssNotBetween(String value1, String value2) {
            addCriterion("used_memory_rss not between", value1, value2, "usedMemoryRss");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanIsNull() {
            addCriterion("used_memory_rss_human is null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanIsNotNull() {
            addCriterion("used_memory_rss_human is not null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanEqualTo(String value) {
            addCriterion("used_memory_rss_human =", value, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanNotEqualTo(String value) {
            addCriterion("used_memory_rss_human <>", value, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanGreaterThan(String value) {
            addCriterion("used_memory_rss_human >", value, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanGreaterThanOrEqualTo(String value) {
            addCriterion("used_memory_rss_human >=", value, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanLessThan(String value) {
            addCriterion("used_memory_rss_human <", value, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanLessThanOrEqualTo(String value) {
            addCriterion("used_memory_rss_human <=", value, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanLike(String value) {
            addCriterion("used_memory_rss_human like", value, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanNotLike(String value) {
            addCriterion("used_memory_rss_human not like", value, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanIn(List<String> values) {
            addCriterion("used_memory_rss_human in", values, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanNotIn(List<String> values) {
            addCriterion("used_memory_rss_human not in", values, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanBetween(String value1, String value2) {
            addCriterion("used_memory_rss_human between", value1, value2, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryRssHumanNotBetween(String value1, String value2) {
            addCriterion("used_memory_rss_human not between", value1, value2, "usedMemoryRssHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakIsNull() {
            addCriterion("used_memory_peak is null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakIsNotNull() {
            addCriterion("used_memory_peak is not null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakEqualTo(String value) {
            addCriterion("used_memory_peak =", value, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakNotEqualTo(String value) {
            addCriterion("used_memory_peak <>", value, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakGreaterThan(String value) {
            addCriterion("used_memory_peak >", value, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakGreaterThanOrEqualTo(String value) {
            addCriterion("used_memory_peak >=", value, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakLessThan(String value) {
            addCriterion("used_memory_peak <", value, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakLessThanOrEqualTo(String value) {
            addCriterion("used_memory_peak <=", value, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakLike(String value) {
            addCriterion("used_memory_peak like", value, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakNotLike(String value) {
            addCriterion("used_memory_peak not like", value, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakIn(List<String> values) {
            addCriterion("used_memory_peak in", values, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakNotIn(List<String> values) {
            addCriterion("used_memory_peak not in", values, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakBetween(String value1, String value2) {
            addCriterion("used_memory_peak between", value1, value2, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakNotBetween(String value1, String value2) {
            addCriterion("used_memory_peak not between", value1, value2, "usedMemoryPeak");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanIsNull() {
            addCriterion("used_memory_peak_human is null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanIsNotNull() {
            addCriterion("used_memory_peak_human is not null");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanEqualTo(String value) {
            addCriterion("used_memory_peak_human =", value, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanNotEqualTo(String value) {
            addCriterion("used_memory_peak_human <>", value, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanGreaterThan(String value) {
            addCriterion("used_memory_peak_human >", value, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanGreaterThanOrEqualTo(String value) {
            addCriterion("used_memory_peak_human >=", value, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanLessThan(String value) {
            addCriterion("used_memory_peak_human <", value, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanLessThanOrEqualTo(String value) {
            addCriterion("used_memory_peak_human <=", value, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanLike(String value) {
            addCriterion("used_memory_peak_human like", value, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanNotLike(String value) {
            addCriterion("used_memory_peak_human not like", value, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanIn(List<String> values) {
            addCriterion("used_memory_peak_human in", values, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanNotIn(List<String> values) {
            addCriterion("used_memory_peak_human not in", values, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanBetween(String value1, String value2) {
            addCriterion("used_memory_peak_human between", value1, value2, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andUsedMemoryPeakHumanNotBetween(String value1, String value2) {
            addCriterion("used_memory_peak_human not between", value1, value2, "usedMemoryPeakHuman");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioIsNull() {
            addCriterion("mem_fragmentation_ratio is null");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioIsNotNull() {
            addCriterion("mem_fragmentation_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioEqualTo(String value) {
            addCriterion("mem_fragmentation_ratio =", value, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioNotEqualTo(String value) {
            addCriterion("mem_fragmentation_ratio <>", value, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioGreaterThan(String value) {
            addCriterion("mem_fragmentation_ratio >", value, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioGreaterThanOrEqualTo(String value) {
            addCriterion("mem_fragmentation_ratio >=", value, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioLessThan(String value) {
            addCriterion("mem_fragmentation_ratio <", value, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioLessThanOrEqualTo(String value) {
            addCriterion("mem_fragmentation_ratio <=", value, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioLike(String value) {
            addCriterion("mem_fragmentation_ratio like", value, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioNotLike(String value) {
            addCriterion("mem_fragmentation_ratio not like", value, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioIn(List<String> values) {
            addCriterion("mem_fragmentation_ratio in", values, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioNotIn(List<String> values) {
            addCriterion("mem_fragmentation_ratio not in", values, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioBetween(String value1, String value2) {
            addCriterion("mem_fragmentation_ratio between", value1, value2, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andMemFragmentationRatioNotBetween(String value1, String value2) {
            addCriterion("mem_fragmentation_ratio not between", value1, value2, "memFragmentationRatio");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryIsNull() {
            addCriterion("total_system_memory is null");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryIsNotNull() {
            addCriterion("total_system_memory is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryEqualTo(String value) {
            addCriterion("total_system_memory =", value, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryNotEqualTo(String value) {
            addCriterion("total_system_memory <>", value, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryGreaterThan(String value) {
            addCriterion("total_system_memory >", value, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryGreaterThanOrEqualTo(String value) {
            addCriterion("total_system_memory >=", value, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryLessThan(String value) {
            addCriterion("total_system_memory <", value, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryLessThanOrEqualTo(String value) {
            addCriterion("total_system_memory <=", value, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryLike(String value) {
            addCriterion("total_system_memory like", value, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryNotLike(String value) {
            addCriterion("total_system_memory not like", value, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryIn(List<String> values) {
            addCriterion("total_system_memory in", values, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryNotIn(List<String> values) {
            addCriterion("total_system_memory not in", values, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryBetween(String value1, String value2) {
            addCriterion("total_system_memory between", value1, value2, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryNotBetween(String value1, String value2) {
            addCriterion("total_system_memory not between", value1, value2, "totalSystemMemory");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanIsNull() {
            addCriterion("total_system_memory_human is null");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanIsNotNull() {
            addCriterion("total_system_memory_human is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanEqualTo(String value) {
            addCriterion("total_system_memory_human =", value, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanNotEqualTo(String value) {
            addCriterion("total_system_memory_human <>", value, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanGreaterThan(String value) {
            addCriterion("total_system_memory_human >", value, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanGreaterThanOrEqualTo(String value) {
            addCriterion("total_system_memory_human >=", value, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanLessThan(String value) {
            addCriterion("total_system_memory_human <", value, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanLessThanOrEqualTo(String value) {
            addCriterion("total_system_memory_human <=", value, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanLike(String value) {
            addCriterion("total_system_memory_human like", value, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanNotLike(String value) {
            addCriterion("total_system_memory_human not like", value, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanIn(List<String> values) {
            addCriterion("total_system_memory_human in", values, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanNotIn(List<String> values) {
            addCriterion("total_system_memory_human not in", values, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanBetween(String value1, String value2) {
            addCriterion("total_system_memory_human between", value1, value2, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalSystemMemoryHumanNotBetween(String value1, String value2) {
            addCriterion("total_system_memory_human not between", value1, value2, "totalSystemMemoryHuman");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedIsNull() {
            addCriterion("total_connections_received is null");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedIsNotNull() {
            addCriterion("total_connections_received is not null");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedEqualTo(String value) {
            addCriterion("total_connections_received =", value, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedNotEqualTo(String value) {
            addCriterion("total_connections_received <>", value, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedGreaterThan(String value) {
            addCriterion("total_connections_received >", value, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedGreaterThanOrEqualTo(String value) {
            addCriterion("total_connections_received >=", value, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedLessThan(String value) {
            addCriterion("total_connections_received <", value, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedLessThanOrEqualTo(String value) {
            addCriterion("total_connections_received <=", value, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedLike(String value) {
            addCriterion("total_connections_received like", value, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedNotLike(String value) {
            addCriterion("total_connections_received not like", value, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedIn(List<String> values) {
            addCriterion("total_connections_received in", values, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedNotIn(List<String> values) {
            addCriterion("total_connections_received not in", values, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedBetween(String value1, String value2) {
            addCriterion("total_connections_received between", value1, value2, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsReceivedNotBetween(String value1, String value2) {
            addCriterion("total_connections_received not between", value1, value2, "totalConnectionsReceived");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedIsNull() {
            addCriterion("total_commands_processed is null");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedIsNotNull() {
            addCriterion("total_commands_processed is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedEqualTo(String value) {
            addCriterion("total_commands_processed =", value, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedNotEqualTo(String value) {
            addCriterion("total_commands_processed <>", value, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedGreaterThan(String value) {
            addCriterion("total_commands_processed >", value, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedGreaterThanOrEqualTo(String value) {
            addCriterion("total_commands_processed >=", value, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedLessThan(String value) {
            addCriterion("total_commands_processed <", value, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedLessThanOrEqualTo(String value) {
            addCriterion("total_commands_processed <=", value, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedLike(String value) {
            addCriterion("total_commands_processed like", value, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedNotLike(String value) {
            addCriterion("total_commands_processed not like", value, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedIn(List<String> values) {
            addCriterion("total_commands_processed in", values, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedNotIn(List<String> values) {
            addCriterion("total_commands_processed not in", values, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedBetween(String value1, String value2) {
            addCriterion("total_commands_processed between", value1, value2, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andTotalCommandsProcessedNotBetween(String value1, String value2) {
            addCriterion("total_commands_processed not between", value1, value2, "totalCommandsProcessed");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecIsNull() {
            addCriterion("instantaneous_ops_per_sec is null");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecIsNotNull() {
            addCriterion("instantaneous_ops_per_sec is not null");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecEqualTo(String value) {
            addCriterion("instantaneous_ops_per_sec =", value, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecNotEqualTo(String value) {
            addCriterion("instantaneous_ops_per_sec <>", value, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecGreaterThan(String value) {
            addCriterion("instantaneous_ops_per_sec >", value, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecGreaterThanOrEqualTo(String value) {
            addCriterion("instantaneous_ops_per_sec >=", value, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecLessThan(String value) {
            addCriterion("instantaneous_ops_per_sec <", value, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecLessThanOrEqualTo(String value) {
            addCriterion("instantaneous_ops_per_sec <=", value, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecLike(String value) {
            addCriterion("instantaneous_ops_per_sec like", value, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecNotLike(String value) {
            addCriterion("instantaneous_ops_per_sec not like", value, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecIn(List<String> values) {
            addCriterion("instantaneous_ops_per_sec in", values, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecNotIn(List<String> values) {
            addCriterion("instantaneous_ops_per_sec not in", values, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecBetween(String value1, String value2) {
            addCriterion("instantaneous_ops_per_sec between", value1, value2, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andInstantaneousOpsPerSecNotBetween(String value1, String value2) {
            addCriterion("instantaneous_ops_per_sec not between", value1, value2, "instantaneousOpsPerSec");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesIsNull() {
            addCriterion("total_net_input_bytes is null");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesIsNotNull() {
            addCriterion("total_net_input_bytes is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesEqualTo(String value) {
            addCriterion("total_net_input_bytes =", value, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesNotEqualTo(String value) {
            addCriterion("total_net_input_bytes <>", value, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesGreaterThan(String value) {
            addCriterion("total_net_input_bytes >", value, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesGreaterThanOrEqualTo(String value) {
            addCriterion("total_net_input_bytes >=", value, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesLessThan(String value) {
            addCriterion("total_net_input_bytes <", value, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesLessThanOrEqualTo(String value) {
            addCriterion("total_net_input_bytes <=", value, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesLike(String value) {
            addCriterion("total_net_input_bytes like", value, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesNotLike(String value) {
            addCriterion("total_net_input_bytes not like", value, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesIn(List<String> values) {
            addCriterion("total_net_input_bytes in", values, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesNotIn(List<String> values) {
            addCriterion("total_net_input_bytes not in", values, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesBetween(String value1, String value2) {
            addCriterion("total_net_input_bytes between", value1, value2, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetInputBytesNotBetween(String value1, String value2) {
            addCriterion("total_net_input_bytes not between", value1, value2, "totalNetInputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesIsNull() {
            addCriterion("total_net_output_bytes is null");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesIsNotNull() {
            addCriterion("total_net_output_bytes is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesEqualTo(String value) {
            addCriterion("total_net_output_bytes =", value, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesNotEqualTo(String value) {
            addCriterion("total_net_output_bytes <>", value, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesGreaterThan(String value) {
            addCriterion("total_net_output_bytes >", value, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesGreaterThanOrEqualTo(String value) {
            addCriterion("total_net_output_bytes >=", value, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesLessThan(String value) {
            addCriterion("total_net_output_bytes <", value, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesLessThanOrEqualTo(String value) {
            addCriterion("total_net_output_bytes <=", value, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesLike(String value) {
            addCriterion("total_net_output_bytes like", value, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesNotLike(String value) {
            addCriterion("total_net_output_bytes not like", value, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesIn(List<String> values) {
            addCriterion("total_net_output_bytes in", values, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesNotIn(List<String> values) {
            addCriterion("total_net_output_bytes not in", values, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesBetween(String value1, String value2) {
            addCriterion("total_net_output_bytes between", value1, value2, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andTotalNetOutputBytesNotBetween(String value1, String value2) {
            addCriterion("total_net_output_bytes not between", value1, value2, "totalNetOutputBytes");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysIsNull() {
            addCriterion("expired_keys is null");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysIsNotNull() {
            addCriterion("expired_keys is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysEqualTo(String value) {
            addCriterion("expired_keys =", value, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysNotEqualTo(String value) {
            addCriterion("expired_keys <>", value, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysGreaterThan(String value) {
            addCriterion("expired_keys >", value, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysGreaterThanOrEqualTo(String value) {
            addCriterion("expired_keys >=", value, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysLessThan(String value) {
            addCriterion("expired_keys <", value, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysLessThanOrEqualTo(String value) {
            addCriterion("expired_keys <=", value, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysLike(String value) {
            addCriterion("expired_keys like", value, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysNotLike(String value) {
            addCriterion("expired_keys not like", value, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysIn(List<String> values) {
            addCriterion("expired_keys in", values, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysNotIn(List<String> values) {
            addCriterion("expired_keys not in", values, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysBetween(String value1, String value2) {
            addCriterion("expired_keys between", value1, value2, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andExpiredKeysNotBetween(String value1, String value2) {
            addCriterion("expired_keys not between", value1, value2, "expiredKeys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysIsNull() {
            addCriterion("used_cpu_sys is null");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysIsNotNull() {
            addCriterion("used_cpu_sys is not null");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysEqualTo(String value) {
            addCriterion("used_cpu_sys =", value, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysNotEqualTo(String value) {
            addCriterion("used_cpu_sys <>", value, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysGreaterThan(String value) {
            addCriterion("used_cpu_sys >", value, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysGreaterThanOrEqualTo(String value) {
            addCriterion("used_cpu_sys >=", value, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysLessThan(String value) {
            addCriterion("used_cpu_sys <", value, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysLessThanOrEqualTo(String value) {
            addCriterion("used_cpu_sys <=", value, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysLike(String value) {
            addCriterion("used_cpu_sys like", value, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysNotLike(String value) {
            addCriterion("used_cpu_sys not like", value, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysIn(List<String> values) {
            addCriterion("used_cpu_sys in", values, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysNotIn(List<String> values) {
            addCriterion("used_cpu_sys not in", values, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysBetween(String value1, String value2) {
            addCriterion("used_cpu_sys between", value1, value2, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuSysNotBetween(String value1, String value2) {
            addCriterion("used_cpu_sys not between", value1, value2, "usedCpuSys");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserIsNull() {
            addCriterion("used_cpu_user is null");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserIsNotNull() {
            addCriterion("used_cpu_user is not null");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserEqualTo(String value) {
            addCriterion("used_cpu_user =", value, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserNotEqualTo(String value) {
            addCriterion("used_cpu_user <>", value, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserGreaterThan(String value) {
            addCriterion("used_cpu_user >", value, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserGreaterThanOrEqualTo(String value) {
            addCriterion("used_cpu_user >=", value, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserLessThan(String value) {
            addCriterion("used_cpu_user <", value, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserLessThanOrEqualTo(String value) {
            addCriterion("used_cpu_user <=", value, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserLike(String value) {
            addCriterion("used_cpu_user like", value, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserNotLike(String value) {
            addCriterion("used_cpu_user not like", value, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserIn(List<String> values) {
            addCriterion("used_cpu_user in", values, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserNotIn(List<String> values) {
            addCriterion("used_cpu_user not in", values, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserBetween(String value1, String value2) {
            addCriterion("used_cpu_user between", value1, value2, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andUsedCpuUserNotBetween(String value1, String value2) {
            addCriterion("used_cpu_user not between", value1, value2, "usedCpuUser");
            return (Criteria) this;
        }

        public Criteria andKeyspaceIsNull() {
            addCriterion("keyspace is null");
            return (Criteria) this;
        }

        public Criteria andKeyspaceIsNotNull() {
            addCriterion("keyspace is not null");
            return (Criteria) this;
        }

        public Criteria andKeyspaceEqualTo(String value) {
            addCriterion("keyspace =", value, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceNotEqualTo(String value) {
            addCriterion("keyspace <>", value, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceGreaterThan(String value) {
            addCriterion("keyspace >", value, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceGreaterThanOrEqualTo(String value) {
            addCriterion("keyspace >=", value, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceLessThan(String value) {
            addCriterion("keyspace <", value, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceLessThanOrEqualTo(String value) {
            addCriterion("keyspace <=", value, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceLike(String value) {
            addCriterion("keyspace like", value, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceNotLike(String value) {
            addCriterion("keyspace not like", value, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceIn(List<String> values) {
            addCriterion("keyspace in", values, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceNotIn(List<String> values) {
            addCriterion("keyspace not in", values, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceBetween(String value1, String value2) {
            addCriterion("keyspace between", value1, value2, "keyspace");
            return (Criteria) this;
        }

        public Criteria andKeyspaceNotBetween(String value1, String value2) {
            addCriterion("keyspace not between", value1, value2, "keyspace");
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