package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.BuildingDao;
import com.laptrinhjavaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.laptrinhjavaweb.dao.impl.BuildingDaoImpl;
import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.emyeuanh.BuildingEmyeuanh;

public class BuildingServiceImpl implements BuildingService {

	private BuildingDao buildingDao = new BuildingDaoImpl();
	
	@Override
	public List<BuildingEmyeuanh> findBuilding(BuildingModel buildingModel) {
		List<BuildingEmyeuanh> buildingEmyeuanhs = new ArrayList<>();
		List<BuildingAnhyeuem> anhyeuems = buildingDao.findBuilding(buildingModel.getFloorArea(), buildingModel.getName(),buildingModel.getWard(), 
								 buildingModel.getStreet(), buildingModel.getDistrict());
//		int i = 0;
		for(BuildingAnhyeuem item : anhyeuems) {
			BuildingEmyeuanh buildingEmyeuanh = new BuildingEmyeuanh();
			buildingEmyeuanh.setName(item.getName());
//			buildingEmyeuanhs[i] = buildingEmyeuanh;
//			i++;
			buildingEmyeuanhs.add(buildingEmyeuanh);
		}
		return buildingEmyeuanhs;
	}

}
