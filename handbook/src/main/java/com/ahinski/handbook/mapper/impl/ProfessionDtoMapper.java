package com.ahinski.handbook.mapper.impl;

import org.springframework.stereotype.Component;

import com.ahinski.handbook.dto.ProfessionDto;
import com.ahinski.handbook.mapper.DtoMapper;
import com.ahinski.handbook.model.Profession;

@Component
public class ProfessionDtoMapper implements DtoMapper<ProfessionDto, Profession> {

    @Override
    public ProfessionDto convertToDto(Profession model) {
        ProfessionDto professionDto = new ProfessionDto();

        professionDto.setId(model.getId());
        professionDto.setName(model.getName());
        professionDto.setNote(model.getNote());

        return professionDto;
    }

    @Override
    public Profession convertToModel(ProfessionDto dto) {
        Profession profession = new Profession();

        profession.setId(dto.getId());
        profession.setName(dto.getName());
        profession.setNote(dto.getNote());

        return profession;
    }
}
