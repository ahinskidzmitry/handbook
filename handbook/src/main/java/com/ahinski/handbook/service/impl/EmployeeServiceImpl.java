package com.ahinski.handbook.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ahinski.handbook.dto.DepartmentDto;
import com.ahinski.handbook.dto.EmployeeDto;
import com.ahinski.handbook.dto.ProfessionDto;
import com.ahinski.handbook.exception.EntityDoesNotExistException;
import com.ahinski.handbook.mapper.DtoMapper;
import com.ahinski.handbook.model.Department;
import com.ahinski.handbook.model.Employee;
import com.ahinski.handbook.model.Profession;
import com.ahinski.handbook.repository.EmployeeRepository;
import com.ahinski.handbook.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DtoMapper<EmployeeDto, Employee> employeeDtoMapper;
    private final DtoMapper<ProfessionDto, Profession> professionDtoMapper;
    private final DtoMapper<DepartmentDto, Department> departmentDtoMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DtoMapper<EmployeeDto, Employee> employeeDtoMapper,
                                DtoMapper<ProfessionDto, Profession> professionDtoMapper, DtoMapper<DepartmentDto, Department> departmentDtoMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeDtoMapper = employeeDtoMapper;
        this.professionDtoMapper = professionDtoMapper;
        this.departmentDtoMapper = departmentDtoMapper;
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll()
                                  .stream()
                                  .map(employeeDtoMapper::convertToDto)
                                  .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        if (!StringUtils.hasText(employeeDto.getName())) {
            throw new IllegalArgumentException("Name field is mandatory");
        }

        Employee employeeToSave = employeeDtoMapper.convertToModel(employeeDto);
        return employeeDtoMapper.convertToDto(employeeRepository.save(employeeToSave));
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employeeDto) {
        Employee employeeToChange = employeeRepository.findById(id).orElseThrow(
            () -> new EntityDoesNotExistException(String.format("Employee with ID %d does not exist", id))
        );

        if (employeeDto.getName() != null) {
            employeeToChange.setName(employeeDto.getName());
        }

        if (employeeDto.getNote() != null) {
            employeeToChange.setNote(employeeDto.getNote());
        }

        if (employeeDto.getProfession() != null) {
            employeeToChange.setProfession(professionDtoMapper.convertToModel(employeeDto.getProfession()));
        }

        if (employeeDto.getDepartment() != null) {
            employeeToChange.setDepartment(departmentDtoMapper.convertToModel(employeeDto.getDepartment()));
        }

        return employeeDtoMapper.convertToDto(employeeRepository.save(employeeToChange));
    }

    @Override
    public void delete(Long id) {
        employeeRepository.findById(id).orElseThrow(
            () -> new EntityDoesNotExistException(String.format("Employee with ID %d does not exist", id))
        );
        employeeRepository.deleteById(id);
    } 
}
