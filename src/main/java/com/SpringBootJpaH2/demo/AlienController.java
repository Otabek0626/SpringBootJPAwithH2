package com.SpringBootJpaH2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView getAlien(@RequestParam("id") int id) {
		
		
		ModelAndView mv = new ModelAndView("showData.jsp");
		Alien alien = repo.findById(id).orElse(null);
		mv.addObject("alien", alien);
		return mv;
	}
}