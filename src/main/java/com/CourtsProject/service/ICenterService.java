package com.CourtsProject.service;
import java.util.List;
import java.util.Optional;

import com.CourtsProject.dto.CenterDTO;
import com.CourtsProject.entity.Center;

public interface ICenterService {

	List<Center> getCenter();
	
	public Optional<Center> findById(Long id);
	
	String addCenter(CenterDTO centerDTO);
	
	String deleteCenter(Long id);
}
