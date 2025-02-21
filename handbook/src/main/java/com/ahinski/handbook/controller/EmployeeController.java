package com.ahinski.handbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ahinski.handbook.dto.EmployeeDto;
import com.ahinski.handbook.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 
 * REST Controller for managing employees
 * 
 * @author Dzmitry Ahinski
 * 
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * 
     * Retrieves all employees
     * 
     * @return List of EmployeeDto with employees information
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> findAllEmployees() {
        return employeeService.findAll();
    }
    
    /**
     * Creates new employee
     * 
     * @param employeeDto to create
     * @return EmployeeDto with created employee information
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }
    
    /**
     * Updates employee
     * 
     * @param id of the employee to update
     * @param employeeDto with new information
     * @return EmployeeDto with updated employee information
     */
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.update(id, employeeDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
