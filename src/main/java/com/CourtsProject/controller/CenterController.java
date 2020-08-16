package com.CourtsProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CourtsProject.dto.CenterDTO;
import com.CourtsProject.entity.Center;
import com.CourtsProject.service.CenterService;

@RestController
public class CenterController {

	@Autowired
	CenterService centerService;
	
	@GetMapping("/getCenter")
	public List<Center> getCenter(){
		return centerService.getCenter();
	}
	
	@PostMapping("/addCenter")
	public String addCenter(@RequestBody CenterDTO centerDTO){
		return centerService.addCenter(centerDTO);
	}
	
	@DeleteMapping("/deleteCenter/{id}")
	public ResponseEntity<String> deleteCenter(@PathVariable Long id) {
		return ResponseEntity.ok(centerService.deleteCenter(id));
	}
}
