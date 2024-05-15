package com.laptrinhjavaweb.enums;

public enum BuildingTypeEnums {

    tang_tret ("tầng trệt"),  
    nguyen_can ("nguyên căn"),  
    noi_that ("nội thất");
	
	private final String value;

    private BuildingTypeEnums(String value) {
        this.value = value;
    }

    public String getValue() {
		return value;
	}
}
