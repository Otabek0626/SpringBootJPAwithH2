package com.SpringBootJpaH2.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.SpringBootJpaH2.demo.model.Alien;



public interface AlienRepo extends JpaRepository<Alien, Integer> {

	List<Alien> findByName(String name);
	
	@Query("from Alien where name=?1 order by age")
	List<Alien> findByNameSorted(String name);
	
	
}
