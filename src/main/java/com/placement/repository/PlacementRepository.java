package com.placement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.placement.entity.CompanyEntity;
import com.placement.entity.PlacementEntity;
import com.placement.entity.TrainingEntity;

public interface PlacementRepository extends JpaRepository<PlacementEntity, Integer>
{

//	List<PlacementEntity> findByCompany(CompanyEntity companyEntity);
	
@Query(value = "SELECT * FROM placement plac WHERE plac.student_student_id = :studid",nativeQuery = true)
	
	public List<PlacementEntity> getPlacementEntityByStudid( @Param("studid") int studid);

	Optional<PlacementEntity> findByplacementType(String placementType);

	public List<PlacementEntity> findByCompany(CompanyEntity company);
	
//	 @Query("SELECT COUNT(placement) FROM Placement placement WHERE placement.placementType=:placementType")
//	    List<PlacementEntity> aMethodNameOrSomething(@Param("placementType") String placementType);

}
