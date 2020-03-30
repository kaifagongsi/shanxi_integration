package com.kfgs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbComplaintsAboutRightsProtectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbComplaintsAboutRightsProtectionExample() {
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

        public Criteria andObjectOfComplaintIsNull() {
            addCriterion("object_of_complaint is null");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintIsNotNull() {
            addCriterion("object_of_complaint is not null");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintEqualTo(String value) {
            addCriterion("object_of_complaint =", value, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintNotEqualTo(String value) {
            addCriterion("object_of_complaint <>", value, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintGreaterThan(String value) {
            addCriterion("object_of_complaint >", value, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintGreaterThanOrEqualTo(String value) {
            addCriterion("object_of_complaint >=", value, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintLessThan(String value) {
            addCriterion("object_of_complaint <", value, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintLessThanOrEqualTo(String value) {
            addCriterion("object_of_complaint <=", value, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintLike(String value) {
            addCriterion("object_of_complaint like", value, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintNotLike(String value) {
            addCriterion("object_of_complaint not like", value, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintIn(List<String> values) {
            addCriterion("object_of_complaint in", values, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintNotIn(List<String> values) {
            addCriterion("object_of_complaint not in", values, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintBetween(String value1, String value2) {
            addCriterion("object_of_complaint between", value1, value2, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andObjectOfComplaintNotBetween(String value1, String value2) {
            addCriterion("object_of_complaint not between", value1, value2, "objectOfComplaint");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsIsNull() {
            addCriterion("details_of_complaints is null");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsIsNotNull() {
            addCriterion("details_of_complaints is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsEqualTo(String value) {
            addCriterion("details_of_complaints =", value, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsNotEqualTo(String value) {
            addCriterion("details_of_complaints <>", value, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsGreaterThan(String value) {
            addCriterion("details_of_complaints >", value, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsGreaterThanOrEqualTo(String value) {
            addCriterion("details_of_complaints >=", value, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsLessThan(String value) {
            addCriterion("details_of_complaints <", value, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsLessThanOrEqualTo(String value) {
            addCriterion("details_of_complaints <=", value, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsLike(String value) {
            addCriterion("details_of_complaints like", value, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsNotLike(String value) {
            addCriterion("details_of_complaints not like", value, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsIn(List<String> values) {
            addCriterion("details_of_complaints in", values, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsNotIn(List<String> values) {
            addCriterion("details_of_complaints not in", values, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsBetween(String value1, String value2) {
            addCriterion("details_of_complaints between", value1, value2, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andDetailsOfComplaintsNotBetween(String value1, String value2) {
            addCriterion("details_of_complaints not between", value1, value2, "detailsOfComplaints");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintIsNull() {
            addCriterion("amount_of_complaint is null");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintIsNotNull() {
            addCriterion("amount_of_complaint is not null");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintEqualTo(Double value) {
            addCriterion("amount_of_complaint =", value, "amountOfComplaint");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintNotEqualTo(Double value) {
            addCriterion("amount_of_complaint <>", value, "amountOfComplaint");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintGreaterThan(Double value) {
            addCriterion("amount_of_complaint >", value, "amountOfComplaint");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintGreaterThanOrEqualTo(Double value) {
            addCriterion("amount_of_complaint >=", value, "amountOfComplaint");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintLessThan(Double value) {
            addCriterion("amount_of_complaint <", value, "amountOfComplaint");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintLessThanOrEqualTo(Double value) {
            addCriterion("amount_of_complaint <=", value, "amountOfComplaint");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintIn(List<Double> values) {
            addCriterion("amount_of_complaint in", values, "amountOfComplaint");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintNotIn(List<Double> values) {
            addCriterion("amount_of_complaint not in", values, "amountOfComplaint");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintBetween(Double value1, Double value2) {
            addCriterion("amount_of_complaint between", value1, value2, "amountOfComplaint");
            return (Criteria) this;
        }

        public Criteria andAmountOfComplaintNotBetween(Double value1, Double value2) {
            addCriterion("amount_of_complaint not between", value1, value2, "amountOfComplaint");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadIsNull() {
            addCriterion("path_of_evidence_upload is null");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadIsNotNull() {
            addCriterion("path_of_evidence_upload is not null");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadEqualTo(String value) {
            addCriterion("path_of_evidence_upload =", value, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadNotEqualTo(String value) {
            addCriterion("path_of_evidence_upload <>", value, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadGreaterThan(String value) {
            addCriterion("path_of_evidence_upload >", value, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadGreaterThanOrEqualTo(String value) {
            addCriterion("path_of_evidence_upload >=", value, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadLessThan(String value) {
            addCriterion("path_of_evidence_upload <", value, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadLessThanOrEqualTo(String value) {
            addCriterion("path_of_evidence_upload <=", value, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadLike(String value) {
            addCriterion("path_of_evidence_upload like", value, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadNotLike(String value) {
            addCriterion("path_of_evidence_upload not like", value, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadIn(List<String> values) {
            addCriterion("path_of_evidence_upload in", values, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadNotIn(List<String> values) {
            addCriterion("path_of_evidence_upload not in", values, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadBetween(String value1, String value2) {
            addCriterion("path_of_evidence_upload between", value1, value2, "pathOfEvidenceUpload");
            return (Criteria) this;
        }

        public Criteria andPathOfEvidenceUploadNotBetween(String value1, String value2) {
            addCriterion("path_of_evidence_upload not between", value1, value2, "pathOfEvidenceUpload");
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

        public Criteria andHandlingSituationIsNull() {
            addCriterion("handling_situation is null");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationIsNotNull() {
            addCriterion("handling_situation is not null");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationEqualTo(String value) {
            addCriterion("handling_situation =", value, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationNotEqualTo(String value) {
            addCriterion("handling_situation <>", value, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationGreaterThan(String value) {
            addCriterion("handling_situation >", value, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationGreaterThanOrEqualTo(String value) {
            addCriterion("handling_situation >=", value, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationLessThan(String value) {
            addCriterion("handling_situation <", value, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationLessThanOrEqualTo(String value) {
            addCriterion("handling_situation <=", value, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationLike(String value) {
            addCriterion("handling_situation like", value, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationNotLike(String value) {
            addCriterion("handling_situation not like", value, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationIn(List<String> values) {
            addCriterion("handling_situation in", values, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationNotIn(List<String> values) {
            addCriterion("handling_situation not in", values, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationBetween(String value1, String value2) {
            addCriterion("handling_situation between", value1, value2, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andHandlingSituationNotBetween(String value1, String value2) {
            addCriterion("handling_situation not between", value1, value2, "handlingSituation");
            return (Criteria) this;
        }

        public Criteria andComplainantIsNull() {
            addCriterion("complainant is null");
            return (Criteria) this;
        }

        public Criteria andComplainantIsNotNull() {
            addCriterion("complainant is not null");
            return (Criteria) this;
        }

        public Criteria andComplainantEqualTo(String value) {
            addCriterion("complainant =", value, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantNotEqualTo(String value) {
            addCriterion("complainant <>", value, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantGreaterThan(String value) {
            addCriterion("complainant >", value, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantGreaterThanOrEqualTo(String value) {
            addCriterion("complainant >=", value, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantLessThan(String value) {
            addCriterion("complainant <", value, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantLessThanOrEqualTo(String value) {
            addCriterion("complainant <=", value, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantLike(String value) {
            addCriterion("complainant like", value, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantNotLike(String value) {
            addCriterion("complainant not like", value, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantIn(List<String> values) {
            addCriterion("complainant in", values, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantNotIn(List<String> values) {
            addCriterion("complainant not in", values, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantBetween(String value1, String value2) {
            addCriterion("complainant between", value1, value2, "complainant");
            return (Criteria) this;
        }

        public Criteria andComplainantNotBetween(String value1, String value2) {
            addCriterion("complainant not between", value1, value2, "complainant");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
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