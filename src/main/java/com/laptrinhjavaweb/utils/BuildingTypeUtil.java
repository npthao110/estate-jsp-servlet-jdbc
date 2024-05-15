package com.laptrinhjavaweb.utils;

import java.util.*;
import com.laptrinhjavaweb.constant.BuildingTypeConstant;

public class BuildingTypeUtil {
    private static final Map<String, String> typeMap = new HashMap<>();
    static {
        typeMap.put(BuildingTypeConstant.TANG_TRET, BuildingTypeConstant.TANG_TRET_NAME);
        typeMap.put(BuildingTypeConstant.NGUYEN_CAN, BuildingTypeConstant.NGUYEN_CAN_NAME);
        typeMap.put(BuildingTypeConstant.NOI_THAT, BuildingTypeConstant.NOI_THAT_NAME);
    }
    public static String mapType(String type) {
        return typeMap.getOrDefault(type, "");
    }
}