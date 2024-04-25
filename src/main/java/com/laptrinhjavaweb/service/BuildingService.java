package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;

public interface BuildingService {
	
	List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel);
}
