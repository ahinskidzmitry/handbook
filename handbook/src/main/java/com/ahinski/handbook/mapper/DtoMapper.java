package com.ahinski.handbook.mapper;

/**
 * DTO to entity and back mapper interface
 * 
 * @author Dzmitry Ahinski
 * 
 */
public interface DtoMapper<D, M> {
    
    D convertToDto(M model);

    M convertToModel(D dto);
}
