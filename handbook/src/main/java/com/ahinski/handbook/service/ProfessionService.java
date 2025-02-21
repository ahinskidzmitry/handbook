package com.ahinski.handbook.service;

import java.util.List;

import com.ahinski.handbook.dto.ProfessionDto;

/**
 * Professions Service for managing professions
 * 
 * @author Dzmitry Ahinski
 * 
 */
public interface ProfessionService {

    /**
     * Retrieves all professions
     * 
     * @return List of ProfessionDtos with professions information
     */
    List<ProfessionDto> findAll();
    
    /**
     * Creates new profession
     * 
     * @param professionDto to create
     * @return ProfessionDto with created profession information
     */
    ProfessionDto save(ProfessionDto professionDto);

    /**
     * Updates profession
     * 
     * @param id of the profession to update
     * @param professionDto with new information
     * @return ProfessionDto with updated profession information
     */
    ProfessionDto update(Long id, ProfessionDto professionDto);

    /**
     * Deletes profession
     * 
     * @param id of the profession to delete
     * 
     */
    void delete(Long id);
}
