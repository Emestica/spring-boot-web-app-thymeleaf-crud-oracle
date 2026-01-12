package com.ae.app.three.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estados")
public class Estado {
	
	@Id
	@Column(name = "id_estado", length = 1)
	private Character idEstado;
	
	@Column(name = "nombre_estado", nullable = false, length = 50)
	private String nombreEstado;
	
	@Column(name = "descripcion_estado", nullable = true, length = 100)
	private String descripcionEstado;
	
	@Column(name = "fecha_creacion", insertable = false, updatable = false)
	private LocalDateTime fechaCreacion;
	
	public Estado() {
		/** Empty Constructor */
	}
	
	public Character getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Character idEstado) {
		this.idEstado = idEstado;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}
