package com.ae.app.three.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ae.app.three.model.Persona;
import com.ae.app.three.repository.PersonaRepository;
import com.ae.app.three.service.PersonaService;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonaServiceImpl.class);
	
	private PersonaRepository repository;
	
	public PersonaServiceImpl(PersonaRepository personaRepository) {
		this.repository = personaRepository;
	}

	@Override
	public List<Persona> obtenerTodosPersonas() {
		return this.repository.findAll();
	}

	@Override
	public Persona obtenerPorIdPersona(Long idPersona) {
		
		return this.repository.findById(idPersona).orElse(null);
	}

	@Override
	public Persona guardarPersona(Persona persona) {
		return this.repository.save(persona);
	}

	@Override
	public boolean eliminarPersona(Long idPersona) {
		LOGGER.info("eliminarPersona() => Iniciando");
		try {
			this.repository.deleteById(idPersona);
			return true;
		} catch (Exception e) {
			LOGGER.error("eliminarPersona() => Exception\n", e);
			return false;
		} finally {
			LOGGER.info("eliminarPersona() => Completado");
		}
	}

}
