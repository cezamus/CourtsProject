package com.CourtsProject.service;

import java.util.List;

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
				.date(dateReservedDTO.getDate())
				.build();
		this.dateReservedRepository.save(dateReserved);
		return "Added";
	}

	@Override
	public String deleteDateReserved(Long id) {
		this.dateReservedRepository.deleteById(id);
		return "Delete";
	}
	
	
}
