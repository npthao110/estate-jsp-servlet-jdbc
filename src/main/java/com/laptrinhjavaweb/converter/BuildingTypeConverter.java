package com.laptrinhjavaweb.converter;

import java.util.*;
import com.laptrinhjavaweb.utils.BuildingTypeMapper;


public class BuildingTypeConverter {

    public static String convertType(String type) {
        List<String> types = Arrays.asList(type.split(","));
        StringBuilder result = new StringBuilder();
        for (String t : types) {
            String mappedType = BuildingTypeMapper.mapType(t.trim());
            if (!mappedType.isEmpty()) {
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(mappedType);
            }
        }
        return result.toString().trim();
    }

}
