package com.SpringBootJpaH2.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SpringBootJpaH2.demo.model.Alien;



public interface AlienRepo extends CrudRepository<Alien, Integer> {

	List<Alien> findByName(String name);
	List<Alien> findByIdGreaterThan(int id);
	
	
}
