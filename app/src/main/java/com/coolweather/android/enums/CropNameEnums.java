package com.coolweather.android.enums;

public enum CropNameEnums {
    ID("id", 101, "id值"),
    CROP_NAME("cropName", 102, "病虫名称"),
    INTRODUCTION("introduction", 103, "简介"),
    ENGLISH_NAME("englishName", 104, "英文名称"),
    TOTAL_TEXT("totalText", 105, "总字符串 用于全文检索"),
    DAMAGE_SYM("damageSym", 106, "为害症状"),
    OCCURRENCE_FACTOR("occurrenceFactor", 107, "发生因素"),
    MORPHOLOGY("morphology", 108, "形态特征"),
    HABITS("habits", 109, "生活习性"),
    HANDLE_METHOD("handleMethod", 110, "防治方法"),
    ANOTHER_NAME("anotherName", 111, "别名"),
    PATHOGEN("pathogen", 112, "病原物"),
    CYCLE("cycle", 113, "侵染循环"),
    CROP_TYPE("cropType", 114, "病虫害分类1.病害 2.虫害"),;

    private String cropName;
    private int cropNo;
    private String cropDesc;

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public int getCropNo() {
        return cropNo;
    }

    public void setCropNo(int cropNo) {
        this.cropNo = cropNo;
    }

    public String getCropDesc() {
        return cropDesc;
    }

    public void setCropDesc(String cropDesc) {
        this.cropDesc = cropDesc;
    }

    CropNameEnums(String cropName, int cropNo, String cropDesc) {
        this.cropDesc = cropDesc;
        this.cropName = cropName;
        this.cropNo = cropNo;
    }

    public static CropNameEnums getCropNameEnumById(int id) {
        for (CropNameEnums cropNameEnums : CropNameEnums.values()) {
            if (cropNameEnums.getCropNo() == id) {
                return cropNameEnums;
            }
        }
        return null;
    }
    public static CropNameEnums getCropNameEnumByDesc(String cropDesc) {
        for (CropNameEnums cropNameEnums : CropNameEnums.values()) {
            if (cropNameEnums.getCropDesc().equals(cropDesc)) {
                return cropNameEnums;
            }
        }
        return null;
    }

}
