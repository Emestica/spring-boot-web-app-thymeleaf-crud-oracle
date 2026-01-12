package com.ae.app.three.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ae.app.three.model.Persona;
import com.ae.app.three.service.EstadoService;
import com.ae.app.three.service.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonaController.class);
	
	private PersonaService servicePersona;
	private EstadoService serviceEstado;
	
	public PersonaController(PersonaService personaServicio, EstadoService estadoServicio) {
		this.servicePersona = personaServicio;
		this.serviceEstado = estadoServicio;
	}
	
	@GetMapping("/crear")
	public String irFormularioGuardarPersona(Model model) {
		LOGGER.info("irFormularioGuardarPersona() => Iniciando");
		try {
			
			model.addAttribute("objPersona", new Persona());
			model.addAttribute("objListEstados", this.serviceEstado.obtenerTodosEstados());
			
		} catch (Exception e) {
			LOGGER.error("irFormularioGuardarPersona() => Exception");
		} finally {
			LOGGER.info("irFormularioGuardarPersona() => Completado");
		}
		return "/pages/persons/create";
	}
	
	@GetMapping("/mostrar")
	public String obtenerPersonas(Model model) {
		LOGGER.info("obtenerPersonas() => Iniciando");
		try {
			List<Persona> lista = this.servicePersona.obtenerTodosPersonas();
			model.addAttribute("objListPersonas", lista);
		} catch (Exception e) {
			LOGGER.error("obtenerPersonas() => Exception");
		} finally {
			LOGGER.info("obtenerPersonas() => Completado");
		}
		return "/pages/persons/list";
	}

}
