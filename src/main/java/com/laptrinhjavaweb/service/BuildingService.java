package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.service.emyeuanh.BuildingEmyeuanh;

public interface BuildingService {
	
	List<BuildingEmyeuanh> findBuilding(BuildingModel buildingModel);
}
