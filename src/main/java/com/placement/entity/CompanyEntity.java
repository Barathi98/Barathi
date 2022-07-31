package com.placement.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(name="Company")
public class CompanyEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	
	@Column(nullable =false)
	private String companyName;
	
	@Column(nullable = false)
	private String companyAddress;
	
	@Column(nullable = false)
	private String companyType;
	
	@Column(nullable = false)
	private String companyDescription;
	
	@ManyToOne
	private PlacementEntity placement;
	
//	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<PlacementEntity> placement = new ArrayList<PlacementEntity>();
	
	@OneToMany(mappedBy = "company",cascade  = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<TrainingEntity> training=new ArrayList<>();
	

}
