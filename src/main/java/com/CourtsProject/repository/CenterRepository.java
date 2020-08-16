package com.CourtsProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CourtsProject.entity.Center;

@Repository
public interface CenterRepository extends JpaRepository <Center, Long>{

}
