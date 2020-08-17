package com.CourtsProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CourtsProject.dto.DateReservedDTO;
import com.CourtsProject.entity.Court;
import com.CourtsProject.entity.DateReserved;
import com.CourtsProject.service.CourtService;
import com.CourtsProject.service.DateReservedService;

@RestController
public class DateReservedController {

	@Autowired
	DateReservedService dateReservedService;
	
	@Autowired
	CourtService courtService;
	
	@GetMapping("/date-reserved")
	public List<DateReserved> getDateReserved(){
		return this.dateReservedService.getDateReserved();
	}
	
	@PostMapping("/date-reserved/{idCourt}")
	public String addDateReserved(@RequestBody DateReservedDTO dateReservedDTO, @PathVariable Long idCourt) {
		System.out.println("idcourt: "+ idCourt);
		Optional<Court> court = courtService.findById(idCourt);
		if(!court.isPresent()) {
			return "Court with that id doesn't exists";
		}
		return this.dateReservedService.addDateReserved(dateReservedDTO, court.get());
	}
	
	@DeleteMapping("/date-reserved/{id}")
	public String deleteDateReserved(@PathVariable Long id) {
		return this.courtService.deleteCourt(id);
	}
	
}
