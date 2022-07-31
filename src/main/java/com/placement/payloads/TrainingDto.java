package com.placement.payloads;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.placement.entity.CompanyEntity;
import com.placement.entity.PlacementEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class TrainingDto
{
     private int trainingId;
	
	private String trainingName;
	
	private String trainingBatch;
	
	private String trainingYear;

	@JsonBackReference
	private CompanyDto company;
}
