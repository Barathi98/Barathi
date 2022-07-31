package com.placement.payloads;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.placement.entity.AdminEntity;

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
public class StudentDto
{
	private int studentId;
	
	private String studentName;
	
	private String studentEmail;
	
	private String studentContact;
	
	private String studentQualification;
	
	private String password;
	@JsonBackReference
	private AdminDto admin;
	
	@JsonManagedReference
	private PlacementDto placement;
	
	
}
