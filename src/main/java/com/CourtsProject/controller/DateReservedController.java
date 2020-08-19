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
	public ResponseEntity<String> addDateReserved(@RequestBody DateReservedDTO dateReservedDTO, @PathVariable Long idCourt) {
		Optional<Court> court = courtService.findById(idCourt);
		if(court.isEmpty()) {
			return new ResponseEntity<String>("Court with id = " + idCourt.toString() + " has not been found.",
					HttpStatus.NOT_FOUND);
		}
		if(dateReservedDTO.checkIncorrectDuration()) {
			return new ResponseEntity<String>("Starting time must be sooner than ending time.",
					HttpStatus.BAD_REQUEST);
		}
		if(dateReservedDTO.checkOverlap(court.get())) {
			return new ResponseEntity<String>("Chosen time is already reserved.",
					HttpStatus.FORBIDDEN);
		}
		return ResponseEntity.ok(dateReservedService.addDateReserved(dateReservedDTO, court.get()));
	}
	
	@DeleteMapping("/date-reserved/{id}")
	public ResponseEntity<String> deleteDateReserved(@PathVariable Long id) {
		Optional<DateReserved> dateReserved = dateReservedService.findById(id);
		if(dateReserved.isEmpty()) {
			return new ResponseEntity<String>("Reservation with id = " + id.toString() + " has not been found",
					HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(dateReservedService.deleteDateReserved(id));
	}
	
}
