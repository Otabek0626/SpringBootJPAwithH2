package com.SpringBootJpaH2.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.SpringBootJpaH2.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

}
