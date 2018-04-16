package com.coolweather.android.pojo;

import org.litepal.crud.DataSupport;

import java.util.Date;

public class LabelDetail extends DataSupport {
    private Long LabelDetailId;

    public Long getLabelDetailId() {
        return LabelDetailId;
    }

    public void setLabelDetailId(Long labelDetailId) {
        LabelDetailId = labelDetailId;
    }

    /**
     *主键id
     */
    private Long id;
    /**
     *整体大类表中id值
     */
    private Long labelId;
    /**
     *种类大类下细分品种名称水稻 小麦 大麦 玉米 高梁
     */
    private String labelName;

    private Date createTime;

    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
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
}