package com.coolweather.android.enums;

/**
 * Created by Administrator on 2018/4/12.
 */

public enum IncludeEnums {
    INCLUDE(" +","包含"),
    NOT_INCLUDE(" -","不含")
    ;
    private String symbol;
    private String desc;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    IncludeEnums(String symbol, String desc) {
        this.symbol = symbol;
        this.desc = desc;
    }

    public static IncludeEnums getIncludeEnumsByDesc(String desc) {
        for (IncludeEnums includeEnums : IncludeEnums.values()) {
            if (includeEnums.getDesc() .equals(desc)) {
                return includeEnums;
            }
        }
        return null;
    }
}
