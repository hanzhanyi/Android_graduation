package com.coolweather.android.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CropDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CropDetailExample() {
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

        public Criteria andCropNameIsNull() {
            addCriterion("crop_name is null");
            return (Criteria) this;
        }

        public Criteria andCropNameIsNotNull() {
            addCriterion("crop_name is not null");
            return (Criteria) this;
        }

        public Criteria andCropNameEqualTo(String value) {
            addCriterion("crop_name =", value, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameNotEqualTo(String value) {
            addCriterion("crop_name <>", value, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameGreaterThan(String value) {
            addCriterion("crop_name >", value, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameGreaterThanOrEqualTo(String value) {
            addCriterion("crop_name >=", value, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameLessThan(String value) {
            addCriterion("crop_name <", value, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameLessThanOrEqualTo(String value) {
            addCriterion("crop_name <=", value, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameLike(String value) {
            addCriterion("crop_name like", value, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameNotLike(String value) {
            addCriterion("crop_name not like", value, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameIn(List<String> values) {
            addCriterion("crop_name in", values, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameNotIn(List<String> values) {
            addCriterion("crop_name not in", values, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameBetween(String value1, String value2) {
            addCriterion("crop_name between", value1, value2, "cropName");
            return (Criteria) this;
        }

        public Criteria andCropNameNotBetween(String value1, String value2) {
            addCriterion("crop_name not between", value1, value2, "cropName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNull() {
            addCriterion("english_name is null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNotNull() {
            addCriterion("english_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameEqualTo(String value) {
            addCriterion("english_name =", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotEqualTo(String value) {
            addCriterion("english_name <>", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThan(String value) {
            addCriterion("english_name >", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("english_name >=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThan(String value) {
            addCriterion("english_name <", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("english_name <=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLike(String value) {
            addCriterion("english_name like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotLike(String value) {
            addCriterion("english_name not like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIn(List<String> values) {
            addCriterion("english_name in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotIn(List<String> values) {
            addCriterion("english_name not in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameBetween(String value1, String value2) {
            addCriterion("english_name between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotBetween(String value1, String value2) {
            addCriterion("english_name not between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andCropImgIsNull() {
            addCriterion("crop_img is null");
            return (Criteria) this;
        }

        public Criteria andCropImgIsNotNull() {
            addCriterion("crop_img is not null");
            return (Criteria) this;
        }

        public Criteria andCropImgEqualTo(Long value) {
            addCriterion("crop_img =", value, "cropImg");
            return (Criteria) this;
        }

        public Criteria andCropImgNotEqualTo(Long value) {
            addCriterion("crop_img <>", value, "cropImg");
            return (Criteria) this;
        }

        public Criteria andCropImgGreaterThan(Long value) {
            addCriterion("crop_img >", value, "cropImg");
            return (Criteria) this;
        }

        public Criteria andCropImgGreaterThanOrEqualTo(Long value) {
            addCriterion("crop_img >=", value, "cropImg");
            return (Criteria) this;
        }

        public Criteria andCropImgLessThan(Long value) {
            addCriterion("crop_img <", value, "cropImg");
            return (Criteria) this;
        }

        public Criteria andCropImgLessThanOrEqualTo(Long value) {
            addCriterion("crop_img <=", value, "cropImg");
            return (Criteria) this;
        }

        public Criteria andCropImgIn(List<Long> values) {
            addCriterion("crop_img in", values, "cropImg");
            return (Criteria) this;
        }

        public Criteria andCropImgNotIn(List<Long> values) {
            addCriterion("crop_img not in", values, "cropImg");
            return (Criteria) this;
        }

        public Criteria andCropImgBetween(Long value1, Long value2) {
            addCriterion("crop_img between", value1, value2, "cropImg");
            return (Criteria) this;
        }

        public Criteria andCropImgNotBetween(Long value1, Long value2) {
            addCriterion("crop_img not between", value1, value2, "cropImg");
            return (Criteria) this;
        }

        public Criteria andDamageSymIsNull() {
            addCriterion("damage_sym is null");
            return (Criteria) this;
        }

        public Criteria andDamageSymIsNotNull() {
            addCriterion("damage_sym is not null");
            return (Criteria) this;
        }

        public Criteria andDamageSymEqualTo(String value) {
            addCriterion("damage_sym =", value, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymNotEqualTo(String value) {
            addCriterion("damage_sym <>", value, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymGreaterThan(String value) {
            addCriterion("damage_sym >", value, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymGreaterThanOrEqualTo(String value) {
            addCriterion("damage_sym >=", value, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymLessThan(String value) {
            addCriterion("damage_sym <", value, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymLessThanOrEqualTo(String value) {
            addCriterion("damage_sym <=", value, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymLike(String value) {
            addCriterion("damage_sym like", value, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymNotLike(String value) {
            addCriterion("damage_sym not like", value, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymIn(List<String> values) {
            addCriterion("damage_sym in", values, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymNotIn(List<String> values) {
            addCriterion("damage_sym not in", values, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymBetween(String value1, String value2) {
            addCriterion("damage_sym between", value1, value2, "damageSym");
            return (Criteria) this;
        }

        public Criteria andDamageSymNotBetween(String value1, String value2) {
            addCriterion("damage_sym not between", value1, value2, "damageSym");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorIsNull() {
            addCriterion("occurrence_factor is null");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorIsNotNull() {
            addCriterion("occurrence_factor is not null");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorEqualTo(String value) {
            addCriterion("occurrence_factor =", value, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorNotEqualTo(String value) {
            addCriterion("occurrence_factor <>", value, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorGreaterThan(String value) {
            addCriterion("occurrence_factor >", value, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorGreaterThanOrEqualTo(String value) {
            addCriterion("occurrence_factor >=", value, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorLessThan(String value) {
            addCriterion("occurrence_factor <", value, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorLessThanOrEqualTo(String value) {
            addCriterion("occurrence_factor <=", value, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorLike(String value) {
            addCriterion("occurrence_factor like", value, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorNotLike(String value) {
            addCriterion("occurrence_factor not like", value, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorIn(List<String> values) {
            addCriterion("occurrence_factor in", values, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorNotIn(List<String> values) {
            addCriterion("occurrence_factor not in", values, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorBetween(String value1, String value2) {
            addCriterion("occurrence_factor between", value1, value2, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andOccurrenceFactorNotBetween(String value1, String value2) {
            addCriterion("occurrence_factor not between", value1, value2, "occurrenceFactor");
            return (Criteria) this;
        }

        public Criteria andMorphologyIsNull() {
            addCriterion("morphology is null");
            return (Criteria) this;
        }

        public Criteria andMorphologyIsNotNull() {
            addCriterion("morphology is not null");
            return (Criteria) this;
        }

        public Criteria andMorphologyEqualTo(String value) {
            addCriterion("morphology =", value, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyNotEqualTo(String value) {
            addCriterion("morphology <>", value, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyGreaterThan(String value) {
            addCriterion("morphology >", value, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyGreaterThanOrEqualTo(String value) {
            addCriterion("morphology >=", value, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyLessThan(String value) {
            addCriterion("morphology <", value, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyLessThanOrEqualTo(String value) {
            addCriterion("morphology <=", value, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyLike(String value) {
            addCriterion("morphology like", value, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyNotLike(String value) {
            addCriterion("morphology not like", value, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyIn(List<String> values) {
            addCriterion("morphology in", values, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyNotIn(List<String> values) {
            addCriterion("morphology not in", values, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyBetween(String value1, String value2) {
            addCriterion("morphology between", value1, value2, "morphology");
            return (Criteria) this;
        }

        public Criteria andMorphologyNotBetween(String value1, String value2) {
            addCriterion("morphology not between", value1, value2, "morphology");
            return (Criteria) this;
        }

        public Criteria andHabitsIsNull() {
            addCriterion("habits is null");
            return (Criteria) this;
        }

        public Criteria andHabitsIsNotNull() {
            addCriterion("habits is not null");
            return (Criteria) this;
        }

        public Criteria andHabitsEqualTo(String value) {
            addCriterion("habits =", value, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsNotEqualTo(String value) {
            addCriterion("habits <>", value, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsGreaterThan(String value) {
            addCriterion("habits >", value, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsGreaterThanOrEqualTo(String value) {
            addCriterion("habits >=", value, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsLessThan(String value) {
            addCriterion("habits <", value, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsLessThanOrEqualTo(String value) {
            addCriterion("habits <=", value, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsLike(String value) {
            addCriterion("habits like", value, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsNotLike(String value) {
            addCriterion("habits not like", value, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsIn(List<String> values) {
            addCriterion("habits in", values, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsNotIn(List<String> values) {
            addCriterion("habits not in", values, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsBetween(String value1, String value2) {
            addCriterion("habits between", value1, value2, "habits");
            return (Criteria) this;
        }

        public Criteria andHabitsNotBetween(String value1, String value2) {
            addCriterion("habits not between", value1, value2, "habits");
            return (Criteria) this;
        }

        public Criteria andHandleMethodIsNull() {
            addCriterion("handle_method is null");
            return (Criteria) this;
        }

        public Criteria andHandleMethodIsNotNull() {
            addCriterion("handle_method is not null");
            return (Criteria) this;
        }

        public Criteria andHandleMethodEqualTo(String value) {
            addCriterion("handle_method =", value, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodNotEqualTo(String value) {
            addCriterion("handle_method <>", value, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodGreaterThan(String value) {
            addCriterion("handle_method >", value, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodGreaterThanOrEqualTo(String value) {
            addCriterion("handle_method >=", value, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodLessThan(String value) {
            addCriterion("handle_method <", value, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodLessThanOrEqualTo(String value) {
            addCriterion("handle_method <=", value, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodLike(String value) {
            addCriterion("handle_method like", value, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodNotLike(String value) {
            addCriterion("handle_method not like", value, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodIn(List<String> values) {
            addCriterion("handle_method in", values, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodNotIn(List<String> values) {
            addCriterion("handle_method not in", values, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodBetween(String value1, String value2) {
            addCriterion("handle_method between", value1, value2, "handleMethod");
            return (Criteria) this;
        }

        public Criteria andHandleMethodNotBetween(String value1, String value2) {
            addCriterion("handle_method not between", value1, value2, "handleMethod");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andAnotherNameIsNull() {
            addCriterion("another_name is null");
            return (Criteria) this;
        }

        public Criteria andAnotherNameIsNotNull() {
            addCriterion("another_name is not null");
            return (Criteria) this;
        }

        public Criteria andAnotherNameEqualTo(String value) {
            addCriterion("another_name =", value, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameNotEqualTo(String value) {
            addCriterion("another_name <>", value, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameGreaterThan(String value) {
            addCriterion("another_name >", value, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameGreaterThanOrEqualTo(String value) {
            addCriterion("another_name >=", value, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameLessThan(String value) {
            addCriterion("another_name <", value, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameLessThanOrEqualTo(String value) {
            addCriterion("another_name <=", value, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameLike(String value) {
            addCriterion("another_name like", value, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameNotLike(String value) {
            addCriterion("another_name not like", value, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameIn(List<String> values) {
            addCriterion("another_name in", values, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameNotIn(List<String> values) {
            addCriterion("another_name not in", values, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameBetween(String value1, String value2) {
            addCriterion("another_name between", value1, value2, "anotherName");
            return (Criteria) this;
        }

        public Criteria andAnotherNameNotBetween(String value1, String value2) {
            addCriterion("another_name not between", value1, value2, "anotherName");
            return (Criteria) this;
        }

        public Criteria andLabelDetailIsNull() {
            addCriterion("label_detail is null");
            return (Criteria) this;
        }

        public Criteria andLabelDetailIsNotNull() {
            addCriterion("label_detail is not null");
            return (Criteria) this;
        }

        public Criteria andLabelDetailEqualTo(Long value) {
            addCriterion("label_detail =", value, "labelDetail");
            return (Criteria) this;
        }

        public Criteria andLabelDetailNotEqualTo(Long value) {
            addCriterion("label_detail <>", value, "labelDetail");
            return (Criteria) this;
        }

        public Criteria andLabelDetailGreaterThan(Long value) {
            addCriterion("label_detail >", value, "labelDetail");
            return (Criteria) this;
        }

        public Criteria andLabelDetailGreaterThanOrEqualTo(Long value) {
            addCriterion("label_detail >=", value, "labelDetail");
            return (Criteria) this;
        }

        public Criteria andLabelDetailLessThan(Long value) {
            addCriterion("label_detail <", value, "labelDetail");
            return (Criteria) this;
        }

        public Criteria andLabelDetailLessThanOrEqualTo(Long value) {
            addCriterion("label_detail <=", value, "labelDetail");
            return (Criteria) this;
        }

        public Criteria andLabelDetailIn(List<Long> values) {
            addCriterion("label_detail in", values, "labelDetail");
            return (Criteria) this;
        }

        public Criteria andLabelDetailNotIn(List<Long> values) {
            addCriterion("label_detail not in", values, "labelDetail");
            return (Criteria) this;
        }

        public Criteria andLabelDetailBetween(Long value1, Long value2) {
            addCriterion("label_detail between", value1, value2, "labelDetail");
            return (Criteria) this;
        }

        public Criteria andLabelDetailNotBetween(Long value1, Long value2) {
            addCriterion("label_detail not between", value1, value2, "labelDetail");
            return (Criteria) this;
        }

        public Criteria andCropTypeIsNull() {
            addCriterion("crop_type is null");
            return (Criteria) this;
        }

        public Criteria andCropTypeIsNotNull() {
            addCriterion("crop_type is not null");
            return (Criteria) this;
        }

        public Criteria andCropTypeEqualTo(Long value) {
            addCriterion("crop_type =", value, "cropType");
            return (Criteria) this;
        }

        public Criteria andCropTypeNotEqualTo(Long value) {
            addCriterion("crop_type <>", value, "cropType");
            return (Criteria) this;
        }

        public Criteria andCropTypeGreaterThan(Long value) {
            addCriterion("crop_type >", value, "cropType");
            return (Criteria) this;
        }

        public Criteria andCropTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("crop_type >=", value, "cropType");
            return (Criteria) this;
        }

        public Criteria andCropTypeLessThan(Long value) {
            addCriterion("crop_type <", value, "cropType");
            return (Criteria) this;
        }

        public Criteria andCropTypeLessThanOrEqualTo(Long value) {
            addCriterion("crop_type <=", value, "cropType");
            return (Criteria) this;
        }

        public Criteria andCropTypeIn(List<Long> values) {
            addCriterion("crop_type in", values, "cropType");
            return (Criteria) this;
        }

        public Criteria andCropTypeNotIn(List<Long> values) {
            addCriterion("crop_type not in", values, "cropType");
            return (Criteria) this;
        }

        public Criteria andCropTypeBetween(Long value1, Long value2) {
            addCriterion("crop_type between", value1, value2, "cropType");
            return (Criteria) this;
        }

        public Criteria andCropTypeNotBetween(Long value1, Long value2) {
            addCriterion("crop_type not between", value1, value2, "cropType");
            return (Criteria) this;
        }

        public Criteria andPathogenIsNull() {
            addCriterion("Pathogen is null");
            return (Criteria) this;
        }

        public Criteria andPathogenIsNotNull() {
            addCriterion("Pathogen is not null");
            return (Criteria) this;
        }

        public Criteria andPathogenEqualTo(String value) {
            addCriterion("Pathogen =", value, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenNotEqualTo(String value) {
            addCriterion("Pathogen <>", value, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenGreaterThan(String value) {
            addCriterion("Pathogen >", value, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenGreaterThanOrEqualTo(String value) {
            addCriterion("Pathogen >=", value, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenLessThan(String value) {
            addCriterion("Pathogen <", value, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenLessThanOrEqualTo(String value) {
            addCriterion("Pathogen <=", value, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenLike(String value) {
            addCriterion("Pathogen like", value, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenNotLike(String value) {
            addCriterion("Pathogen not like", value, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenIn(List<String> values) {
            addCriterion("Pathogen in", values, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenNotIn(List<String> values) {
            addCriterion("Pathogen not in", values, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenBetween(String value1, String value2) {
            addCriterion("Pathogen between", value1, value2, "pathogen");
            return (Criteria) this;
        }

        public Criteria andPathogenNotBetween(String value1, String value2) {
            addCriterion("Pathogen not between", value1, value2, "pathogen");
            return (Criteria) this;
        }

        public Criteria andCycleIsNull() {
            addCriterion("Cycle is null");
            return (Criteria) this;
        }

        public Criteria andCycleIsNotNull() {
            addCriterion("Cycle is not null");
            return (Criteria) this;
        }

        public Criteria andCycleEqualTo(String value) {
            addCriterion("Cycle =", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotEqualTo(String value) {
            addCriterion("Cycle <>", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThan(String value) {
            addCriterion("Cycle >", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThanOrEqualTo(String value) {
            addCriterion("Cycle >=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThan(String value) {
            addCriterion("Cycle <", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThanOrEqualTo(String value) {
            addCriterion("Cycle <=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLike(String value) {
            addCriterion("Cycle like", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotLike(String value) {
            addCriterion("Cycle not like", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleIn(List<String> values) {
            addCriterion("Cycle in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotIn(List<String> values) {
            addCriterion("Cycle not in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleBetween(String value1, String value2) {
            addCriterion("Cycle between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotBetween(String value1, String value2) {
            addCriterion("Cycle not between", value1, value2, "cycle");
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