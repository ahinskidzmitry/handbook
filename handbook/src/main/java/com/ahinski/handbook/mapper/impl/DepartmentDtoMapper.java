package com.ahinski.handbook.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.ahinski.handbook.dto.DepartmentDto;
import com.ahinski.handbook.mapper.DtoMapper;
import com.ahinski.handbook.model.Department;

@Component
public class DepartmentDtoMapper implements DtoMapper<DepartmentDto, Department> {

    @Override
    public DepartmentDto convertToDto(Department model) {
        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId(model.getId());
        departmentDto.setName(model.getName());
        departmentDto.setNote(model.getNote());

        if (model.getParent() != null) {
            departmentDto.setParentId(model.getParent().getId());
        }

        if (!CollectionUtils.isEmpty(model.getChildren())) {
            List<DepartmentDto> departmentDtos = model.getChildren()
                                                    .stream()
                                                    .map(this::convertToDto)
                                                    .collect(Collectors.toList());
            departmentDto.setChildren(departmentDtos);
        }

        return departmentDto;
    }

    @Override
    public Department convertToModel(DepartmentDto dto) {
        Department department = new Department();

        department.setId(dto.getId());
        department.setName(dto.getName());
        department.setNote(dto.getNote());

        if (!CollectionUtils.isEmpty(dto.getChildren())) {
            List<Department> departments = dto.getChildren()
                                            .stream()
                                            .map(this::convertToModel)
                                            .collect(Collectors.toList());
            department.setChildren(departments);
        }

        return department;
    }
}
