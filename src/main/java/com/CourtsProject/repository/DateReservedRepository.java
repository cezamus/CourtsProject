package com.CourtsProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CourtsProject.entity.DateReserved;

@Repository
public interface DateReservedRepository extends JpaRepository<DateReserved, Long>{

}
