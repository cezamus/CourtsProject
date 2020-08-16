package com.CourtsProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CourtsProject.entity.Center;
import com.CourtsProject.entity.Court;
import com.CourtsProject.service.CenterService;
import com.CourtsProject.service.CourtService;

@RestController
public class CourtController {

	@Autowired
	CourtService courtService;
	
	@Autowired
	CenterService centerService;
	
	@GetMapping("/getCourt")
	public List<Court> getCourt(){
		return this.courtService.getCourt();
	}
	
	@PostMapping("/addCourt/{idCenter}")
	public String addCourt(@PathVariable Long idCenter){
		
		Optional<Center> center = this.centerService.findById(idCenter);
		if(center.isEmpty()) {
			return "Center with this id doesn't exist";
		}
		return this.courtService.addCourt(center.get());
	}
	
	@DeleteMapping("/deleteCourt/{id}")
	public String deleteCourt(@PathVariable Long id){
		return this.courtService.deleteCourt(id);
	}
}
