package com.CourtsProject.service;

import java.util.List;

import com.CourtsProject.dto.DateReservedDTO;
import com.CourtsProject.entity.Court;
import com.CourtsProject.entity.DateReserved;

public interface IDateReservedService {

	List<DateReserved> getDateReserved();
	
	public String addDateReserved(DateReservedDTO dateReservedDTO, Court court);
	
	String deleteDateReserved(Long id);
}
