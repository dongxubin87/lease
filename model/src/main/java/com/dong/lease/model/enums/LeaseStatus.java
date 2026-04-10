package com.dong.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LeaseStatus implements BaseEnum {

    SIGNING(1, "Pending Signature"),
    SIGNED(2, "Signed"),
    CANCELED(3, "Canceled"),
    EXPIRED(4, "Expired"),
    WITHDRAWING(5, "Pending Move-out"),
    WITHDRAWN(6, "Moved Out"),
    RENEWING(7, "Pending Renewal");

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    LeaseStatus(Integer code, String name) {
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