package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.emyeuanh.BuildingEmyeuanh;
import com.laptrinhjavaweb.service.impl.BuildingServiceImpl;

public class BuildingController {
	
	private BuildingService buildingService = new BuildingServiceImpl();
	
	public List<BuildingModel> findBuilding(BuildingModel buildingSearch) {
		List<BuildingModel> results = new ArrayList<>();
		List<BuildingEmyeuanh> buildingEmyeuanhs = buildingService.findBuilding(buildingSearch);
		for (BuildingEmyeuanh item : buildingEmyeuanhs) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(item.getName());
			results.add(buildingModel);
		}
		
		return results;
	}
}
