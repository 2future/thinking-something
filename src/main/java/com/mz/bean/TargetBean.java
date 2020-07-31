package com.mz.bean;

/**
 * @author mz
 * @version V1.0
 * @Title TargetBean
 * @Package com.mz.bean
 * @Description 目标bean
 * @date 2020/7/31 5:16 下午
 */
public class TargetBean {

    private String fieldFirst;


    private Integer fieldSecond;

    public String getFieldFirst() {
        return fieldFirst;
    }

    public void setFieldFirst(String fieldFirst) {
        this.fieldFirst = fieldFirst;
    }

    public Integer getFieldSecond() {
        return fieldSecond;
    }

    public void setFieldSecond(Integer fieldSecond) {
        this.fieldSecond = fieldSecond;
    }

    @Override
    public String toString() {
        return "TargetBean{" +
                "fieldFirst='" + fieldFirst + '\'' +
                ", fieldSecond=" + fieldSecond +
                '}';
    }
}