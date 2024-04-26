package com.laptrinhjavaweb.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingTypeMapper {

    private static final Map<String, String> typeMap = new HashMap<>();

    static {
        typeMap.put("tang-tret", "tầng trệt");
        typeMap.put("nguyen-can", "nguyên căn");
        typeMap.put("noi-that", "nội thất");
    }


    public static String mapType(String type) {
        List<String> types = Arrays.asList(type.split(","));
        StringBuilder result = new StringBuilder();
        for (String t : types) {
            if (typeMap.containsKey(t)) {
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(typeMap.get(t));
            }
        }
        return result.toString().trim();
    }

}
