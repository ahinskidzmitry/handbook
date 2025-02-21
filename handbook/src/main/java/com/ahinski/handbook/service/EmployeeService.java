package com.ahinski.handbook.service;

import java.util.List;

import com.ahinski.handbook.dto.EmployeeDto;

/**
 * Employees Service for managing employees
 * 
 * @author Dzmitry Ahinski
 * 
 */
public interface EmployeeService {
    
    /**
     * Retrieves all employees
     * 
     * @return List of EmployeeDtos with employees information
     */
    List<EmployeeDto> findAll();

    /**
     * Creates new employee
     * 
     * @param employeeDto to create
     * @return EmployeeDto with created employee information
     */
    EmployeeDto save(EmployeeDto employeeDto);

    /**
     * Updates employee
     * 
     * @param id of the employee to update
     * @param employeeDto with new information
     * @return EmployeeDto with updated employee information
     */
    EmployeeDto update(Long id, EmployeeDto employeeDto);

    /**
     * Deletes employee
     * 
     * @param id of the employee to delete
     * 
     */
    void delete(Long id);
}
