package com.placement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name="Admin")
public class AdminEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	@Column(nullable = false)
	private String adminName;
	
	@Column(nullable=false)
	private String adminEmail;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JsonManagedReference
	private List<StudentEntity> student=new ArrayList<StudentEntity>();
	
//	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<PlacementEntity> placement=new ArrayList<>();

	
}
