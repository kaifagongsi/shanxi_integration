package com.kfgs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEnterpriseExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("enterprise_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("enterprise_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("enterprise_name =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("enterprise_name <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("enterprise_name >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_name >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("enterprise_name <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_name <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("enterprise_name like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("enterprise_name not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("enterprise_name in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("enterprise_name not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("enterprise_name between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_name not between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseIsNull() {
            addCriterion("approval_announcement_no_enterprise is null");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseIsNotNull() {
            addCriterion("approval_announcement_no_enterprise is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseEqualTo(String value) {
            addCriterion("approval_announcement_no_enterprise =", value, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseNotEqualTo(String value) {
            addCriterion("approval_announcement_no_enterprise <>", value, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseGreaterThan(String value) {
            addCriterion("approval_announcement_no_enterprise >", value, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseGreaterThanOrEqualTo(String value) {
            addCriterion("approval_announcement_no_enterprise >=", value, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseLessThan(String value) {
            addCriterion("approval_announcement_no_enterprise <", value, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseLessThanOrEqualTo(String value) {
            addCriterion("approval_announcement_no_enterprise <=", value, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseLike(String value) {
            addCriterion("approval_announcement_no_enterprise like", value, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseNotLike(String value) {
            addCriterion("approval_announcement_no_enterprise not like", value, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseIn(List<String> values) {
            addCriterion("approval_announcement_no_enterprise in", values, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseNotIn(List<String> values) {
            addCriterion("approval_announcement_no_enterprise not in", values, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseBetween(String value1, String value2) {
            addCriterion("approval_announcement_no_enterprise between", value1, value2, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseNotBetween(String value1, String value2) {
            addCriterion("approval_announcement_no_enterprise not between", value1, value2, "approvalAnnouncementNoEnterprise");
            return (Criteria) this;
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

        public Criteria andEnterpriseAddressIsNull() {
            addCriterion("enterprise_address is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressIsNotNull() {
            addCriterion("enterprise_address is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressEqualTo(String value) {
            addCriterion("enterprise_address =", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressNotEqualTo(String value) {
            addCriterion("enterprise_address <>", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressGreaterThan(String value) {
            addCriterion("enterprise_address >", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_address >=", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressLessThan(String value) {
            addCriterion("enterprise_address <", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressLessThanOrEqualTo(String value) {
            addCriterion("enterprise_address <=", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressLike(String value) {
            addCriterion("enterprise_address like", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressNotLike(String value) {
            addCriterion("enterprise_address not like", value, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressIn(List<String> values) {
            addCriterion("enterprise_address in", values, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressNotIn(List<String> values) {
            addCriterion("enterprise_address not in", values, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressBetween(String value1, String value2) {
            addCriterion("enterprise_address between", value1, value2, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andEnterpriseAddressNotBetween(String value1, String value2) {
            addCriterion("enterprise_address not between", value1, value2, "enterpriseAddress");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdIsNull() {
            addCriterion("administrative_id is null");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdIsNotNull() {
            addCriterion("administrative_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdEqualTo(String value) {
            addCriterion("administrative_id =", value, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdNotEqualTo(String value) {
            addCriterion("administrative_id <>", value, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdGreaterThan(String value) {
            addCriterion("administrative_id >", value, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdGreaterThanOrEqualTo(String value) {
            addCriterion("administrative_id >=", value, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdLessThan(String value) {
            addCriterion("administrative_id <", value, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdLessThanOrEqualTo(String value) {
            addCriterion("administrative_id <=", value, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdLike(String value) {
            addCriterion("administrative_id like", value, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdNotLike(String value) {
            addCriterion("administrative_id not like", value, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdIn(List<String> values) {
            addCriterion("administrative_id in", values, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdNotIn(List<String> values) {
            addCriterion("administrative_id not in", values, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdBetween(String value1, String value2) {
            addCriterion("administrative_id between", value1, value2, "administrativeId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeIdNotBetween(String value1, String value2) {
            addCriterion("administrative_id not between", value1, value2, "administrativeId");
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

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeIsNull() {
            addCriterion("corporate_representative is null");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeIsNotNull() {
            addCriterion("corporate_representative is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeEqualTo(String value) {
            addCriterion("corporate_representative =", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeNotEqualTo(String value) {
            addCriterion("corporate_representative <>", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeGreaterThan(String value) {
            addCriterion("corporate_representative >", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeGreaterThanOrEqualTo(String value) {
            addCriterion("corporate_representative >=", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeLessThan(String value) {
            addCriterion("corporate_representative <", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeLessThanOrEqualTo(String value) {
            addCriterion("corporate_representative <=", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeLike(String value) {
            addCriterion("corporate_representative like", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeNotLike(String value) {
            addCriterion("corporate_representative not like", value, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeIn(List<String> values) {
            addCriterion("corporate_representative in", values, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeNotIn(List<String> values) {
            addCriterion("corporate_representative not in", values, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeBetween(String value1, String value2) {
            addCriterion("corporate_representative between", value1, value2, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andCorporateRepresentativeNotBetween(String value1, String value2) {
            addCriterion("corporate_representative not between", value1, value2, "corporateRepresentative");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllIsNull() {
            addCriterion("approval_announcement_no_enterprise_all is null");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllIsNotNull() {
            addCriterion("approval_announcement_no_enterprise_all is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllEqualTo(String value) {
            addCriterion("approval_announcement_no_enterprise_all =", value, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllNotEqualTo(String value) {
            addCriterion("approval_announcement_no_enterprise_all <>", value, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllGreaterThan(String value) {
            addCriterion("approval_announcement_no_enterprise_all >", value, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllGreaterThanOrEqualTo(String value) {
            addCriterion("approval_announcement_no_enterprise_all >=", value, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllLessThan(String value) {
            addCriterion("approval_announcement_no_enterprise_all <", value, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllLessThanOrEqualTo(String value) {
            addCriterion("approval_announcement_no_enterprise_all <=", value, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllLike(String value) {
            addCriterion("approval_announcement_no_enterprise_all like", value, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllNotLike(String value) {
            addCriterion("approval_announcement_no_enterprise_all not like", value, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllIn(List<String> values) {
            addCriterion("approval_announcement_no_enterprise_all in", values, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllNotIn(List<String> values) {
            addCriterion("approval_announcement_no_enterprise_all not in", values, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllBetween(String value1, String value2) {
            addCriterion("approval_announcement_no_enterprise_all between", value1, value2, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andApprovalAnnouncementNoEnterpriseAllNotBetween(String value1, String value2) {
            addCriterion("approval_announcement_no_enterprise_all not between", value1, value2, "approvalAnnouncementNoEnterpriseAll");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeIsNull() {
            addCriterion("uniform_social_credit_code is null");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeIsNotNull() {
            addCriterion("uniform_social_credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeEqualTo(String value) {
            addCriterion("uniform_social_credit_code =", value, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeNotEqualTo(String value) {
            addCriterion("uniform_social_credit_code <>", value, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeGreaterThan(String value) {
            addCriterion("uniform_social_credit_code >", value, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("uniform_social_credit_code >=", value, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeLessThan(String value) {
            addCriterion("uniform_social_credit_code <", value, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("uniform_social_credit_code <=", value, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeLike(String value) {
            addCriterion("uniform_social_credit_code like", value, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeNotLike(String value) {
            addCriterion("uniform_social_credit_code not like", value, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeIn(List<String> values) {
            addCriterion("uniform_social_credit_code in", values, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeNotIn(List<String> values) {
            addCriterion("uniform_social_credit_code not in", values, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeBetween(String value1, String value2) {
            addCriterion("uniform_social_credit_code between", value1, value2, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andUniformSocialCreditCodeNotBetween(String value1, String value2) {
            addCriterion("uniform_social_credit_code not between", value1, value2, "uniformSocialCreditCode");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseIsNull() {
            addCriterion("approval_authority_enterprise is null");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseIsNotNull() {
            addCriterion("approval_authority_enterprise is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseEqualTo(String value) {
            addCriterion("approval_authority_enterprise =", value, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseNotEqualTo(String value) {
            addCriterion("approval_authority_enterprise <>", value, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseGreaterThan(String value) {
            addCriterion("approval_authority_enterprise >", value, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseGreaterThanOrEqualTo(String value) {
            addCriterion("approval_authority_enterprise >=", value, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseLessThan(String value) {
            addCriterion("approval_authority_enterprise <", value, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseLessThanOrEqualTo(String value) {
            addCriterion("approval_authority_enterprise <=", value, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseLike(String value) {
            addCriterion("approval_authority_enterprise like", value, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseNotLike(String value) {
            addCriterion("approval_authority_enterprise not like", value, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseIn(List<String> values) {
            addCriterion("approval_authority_enterprise in", values, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseNotIn(List<String> values) {
            addCriterion("approval_authority_enterprise not in", values, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseBetween(String value1, String value2) {
            addCriterion("approval_authority_enterprise between", value1, value2, "approvalAuthorityEnterprise");
            return (Criteria) this;
        }

        public Criteria andApprovalAuthorityEnterpriseNotBetween(String value1, String value2) {
            addCriterion("approval_authority_enterprise not between", value1, value2, "approvalAuthorityEnterprise");
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

        public Criteria andIsFirstSubmissionIsNull() {
            addCriterion("is_first_submission is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionIsNotNull() {
            addCriterion("is_first_submission is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionEqualTo(String value) {
            addCriterion("is_first_submission =", value, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionNotEqualTo(String value) {
            addCriterion("is_first_submission <>", value, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionGreaterThan(String value) {
            addCriterion("is_first_submission >", value, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionGreaterThanOrEqualTo(String value) {
            addCriterion("is_first_submission >=", value, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionLessThan(String value) {
            addCriterion("is_first_submission <", value, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionLessThanOrEqualTo(String value) {
            addCriterion("is_first_submission <=", value, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionLike(String value) {
            addCriterion("is_first_submission like", value, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionNotLike(String value) {
            addCriterion("is_first_submission not like", value, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionIn(List<String> values) {
            addCriterion("is_first_submission in", values, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionNotIn(List<String> values) {
            addCriterion("is_first_submission not in", values, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionBetween(String value1, String value2) {
            addCriterion("is_first_submission between", value1, value2, "isFirstSubmission");
            return (Criteria) this;
        }

        public Criteria andIsFirstSubmissionNotBetween(String value1, String value2) {
            addCriterion("is_first_submission not between", value1, value2, "isFirstSubmission");
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