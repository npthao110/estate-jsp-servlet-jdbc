package com.laptrinhjavaweb.utils;

import java.util.*;


public class BuildingTypeMapper {

    public static final String TANG_TRET = "tang-tret";
    public static final String NGUYEN_CAN = "nguyen-can";
    public static final String NOI_THAT = "noi-that";

    private static final Map<String, String> typeMap = new HashMap<>();

    static {
        typeMap.put(TANG_TRET, "tầng trệt");
        typeMap.put(NGUYEN_CAN, "nguyên căn");
        typeMap.put(NOI_THAT, "nội thất");
    }

    public static String mapType(String type) {
        return typeMap.getOrDefault(type, "");
    }
}
