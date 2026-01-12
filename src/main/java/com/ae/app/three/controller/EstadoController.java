package com.ae.app.three.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ae.app.three.model.Estado;
import com.ae.app.three.service.EstadoService;

@Controller
@RequestMapping("/estados")
public class EstadoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EstadoController.class);
	
	private final EstadoService service;
	
	public EstadoController(EstadoService service) {
		this.service = service;
	}
	
	@GetMapping("/mostrar")
	public String obtenerEstados(Model model) {
		LOGGER.info("obtenerEstados() => Iniciando");
		try {
			List<Estado> lista = this.service.obtenerTodosEstados();
			model.addAttribute("objEstados", lista);
			LOGGER.info("obtenerEstados() => Size: \"{}\"", lista.size());
		} catch (Exception e) {
			LOGGER.error("obtenerEstados() => Exception");
		} finally {
			LOGGER.info("obtenerEstados() => Completado");
		}
		return "/pages/states/list";
	}
	
	@GetMapping("/crear")
	public String irFormularioGuardarEstado(Model model) {
		LOGGER.info("irFormularioGuardarEstado() => Iniciando");
		try {
			
			model.addAttribute("objEstado", new Estado());
			
		} catch (Exception e) {
			LOGGER.error("irFormularioGuardarEstado() => Exception");
		} finally {
			LOGGER.info("irFormularioGuardarEstado() => Completado");
		}
		return "/pages/states/create";
	}
	
	@PostMapping("/guardar")
	public String guardarEstado(@ModelAttribute Estado estado) {
		LOGGER.info("guardarEstado() => Iniciando");
		try {
			
			Estado estadoResult = this.service.guardarEstado(estado);
			LOGGER.info("guardarEstado() => Result: [{}]", estadoResult);
			
		} catch (Exception e) {
			LOGGER.error("guardarEstado() => Exception\n", e);
		} finally {
			LOGGER.info("guardarEstado() => Completado");
		}
		return "redirect:/estados/mostrar";
	}
	
	@GetMapping("/ir-formulario-editar/{id}")
	public String irFormularioEditarEstado(@PathVariable("id") Character id, Model model) {
		LOGGER.info("irFormularioEditarEstado() => Iniciando");
		try {
			
			LOGGER.info("irFormularioEditarEstado() => ID: \"{}\"", id);
			Estado estadoResult = this.service.obtenerPorIdEstado(id);
			LOGGER.info("irFormularioEditarEstado() => Result: [{}]", estadoResult);
			model.addAttribute("objEstado", estadoResult);
			
		} catch (Exception e) {
			LOGGER.error("irFormularioEditarEstado() => Exception\n", e);
		} finally {
			LOGGER.info("irFormularioEditarEstado() => Completado");
		}
		return "/pages/states/create";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Character id, Model model) {
		LOGGER.info("eliminar() => Iniciando");
		try {
			
			LOGGER.info("eliminar() => ID: \"{}\"", id);
			boolean estadoResult = this.service.eliminarEstado(id);
			LOGGER.info("eliminar() => Result: [{}]", estadoResult);
			
		} catch (Exception e) {
			LOGGER.error("eliminar() => Exception\n", e);
		} finally {
			LOGGER.info("eliminar() => Completado");
		}
		return "redirect:/estados/mostrar";
	}

}
