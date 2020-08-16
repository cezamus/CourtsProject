package com.CourtsProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourtsProject.dto.CenterDTO;
import com.CourtsProject.entity.Center;
import com.CourtsProject.repository.CenterRepository;

@Service
public class CenterService implements ICenterService{

	@Autowired
	private CenterRepository centerRepository;

	@Override
	public List<Center> getCenter() {
		return this.centerRepository.findAll();
	}

	@Override
	public String addCenter(CenterDTO centerDTO) {
		Center center = Center.builder()
				.location(centerDTO.getLocation())
				.build();
		this.centerRepository.save(center);
		return "Added";
	}

	@Override
	public Optional<Center> findById(Long id) {
		return this.centerRepository.findById(id);
	}

	@Override
	public String deleteCenter(Long id) {
		this.centerRepository.deleteById(id);
		return "Deleted";
	}

}

