package com.CourtsProject.service;

import java.util.List;
import java.util.Optional;

import com.CourtsProject.entity.Center;
import com.CourtsProject.entity.Court;

public interface ICourtService {

	List<Court> getCourt();
	
	public Optional<Court> findById(Long id);
	
	public String addCourt(Center center);
	
	String deleteCourt(Long id);
}
