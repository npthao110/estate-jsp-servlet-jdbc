package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.BuildingDao;
import com.laptrinhjavaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.laptrinhjavaweb.dao.impl.BuildingDaoImpl;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.converter.BuildingTypeConverter;
import com.laptrinhjavaweb.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {

	private BuildingDao buildingDao = new BuildingDaoImpl();
	
	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel) {
		List<BuildingOutput> buildingEmyeuanhs = new ArrayList<>();
		List<BuildingAnhyeuem> anhyeuems = buildingDao.findBuilding(buildingModel.getFloorArea(), buildingModel.getName(),buildingModel.getWard(), 
								 buildingModel.getStreet(), buildingModel.getDistrict(), buildingModel.getType());
		for (BuildingAnhyeuem item : anhyeuems) {
		    BuildingOutput buildingOutput = new BuildingOutput();
		    buildingOutput.setName(item.getName());
		    String street = item.getStreet() != null ? item.getStreet() : "";
		    String ward = item.getWard() != null ? item.getWard() : "";
		    String district = item.getDistrict() != null ? item.getDistrict() : "";
		    StringBuilder addressBuilder = new StringBuilder();
		    if (!street.isEmpty()) {
		        addressBuilder.append(street);
		    }
		    if (!ward.isEmpty()) {
		        addressBuilder.append(" - ").append(ward);
		    }
		    if (!district.isEmpty()) {
		        addressBuilder.append(" - ").append(district);
		    }
		    buildingOutput.setAddress(addressBuilder.toString());
		    buildingOutput.setType(BuildingTypeConverter.convertType(item.getType()));
		    buildingEmyeuanhs.add(buildingOutput);
		}
		return buildingEmyeuanhs;
	}

}
