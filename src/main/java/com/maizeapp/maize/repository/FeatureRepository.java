package com.maizeapp.maize.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maizeapp.maize.entity.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
//
//	 @Query("SELECT f FROM Feature f WHERE f.role.id = :roleId")
//	    List<Feature> findByRoleId(@Param("roleId") Long roleId);
//	
//c for mysql  quury to run change r.id to 3 2 1

//	select f.*
//	FROM maizeproject2.feature f
//	INNER JOIN maizeproject2.role r ON f.role_id = r.id
//	WHERE r.id = 2;
//
//	@Query("SELECT f FROM Feature f INNER JOIN f.role r WHERE r.id = :roleId")
//	List<Feature> findByRoleId(@Param("roleId") int i);

	@Query("SELECT f FROM Feature f INNER JOIN f.role r WHERE r.id = :roleId")
	List<Feature> findByRoleId(@Param("roleId") Long roleId);

	// List<Feature> findAll();
}
