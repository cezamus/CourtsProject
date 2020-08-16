package com.CourtsProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CourtsProject.entity.Court;

@Repository
public interface CourtRepository extends JpaRepository<Court,Long>{

}
