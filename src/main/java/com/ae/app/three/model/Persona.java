package com.ae.app.three.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona", length = 1)
	private Long idPersona;
	
	@Column(name = "nombres", length = 250, nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", length = 250, nullable = false)
	private String apellidos;
	
	@Column(name = "correo_electronico", length = 250, nullable = true)
	private String correoElectronico;
	
	@Column(name = "telefono", length = 15, nullable = true)
	private String telefono;
	
	@Column(name = "celular", length = 15, nullable = true)
	private String celular;
	
	@Column(name = "estado", length = 1, nullable = false)
	private Character estado;
	
	@Column(name = "fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime fechaCreacion;
	
	public Persona() {
		/** Empty Constructor */
	}
	
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Character getEstado() {
		return estado;
	}
	public void setEstado(Character estado) {
		this.estado = estado;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}
