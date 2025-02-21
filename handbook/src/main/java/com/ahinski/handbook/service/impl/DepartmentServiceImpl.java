package com.ahinski.handbook.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ahinski.handbook.dto.DepartmentDto;
import com.ahinski.handbook.exception.EntityDoesNotExistException;
import com.ahinski.handbook.mapper.DtoMapper;
import com.ahinski.handbook.model.Department;
import com.ahinski.handbook.repository.DepartmentRepository;
import com.ahinski.handbook.service.DepartmentService;

import jakarta.transaction.Transactional;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DtoMapper<DepartmentDto, Department> departmentDtoMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DtoMapper<DepartmentDto, Department> departmentDtoMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentDtoMapper = departmentDtoMapper;
    }

    @Override
    public List<DepartmentDto> findAll() {
        return departmentRepository.findByParentIsNull()
                                    .stream()
                                    .map(departmentDtoMapper::convertToDto)
                                    .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        if (!StringUtils.hasText(departmentDto.getName())) {
            throw new IllegalArgumentException("Name field is mandatory");
        }

        Department departmentToSave = departmentDtoMapper.convertToModel(departmentDto);
        updateParent(departmentToSave, departmentDto);

        return departmentDtoMapper.convertToDto(departmentRepository.save(departmentToSave));
    }

    @Transactional
    @Override
    public DepartmentDto update(Long id, DepartmentDto departmentDto) {
        Department departmentToChange = departmentRepository.findById(id).orElseThrow(
            () -> new EntityDoesNotExistException(String.format("Department with ID %d does not exist", id))
        );

        if (departmentToChange.getId().equals(departmentDto.getParentId())) {
            throw new IllegalArgumentException("Department cannot be the parent of itself");
        }

        updateParent(departmentToChange, departmentDto);

        if (departmentDto.getName() != null) {
            departmentToChange.setName(departmentDto.getName());
        }

        if (departmentDto.getNote() != null) {
            departmentToChange.setNote(departmentDto.getNote());
        }

        return departmentDtoMapper.convertToDto(departmentRepository.save(departmentToChange));
    }

    protected void updateParent(Department departmentToChange, DepartmentDto departmentDto) {
        Department parent = null;
        if (departmentDto.getParentId() != null) {
            parent = departmentRepository.findById(departmentDto.getParentId()).orElseThrow(
                () -> new IllegalArgumentException(String.format("Parent ID %d is invalid", departmentDto.getParentId()))
            );
        }
        departmentToChange.setParent(parent);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Department departmentToDelete = departmentRepository.findById(id).orElseThrow(
            () -> new EntityDoesNotExistException(String.format("Department with ID %d does not exist", id))
        );

        
        departmentRepository.delete(departmentToDelete);
    }
}
