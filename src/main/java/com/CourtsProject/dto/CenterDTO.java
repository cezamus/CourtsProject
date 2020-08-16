package com.CourtsProject.dto;

import java.util.HashSet;
import java.util.Set;

import com.CourtsProject.entity.Court;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CenterDTO {

	private Long id;
	private String location;
    private Set<Court> courts = new HashSet<>();
}
