package com.ae.app.three.service;

import java.util.List;

import com.ae.app.three.model.Estado;

public interface EstadoService {
	
	public List<Estado> obtenerTodosEstados();
	
	public Estado obtenerPorIdEstado(Character idEstado);
	
	public Estado guardarEstado(Estado estado);
	
	public boolean eliminarEstado(Character idEstado);
	

}
