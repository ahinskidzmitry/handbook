package com.ahinski.handbook.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ahinski.handbook.dto.ProfessionDto;
import com.ahinski.handbook.exception.EntityDoesNotExistException;
import com.ahinski.handbook.mapper.DtoMapper;
import com.ahinski.handbook.model.Profession;
import com.ahinski.handbook.repository.ProfessionRepository;
import com.ahinski.handbook.service.ProfessionService;

import jakarta.transaction.Transactional;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    private final ProfessionRepository professionRepository;
    private final DtoMapper<ProfessionDto, Profession> professionDtoMapper;

    public ProfessionServiceImpl(ProfessionRepository professionRepository, DtoMapper<ProfessionDto, Profession> professionDtoMapper) {
        this.professionRepository = professionRepository;
        this.professionDtoMapper = professionDtoMapper;
    }

    @Override
    public List<ProfessionDto> findAll() {
        return professionRepository.findAll()
                                    .stream()
                                    .map(professionDtoMapper::convertToDto)
                                    .toList();
    }

    @Override
    public ProfessionDto save(ProfessionDto professionDto) {
        if (!StringUtils.hasText(professionDto.getName())) {
            throw new IllegalArgumentException("Name field is mandatory");
        }

        Profession professionToSave = professionDtoMapper.convertToModel(professionDto);
        return professionDtoMapper.convertToDto(professionRepository.save(professionToSave));
    }

    @Transactional
    @Override
    public ProfessionDto update(Long id, ProfessionDto professionDto) {
        
        Profession professionToChange = professionRepository.findById(id).orElseThrow(
            () -> new EntityDoesNotExistException(String.format("Profession with ID %d does not exist", id))
        );

        if (StringUtils.hasText(professionDto.getName())) {
            professionToChange.setName(professionDto.getName());
        }
        
        if (professionDto.getNote() != null) {
            professionToChange.setNote(professionDto.getNote());
        }
        
        return professionDtoMapper.convertToDto(professionRepository.save(professionToChange));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        professionRepository.findById(id).orElseThrow(
            () -> new EntityDoesNotExistException(String.format("Entity with ID %d does not exist", id))
        );
        
        professionRepository.deleteById(id);
    }
}
