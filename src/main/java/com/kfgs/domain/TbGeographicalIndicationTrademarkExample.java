package com.kfgs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbGeographicalIndicationTrademarkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGeographicalIndicationTrademarkExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andTradeNameIsNull() {
            addCriterion("trade_name is null");
            return (Criteria) this;
        }

        public Criteria andTradeNameIsNotNull() {
            addCriterion("trade_name is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNameEqualTo(String value) {
            addCriterion("trade_name =", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotEqualTo(String value) {
            addCriterion("trade_name <>", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameGreaterThan(String value) {
            addCriterion("trade_name >", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameGreaterThanOrEqualTo(String value) {
            addCriterion("trade_name >=", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLessThan(String value) {
            addCriterion("trade_name <", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLessThanOrEqualTo(String value) {
            addCriterion("trade_name <=", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLike(String value) {
            addCriterion("trade_name like", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotLike(String value) {
            addCriterion("trade_name not like", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameIn(List<String> values) {
            addCriterion("trade_name in", values, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotIn(List<String> values) {
            addCriterion("trade_name not in", values, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameBetween(String value1, String value2) {
            addCriterion("trade_name between", value1, value2, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotBetween(String value1, String value2) {
            addCriterion("trade_name not between", value1, value2, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeIsNull() {
            addCriterion("trademark_type is null");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeIsNotNull() {
            addCriterion("trademark_type is not null");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeEqualTo(String value) {
            addCriterion("trademark_type =", value, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeNotEqualTo(String value) {
            addCriterion("trademark_type <>", value, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeGreaterThan(String value) {
            addCriterion("trademark_type >", value, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trademark_type >=", value, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeLessThan(String value) {
            addCriterion("trademark_type <", value, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeLessThanOrEqualTo(String value) {
            addCriterion("trademark_type <=", value, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeLike(String value) {
            addCriterion("trademark_type like", value, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeNotLike(String value) {
            addCriterion("trademark_type not like", value, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeIn(List<String> values) {
            addCriterion("trademark_type in", values, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeNotIn(List<String> values) {
            addCriterion("trademark_type not in", values, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeBetween(String value1, String value2) {
            addCriterion("trademark_type between", value1, value2, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andTrademarkTypeNotBetween(String value1, String value2) {
            addCriterion("trademark_type not between", value1, value2, "trademarkType");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantIsNull() {
            addCriterion("chinese_name_of_regisrant is null");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantIsNotNull() {
            addCriterion("chinese_name_of_regisrant is not null");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantEqualTo(String value) {
            addCriterion("chinese_name_of_regisrant =", value, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantNotEqualTo(String value) {
            addCriterion("chinese_name_of_regisrant <>", value, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantGreaterThan(String value) {
            addCriterion("chinese_name_of_regisrant >", value, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantGreaterThanOrEqualTo(String value) {
            addCriterion("chinese_name_of_regisrant >=", value, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantLessThan(String value) {
            addCriterion("chinese_name_of_regisrant <", value, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantLessThanOrEqualTo(String value) {
            addCriterion("chinese_name_of_regisrant <=", value, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantLike(String value) {
            addCriterion("chinese_name_of_regisrant like", value, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantNotLike(String value) {
            addCriterion("chinese_name_of_regisrant not like", value, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantIn(List<String> values) {
            addCriterion("chinese_name_of_regisrant in", values, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantNotIn(List<String> values) {
            addCriterion("chinese_name_of_regisrant not in", values, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantBetween(String value1, String value2) {
            addCriterion("chinese_name_of_regisrant between", value1, value2, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andChineseNameOfRegisrantNotBetween(String value1, String value2) {
            addCriterion("chinese_name_of_regisrant not between", value1, value2, "chineseNameOfRegisrant");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberIsNull() {
            addCriterion("registration_number is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberIsNotNull() {
            addCriterion("registration_number is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberEqualTo(String value) {
            addCriterion("registration_number =", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberNotEqualTo(String value) {
            addCriterion("registration_number <>", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberGreaterThan(String value) {
            addCriterion("registration_number >", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberGreaterThanOrEqualTo(String value) {
            addCriterion("registration_number >=", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberLessThan(String value) {
            addCriterion("registration_number <", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberLessThanOrEqualTo(String value) {
            addCriterion("registration_number <=", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberLike(String value) {
            addCriterion("registration_number like", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberNotLike(String value) {
            addCriterion("registration_number not like", value, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberIn(List<String> values) {
            addCriterion("registration_number in", values, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberNotIn(List<String> values) {
            addCriterion("registration_number not in", values, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberBetween(String value1, String value2) {
            addCriterion("registration_number between", value1, value2, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andRegistrationNumberNotBetween(String value1, String value2) {
            addCriterion("registration_number not between", value1, value2, "registrationNumber");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationIsNull() {
            addCriterion("International_classification is null");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationIsNotNull() {
            addCriterion("International_classification is not null");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationEqualTo(Integer value) {
            addCriterion("International_classification =", value, "internationalClassification");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationNotEqualTo(Integer value) {
            addCriterion("International_classification <>", value, "internationalClassification");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationGreaterThan(Integer value) {
            addCriterion("International_classification >", value, "internationalClassification");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationGreaterThanOrEqualTo(Integer value) {
            addCriterion("International_classification >=", value, "internationalClassification");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationLessThan(Integer value) {
            addCriterion("International_classification <", value, "internationalClassification");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationLessThanOrEqualTo(Integer value) {
            addCriterion("International_classification <=", value, "internationalClassification");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationIn(List<Integer> values) {
            addCriterion("International_classification in", values, "internationalClassification");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationNotIn(List<Integer> values) {
            addCriterion("International_classification not in", values, "internationalClassification");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationBetween(Integer value1, Integer value2) {
            addCriterion("International_classification between", value1, value2, "internationalClassification");
            return (Criteria) this;
        }

        public Criteria andInternationalClassificationNotBetween(Integer value1, Integer value2) {
            addCriterion("International_classification not between", value1, value2, "internationalClassification");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIsNull() {
            addCriterion("application_date is null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIsNotNull() {
            addCriterion("application_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateEqualTo(Date value) {
            addCriterionForJDBCDate("application_date =", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("application_date <>", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("application_date >", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("application_date >=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThan(Date value) {
            addCriterionForJDBCDate("application_date <", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("application_date <=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIn(List<Date> values) {
            addCriterionForJDBCDate("application_date in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("application_date not in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("application_date between", value1, value2, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("application_date not between", value1, value2, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantIsNull() {
            addCriterion("chinese_address_of_registrant is null");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantIsNotNull() {
            addCriterion("chinese_address_of_registrant is not null");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantEqualTo(String value) {
            addCriterion("chinese_address_of_registrant =", value, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantNotEqualTo(String value) {
            addCriterion("chinese_address_of_registrant <>", value, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantGreaterThan(String value) {
            addCriterion("chinese_address_of_registrant >", value, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantGreaterThanOrEqualTo(String value) {
            addCriterion("chinese_address_of_registrant >=", value, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantLessThan(String value) {
            addCriterion("chinese_address_of_registrant <", value, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantLessThanOrEqualTo(String value) {
            addCriterion("chinese_address_of_registrant <=", value, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantLike(String value) {
            addCriterion("chinese_address_of_registrant like", value, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantNotLike(String value) {
            addCriterion("chinese_address_of_registrant not like", value, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantIn(List<String> values) {
            addCriterion("chinese_address_of_registrant in", values, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantNotIn(List<String> values) {
            addCriterion("chinese_address_of_registrant not in", values, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantBetween(String value1, String value2) {
            addCriterion("chinese_address_of_registrant between", value1, value2, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andChineseAddressOfRegistrantNotBetween(String value1, String value2) {
            addCriterion("chinese_address_of_registrant not between", value1, value2, "chineseAddressOfRegistrant");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyIsNull() {
            addCriterion("name_of_agency is null");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyIsNotNull() {
            addCriterion("name_of_agency is not null");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyEqualTo(String value) {
            addCriterion("name_of_agency =", value, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyNotEqualTo(String value) {
            addCriterion("name_of_agency <>", value, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyGreaterThan(String value) {
            addCriterion("name_of_agency >", value, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyGreaterThanOrEqualTo(String value) {
            addCriterion("name_of_agency >=", value, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyLessThan(String value) {
            addCriterion("name_of_agency <", value, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyLessThanOrEqualTo(String value) {
            addCriterion("name_of_agency <=", value, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyLike(String value) {
            addCriterion("name_of_agency like", value, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyNotLike(String value) {
            addCriterion("name_of_agency not like", value, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyIn(List<String> values) {
            addCriterion("name_of_agency in", values, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyNotIn(List<String> values) {
            addCriterion("name_of_agency not in", values, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyBetween(String value1, String value2) {
            addCriterion("name_of_agency between", value1, value2, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andNameOfAgencyNotBetween(String value1, String value2) {
            addCriterion("name_of_agency not between", value1, value2, "nameOfAgency");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementIsNull() {
            addCriterion("issue_num_of_preliminary_examination_announcement is null");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementIsNotNull() {
            addCriterion("issue_num_of_preliminary_examination_announcement is not null");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementEqualTo(Integer value) {
            addCriterion("issue_num_of_preliminary_examination_announcement =", value, "issueNumOfPreliminaryExaminationAnnouncement");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementNotEqualTo(Integer value) {
            addCriterion("issue_num_of_preliminary_examination_announcement <>", value, "issueNumOfPreliminaryExaminationAnnouncement");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementGreaterThan(Integer value) {
            addCriterion("issue_num_of_preliminary_examination_announcement >", value, "issueNumOfPreliminaryExaminationAnnouncement");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_num_of_preliminary_examination_announcement >=", value, "issueNumOfPreliminaryExaminationAnnouncement");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementLessThan(Integer value) {
            addCriterion("issue_num_of_preliminary_examination_announcement <", value, "issueNumOfPreliminaryExaminationAnnouncement");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementLessThanOrEqualTo(Integer value) {
            addCriterion("issue_num_of_preliminary_examination_announcement <=", value, "issueNumOfPreliminaryExaminationAnnouncement");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementIn(List<Integer> values) {
            addCriterion("issue_num_of_preliminary_examination_announcement in", values, "issueNumOfPreliminaryExaminationAnnouncement");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementNotIn(List<Integer> values) {
            addCriterion("issue_num_of_preliminary_examination_announcement not in", values, "issueNumOfPreliminaryExaminationAnnouncement");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementBetween(Integer value1, Integer value2) {
            addCriterion("issue_num_of_preliminary_examination_announcement between", value1, value2, "issueNumOfPreliminaryExaminationAnnouncement");
            return (Criteria) this;
        }

        public Criteria andIssueNumOfPreliminaryExaminationAnnouncementNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_num_of_preliminary_examination_announcement not between", value1, value2, "issueNumOfPreliminaryExaminationAnnouncement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationIsNull() {
            addCriterion("announcement_date_of_preliminary_examination is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationIsNotNull() {
            addCriterion("announcement_date_of_preliminary_examination is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationEqualTo(Date value) {
            addCriterionForJDBCDate("announcement_date_of_preliminary_examination =", value, "announcementDateOfPreliminaryExamination");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationNotEqualTo(Date value) {
            addCriterionForJDBCDate("announcement_date_of_preliminary_examination <>", value, "announcementDateOfPreliminaryExamination");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationGreaterThan(Date value) {
            addCriterionForJDBCDate("announcement_date_of_preliminary_examination >", value, "announcementDateOfPreliminaryExamination");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("announcement_date_of_preliminary_examination >=", value, "announcementDateOfPreliminaryExamination");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationLessThan(Date value) {
            addCriterionForJDBCDate("announcement_date_of_preliminary_examination <", value, "announcementDateOfPreliminaryExamination");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("announcement_date_of_preliminary_examination <=", value, "announcementDateOfPreliminaryExamination");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationIn(List<Date> values) {
            addCriterionForJDBCDate("announcement_date_of_preliminary_examination in", values, "announcementDateOfPreliminaryExamination");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationNotIn(List<Date> values) {
            addCriterionForJDBCDate("announcement_date_of_preliminary_examination not in", values, "announcementDateOfPreliminaryExamination");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("announcement_date_of_preliminary_examination between", value1, value2, "announcementDateOfPreliminaryExamination");
            return (Criteria) this;
        }

        public Criteria andAnnouncementDateOfPreliminaryExaminationNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("announcement_date_of_preliminary_examination not between", value1, value2, "announcementDateOfPreliminaryExamination");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoIsNull() {
            addCriterion("regeistration_notice_issue_no is null");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoIsNotNull() {
            addCriterion("regeistration_notice_issue_no is not null");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoEqualTo(Integer value) {
            addCriterion("regeistration_notice_issue_no =", value, "regeistrationNoticeIssueNo");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoNotEqualTo(Integer value) {
            addCriterion("regeistration_notice_issue_no <>", value, "regeistrationNoticeIssueNo");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoGreaterThan(Integer value) {
            addCriterion("regeistration_notice_issue_no >", value, "regeistrationNoticeIssueNo");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("regeistration_notice_issue_no >=", value, "regeistrationNoticeIssueNo");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoLessThan(Integer value) {
            addCriterion("regeistration_notice_issue_no <", value, "regeistrationNoticeIssueNo");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoLessThanOrEqualTo(Integer value) {
            addCriterion("regeistration_notice_issue_no <=", value, "regeistrationNoticeIssueNo");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoIn(List<Integer> values) {
            addCriterion("regeistration_notice_issue_no in", values, "regeistrationNoticeIssueNo");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoNotIn(List<Integer> values) {
            addCriterion("regeistration_notice_issue_no not in", values, "regeistrationNoticeIssueNo");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoBetween(Integer value1, Integer value2) {
            addCriterion("regeistration_notice_issue_no between", value1, value2, "regeistrationNoticeIssueNo");
            return (Criteria) this;
        }

        public Criteria andRegeistrationNoticeIssueNoNotBetween(Integer value1, Integer value2) {
            addCriterion("regeistration_notice_issue_no not between", value1, value2, "regeistrationNoticeIssueNo");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationIsNull() {
            addCriterion("date_of_botice_of_regeistation is null");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationIsNotNull() {
            addCriterion("date_of_botice_of_regeistation is not null");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationEqualTo(Date value) {
            addCriterionForJDBCDate("date_of_botice_of_regeistation =", value, "dateOfBoticeOfRegeistation");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationNotEqualTo(Date value) {
            addCriterionForJDBCDate("date_of_botice_of_regeistation <>", value, "dateOfBoticeOfRegeistation");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationGreaterThan(Date value) {
            addCriterionForJDBCDate("date_of_botice_of_regeistation >", value, "dateOfBoticeOfRegeistation");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date_of_botice_of_regeistation >=", value, "dateOfBoticeOfRegeistation");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationLessThan(Date value) {
            addCriterionForJDBCDate("date_of_botice_of_regeistation <", value, "dateOfBoticeOfRegeistation");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date_of_botice_of_regeistation <=", value, "dateOfBoticeOfRegeistation");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationIn(List<Date> values) {
            addCriterionForJDBCDate("date_of_botice_of_regeistation in", values, "dateOfBoticeOfRegeistation");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationNotIn(List<Date> values) {
            addCriterionForJDBCDate("date_of_botice_of_regeistation not in", values, "dateOfBoticeOfRegeistation");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date_of_botice_of_regeistation between", value1, value2, "dateOfBoticeOfRegeistation");
            return (Criteria) this;
        }

        public Criteria andDateOfBoticeOfRegeistationNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date_of_botice_of_regeistation not between", value1, value2, "dateOfBoticeOfRegeistation");
            return (Criteria) this;
        }

        public Criteria andPdfPathIsNull() {
            addCriterion("pdf_path is null");
            return (Criteria) this;
        }

        public Criteria andPdfPathIsNotNull() {
            addCriterion("pdf_path is not null");
            return (Criteria) this;
        }

        public Criteria andPdfPathEqualTo(String value) {
            addCriterion("pdf_path =", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathNotEqualTo(String value) {
            addCriterion("pdf_path <>", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathGreaterThan(String value) {
            addCriterion("pdf_path >", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathGreaterThanOrEqualTo(String value) {
            addCriterion("pdf_path >=", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathLessThan(String value) {
            addCriterion("pdf_path <", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathLessThanOrEqualTo(String value) {
            addCriterion("pdf_path <=", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathLike(String value) {
            addCriterion("pdf_path like", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathNotLike(String value) {
            addCriterion("pdf_path not like", value, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathIn(List<String> values) {
            addCriterion("pdf_path in", values, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathNotIn(List<String> values) {
            addCriterion("pdf_path not in", values, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathBetween(String value1, String value2) {
            addCriterion("pdf_path between", value1, value2, "pdfPath");
            return (Criteria) this;
        }

        public Criteria andPdfPathNotBetween(String value1, String value2) {
            addCriterion("pdf_path not between", value1, value2, "pdfPath");
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