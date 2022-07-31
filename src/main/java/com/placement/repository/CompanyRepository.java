package com.placement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.placement.entity.CompanyEntity;
import com.placement.entity.StudentEntity;
import com.placement.payloads.CompanyDto;

public interface CompanyRepository  extends JpaRepository<CompanyEntity,Integer>
{

	//List<CompanyEntity> findByStudent(StudentEntity studentEntity);
	
	
@Query(value = "SELECT * FROM company comp WHERE comp.placement_placement_id = :placid",nativeQuery = true)
	
	public List<CompanyEntity> getCompanyEntityByPlacid( @Param("placid") int placid);

	Optional<CompanyEntity> findBycompanyType(String companyType);



//	public List<CompanyEntity> findByStudent(StudentEntity student);

}
