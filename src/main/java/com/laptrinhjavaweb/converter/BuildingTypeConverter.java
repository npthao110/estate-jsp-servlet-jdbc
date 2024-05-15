package com.laptrinhjavaweb.converter;

import java.util.*;

import com.laptrinhjavaweb.enums.BuildingTypeEnums;
import com.laptrinhjavaweb.utils.StringUtils;

public class BuildingTypeConverter {

	public static String convertType(String oldType) {
		List<String> newTypes = new ArrayList<>();
	    if(oldType != null) { 
//	        for(String item: oldType.split(",")) {
//	            for (BuildingTypeEnums value : BuildingTypeEnums.values()) {
//	                if (value.name().equalsIgnoreCase(item)) {
//	                    newTypes.add(value.getValue());
//	                }
//	            }
//	        }
	        
	        StringBuilder convertedType = new StringBuilder();
	        
	        String[] typeArray = oldType.split(",");

	        for (String item : typeArray) {
	        	convertedType.append("\n- " + BuildingTypeEnums.valueOf(item).getValue());
	        }
	        
//	        buildingSearchOutput.setType(convertedType.toString());
	        
	        return String.join(", ", convertedType.toString());

//	        return String.join(", ", newTypes);
	    }
	    return null;
    }
}

