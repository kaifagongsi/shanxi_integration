package com.kfgs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbStandardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbStandardExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andStandardNumberIsNull() {
            addCriterion("standard_number is null");
            return (Criteria) this;
        }

        public Criteria andStandardNumberIsNotNull() {
            addCriterion("standard_number is not null");
            return (Criteria) this;
        }

        public Criteria andStandardNumberEqualTo(String value) {
            addCriterion("standard_number =", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberNotEqualTo(String value) {
            addCriterion("standard_number <>", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberGreaterThan(String value) {
            addCriterion("standard_number >", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("standard_number >=", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberLessThan(String value) {
            addCriterion("standard_number <", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberLessThanOrEqualTo(String value) {
            addCriterion("standard_number <=", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberLike(String value) {
            addCriterion("standard_number like", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberNotLike(String value) {
            addCriterion("standard_number not like", value, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberIn(List<String> values) {
            addCriterion("standard_number in", values, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberNotIn(List<String> values) {
            addCriterion("standard_number not in", values, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberBetween(String value1, String value2) {
            addCriterion("standard_number between", value1, value2, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNumberNotBetween(String value1, String value2) {
            addCriterion("standard_number not between", value1, value2, "standardNumber");
            return (Criteria) this;
        }

        public Criteria andStandardNameIsNull() {
            addCriterion("standard_name is null");
            return (Criteria) this;
        }

        public Criteria andStandardNameIsNotNull() {
            addCriterion("standard_name is not null");
            return (Criteria) this;
        }

        public Criteria andStandardNameEqualTo(String value) {
            addCriterion("standard_name =", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameNotEqualTo(String value) {
            addCriterion("standard_name <>", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameGreaterThan(String value) {
            addCriterion("standard_name >", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameGreaterThanOrEqualTo(String value) {
            addCriterion("standard_name >=", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameLessThan(String value) {
            addCriterion("standard_name <", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameLessThanOrEqualTo(String value) {
            addCriterion("standard_name <=", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameLike(String value) {
            addCriterion("standard_name like", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameNotLike(String value) {
            addCriterion("standard_name not like", value, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameIn(List<String> values) {
            addCriterion("standard_name in", values, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameNotIn(List<String> values) {
            addCriterion("standard_name not in", values, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameBetween(String value1, String value2) {
            addCriterion("standard_name between", value1, value2, "standardName");
            return (Criteria) this;
        }

        public Criteria andStandardNameNotBetween(String value1, String value2) {
            addCriterion("standard_name not between", value1, value2, "standardName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andImplementTimeIsNull() {
            addCriterion("implement_time is null");
            return (Criteria) this;
        }

        public Criteria andImplementTimeIsNotNull() {
            addCriterion("implement_time is not null");
            return (Criteria) this;
        }

        public Criteria andImplementTimeEqualTo(Date value) {
            addCriterion("implement_time =", value, "implementTime");
            return (Criteria) this;
        }

        public Criteria andImplementTimeNotEqualTo(Date value) {
            addCriterion("implement_time <>", value, "implementTime");
            return (Criteria) this;
        }

        public Criteria andImplementTimeGreaterThan(Date value) {
            addCriterion("implement_time >", value, "implementTime");
            return (Criteria) this;
        }

        public Criteria andImplementTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("implement_time >=", value, "implementTime");
            return (Criteria) this;
        }

        public Criteria andImplementTimeLessThan(Date value) {
            addCriterion("implement_time <", value, "implementTime");
            return (Criteria) this;
        }

        public Criteria andImplementTimeLessThanOrEqualTo(Date value) {
            addCriterion("implement_time <=", value, "implementTime");
            return (Criteria) this;
        }

        public Criteria andImplementTimeIn(List<Date> values) {
            addCriterion("implement_time in", values, "implementTime");
            return (Criteria) this;
        }

        public Criteria andImplementTimeNotIn(List<Date> values) {
            addCriterion("implement_time not in", values, "implementTime");
            return (Criteria) this;
        }

        public Criteria andImplementTimeBetween(Date value1, Date value2) {
            addCriterion("implement_time between", value1, value2, "implementTime");
            return (Criteria) this;
        }

        public Criteria andImplementTimeNotBetween(Date value1, Date value2) {
            addCriterion("implement_time not between", value1, value2, "implementTime");
            return (Criteria) this;
        }

        public Criteria andRecordNumberIsNull() {
            addCriterion("record_number is null");
            return (Criteria) this;
        }

        public Criteria andRecordNumberIsNotNull() {
            addCriterion("record_number is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNumberEqualTo(String value) {
            addCriterion("record_number =", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberNotEqualTo(String value) {
            addCriterion("record_number <>", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberGreaterThan(String value) {
            addCriterion("record_number >", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberGreaterThanOrEqualTo(String value) {
            addCriterion("record_number >=", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberLessThan(String value) {
            addCriterion("record_number <", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberLessThanOrEqualTo(String value) {
            addCriterion("record_number <=", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberLike(String value) {
            addCriterion("record_number like", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberNotLike(String value) {
            addCriterion("record_number not like", value, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberIn(List<String> values) {
            addCriterion("record_number in", values, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberNotIn(List<String> values) {
            addCriterion("record_number not in", values, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberBetween(String value1, String value2) {
            addCriterion("record_number between", value1, value2, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordNumberNotBetween(String value1, String value2) {
            addCriterion("record_number not between", value1, value2, "recordNumber");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Date value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Date value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Date value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Date value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Date> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Date> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Date value1, Date value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionIsNull() {
            addCriterion("setting_or_revision is null");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionIsNotNull() {
            addCriterion("setting_or_revision is not null");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionEqualTo(String value) {
            addCriterion("setting_or_revision =", value, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionNotEqualTo(String value) {
            addCriterion("setting_or_revision <>", value, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionGreaterThan(String value) {
            addCriterion("setting_or_revision >", value, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionGreaterThanOrEqualTo(String value) {
            addCriterion("setting_or_revision >=", value, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionLessThan(String value) {
            addCriterion("setting_or_revision <", value, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionLessThanOrEqualTo(String value) {
            addCriterion("setting_or_revision <=", value, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionLike(String value) {
            addCriterion("setting_or_revision like", value, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionNotLike(String value) {
            addCriterion("setting_or_revision not like", value, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionIn(List<String> values) {
            addCriterion("setting_or_revision in", values, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionNotIn(List<String> values) {
            addCriterion("setting_or_revision not in", values, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionBetween(String value1, String value2) {
            addCriterion("setting_or_revision between", value1, value2, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andSettingOrRevisionNotBetween(String value1, String value2) {
            addCriterion("setting_or_revision not between", value1, value2, "settingOrRevision");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardIsNull() {
            addCriterion("replace_standard is null");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardIsNotNull() {
            addCriterion("replace_standard is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardEqualTo(String value) {
            addCriterion("replace_standard =", value, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardNotEqualTo(String value) {
            addCriterion("replace_standard <>", value, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardGreaterThan(String value) {
            addCriterion("replace_standard >", value, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardGreaterThanOrEqualTo(String value) {
            addCriterion("replace_standard >=", value, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardLessThan(String value) {
            addCriterion("replace_standard <", value, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardLessThanOrEqualTo(String value) {
            addCriterion("replace_standard <=", value, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardLike(String value) {
            addCriterion("replace_standard like", value, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardNotLike(String value) {
            addCriterion("replace_standard not like", value, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardIn(List<String> values) {
            addCriterion("replace_standard in", values, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardNotIn(List<String> values) {
            addCriterion("replace_standard not in", values, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardBetween(String value1, String value2) {
            addCriterion("replace_standard between", value1, value2, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andReplaceStandardNotBetween(String value1, String value2) {
            addCriterion("replace_standard not between", value1, value2, "replaceStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardIsNull() {
            addCriterion("china_standard is null");
            return (Criteria) this;
        }

        public Criteria andChinaStandardIsNotNull() {
            addCriterion("china_standard is not null");
            return (Criteria) this;
        }

        public Criteria andChinaStandardEqualTo(String value) {
            addCriterion("china_standard =", value, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardNotEqualTo(String value) {
            addCriterion("china_standard <>", value, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardGreaterThan(String value) {
            addCriterion("china_standard >", value, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardGreaterThanOrEqualTo(String value) {
            addCriterion("china_standard >=", value, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardLessThan(String value) {
            addCriterion("china_standard <", value, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardLessThanOrEqualTo(String value) {
            addCriterion("china_standard <=", value, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardLike(String value) {
            addCriterion("china_standard like", value, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardNotLike(String value) {
            addCriterion("china_standard not like", value, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardIn(List<String> values) {
            addCriterion("china_standard in", values, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardNotIn(List<String> values) {
            addCriterion("china_standard not in", values, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardBetween(String value1, String value2) {
            addCriterion("china_standard between", value1, value2, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andChinaStandardNotBetween(String value1, String value2) {
            addCriterion("china_standard not between", value1, value2, "chinaStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardIsNull() {
            addCriterion("international_standard is null");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardIsNotNull() {
            addCriterion("international_standard is not null");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardEqualTo(String value) {
            addCriterion("international_standard =", value, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardNotEqualTo(String value) {
            addCriterion("international_standard <>", value, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardGreaterThan(String value) {
            addCriterion("international_standard >", value, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardGreaterThanOrEqualTo(String value) {
            addCriterion("international_standard >=", value, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardLessThan(String value) {
            addCriterion("international_standard <", value, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardLessThanOrEqualTo(String value) {
            addCriterion("international_standard <=", value, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardLike(String value) {
            addCriterion("international_standard like", value, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardNotLike(String value) {
            addCriterion("international_standard not like", value, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardIn(List<String> values) {
            addCriterion("international_standard in", values, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardNotIn(List<String> values) {
            addCriterion("international_standard not in", values, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardBetween(String value1, String value2) {
            addCriterion("international_standard between", value1, value2, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andInternationalStandardNotBetween(String value1, String value2) {
            addCriterion("international_standard not between", value1, value2, "internationalStandard");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallIsNull() {
            addCriterion("technique_shall is null");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallIsNotNull() {
            addCriterion("technique_shall is not null");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallEqualTo(String value) {
            addCriterion("technique_shall =", value, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallNotEqualTo(String value) {
            addCriterion("technique_shall <>", value, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallGreaterThan(String value) {
            addCriterion("technique_shall >", value, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallGreaterThanOrEqualTo(String value) {
            addCriterion("technique_shall >=", value, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallLessThan(String value) {
            addCriterion("technique_shall <", value, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallLessThanOrEqualTo(String value) {
            addCriterion("technique_shall <=", value, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallLike(String value) {
            addCriterion("technique_shall like", value, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallNotLike(String value) {
            addCriterion("technique_shall not like", value, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallIn(List<String> values) {
            addCriterion("technique_shall in", values, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallNotIn(List<String> values) {
            addCriterion("technique_shall not in", values, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallBetween(String value1, String value2) {
            addCriterion("technique_shall between", value1, value2, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andTechniqueShallNotBetween(String value1, String value2) {
            addCriterion("technique_shall not between", value1, value2, "techniqueShall");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentIsNull() {
            addCriterion("approval_release_department is null");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentIsNotNull() {
            addCriterion("approval_release_department is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentEqualTo(String value) {
            addCriterion("approval_release_department =", value, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentNotEqualTo(String value) {
            addCriterion("approval_release_department <>", value, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentGreaterThan(String value) {
            addCriterion("approval_release_department >", value, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("approval_release_department >=", value, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentLessThan(String value) {
            addCriterion("approval_release_department <", value, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentLessThanOrEqualTo(String value) {
            addCriterion("approval_release_department <=", value, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentLike(String value) {
            addCriterion("approval_release_department like", value, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentNotLike(String value) {
            addCriterion("approval_release_department not like", value, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentIn(List<String> values) {
            addCriterion("approval_release_department in", values, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentNotIn(List<String> values) {
            addCriterion("approval_release_department not in", values, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentBetween(String value1, String value2) {
            addCriterion("approval_release_department between", value1, value2, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andApprovalReleaseDepartmentNotBetween(String value1, String value2) {
            addCriterion("approval_release_department not between", value1, value2, "approvalReleaseDepartment");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationIsNull() {
            addCriterion("industry_classification is null");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationIsNotNull() {
            addCriterion("industry_classification is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationEqualTo(String value) {
            addCriterion("industry_classification =", value, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationNotEqualTo(String value) {
            addCriterion("industry_classification <>", value, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationGreaterThan(String value) {
            addCriterion("industry_classification >", value, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationGreaterThanOrEqualTo(String value) {
            addCriterion("industry_classification >=", value, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationLessThan(String value) {
            addCriterion("industry_classification <", value, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationLessThanOrEqualTo(String value) {
            addCriterion("industry_classification <=", value, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationLike(String value) {
            addCriterion("industry_classification like", value, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationNotLike(String value) {
            addCriterion("industry_classification not like", value, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationIn(List<String> values) {
            addCriterion("industry_classification in", values, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationNotIn(List<String> values) {
            addCriterion("industry_classification not in", values, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationBetween(String value1, String value2) {
            addCriterion("industry_classification between", value1, value2, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andIndustryClassificationNotBetween(String value1, String value2) {
            addCriterion("industry_classification not between", value1, value2, "industryClassification");
            return (Criteria) this;
        }

        public Criteria andStandardTypeIsNull() {
            addCriterion("standard_type is null");
            return (Criteria) this;
        }

        public Criteria andStandardTypeIsNotNull() {
            addCriterion("standard_type is not null");
            return (Criteria) this;
        }

        public Criteria andStandardTypeEqualTo(String value) {
            addCriterion("standard_type =", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeNotEqualTo(String value) {
            addCriterion("standard_type <>", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeGreaterThan(String value) {
            addCriterion("standard_type >", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("standard_type >=", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeLessThan(String value) {
            addCriterion("standard_type <", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeLessThanOrEqualTo(String value) {
            addCriterion("standard_type <=", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeLike(String value) {
            addCriterion("standard_type like", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeNotLike(String value) {
            addCriterion("standard_type not like", value, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeIn(List<String> values) {
            addCriterion("standard_type in", values, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeNotIn(List<String> values) {
            addCriterion("standard_type not in", values, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeBetween(String value1, String value2) {
            addCriterion("standard_type between", value1, value2, "standardType");
            return (Criteria) this;
        }

        public Criteria andStandardTypeNotBetween(String value1, String value2) {
            addCriterion("standard_type not between", value1, value2, "standardType");
            return (Criteria) this;
        }

        public Criteria andLimitationIsNull() {
            addCriterion("limitation is null");
            return (Criteria) this;
        }

        public Criteria andLimitationIsNotNull() {
            addCriterion("limitation is not null");
            return (Criteria) this;
        }

        public Criteria andLimitationEqualTo(String value) {
            addCriterion("limitation =", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationNotEqualTo(String value) {
            addCriterion("limitation <>", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationGreaterThan(String value) {
            addCriterion("limitation >", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationGreaterThanOrEqualTo(String value) {
            addCriterion("limitation >=", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationLessThan(String value) {
            addCriterion("limitation <", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationLessThanOrEqualTo(String value) {
            addCriterion("limitation <=", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationLike(String value) {
            addCriterion("limitation like", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationNotLike(String value) {
            addCriterion("limitation not like", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationIn(List<String> values) {
            addCriterion("limitation in", values, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationNotIn(List<String> values) {
            addCriterion("limitation not in", values, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationBetween(String value1, String value2) {
            addCriterion("limitation between", value1, value2, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationNotBetween(String value1, String value2) {
            addCriterion("limitation not between", value1, value2, "limitation");
            return (Criteria) this;
        }

        public Criteria andDrafterIsNull() {
            addCriterion("drafter is null");
            return (Criteria) this;
        }

        public Criteria andDrafterIsNotNull() {
            addCriterion("drafter is not null");
            return (Criteria) this;
        }

        public Criteria andDrafterEqualTo(String value) {
            addCriterion("drafter =", value, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterNotEqualTo(String value) {
            addCriterion("drafter <>", value, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterGreaterThan(String value) {
            addCriterion("drafter >", value, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterGreaterThanOrEqualTo(String value) {
            addCriterion("drafter >=", value, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterLessThan(String value) {
            addCriterion("drafter <", value, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterLessThanOrEqualTo(String value) {
            addCriterion("drafter <=", value, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterLike(String value) {
            addCriterion("drafter like", value, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterNotLike(String value) {
            addCriterion("drafter not like", value, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterIn(List<String> values) {
            addCriterion("drafter in", values, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterNotIn(List<String> values) {
            addCriterion("drafter not in", values, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterBetween(String value1, String value2) {
            addCriterion("drafter between", value1, value2, "drafter");
            return (Criteria) this;
        }

        public Criteria andDrafterNotBetween(String value1, String value2) {
            addCriterion("drafter not between", value1, value2, "drafter");
            return (Criteria) this;
        }

        public Criteria andDraftUnitIsNull() {
            addCriterion("draft_unit is null");
            return (Criteria) this;
        }

        public Criteria andDraftUnitIsNotNull() {
            addCriterion("draft_unit is not null");
            return (Criteria) this;
        }

        public Criteria andDraftUnitEqualTo(String value) {
            addCriterion("draft_unit =", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitNotEqualTo(String value) {
            addCriterion("draft_unit <>", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitGreaterThan(String value) {
            addCriterion("draft_unit >", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitGreaterThanOrEqualTo(String value) {
            addCriterion("draft_unit >=", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitLessThan(String value) {
            addCriterion("draft_unit <", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitLessThanOrEqualTo(String value) {
            addCriterion("draft_unit <=", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitLike(String value) {
            addCriterion("draft_unit like", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitNotLike(String value) {
            addCriterion("draft_unit not like", value, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitIn(List<String> values) {
            addCriterion("draft_unit in", values, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitNotIn(List<String> values) {
            addCriterion("draft_unit not in", values, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitBetween(String value1, String value2) {
            addCriterion("draft_unit between", value1, value2, "draftUnit");
            return (Criteria) this;
        }

        public Criteria andDraftUnitNotBetween(String value1, String value2) {
            addCriterion("draft_unit not between", value1, value2, "draftUnit");
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