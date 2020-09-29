package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

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
    
    private String apellido_paterno;
    
    private String apellido_materno;
    
    private String nombres;
    
    private Integer edad;
    
    private String fecha_nacimiento;
    
    private String estado_civil;
    
    private String nacionalidad;
    
    private String seudonimo;
    
    private String grupo_etnico;
    
    private Long id_expediente;
    
    private String conoce_agresor;
    
    private String info_adicional;
    
    private String relacion_victima;
    
    private String sexo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apllido_paterno) {
		this.apellido_paterno = apllido_paterno;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
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

	public Long getId_expediente() {
		return id_expediente;
	}

	public void setId_expediente(Long id_expediente) {
		this.id_expediente = id_expediente;
	}

	public String getConoce_agresor() {
		return conoce_agresor;
	}

	public void setConoce_agresor(String conoce_agresor) {
		this.conoce_agresor = conoce_agresor;
	}

	public String getInfo_adicional() {
		return info_adicional;
	}

	public void setInfo_adicional(String info_adicional) {
		this.info_adicional = info_adicional;
	}

	public String getRelacion_victima() {
		return relacion_victima;
	}

	public void setRelacion_victima(String relacion_victima) {
		this.relacion_victima = relacion_victima;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
    
    
}
