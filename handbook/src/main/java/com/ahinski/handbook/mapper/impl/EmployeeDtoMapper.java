package com.ahinski.handbook.mapper.impl;

import org.springframework.stereotype.Component;

import com.ahinski.handbook.dto.DepartmentDto;
import com.ahinski.handbook.dto.EmployeeDto;
import com.ahinski.handbook.dto.ProfessionDto;
import com.ahinski.handbook.mapper.DtoMapper;
import com.ahinski.handbook.model.Department;
import com.ahinski.handbook.model.Employee;
import com.ahinski.handbook.model.Profession;

@Component
public class EmployeeDtoMapper implements DtoMapper<EmployeeDto, Employee> {

    private final DtoMapper<DepartmentDto, Department> departmentDtoMapper;
    private final DtoMapper<ProfessionDto, Profession> professionDtoMapper;

    public EmployeeDtoMapper(DtoMapper<DepartmentDto, Department> departmentDtoMapper, DtoMapper<ProfessionDto, Profession> professionDtoMapper) {
        this.departmentDtoMapper = departmentDtoMapper;
        this.professionDtoMapper = professionDtoMapper;
    }

    @Override
    public EmployeeDto convertToDto(Employee model) {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId(model.getId());
        employeeDto.setName(model.getName());
        employeeDto.setNote(model.getNote());
        employeeDto.setProfession(professionDtoMapper.convertToDto(model.getProfession()));
        employeeDto.setDepartment(departmentDtoMapper.convertToDto(model.getDepartment()));

        return employeeDto;
    }

    @Override
    public Employee convertToModel(EmployeeDto dto) {
        Employee employee = new Employee();

        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setNote(dto.getNote());
        employee.setProfession(professionDtoMapper.convertToModel(dto.getProfession()));
        employee.setDepartment(departmentDtoMapper.convertToModel(dto.getDepartment()));

        return employee;
    }
}
