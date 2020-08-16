package com.CourtsProject.dto;

import java.sql.Date;

import com.CourtsProject.entity.Court;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateReservedDTO {

	private Long id;
	private Date date;
    private Court court;
}
