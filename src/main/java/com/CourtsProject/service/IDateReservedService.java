package com.CourtsProject.service;

import java.util.List;
import java.util.Optional;

import com.CourtsProject.dto.DateReservedDTO;
import com.CourtsProject.entity.Center;
import com.CourtsProject.entity.Court;
import com.CourtsProject.entity.DateReserved;

public interface IDateReservedService {

	List<DateReserved> getDateReserved();

	public Optional<DateReserved> findById(Long id);

	public String addDateReserved(DateReservedDTO dateReservedDTO, Court court);
	
	String deleteDateReserved(Long id);
}
