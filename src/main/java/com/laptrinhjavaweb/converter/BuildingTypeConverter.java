package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.enums.BuildingTypeEnums;

public class BuildingTypeConverter {

    public static String convertType(String oldType) {
        if (oldType != null) {
            StringBuilder convertedType = new StringBuilder();

            String[] typeArray = oldType.split(",");

            for (String item : typeArray) {
                convertedType.append("\n- " + BuildingTypeEnums.valueOf(item).getValue());
            }

            return String.join(", ", convertedType.toString());
        }

        return null;
    }
}

