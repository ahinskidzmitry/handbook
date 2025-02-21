package com.ahinski.handbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahinski.handbook.model.Department;

/**
 * Departments Repository for managing departments
 * 
 * @author Dzmitry Ahinski
 * 
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByParentIsNull();
}
