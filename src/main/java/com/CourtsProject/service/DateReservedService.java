package com.CourtsProject.service;

import java.util.List;
import java.util.Optional;

import com.CourtsProject.entity.Center;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourtsProject.dto.DateReservedDTO;
import com.CourtsProject.entity.Court;
import com.CourtsProject.entity.DateReserved;
import com.CourtsProject.repository.DateReservedRepository;

@Service
public class DateReservedService implements IDateReservedService{

	@Autowired
	DateReservedRepository dateReservedRepository;

	@Override
	public List<DateReserved> getDateReserved() {
		return this.dateReservedRepository.findAll();
	}

	@Override
	public String addDateReserved(DateReservedDTO dateReservedDTO, Court court) {
		DateReserved dateReserved = DateReserved.builder()
				.court(court)
				.startingTime(dateReservedDTO.getStartingTime())
				.endingTime(dateReservedDTO.getEndingTime())
				.build();
		this.dateReservedRepository.save(dateReserved);
		return "New reservation's id = " + dateReserved.getId();
	}

	@Override
	public String deleteDateReserved(Long id) {
		String startingTime = this.dateReservedRepository.findById(id).get().getStartingTime().toString();
		this.dateReservedRepository.deleteById(id);
		return "Reservation on " + startingTime + " has been deleted";
	}

	@Override
	public Optional<DateReserved> findById(Long id) {
		return this.dateReservedRepository.findById(id);
	}
}
