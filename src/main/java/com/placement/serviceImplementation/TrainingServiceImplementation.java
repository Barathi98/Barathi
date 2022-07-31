package com.placement.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.entity.CompanyEntity;
import com.placement.entity.PlacementEntity;
import com.placement.entity.TrainingEntity;
import com.placement.exception.ResourceNotFoundException;
import com.placement.payloads.CompanyDto;
import com.placement.payloads.PlacementDto;
import com.placement.payloads.TrainingDto;
import com.placement.repository.CompanyRepository;
import com.placement.repository.PlacementRepository;
import com.placement.repository.TrainingRepository;
import com.placement.service.TrainingService;
@Service
public class TrainingServiceImplementation implements TrainingService
{
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private ModelMapper modelMapper;
		
	@Autowired
    private CompanyRepository companyRepository;
	
	@Override
	public TrainingDto createTraining(TrainingDto trainingDto,int companyId)
	{
		CompanyEntity companyEntity = this.companyRepository.findById(companyId).
				       orElseThrow(
				    		   ()->new ResourceNotFoundException("Company", "CompanyId", companyId));
		TrainingEntity trainingEntity=this.modelMapper.map(trainingDto, TrainingEntity.class);
		trainingEntity.setCompany(companyEntity);
		//trainingDto.setCompany(this.modelMapper.map(companyEntity, CompanyDto.class));
		TrainingEntity savedtraining = this.trainingRepository.save(trainingEntity);
		return this.modelMapper.map(savedtraining, TrainingDto.class);
	}

	

	@Override
	public List<TrainingDto> getAllTrainings()
	{
		List<TrainingDto> getAllTrainings = this.trainingRepository.findAll().stream().map(training->this.trainingEntityToTrainingDto(training)).collect(Collectors.toList());
		return getAllTrainings;
	}

	@Override
	public TrainingDto getTrainingById(int trainingId)
	{
		TrainingEntity trainingEntity = this.trainingRepository.findById(trainingId).
				     orElseThrow(
				    		 ()->new ResourceNotFoundException("Training", "TrainingId", trainingId));
		return this.trainingEntityToTrainingDto(trainingEntity);
	}

	@Override
	public TrainingDto updateTrainingById(TrainingDto trainingDto, int trainingId) 
	{
		TrainingEntity trainingEntity = this.trainingRepository.findById(trainingId).
				         orElseThrow(
				        		  ()->new ResourceNotFoundException("Training","TrainingId",trainingId));
		TrainingEntity updateTraining = this.trainingRepository.save(this.trainingDtoToTrainingEntity(trainingDto));
		return this.trainingEntityToTrainingDto(updateTraining);
	}

	@Override
	public void deleteTrainingById(int trainingId)
	{
		TrainingEntity trainingEntity = this.trainingRepository.findById(trainingId).
		         orElseThrow(
		        		  ()->new ResourceNotFoundException("Training","TrainingId",trainingId));
        this.trainingRepository.delete(trainingEntity);
		
	}

	@Override
	public List<TrainingDto> getAllTrainingsByCompanyId(int companyId) 
	{
		List<TrainingEntity> trainings = this.trainingRepository.getTrainingEntityByCompid(companyId);
		//System.out.println("List Of Trainings"+trainings);
		List<TrainingDto> trainingDtoList = trainings.stream().map(training->this.modelMapper.map(training, TrainingDto.class)).collect(Collectors.toList());
		
		return trainingDtoList;
	}

	private TrainingDto trainingEntityToTrainingDto(TrainingEntity trainingEntity)
	{
		return this.modelMapper.map(trainingEntity, TrainingDto.class);
	}
	private TrainingEntity trainingDtoToTrainingEntity(TrainingDto trainingDto)
	{
		return this.modelMapper.map(trainingDto, TrainingEntity.class);
		
	}



}
