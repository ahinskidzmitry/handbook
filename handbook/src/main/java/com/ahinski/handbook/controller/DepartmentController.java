package com.ahinski.handbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ahinski.handbook.dto.DepartmentDto;
import com.ahinski.handbook.service.DepartmentService;

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
 * REST Controller for managing departments
 * 
 * @author Dzmitry Ahinski
 * 
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 
     * Retrieves all departments
     * 
     * @return List of DepartmentDto with departemnts information
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DepartmentDto> findAllDepartments() {
        return departmentService.findAll();
    }
    
    /**
     * Creates new department
     * 
     * @param departmentDto to create
     * @return DepartmentDto with created department information
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDto createDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.save(departmentDto);
    }
    
    /**
     * Updates department
     * 
     * @param id of the department to update
     * @param departmentDto with new information
     * @return DepartmentDto with updated department information
     */
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDto updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto departmentDto) {
        return departmentService.update(id, departmentDto);
    }

    /**
     * Deletes department
     * 
     * @param id of the department to delete
     * 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
    }
}
