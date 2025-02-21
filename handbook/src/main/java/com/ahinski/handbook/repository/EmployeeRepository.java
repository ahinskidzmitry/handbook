package com.ahinski.handbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahinski.handbook.model.Employee;

/**
 * Employee Repository for managing employees
 * 
 * @author Dzmitry Ahinski
 * 
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
