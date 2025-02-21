package com.ahinski.handbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahinski.handbook.dto.ProfessionDto;
import com.ahinski.handbook.service.ProfessionService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 
 * REST Controller for managing professions
 * 
 * @author Dzmitry Ahinski
 * 
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/professions")
public class ProfessionController {
    
    private final ProfessionService professionService;

    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    /**
     * 
     * Retrieves all professions
     * 
     * @return List of ProfessionDto with professions information
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessionDto> findAllProfessions() {
        return professionService.findAll();
    }
    
    /**
     * Creates new profession
     * 
     * @param professionDto to create
     * @return ProfessionDto with created profession information
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessionDto createProfession(@RequestBody ProfessionDto professionDto) {
        return professionService.save(professionDto);
    }
    
    /**
     * Updates profession
     * 
     * @param id of the profession to update
     * @param professionDto to create
     * @return ProfessionDto with updated profession information
     */
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProfessionDto updateProfession(@PathVariable Long id, @RequestBody ProfessionDto professionDto) {
        return professionService.update(id, professionDto);
    }

    /**
     * Deletes profession
     * 
     * @param id of the profession to delete
     * 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfession(@PathVariable Long id) {
        professionService.delete(id);
    }
}
