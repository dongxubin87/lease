package com.dong.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AppointmentStatus implements BaseEnum {

    WAITING(1, "Pending Viewing"),

    CANCELED(2, "Canceled"),

    VIEWED(3, "Viewed");

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    AppointmentStatus(Integer code, String name) {
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