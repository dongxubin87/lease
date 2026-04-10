package com.dong.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReleaseStatus implements BaseEnum {

    RELEASED(1, "Released"),
    NOT_RELEASED(0, "Unreleased");

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    ReleaseStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}