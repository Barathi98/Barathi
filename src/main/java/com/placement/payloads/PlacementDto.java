package com.placement.payloads;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.placement.entity.CompanyEntity;
import com.placement.entity.StudentEntity;
import com.placement.entity.TrainingEntity;

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
public class PlacementDto 
{
    private int placementId;
	
	private String placementType;
	
	private String placementDescription;
	
	private String placementCompanyName;
	
	@JsonBackReference
	private StudentDto student;
	
	@JsonManagedReference
	private List<CompanyDto> company;

}
