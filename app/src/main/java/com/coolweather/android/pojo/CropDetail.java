package com.coolweather.android.pojo;

import org.litepal.crud.DataSupport;

import java.util.Date;
import java.util.List;

public class CropDetail extends DataSupport {
    private Long cropId;

    public Long getCropId() {
        return cropId;
    }

    public void setCropId(Long cropId) {
        this.cropId = cropId;
    }

    private Long id;
    /**
     *病虫名称
     */
    private String cropName;
    /**
     *英文名称
     */
    private String englishName;
    /**
     *简介
     */
    private String introduction;
    /**
     *病虫害图片表id
     */
    private Long cropImg;
    /**
     *为害症状
     */
    private String damageSym;
    /**
     *发生因素
     */
    private String occurrenceFactor;
    /**
     *形态特征
     */
    private String morphology;
    /**
     *生活习性
     */
    private String habits;
    /**
     *防治方法
     */
    private String handleMethod;

    private Date createTime;

    private Date updateTime;
    /**
     *别名
     */
    private String anotherName;
    /**
     *种类细分表中id值
     */
    private Long labelDetail;
    /**
     *病虫害分类1.病害 2.虫害
     */
    private Long cropType;
    /**
     * 病原物
     */
    private String pathogen;
    /**
     *侵染循环
     */
    private String cycle;

    /**
     * 图片对应lsit
     */
    private List<CropDetailImg> imgList;

    public List<CropDetailImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<CropDetailImg> imgList) {
        this.imgList = imgList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getCropImg() {
        return cropImg;
    }

    public void setCropImg(Long cropImg) {
        this.cropImg = cropImg;
    }

    public String getDamageSym() {
        return damageSym;
    }

    public void setDamageSym(String damageSym) {
        this.damageSym = damageSym;
    }

    public String getOccurrenceFactor() {
        return occurrenceFactor;
    }

    public void setOccurrenceFactor(String occurrenceFactor) {
        this.occurrenceFactor = occurrenceFactor;
    }

    public String getMorphology() {
        return morphology;
    }

    public void setMorphology(String morphology) {
        this.morphology = morphology;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public String getHandleMethod() {
        return handleMethod;
    }

    public void setHandleMethod(String handleMethod) {
        this.handleMethod = handleMethod;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(String anotherName) {
        this.anotherName = anotherName;
    }

    public Long getLabelDetail() {
        return labelDetail;
    }

    public void setLabelDetail(Long labelDetail) {
        this.labelDetail = labelDetail;
    }

    public Long getCropType() {
        return cropType;
    }

    public void setCropType(Long cropType) {
        this.cropType = cropType;
    }

    public String getPathogen() {
        return pathogen;
    }

    public void setPathogen(String pathogen) {
        this.pathogen = pathogen;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}