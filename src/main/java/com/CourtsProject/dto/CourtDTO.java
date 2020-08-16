package com.CourtsProject.dto;

import java.util.HashSet;
import java.util.Set;

import com.CourtsProject.entity.Center;
import com.CourtsProject.entity.DateReserved;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourtDTO {

	private Long id;
    private Center center;
    private Set<DateReserved> dateReserved = new HashSet<>();
}
