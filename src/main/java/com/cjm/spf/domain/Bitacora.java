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
@Table(name = "bitacora_ludico")
public class Bitacora implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date fecha;
    
    private Long registro;
    
    private String temas_tratados;
    
    private String desarrollo_actividades;
    
    private String realizado;
    
    private String material;
    
    private String actividades;
    
    private String involucrado;
    
    private String disposicion;
    
    private String empatia;
    
    private String actitud;
    
    private String interaccion;
    
    private String consignas_actividades;
    
    private String convivencia;
    
    private String logros;
    
    private String dificultades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getRegistro() {
		return registro;
	}

	public void setRegistro(Long registro) {
		this.registro = registro;
	}

	public String getTemas_tratados() {
		return temas_tratados;
	}

	public void setTemas_tratados(String temas_tratados) {
		this.temas_tratados = temas_tratados;
	}

	public String getDesarrollo_actividades() {
		return desarrollo_actividades;
	}

	public void setDesarrollo_actividades(String desarrollo_actividades) {
		this.desarrollo_actividades = desarrollo_actividades;
	}

	public String getRealizado() {
		return realizado;
	}

	public void setRealizado(String realizado) {
		this.realizado = realizado;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public String getInvolucrado() {
		return involucrado;
	}

	public void setInvolucrado(String involucrado) {
		this.involucrado = involucrado;
	}

	public String getDisposicion() {
		return disposicion;
	}

	public void setDisposicion(String disposicion) {
		this.disposicion = disposicion;
	}

	public String getEmpatia() {
		return empatia;
	}

	public void setEmpatia(String empatia) {
		this.empatia = empatia;
	}

	public String getActitud() {
		return actitud;
	}

	public void setActitud(String actitud) {
		this.actitud = actitud;
	}

	public String getInteraccion() {
		return interaccion;
	}

	public void setInteraccion(String interaccion) {
		this.interaccion = interaccion;
	}

	public String getConsignas_actividades() {
		return consignas_actividades;
	}

	public void setConsignas_actividades(String consignas_actividades) {
		this.consignas_actividades = consignas_actividades;
	}

	public String getConvivencia() {
		return convivencia;
	}

	public void setConvivencia(String convivencia) {
		this.convivencia = convivencia;
	}

	public String getLogros() {
		return logros;
	}

	public void setLogros(String logros) {
		this.logros = logros;
	}

	public String getDificultades() {
		return dificultades;
	}

	public void setDificultades(String dificultades) {
		this.dificultades = dificultades;
	}
    
    

}
