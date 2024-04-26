package com.laptrinhjavaweb.view;

import java.util.*;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;

public class BuildingListView {

	public static void main(String[] args) {
		String name = null;
		String street = null;
		String ward = null;
		String district = null;
		Integer floorArea = null;
		BuildingSearchInput buildingSearch = new BuildingSearchInput();
		buildingSearch.setFloorArea(floorArea);
		buildingSearch.setName(name);
		buildingSearch.setWard(ward);
		buildingSearch.setStreet(street);
		buildingSearch.setDistrict(district);
		BuildingController buildingController = new BuildingController();
		List<BuildingOutput> buildings = buildingController.findBuilding(buildingSearch);
//		System.out.println("test");
//		Map<String, String> typeMapping = new HashMap<>();
//		typeMapping.put("tang-tret,nguyen-can", "(tầng trệt, nguyên căn)");
//		typeMapping.put("nguyen-can,noi-that", "(nguyên căn, nội thất)");
		for (BuildingOutput item : buildings) {
//		    String type = item.getType();
//		    if (typeMapping.containsKey(type)) {
//		        type = typeMapping.get(type);
//		    }

		    System.out.println(item.getName() + ", " + item.getAddress() + ", (" + item.getType() + ")");
		}

	}
}
