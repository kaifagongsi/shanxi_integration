package com.kfgs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbProductExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andClassificationidIsNull() {
            addCriterion("classificationId is null");
            return (Criteria) this;
        }

        public Criteria andClassificationidIsNotNull() {
            addCriterion("classificationId is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationidEqualTo(String value) {
            addCriterion("classificationId =", value, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidNotEqualTo(String value) {
            addCriterion("classificationId <>", value, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidGreaterThan(String value) {
            addCriterion("classificationId >", value, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidGreaterThanOrEqualTo(String value) {
            addCriterion("classificationId >=", value, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidLessThan(String value) {
            addCriterion("classificationId <", value, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidLessThanOrEqualTo(String value) {
            addCriterion("classificationId <=", value, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidLike(String value) {
            addCriterion("classificationId like", value, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidNotLike(String value) {
            addCriterion("classificationId not like", value, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidIn(List<String> values) {
            addCriterion("classificationId in", values, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidNotIn(List<String> values) {
            addCriterion("classificationId not in", values, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidBetween(String value1, String value2) {
            addCriterion("classificationId between", value1, value2, "classificationid");
            return (Criteria) this;
        }

        public Criteria andClassificationidNotBetween(String value1, String value2) {
            addCriterion("classificationId not between", value1, value2, "classificationid");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaIsNull() {
            addCriterion("administrative_area is null");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaIsNotNull() {
            addCriterion("administrative_area is not null");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaEqualTo(String value) {
            addCriterion("administrative_area =", value, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaNotEqualTo(String value) {
            addCriterion("administrative_area <>", value, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaGreaterThan(String value) {
            addCriterion("administrative_area >", value, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaGreaterThanOrEqualTo(String value) {
            addCriterion("administrative_area >=", value, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaLessThan(String value) {
            addCriterion("administrative_area <", value, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaLessThanOrEqualTo(String value) {
            addCriterion("administrative_area <=", value, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaLike(String value) {
            addCriterion("administrative_area like", value, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaNotLike(String value) {
            addCriterion("administrative_area not like", value, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaIn(List<String> values) {
            addCriterion("administrative_area in", values, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaNotIn(List<String> values) {
            addCriterion("administrative_area not in", values, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaBetween(String value1, String value2) {
            addCriterion("administrative_area between", value1, value2, "administrativeArea");
            return (Criteria) this;
        }

        public Criteria andAdministrativeAreaNotBetween(String value1, String value2) {
            addCriterion("administrative_area not between", value1, value2, "administrativeArea");
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

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andApprovalYearIsNull() {
            addCriterion("approval_year is null");
            return (Criteria) this;
        }

        public Criteria andApprovalYearIsNotNull() {
            addCriterion("approval_year is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalYearEqualTo(String value) {
            addCriterion("approval_year =", value, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearNotEqualTo(String value) {
            addCriterion("approval_year <>", value, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearGreaterThan(String value) {
            addCriterion("approval_year >", value, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearGreaterThanOrEqualTo(String value) {
            addCriterion("approval_year >=", value, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearLessThan(String value) {
            addCriterion("approval_year <", value, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearLessThanOrEqualTo(String value) {
            addCriterion("approval_year <=", value, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearLike(String value) {
            addCriterion("approval_year like", value, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearNotLike(String value) {
            addCriterion("approval_year not like", value, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearIn(List<String> values) {
            addCriterion("approval_year in", values, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearNotIn(List<String> values) {
            addCriterion("approval_year not in", values, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearBetween(String value1, String value2) {
            addCriterion("approval_year between", value1, value2, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalYearNotBetween(String value1, String value2) {
            addCriterion("approval_year not between", value1, value2, "approvalYear");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductIsNull() {
            addCriterion("approval_authority_product is null");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductIsNotNull() {
            addCriterion("approval_authority_product is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductEqualTo(String value) {
            addCriterion("approval_authority_product =", value, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductNotEqualTo(String value) {
            addCriterion("approval_authority_product <>", value, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductGreaterThan(String value) {
            addCriterion("approval_authority_product >", value, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductGreaterThanOrEqualTo(String value) {
            addCriterion("approval_authority_product >=", value, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductLessThan(String value) {
            addCriterion("approval_authority_product <", value, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductLessThanOrEqualTo(String value) {
            addCriterion("approval_authority_product <=", value, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductLike(String value) {
            addCriterion("approval_authority_product like", value, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductNotLike(String value) {
            addCriterion("approval_authority_product not like", value, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductIn(List<String> values) {
            addCriterion("approval_authority_product in", values, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductNotIn(List<String> values) {
            addCriterion("approval_authority_product not in", values, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductBetween(String value1, String value2) {
            addCriterion("approval_authority_product between", value1, value2, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityProductNotBetween(String value1, String value2) {
            addCriterion("approval_authority_product not between", value1, value2, "approvalAuthorityProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductIsNull() {
            addCriterion("approval_announcement_no_product is null");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductIsNotNull() {
            addCriterion("approval_announcement_no_product is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductEqualTo(String value) {
            addCriterion("approval_announcement_no_product =", value, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductNotEqualTo(String value) {
            addCriterion("approval_announcement_no_product <>", value, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductGreaterThan(String value) {
            addCriterion("approval_announcement_no_product >", value, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductGreaterThanOrEqualTo(String value) {
            addCriterion("approval_announcement_no_product >=", value, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductLessThan(String value) {
            addCriterion("approval_announcement_no_product <", value, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductLessThanOrEqualTo(String value) {
            addCriterion("approval_announcement_no_product <=", value, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductLike(String value) {
            addCriterion("approval_announcement_no_product like", value, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductNotLike(String value) {
            addCriterion("approval_announcement_no_product not like", value, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductIn(List<String> values) {
            addCriterion("approval_announcement_no_product in", values, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductNotIn(List<String> values) {
            addCriterion("approval_announcement_no_product not in", values, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductBetween(String value1, String value2) {
            addCriterion("approval_announcement_no_product between", value1, value2, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductNotBetween(String value1, String value2) {
            addCriterion("approval_announcement_no_product not between", value1, value2, "approvalAnnouncementNoProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllIsNull() {
            addCriterion("approval_announcement_no_product_all is null");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllIsNotNull() {
            addCriterion("approval_announcement_no_product_all is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllEqualTo(String value) {
            addCriterion("approval_announcement_no_product_all =", value, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllNotEqualTo(String value) {
            addCriterion("approval_announcement_no_product_all <>", value, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllGreaterThan(String value) {
            addCriterion("approval_announcement_no_product_all >", value, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllGreaterThanOrEqualTo(String value) {
            addCriterion("approval_announcement_no_product_all >=", value, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllLessThan(String value) {
            addCriterion("approval_announcement_no_product_all <", value, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllLessThanOrEqualTo(String value) {
            addCriterion("approval_announcement_no_product_all <=", value, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllLike(String value) {
            addCriterion("approval_announcement_no_product_all like", value, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllNotLike(String value) {
            addCriterion("approval_announcement_no_product_all not like", value, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllIn(List<String> values) {
            addCriterion("approval_announcement_no_product_all in", values, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllNotIn(List<String> values) {
            addCriterion("approval_announcement_no_product_all not in", values, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllBetween(String value1, String value2) {
            addCriterion("approval_announcement_no_product_all between", value1, value2, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoProductAllNotBetween(String value1, String value2) {
            addCriterion("approval_announcement_no_product_all not between", value1, value2, "approvalAnnouncementNoProductAll");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNull() {
            addCriterion("province_name is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("province_name is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("province_name =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("province_name <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("province_name >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("province_name >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("province_name <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("province_name <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("province_name like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("province_name not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("province_name in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("province_name not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("province_name between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("province_name not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyIsNull() {
            addCriterion("preliminary_examination_body is null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyIsNotNull() {
            addCriterion("preliminary_examination_body is not null");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyEqualTo(String value) {
            addCriterion("preliminary_examination_body =", value, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyNotEqualTo(String value) {
            addCriterion("preliminary_examination_body <>", value, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyGreaterThan(String value) {
            addCriterion("preliminary_examination_body >", value, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyGreaterThanOrEqualTo(String value) {
            addCriterion("preliminary_examination_body >=", value, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyLessThan(String value) {
            addCriterion("preliminary_examination_body <", value, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyLessThanOrEqualTo(String value) {
            addCriterion("preliminary_examination_body <=", value, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyLike(String value) {
            addCriterion("preliminary_examination_body like", value, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyNotLike(String value) {
            addCriterion("preliminary_examination_body not like", value, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyIn(List<String> values) {
            addCriterion("preliminary_examination_body in", values, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyNotIn(List<String> values) {
            addCriterion("preliminary_examination_body not in", values, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyBetween(String value1, String value2) {
            addCriterion("preliminary_examination_body between", value1, value2, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andPreliminaryExaminationBodyNotBetween(String value1, String value2) {
            addCriterion("preliminary_examination_body not between", value1, value2, "preliminaryExaminationBody");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationIsNull() {
            addCriterion("applicant_organization is null");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationIsNotNull() {
            addCriterion("applicant_organization is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationEqualTo(String value) {
            addCriterion("applicant_organization =", value, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationNotEqualTo(String value) {
            addCriterion("applicant_organization <>", value, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationGreaterThan(String value) {
            addCriterion("applicant_organization >", value, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_organization >=", value, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationLessThan(String value) {
            addCriterion("applicant_organization <", value, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationLessThanOrEqualTo(String value) {
            addCriterion("applicant_organization <=", value, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationLike(String value) {
            addCriterion("applicant_organization like", value, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationNotLike(String value) {
            addCriterion("applicant_organization not like", value, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationIn(List<String> values) {
            addCriterion("applicant_organization in", values, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationNotIn(List<String> values) {
            addCriterion("applicant_organization not in", values, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationBetween(String value1, String value2) {
            addCriterion("applicant_organization between", value1, value2, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andApplicantOrganizationNotBetween(String value1, String value2) {
            addCriterion("applicant_organization not between", value1, value2, "applicantOrganization");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeIsNull() {
            addCriterion("protection_scope is null");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeIsNotNull() {
            addCriterion("protection_scope is not null");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeEqualTo(String value) {
            addCriterion("protection_scope =", value, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeNotEqualTo(String value) {
            addCriterion("protection_scope <>", value, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeGreaterThan(String value) {
            addCriterion("protection_scope >", value, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeGreaterThanOrEqualTo(String value) {
            addCriterion("protection_scope >=", value, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeLessThan(String value) {
            addCriterion("protection_scope <", value, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeLessThanOrEqualTo(String value) {
            addCriterion("protection_scope <=", value, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeLike(String value) {
            addCriterion("protection_scope like", value, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeNotLike(String value) {
            addCriterion("protection_scope not like", value, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeIn(List<String> values) {
            addCriterion("protection_scope in", values, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeNotIn(List<String> values) {
            addCriterion("protection_scope not in", values, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeBetween(String value1, String value2) {
            addCriterion("protection_scope between", value1, value2, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andProtectionScopeNotBetween(String value1, String value2) {
            addCriterion("protection_scope not between", value1, value2, "protectionScope");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionIsNull() {
            addCriterion("document_defining_the_scope_of_protection is null");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionIsNotNull() {
            addCriterion("document_defining_the_scope_of_protection is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionEqualTo(String value) {
            addCriterion("document_defining_the_scope_of_protection =", value, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionNotEqualTo(String value) {
            addCriterion("document_defining_the_scope_of_protection <>", value, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionGreaterThan(String value) {
            addCriterion("document_defining_the_scope_of_protection >", value, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionGreaterThanOrEqualTo(String value) {
            addCriterion("document_defining_the_scope_of_protection >=", value, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionLessThan(String value) {
            addCriterion("document_defining_the_scope_of_protection <", value, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionLessThanOrEqualTo(String value) {
            addCriterion("document_defining_the_scope_of_protection <=", value, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionLike(String value) {
            addCriterion("document_defining_the_scope_of_protection like", value, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionNotLike(String value) {
            addCriterion("document_defining_the_scope_of_protection not like", value, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionIn(List<String> values) {
            addCriterion("document_defining_the_scope_of_protection in", values, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionNotIn(List<String> values) {
            addCriterion("document_defining_the_scope_of_protection not in", values, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionBetween(String value1, String value2) {
            addCriterion("document_defining_the_scope_of_protection between", value1, value2, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andDocumentDefiningTheScopeOfProtectionNotBetween(String value1, String value2) {
            addCriterion("document_defining_the_scope_of_protection not between", value1, value2, "documentDefiningTheScopeOfProtection");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsIsNull() {
            addCriterion("technical_specifications is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsIsNotNull() {
            addCriterion("technical_specifications is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsEqualTo(String value) {
            addCriterion("technical_specifications =", value, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsNotEqualTo(String value) {
            addCriterion("technical_specifications <>", value, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsGreaterThan(String value) {
            addCriterion("technical_specifications >", value, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("technical_specifications >=", value, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsLessThan(String value) {
            addCriterion("technical_specifications <", value, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("technical_specifications <=", value, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsLike(String value) {
            addCriterion("technical_specifications like", value, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsNotLike(String value) {
            addCriterion("technical_specifications not like", value, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsIn(List<String> values) {
            addCriterion("technical_specifications in", values, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsNotIn(List<String> values) {
            addCriterion("technical_specifications not in", values, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsBetween(String value1, String value2) {
            addCriterion("technical_specifications between", value1, value2, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andTechnicalSpecificationsNotBetween(String value1, String value2) {
            addCriterion("technical_specifications not between", value1, value2, "technicalSpecifications");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsIsNull() {
            addCriterion("use_of_special_signs is null");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsIsNotNull() {
            addCriterion("use_of_special_signs is not null");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsEqualTo(String value) {
            addCriterion("use_of_special_signs =", value, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsNotEqualTo(String value) {
            addCriterion("use_of_special_signs <>", value, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsGreaterThan(String value) {
            addCriterion("use_of_special_signs >", value, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsGreaterThanOrEqualTo(String value) {
            addCriterion("use_of_special_signs >=", value, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsLessThan(String value) {
            addCriterion("use_of_special_signs <", value, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsLessThanOrEqualTo(String value) {
            addCriterion("use_of_special_signs <=", value, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsLike(String value) {
            addCriterion("use_of_special_signs like", value, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsNotLike(String value) {
            addCriterion("use_of_special_signs not like", value, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsIn(List<String> values) {
            addCriterion("use_of_special_signs in", values, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsNotIn(List<String> values) {
            addCriterion("use_of_special_signs not in", values, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsBetween(String value1, String value2) {
            addCriterion("use_of_special_signs between", value1, value2, "useOfSpecialSigns");
            return (Criteria) this;
        }

        public Criteria andUseOfSpecialSignsNotBetween(String value1, String value2) {
            addCriterion("use_of_special_signs not between", value1, value2, "useOfSpecialSigns");
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