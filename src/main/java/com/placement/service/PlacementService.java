package com.placement.service;

import java.util.List;

import com.placement.payloads.PlacementDto;

public interface PlacementService 
{
	 public PlacementDto createPlacement(PlacementDto placementDto,int studentId);
	
     public PlacementDto getPlacementById(int placementId);
     
     public List<PlacementDto> getAllPlacements();
     
     public PlacementDto updatePlacementById(PlacementDto placementDto,int placementId);
     
     public void deletePlacementById(int placementId);
     
   //  public List<PlacementDto> getAllPlacementsByCompany(int companyId);
     public List<PlacementDto> getAllPlacementsByStudentId(int studentId);
     
   //  public List<PlacementDto> getPlacementCounts(String placementType);
     
     public long getCountOfPlacements();
}

