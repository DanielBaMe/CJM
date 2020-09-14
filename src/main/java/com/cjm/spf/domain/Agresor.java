package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "datos_agresor")
public class Agresor implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String apllido_paterno;
    
    private String apellido_materno;
    
    private String nombres;
    
    private String edad;
    
    private String fecha_nacimiento;
    
    private String estado_civil;
    
    private String nacionalidad;
    
    private String seudonimo;
    
    private String grupo_etnico;
    
    private String id_domicilio;
    
    private String id_perfil_agresor;
    
    private String id_fijacion;
    
    private String id_factor;
    
    private String id_expediente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApllido_paterno() {
		return apllido_paterno;
	}

	public void setApllido_paterno(String apllido_paterno) {
		this.apllido_paterno = apllido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getSeudonimo() {
		return seudonimo;
	}

	public void setSeudonimo(String seudonimo) {
		this.seudonimo = seudonimo;
	}

	public String getGrupo_etnico() {
		return grupo_etnico;
	}

	public void setGrupo_etnico(String grupo_etnico) {
		this.grupo_etnico = grupo_etnico;
	}

	public String getId_domicilio() {
		return id_domicilio;
	}

	public void setId_domicilio(String id_domicilio) {
		this.id_domicilio = id_domicilio;
	}

	public String getId_perfil_agresor() {
		return id_perfil_agresor;
	}

	public void setId_perfil_agresor(String id_perfil_agresor) {
		this.id_perfil_agresor = id_perfil_agresor;
	}

	public String getId_fijacion() {
		return id_fijacion;
	}

	public void setId_fijacion(String id_fijacion) {
		this.id_fijacion = id_fijacion;
	}

	public String getId_factor() {
		return id_factor;
	}

	public void setId_factor(String id_factor) {
		this.id_factor = id_factor;
	}

	public String getId_expediente() {
		return id_expediente;
	}

	public void setId_expediente(String id_expediente) {
		this.id_expediente = id_expediente;
	}
    
    
}
