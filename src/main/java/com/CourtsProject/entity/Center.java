package com.CourtsProject.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "center")
@Builder(toBuilder = true)
public class Center {

	@Id
	@Column(name = "id")
	@GenericGenerator(name = "increment", strategy = "increment")
	@GeneratedValue(generator = "increment")
	private Long id;
	
	@Column(name = "location")
	private String location;
	
	@JsonIgnore
	@Transient 
	@OneToMany(mappedBy = "center")
    private Set<Court> courts = new HashSet<>();
}
