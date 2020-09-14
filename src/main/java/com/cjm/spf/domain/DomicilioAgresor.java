package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "domicilio_agresor")
public class DomicilioAgresor implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String calle;
    
    private String no_exterior;
    
    private String no_interior;
    
    private String colonia;
    
    private String municipio;
    
    private String estado;
    
    private String pais;
    
    private String idioma;
    
    private String leer;
    
    private String escribir;
    
    private String escolaridad;
    
    private String serv_medico;
    
    private String tipo_vivienda;
    
    private String id_agresor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNo_exterior() {
		return no_exterior;
	}

	public void setNo_exterior(String no_exterior) {
		this.no_exterior = no_exterior;
	}

	public String getNo_interior() {
		return no_interior;
	}

	public void setNo_interior(String no_interior) {
		this.no_interior = no_interior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getLeer() {
		return leer;
	}

	public void setLeer(String leer) {
		this.leer = leer;
	}

	public String getEscribir() {
		return escribir;
	}

	public void setEscribir(String escribir) {
		this.escribir = escribir;
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	public String getServ_medico() {
		return serv_medico;
	}

	public void setServ_medico(String serv_medico) {
		this.serv_medico = serv_medico;
	}

	public String getTipo_vivienda() {
		return tipo_vivienda;
	}

	public void setTipo_vivienda(String tipo_vivienda) {
		this.tipo_vivienda = tipo_vivienda;
	}

	public String getId_agresor() {
		return id_agresor;
	}

	public void setId_agresor(String id_agresor) {
		this.id_agresor = id_agresor;
	}
    
    

}
