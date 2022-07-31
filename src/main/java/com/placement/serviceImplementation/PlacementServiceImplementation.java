package com.placement.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.entity.CompanyEntity;
import com.placement.entity.PlacementEntity;
import com.placement.entity.StudentEntity;
import com.placement.entity.TrainingEntity;
import com.placement.exception.ResourceNotFoundException;
import com.placement.payloads.CompanyDto;
import com.placement.payloads.PlacementDto;
import com.placement.payloads.StudentDto;
import com.placement.payloads.TrainingDto;
import com.placement.repository.CompanyRepository;
import com.placement.repository.PlacementRepository;
import com.placement.repository.StudentRepository;
import com.placement.repository.TrainingRepository;
import com.placement.service.PlacementService;
@Service
public class PlacementServiceImplementation  implements PlacementService
{
	
	@Autowired
	private PlacementRepository placementRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public PlacementDto createPlacement(PlacementDto placementDto, int studentId)
	{
		StudentEntity studentEntity=this.studentRepository.findById(studentId).
				 orElseThrow(
						 ()->new ResourceNotFoundException("Student","StudentId",studentId));
		PlacementEntity placementEntity=this.modelMapper.map(placementDto, PlacementEntity.class);
		placementEntity.setStudent(studentEntity);			
		//placementDto.setStudent(this.modelMapper.map(studentEntity, StudentDto.class));
		PlacementEntity createdPlacement = this.placementRepository.save(placementEntity);
		
		return this.modelMapper.map(createdPlacement, PlacementDto.class);
	}

	

	@Override
	public PlacementDto getPlacementById(int placementId)
	{
		PlacementEntity placementEntity = this.placementRepository.findById(placementId).
				     orElseThrow(
				    		 ()->new ResourceNotFoundException("Placement","PlacementId",placementId));
		
		return this.placementEntityToPlacementDto(placementEntity);
	}

	@Override
	public List<PlacementDto> getAllPlacements() 
	{
		List<PlacementEntity> placementList=this.placementRepository.findAll();
		//System.out.println("List of Placements"+placementList);
		List<PlacementDto> getAllPlacements = placementList.stream().map(placement->this.modelMapper.map(placement, PlacementDto.class)).collect(Collectors.toList());
		
		return getAllPlacements;
	}

	@Override
	public PlacementDto updatePlacementById(PlacementDto placementDto, int placementId)
	{
		PlacementEntity placementEntity = this.placementRepository.findById(placementId).
				    orElseThrow(
				    		()->new ResourceNotFoundException("Placement","PlacementId",placementId));
		PlacementEntity updatePlacement = this.placementRepository.save(this.placementDtoToPlacementEntity(placementDto));
		return this.placementEntityToPlacementDto(updatePlacement);
	}

	@Override
	public void deletePlacementById(int placementId)
	{
		PlacementEntity placementEntity = this.placementRepository.findById(placementId).
			    orElseThrow(
			    		()->new ResourceNotFoundException("Placement","PlacementId",placementId));
		this.placementRepository.delete(placementEntity);
		
	}
	private PlacementDto placementEntityToPlacementDto(PlacementEntity placementEntity)
	{
		return this.modelMapper.map(placementEntity, PlacementDto.class);
	}
	private PlacementEntity placementDtoToPlacementEntity(PlacementDto placementDto)
	{
		return this.modelMapper.map(placementDto, PlacementEntity.class);
	}

	@Override
	public List<PlacementDto> getAllPlacementsByStudentId(int studentId) 
	{
		List<PlacementEntity> placements = this.placementRepository.getPlacementEntityByStudid(studentId);
		//System.out.println("List Of Placements"+placements);
		List<PlacementDto> placementDtoList = placements.stream().map(placement->this.modelMapper.map(placement, PlacementDto.class)).collect(Collectors.toList()); 
		
		return placementDtoList;
	}



	@Override
	public long getCountOfPlacements()
	{
		long Count=placementRepository.count();
		return Count;
	}


//
//	@Override
//	public List<PlacementDto> getPlacementCounts(String placementType) 
//	{
////		List<PlacementEntity> placements=this.placementRepository.aMethodNameOrSomething(placementType);
////		List<PlacementDto> placaementList=placements.stream().map(placement->this.modelMapper.map(placement, PlacementDto.class)).collect(Collectors.toList());
////		return placaementList;
//	}

}
