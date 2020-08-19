package com.CourtsProject.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.CourtsProject.entity.Court;

import com.CourtsProject.entity.DateReserved;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateReservedDTO {

	private Long id;
	private LocalDateTime startingTime;
	private LocalDateTime endingTime;
	private Court court;

	public boolean checkIncorrectDuration() {
		boolean incorrectDuration = false;

		if(this.startingTime.isAfter(this.endingTime)) {
			incorrectDuration = true;
		}
		return incorrectDuration;
	}

	public boolean checkOverlap(Court currentCourt) {
		boolean overlap = false;

		Set<DateReserved> currentCourtReservations = currentCourt.getDatesReserved();
		for(DateReserved dateReserved: currentCourtReservations) {
			if(this.endingTime.isAfter(dateReserved.getStartingTime())) {
				if(this.startingTime.isBefore(dateReserved.getEndingTime())) {
					overlap = true;
				}
			}
		}
		return overlap;
	}
}
