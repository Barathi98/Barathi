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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="Placement")
public class PlacementEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int placementId;
	
	@Column(nullable = false)
	private String placementType;
	
	@Column(nullable = false)
	private String placementDescription;
	
	@Column(nullable = false)
	private String placementCompanyName;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@OneToOne(mappedBy = "placement")
	private StudentEntity student;
	
	@OneToMany(mappedBy = "placement",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CompanyEntity> company=new ArrayList<>();
	

}
