package com.laptrinhjavaweb.enums;

public enum BuildingTypeEnums {
    TANG_TRET("Tầng trệt"),
    NGUYEN_CAN("Nguyeen căn"),
    NOI_THAT("Nội thất");

    private final String value;

    BuildingTypeEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}