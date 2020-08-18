package com.CourtsProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/courts")
	public List<Court> getCourt(){
		return this.courtService.getCourt();
	}
	
	@PostMapping("/courts/{idCenter}")
	public ResponseEntity<String> addCourt(@PathVariable Long idCenter){
		Optional<Center> center = this.centerService.findById(idCenter);
		if(center.isEmpty()) {
			return new ResponseEntity<String>("Center with id = " + idCenter.toString() + " has not been found.",
					HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(courtService.addCourt(center.get()));
	}
	
	@DeleteMapping("/courts/{id}")
	public ResponseEntity<String> deleteCourt(@PathVariable Long id){
		Optional<Court> court = this.courtService.findById(id);
		if(court.isEmpty()) {
			return new ResponseEntity<String>("Court with id = " + id.toString() + " has not been found.",
					HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(courtService.deleteCourt(id));
	}
}
