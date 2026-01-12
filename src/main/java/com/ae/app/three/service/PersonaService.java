package com.ae.app.three.service;

import java.util.List;

import com.ae.app.three.model.Persona;

public interface PersonaService {

	public List<Persona> obtenerTodosPersonas();

	public Persona obtenerPorIdPersona(Long idPersona);

	public Persona guardarPersona(Persona persona);

	public boolean eliminarPersona(Long idPersona);

}
