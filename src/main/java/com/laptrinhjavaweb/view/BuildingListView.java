package com.laptrinhjavaweb.view;

import java.util.List;

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
		for (BuildingOutput item : buildings) {
		    System.out.println(item.getName() + ", " + item.getAddress() + ", " + item.getType());
		}

	}
}
