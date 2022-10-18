package com.SpringBootJpaH2.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBootJpaH2.demo.dao.AlienRepo;
import com.SpringBootJpaH2.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@PostMapping("/alien")
	public Alien addAlien(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{id}")
	public String deleteAlien(@PathVariable int id) {
		Alien alien = repo.getOne(id);
		repo.delete(alien);
		return "deleted";
	}
	
	@PutMapping("/alien")
	public Alien updateAlien(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@GetMapping("/alien")
	public List<Alien> GetAllAliens() {
		
		return repo.findAll();
	}
	
	@GetMapping("/alien/{id}")
	public Optional<Alien> GetAlien(@PathVariable int id) {
		
		return repo.findById(id);
	}
	
//	@RequestMapping("/")
//	public String home() {
//		return "home.jsp";
//	}
//	
//	@RequestMapping("/addAlien")
//	public String addAlien(Alien alien) {
//		repo.save(alien);
//		return "home.jsp";
//	}
//	
//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam("name") String name) {
//		
//		
//		ModelAndView mv = new ModelAndView("showData.jsp");
//		List<Alien> aliens = repo.findByNameSorted(name);
//		mv.addObject("aliens", aliens);
//		return mv;
//	}
//	
//	@RequestMapping("/aliens")
//	@ResponseBody
//	public List<Alien> getAliens() {
//		
//		return repo.findAll();
//	}
//	
//	@RequestMapping("/alien/1")
//	@ResponseBody
//	public String getAlien() {
//		
//		return repo.findById(1).toString();
//	}
//	
//	
//	@RequestMapping("/alien/{id}")
//	@ResponseBody
//	public Optional<Alien> getAlien(@PathVariable int id) {
//		
//		return repo.findById(id);
//	}
	
	
	
}