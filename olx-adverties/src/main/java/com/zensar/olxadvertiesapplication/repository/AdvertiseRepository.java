package com.zensar.olxadvertiesapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zensar.olxadvertiesapplication.entity.Advertise;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Long>{

	@Query(value = "SELECT * FROM advertise WHERE category LIKE %:searchByText% or description LIKE"
			+ " %:searchByText% or status LIKE %:searchByText% or title LIKE %:searchByText% or username"
			+ " LIKE %:searchByText%",nativeQuery = true)
	List<Advertise> searchByText(@Param("searchByText")String searchText);

	@Query(value = "SELECT * FROM advertise WHERE category LIKE %:search% or description LIKE"
			+ " %:search% or status LIKE %:search% or title LIKE %:search% or username"
			+ " LIKE %:search% or category LIKE %:categorys%",nativeQuery = true)
	List<Advertise> searchByFilterCriteria(@Param("search")String searchText,@Param("categorys")String category);

}
