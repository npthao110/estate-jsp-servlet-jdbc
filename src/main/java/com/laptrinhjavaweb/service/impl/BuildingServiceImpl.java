package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.BuildingDao;
import com.laptrinhjavaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.laptrinhjavaweb.dao.impl.BuildingDaoImpl;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.output.BuildingOutput;
import com.laptrinhjavaweb.service.impl.BuildingTypeConverter;
import com.laptrinhjavaweb.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {

	private BuildingDao buildingDao = new BuildingDaoImpl();
	
	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel) {
		List<BuildingOutput> buildingEmyeuanhs = new ArrayList<>();
		List<BuildingAnhyeuem> anhyeuems = buildingDao.findBuilding(buildingModel.getFloorArea(), buildingModel.getName(),buildingModel.getWard(), 
								 buildingModel.getStreet(), buildingModel.getDistrict(), buildingModel.getType());
//		int i = 0;
//		for(BuildingAnhyeuem item : anhyeuems) {
//			BuildingOutput buildingOutput = new BuildingOutput();
//			buildingOutput.setName(item.getName());
//			buildingOutput.setAddress(item.getStreet() + " - " + item.getWard() + " - " + item.getDistrict());
//		    buildingOutput.setType(BuildingTypeConverter.convertType(item.getType()));
////			buildingEmyeuanhs[i] = buildingEmyeuanh;
////			i++;
//			buildingEmyeuanhs.add(buildingOutput);
//		}
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
		        if (addressBuilder.length() > 0) {
		            addressBuilder.append(" - ");
		        }
		        addressBuilder.append(ward);
		    }
		    if (!district.isEmpty()) {
		        if (addressBuilder.length() > 0) {
		            addressBuilder.append(" - ");
		        }
		        addressBuilder.append(district);
		    }

		    buildingOutput.setAddress(addressBuilder.toString());
		    buildingOutput.setType(BuildingTypeConverter.convertType(item.getType()));
		    buildingEmyeuanhs.add(buildingOutput);
		}
		
		return buildingEmyeuanhs;
	}

}
