package com.ahinski.handbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahinski.handbook.model.Profession;

/**
 * Professions Repository for managing professions
 * 
 * @author Dzmitry Ahinski
 * 
 */
@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Long> {}
