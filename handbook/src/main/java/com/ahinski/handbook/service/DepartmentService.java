package com.ahinski.handbook.service;

import java.util.List;

import com.ahinski.handbook.dto.DepartmentDto;

/**
 * Departments Service for managing departments
 * 
 * @author Dzmitry Ahinski
 * 
 */
public interface DepartmentService {

    /**
     * Retrieves all departments
     * 
     * @return List of DepartmentDtos with departments information
     */
    List<DepartmentDto> findAll();
    
    /**
     * Creates new department
     * 
     * @param departmentDto to create
     * @return DepartmentDto with created department information
     */
    DepartmentDto save(DepartmentDto departmentDto);

    /**
     * Updates department
     * 
     * @param id of the department to update
     * @param departmentDto with new information
     * @return DepartmentDto with updated department information
     */
    DepartmentDto update(Long id, DepartmentDto departmentDto);

    /**
     * Deletes department
     * 
     * @param id of the department to delete
     * 
     */
    void delete(Long id);
}
