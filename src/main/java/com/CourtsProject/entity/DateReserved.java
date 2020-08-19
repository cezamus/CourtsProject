package com.CourtsProject.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "date_reserved")
@Builder(toBuilder = true)
public class DateReserved {

	@Id
	@Column(name = "id")
	@GenericGenerator(name = "increment", strategy = "increment")
	@GeneratedValue(generator = "increment")
	private Long id;

	@Column(name = "starting_time")
	private LocalDateTime startingTime;

	@Column(name = "ending_time")
	private LocalDateTime endingTime;
	
	@ManyToOne
    @JoinColumn(name = "date_reserved_id")
    private Court court;


}
