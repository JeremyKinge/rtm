package com.kingge.rtm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TKDeadMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TKDeadMessageExample() {
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

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(String value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(String value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(String value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(String value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(String value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLike(String value) {
            addCriterion("msg_id like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotLike(String value) {
            addCriterion("msg_id not like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<String> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<String> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(String value1, String value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(String value1, String value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgNameIsNull() {
            addCriterion("msg_name is null");
            return (Criteria) this;
        }

        public Criteria andMsgNameIsNotNull() {
            addCriterion("msg_name is not null");
            return (Criteria) this;
        }

        public Criteria andMsgNameEqualTo(String value) {
            addCriterion("msg_name =", value, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameNotEqualTo(String value) {
            addCriterion("msg_name <>", value, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameGreaterThan(String value) {
            addCriterion("msg_name >", value, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameGreaterThanOrEqualTo(String value) {
            addCriterion("msg_name >=", value, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameLessThan(String value) {
            addCriterion("msg_name <", value, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameLessThanOrEqualTo(String value) {
            addCriterion("msg_name <=", value, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameLike(String value) {
            addCriterion("msg_name like", value, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameNotLike(String value) {
            addCriterion("msg_name not like", value, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameIn(List<String> values) {
            addCriterion("msg_name in", values, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameNotIn(List<String> values) {
            addCriterion("msg_name not in", values, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameBetween(String value1, String value2) {
            addCriterion("msg_name between", value1, value2, "msgName");
            return (Criteria) this;
        }

        public Criteria andMsgNameNotBetween(String value1, String value2) {
            addCriterion("msg_name not between", value1, value2, "msgName");
            return (Criteria) this;
        }

        public Criteria andTopicIsNull() {
            addCriterion("topic is null");
            return (Criteria) this;
        }

        public Criteria andTopicIsNotNull() {
            addCriterion("topic is not null");
            return (Criteria) this;
        }

        public Criteria andTopicEqualTo(String value) {
            addCriterion("topic =", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotEqualTo(String value) {
            addCriterion("topic <>", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThan(String value) {
            addCriterion("topic >", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThanOrEqualTo(String value) {
            addCriterion("topic >=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThan(String value) {
            addCriterion("topic <", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThanOrEqualTo(String value) {
            addCriterion("topic <=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLike(String value) {
            addCriterion("topic like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotLike(String value) {
            addCriterion("topic not like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicIn(List<String> values) {
            addCriterion("topic in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotIn(List<String> values) {
            addCriterion("topic not in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicBetween(String value1, String value2) {
            addCriterion("topic between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotBetween(String value1, String value2) {
            addCriterion("topic not between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andQueneNameIsNull() {
            addCriterion("quene_name is null");
            return (Criteria) this;
        }

        public Criteria andQueneNameIsNotNull() {
            addCriterion("quene_name is not null");
            return (Criteria) this;
        }

        public Criteria andQueneNameEqualTo(String value) {
            addCriterion("quene_name =", value, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameNotEqualTo(String value) {
            addCriterion("quene_name <>", value, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameGreaterThan(String value) {
            addCriterion("quene_name >", value, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameGreaterThanOrEqualTo(String value) {
            addCriterion("quene_name >=", value, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameLessThan(String value) {
            addCriterion("quene_name <", value, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameLessThanOrEqualTo(String value) {
            addCriterion("quene_name <=", value, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameLike(String value) {
            addCriterion("quene_name like", value, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameNotLike(String value) {
            addCriterion("quene_name not like", value, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameIn(List<String> values) {
            addCriterion("quene_name in", values, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameNotIn(List<String> values) {
            addCriterion("quene_name not in", values, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameBetween(String value1, String value2) {
            addCriterion("quene_name between", value1, value2, "queneName");
            return (Criteria) this;
        }

        public Criteria andQueneNameNotBetween(String value1, String value2) {
            addCriterion("quene_name not between", value1, value2, "queneName");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNull() {
            addCriterion("msg_content is null");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNotNull() {
            addCriterion("msg_content is not null");
            return (Criteria) this;
        }

        public Criteria andMsgContentEqualTo(String value) {
            addCriterion("msg_content =", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotEqualTo(String value) {
            addCriterion("msg_content <>", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThan(String value) {
            addCriterion("msg_content >", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThanOrEqualTo(String value) {
            addCriterion("msg_content >=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThan(String value) {
            addCriterion("msg_content <", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThanOrEqualTo(String value) {
            addCriterion("msg_content <=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLike(String value) {
            addCriterion("msg_content like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotLike(String value) {
            addCriterion("msg_content not like", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentIn(List<String> values) {
            addCriterion("msg_content in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotIn(List<String> values) {
            addCriterion("msg_content not in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentBetween(String value1, String value2) {
            addCriterion("msg_content between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotBetween(String value1, String value2) {
            addCriterion("msg_content not between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgStatusIsNull() {
            addCriterion("msg_status is null");
            return (Criteria) this;
        }

        public Criteria andMsgStatusIsNotNull() {
            addCriterion("msg_status is not null");
            return (Criteria) this;
        }

        public Criteria andMsgStatusEqualTo(String value) {
            addCriterion("msg_status =", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusNotEqualTo(String value) {
            addCriterion("msg_status <>", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusGreaterThan(String value) {
            addCriterion("msg_status >", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusGreaterThanOrEqualTo(String value) {
            addCriterion("msg_status >=", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusLessThan(String value) {
            addCriterion("msg_status <", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusLessThanOrEqualTo(String value) {
            addCriterion("msg_status <=", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusLike(String value) {
            addCriterion("msg_status like", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusNotLike(String value) {
            addCriterion("msg_status not like", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusIn(List<String> values) {
            addCriterion("msg_status in", values, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusNotIn(List<String> values) {
            addCriterion("msg_status not in", values, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusBetween(String value1, String value2) {
            addCriterion("msg_status between", value1, value2, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusNotBetween(String value1, String value2) {
            addCriterion("msg_status not between", value1, value2, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusIsNull() {
            addCriterion("msg_d_status is null");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusIsNotNull() {
            addCriterion("msg_d_status is not null");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusEqualTo(String value) {
            addCriterion("msg_d_status =", value, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusNotEqualTo(String value) {
            addCriterion("msg_d_status <>", value, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusGreaterThan(String value) {
            addCriterion("msg_d_status >", value, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusGreaterThanOrEqualTo(String value) {
            addCriterion("msg_d_status >=", value, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusLessThan(String value) {
            addCriterion("msg_d_status <", value, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusLessThanOrEqualTo(String value) {
            addCriterion("msg_d_status <=", value, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusLike(String value) {
            addCriterion("msg_d_status like", value, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusNotLike(String value) {
            addCriterion("msg_d_status not like", value, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusIn(List<String> values) {
            addCriterion("msg_d_status in", values, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusNotIn(List<String> values) {
            addCriterion("msg_d_status not in", values, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusBetween(String value1, String value2) {
            addCriterion("msg_d_status between", value1, value2, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andMsgDStatusNotBetween(String value1, String value2) {
            addCriterion("msg_d_status not between", value1, value2, "msgDStatus");
            return (Criteria) this;
        }

        public Criteria andRetryCountsIsNull() {
            addCriterion("retry_counts is null");
            return (Criteria) this;
        }

        public Criteria andRetryCountsIsNotNull() {
            addCriterion("retry_counts is not null");
            return (Criteria) this;
        }

        public Criteria andRetryCountsEqualTo(String value) {
            addCriterion("retry_counts =", value, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsNotEqualTo(String value) {
            addCriterion("retry_counts <>", value, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsGreaterThan(String value) {
            addCriterion("retry_counts >", value, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsGreaterThanOrEqualTo(String value) {
            addCriterion("retry_counts >=", value, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsLessThan(String value) {
            addCriterion("retry_counts <", value, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsLessThanOrEqualTo(String value) {
            addCriterion("retry_counts <=", value, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsLike(String value) {
            addCriterion("retry_counts like", value, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsNotLike(String value) {
            addCriterion("retry_counts not like", value, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsIn(List<String> values) {
            addCriterion("retry_counts in", values, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsNotIn(List<String> values) {
            addCriterion("retry_counts not in", values, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsBetween(String value1, String value2) {
            addCriterion("retry_counts between", value1, value2, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andRetryCountsNotBetween(String value1, String value2) {
            addCriterion("retry_counts not between", value1, value2, "retryCounts");
            return (Criteria) this;
        }

        public Criteria andCheckUrlIsNull() {
            addCriterion("check_url is null");
            return (Criteria) this;
        }

        public Criteria andCheckUrlIsNotNull() {
            addCriterion("check_url is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUrlEqualTo(String value) {
            addCriterion("check_url =", value, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlNotEqualTo(String value) {
            addCriterion("check_url <>", value, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlGreaterThan(String value) {
            addCriterion("check_url >", value, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlGreaterThanOrEqualTo(String value) {
            addCriterion("check_url >=", value, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlLessThan(String value) {
            addCriterion("check_url <", value, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlLessThanOrEqualTo(String value) {
            addCriterion("check_url <=", value, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlLike(String value) {
            addCriterion("check_url like", value, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlNotLike(String value) {
            addCriterion("check_url not like", value, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlIn(List<String> values) {
            addCriterion("check_url in", values, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlNotIn(List<String> values) {
            addCriterion("check_url not in", values, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlBetween(String value1, String value2) {
            addCriterion("check_url between", value1, value2, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckUrlNotBetween(String value1, String value2) {
            addCriterion("check_url not between", value1, value2, "checkUrl");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutIsNull() {
            addCriterion("check_timeout is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutIsNotNull() {
            addCriterion("check_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutEqualTo(String value) {
            addCriterion("check_timeout =", value, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutNotEqualTo(String value) {
            addCriterion("check_timeout <>", value, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutGreaterThan(String value) {
            addCriterion("check_timeout >", value, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutGreaterThanOrEqualTo(String value) {
            addCriterion("check_timeout >=", value, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutLessThan(String value) {
            addCriterion("check_timeout <", value, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutLessThanOrEqualTo(String value) {
            addCriterion("check_timeout <=", value, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutLike(String value) {
            addCriterion("check_timeout like", value, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutNotLike(String value) {
            addCriterion("check_timeout not like", value, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutIn(List<String> values) {
            addCriterion("check_timeout in", values, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutNotIn(List<String> values) {
            addCriterion("check_timeout not in", values, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutBetween(String value1, String value2) {
            addCriterion("check_timeout between", value1, value2, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckTimeoutNotBetween(String value1, String value2) {
            addCriterion("check_timeout not between", value1, value2, "checkTimeout");
            return (Criteria) this;
        }

        public Criteria andCheckDurationIsNull() {
            addCriterion("check_duration is null");
            return (Criteria) this;
        }

        public Criteria andCheckDurationIsNotNull() {
            addCriterion("check_duration is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDurationEqualTo(String value) {
            addCriterion("check_duration =", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationNotEqualTo(String value) {
            addCriterion("check_duration <>", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationGreaterThan(String value) {
            addCriterion("check_duration >", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationGreaterThanOrEqualTo(String value) {
            addCriterion("check_duration >=", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationLessThan(String value) {
            addCriterion("check_duration <", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationLessThanOrEqualTo(String value) {
            addCriterion("check_duration <=", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationLike(String value) {
            addCriterion("check_duration like", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationNotLike(String value) {
            addCriterion("check_duration not like", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationIn(List<String> values) {
            addCriterion("check_duration in", values, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationNotIn(List<String> values) {
            addCriterion("check_duration not in", values, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationBetween(String value1, String value2) {
            addCriterion("check_duration between", value1, value2, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationNotBetween(String value1, String value2) {
            addCriterion("check_duration not between", value1, value2, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidIsNull() {
            addCriterion("create_msg_uid is null");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidIsNotNull() {
            addCriterion("create_msg_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidEqualTo(String value) {
            addCriterion("create_msg_uid =", value, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidNotEqualTo(String value) {
            addCriterion("create_msg_uid <>", value, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidGreaterThan(String value) {
            addCriterion("create_msg_uid >", value, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidGreaterThanOrEqualTo(String value) {
            addCriterion("create_msg_uid >=", value, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidLessThan(String value) {
            addCriterion("create_msg_uid <", value, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidLessThanOrEqualTo(String value) {
            addCriterion("create_msg_uid <=", value, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidLike(String value) {
            addCriterion("create_msg_uid like", value, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidNotLike(String value) {
            addCriterion("create_msg_uid not like", value, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidIn(List<String> values) {
            addCriterion("create_msg_uid in", values, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidNotIn(List<String> values) {
            addCriterion("create_msg_uid not in", values, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidBetween(String value1, String value2) {
            addCriterion("create_msg_uid between", value1, value2, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgUidNotBetween(String value1, String value2) {
            addCriterion("create_msg_uid not between", value1, value2, "createMsgUid");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeIsNull() {
            addCriterion("create_msg_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeIsNotNull() {
            addCriterion("create_msg_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeEqualTo(Date value) {
            addCriterion("create_msg_time =", value, "createMsgTime");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeNotEqualTo(Date value) {
            addCriterion("create_msg_time <>", value, "createMsgTime");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeGreaterThan(Date value) {
            addCriterion("create_msg_time >", value, "createMsgTime");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_msg_time >=", value, "createMsgTime");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeLessThan(Date value) {
            addCriterion("create_msg_time <", value, "createMsgTime");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_msg_time <=", value, "createMsgTime");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeIn(List<Date> values) {
            addCriterion("create_msg_time in", values, "createMsgTime");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeNotIn(List<Date> values) {
            addCriterion("create_msg_time not in", values, "createMsgTime");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeBetween(Date value1, Date value2) {
            addCriterion("create_msg_time between", value1, value2, "createMsgTime");
            return (Criteria) this;
        }

        public Criteria andCreateMsgTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_msg_time not between", value1, value2, "createMsgTime");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidIsNull() {
            addCriterion("update_msg_uid is null");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidIsNotNull() {
            addCriterion("update_msg_uid is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidEqualTo(String value) {
            addCriterion("update_msg_uid =", value, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidNotEqualTo(String value) {
            addCriterion("update_msg_uid <>", value, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidGreaterThan(String value) {
            addCriterion("update_msg_uid >", value, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidGreaterThanOrEqualTo(String value) {
            addCriterion("update_msg_uid >=", value, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidLessThan(String value) {
            addCriterion("update_msg_uid <", value, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidLessThanOrEqualTo(String value) {
            addCriterion("update_msg_uid <=", value, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidLike(String value) {
            addCriterion("update_msg_uid like", value, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidNotLike(String value) {
            addCriterion("update_msg_uid not like", value, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidIn(List<String> values) {
            addCriterion("update_msg_uid in", values, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidNotIn(List<String> values) {
            addCriterion("update_msg_uid not in", values, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidBetween(String value1, String value2) {
            addCriterion("update_msg_uid between", value1, value2, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgUidNotBetween(String value1, String value2) {
            addCriterion("update_msg_uid not between", value1, value2, "updateMsgUid");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeIsNull() {
            addCriterion("update_msg_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeIsNotNull() {
            addCriterion("update_msg_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeEqualTo(Date value) {
            addCriterion("update_msg_time =", value, "updateMsgTime");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeNotEqualTo(Date value) {
            addCriterion("update_msg_time <>", value, "updateMsgTime");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeGreaterThan(Date value) {
            addCriterion("update_msg_time >", value, "updateMsgTime");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_msg_time >=", value, "updateMsgTime");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeLessThan(Date value) {
            addCriterion("update_msg_time <", value, "updateMsgTime");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_msg_time <=", value, "updateMsgTime");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeIn(List<Date> values) {
            addCriterion("update_msg_time in", values, "updateMsgTime");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeNotIn(List<Date> values) {
            addCriterion("update_msg_time not in", values, "updateMsgTime");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeBetween(Date value1, Date value2) {
            addCriterion("update_msg_time between", value1, value2, "updateMsgTime");
            return (Criteria) this;
        }

        public Criteria andUpdateMsgTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_msg_time not between", value1, value2, "updateMsgTime");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeIsNull() {
            addCriterion("confirm_msg_time is null");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeIsNotNull() {
            addCriterion("confirm_msg_time is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeEqualTo(Date value) {
            addCriterion("confirm_msg_time =", value, "confirmMsgTime");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeNotEqualTo(Date value) {
            addCriterion("confirm_msg_time <>", value, "confirmMsgTime");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeGreaterThan(Date value) {
            addCriterion("confirm_msg_time >", value, "confirmMsgTime");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("confirm_msg_time >=", value, "confirmMsgTime");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeLessThan(Date value) {
            addCriterion("confirm_msg_time <", value, "confirmMsgTime");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeLessThanOrEqualTo(Date value) {
            addCriterion("confirm_msg_time <=", value, "confirmMsgTime");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeIn(List<Date> values) {
            addCriterion("confirm_msg_time in", values, "confirmMsgTime");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeNotIn(List<Date> values) {
            addCriterion("confirm_msg_time not in", values, "confirmMsgTime");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeBetween(Date value1, Date value2) {
            addCriterion("confirm_msg_time between", value1, value2, "confirmMsgTime");
            return (Criteria) this;
        }

        public Criteria andConfirmMsgTimeNotBetween(Date value1, Date value2) {
            addCriterion("confirm_msg_time not between", value1, value2, "confirmMsgTime");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidIsNull() {
            addCriterion("resend_msg_uid is null");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidIsNotNull() {
            addCriterion("resend_msg_uid is not null");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidEqualTo(String value) {
            addCriterion("resend_msg_uid =", value, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidNotEqualTo(String value) {
            addCriterion("resend_msg_uid <>", value, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidGreaterThan(String value) {
            addCriterion("resend_msg_uid >", value, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidGreaterThanOrEqualTo(String value) {
            addCriterion("resend_msg_uid >=", value, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidLessThan(String value) {
            addCriterion("resend_msg_uid <", value, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidLessThanOrEqualTo(String value) {
            addCriterion("resend_msg_uid <=", value, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidLike(String value) {
            addCriterion("resend_msg_uid like", value, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidNotLike(String value) {
            addCriterion("resend_msg_uid not like", value, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidIn(List<String> values) {
            addCriterion("resend_msg_uid in", values, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidNotIn(List<String> values) {
            addCriterion("resend_msg_uid not in", values, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidBetween(String value1, String value2) {
            addCriterion("resend_msg_uid between", value1, value2, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgUidNotBetween(String value1, String value2) {
            addCriterion("resend_msg_uid not between", value1, value2, "resendMsgUid");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeIsNull() {
            addCriterion("resend_msg_time is null");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeIsNotNull() {
            addCriterion("resend_msg_time is not null");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeEqualTo(Date value) {
            addCriterion("resend_msg_time =", value, "resendMsgTime");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeNotEqualTo(Date value) {
            addCriterion("resend_msg_time <>", value, "resendMsgTime");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeGreaterThan(Date value) {
            addCriterion("resend_msg_time >", value, "resendMsgTime");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("resend_msg_time >=", value, "resendMsgTime");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeLessThan(Date value) {
            addCriterion("resend_msg_time <", value, "resendMsgTime");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeLessThanOrEqualTo(Date value) {
            addCriterion("resend_msg_time <=", value, "resendMsgTime");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeIn(List<Date> values) {
            addCriterion("resend_msg_time in", values, "resendMsgTime");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeNotIn(List<Date> values) {
            addCriterion("resend_msg_time not in", values, "resendMsgTime");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeBetween(Date value1, Date value2) {
            addCriterion("resend_msg_time between", value1, value2, "resendMsgTime");
            return (Criteria) this;
        }

        public Criteria andResendMsgTimeNotBetween(Date value1, Date value2) {
            addCriterion("resend_msg_time not between", value1, value2, "resendMsgTime");
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