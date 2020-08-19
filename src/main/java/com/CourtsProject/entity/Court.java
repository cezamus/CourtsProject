package com.CourtsProject.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "court")
@Builder(toBuilder = true)
public class Court {

	@Id
	@Column(name = "id")
	@GenericGenerator(name = "increment", strategy = "increment")
	@GeneratedValue(generator = "increment")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;
	
	@JsonIgnore
	@Transient 
	@OneToMany(mappedBy = "court")
    private Set<DateReserved> datesReserved = new HashSet<>();
}
