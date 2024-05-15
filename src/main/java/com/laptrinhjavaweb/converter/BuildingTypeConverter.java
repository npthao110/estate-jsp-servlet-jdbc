package com.laptrinhjavaweb.converter;

import java.util.*;

import com.laptrinhjavaweb.enums.BuildingTypeEnums;

public class BuildingTypeConverter {

	public static String convertType(String oldType) {
		List<String> newTypes = new ArrayList<>();
	    if(oldType != null) { 
	        for(String item: oldType.split(",")) {
	            for (BuildingTypeEnums value : BuildingTypeEnums.values()) {
	                if (value.name().equalsIgnoreCase(item)) {
	                    newTypes.add(value.getValue());
	                }
	            }
	        }
	        return String.join(", ", newTypes);
	    }
	    return null;
    }
}

