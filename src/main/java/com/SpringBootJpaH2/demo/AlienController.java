package com.SpringBootJpaH2.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBootJpaH2.demo.dao.AlienRepo;
import com.SpringBootJpaH2.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("name") String name) {
		
		
		ModelAndView mv = new ModelAndView("showData.jsp");
		List<Alien> aliens = repo.findByNameSorted(name);
		mv.addObject("aliens", aliens);
		return mv;
	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens() {
		
		return repo.findAll();
	}
	
	@RequestMapping("/alien/1")
	@ResponseBody
	public String getAlien() {
		
		return repo.findById(1).toString();
	}
	
	
	@RequestMapping("/alien/{id}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable int id) {
		
		return repo.findById(id);
	}
	
	
	
}