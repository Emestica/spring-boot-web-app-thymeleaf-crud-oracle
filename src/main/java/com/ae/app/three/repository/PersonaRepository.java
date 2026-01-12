package com.ae.app.three.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae.app.three.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	List<Persona> findByIdPersona(Long idPersona);
}
