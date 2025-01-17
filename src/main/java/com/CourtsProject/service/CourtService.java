package com.CourtsProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourtsProject.entity.Center;
import com.CourtsProject.entity.Court;
import com.CourtsProject.repository.CourtRepository;

@Service
public class CourtService implements ICourtService{

	@Autowired
	CourtRepository courtRepository;
	
	@Override
	public List<Court> getCourt() {
		return this.courtRepository.findAll();
	}

	@Override
	public String addCourt(Center center) {
		Court court = Court.builder()
				.center(center)
				.build();
		
		this.courtRepository.save(court);
		return "Court with id = " + court.getId().toString() + " has been added in " + center.getLocation() + ".";
	}

	@Override
	public Optional<Court> findById(Long id) {
		return this.courtRepository.findById(id);
	}

	@Override
	public String deleteCourt(Long id) {
		String centerLocation = this.courtRepository.findById(id).get().getCenter().getLocation();
		this.courtRepository.deleteById(id);
		return "Court in " + centerLocation + " has been deleted";
	}
}
