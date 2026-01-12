package com.ae.app.three.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ae.app.three.model.Estado;
import com.ae.app.three.repository.EstadoRepository;
import com.ae.app.three.service.EstadoService;

@Service
@Transactional
public class EstadoServiceImpl implements EstadoService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EstadoServiceImpl.class);

	private EstadoRepository repository;
	
	public EstadoServiceImpl(EstadoRepository repository) {
		this.repository = repository;
	}	
	
	@Override
	public List<Estado> obtenerTodosEstados() {
		LOGGER.info("obtenerTodosEstados() => Iniciando");
		List<Estado> listaEstados = this.repository.findAll();
		LOGGER.info("obtenerTodosEstados() => Completado");
		return listaEstados;
	}

	@Override
	public Estado obtenerPorIdEstado(Character idEstado) {
		LOGGER.info("obtenerPorIdEstado() => Iniciando");
		
		Estado estadoOpt = this.repository.findById(idEstado).orElse(null);
		
		LOGGER.info("obtenerPorIdEstado() => Completado");
		return estadoOpt;
	}

	@Override
	public Estado guardarEstado(Estado estado) {
		LOGGER.info("guardarEstado() => Iniciando");
		
		Estado estadoRtr = this.repository.save(estado);
		
		LOGGER.info("guardarEstado() => Completado");
		return estadoRtr;
	}

	@Override
	public boolean eliminarEstado(Character idEstado) {
		LOGGER.info("eliminarEstado() => Iniciando");
		try {
			this.repository.deleteById(idEstado);
			return true;
		} catch (Exception e) {
			LOGGER.error("eliminarEstado() => Exception\n", e);
			return false;
		} finally {
			LOGGER.info("eliminarEstado() => Completado");
		}
	}

}
