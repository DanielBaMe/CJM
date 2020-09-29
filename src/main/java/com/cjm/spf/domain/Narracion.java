package com.cjm.spf.domain;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@Entity
@Table(name = "narracion_hechos")
public class Narracion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="El campo no puede estar vacio")
	private String fecha;
	
	@NotBlank (message="El campo no puede esta vacío.")
	private String hora;
	
	private String direccion;
	
	private String espacio_publico;
	
	private String espacio_particular;
	
	private String otro;
	
	private String calle;
	
	private Integer no_exterior;
	
	private Integer no_interior;
	
	private String colonia;
	
	@NotBlank(message="El campo no puede estar vacio")
	private Integer municipio;
	
	@NotBlank(message="El campo no puede estar vacio")
	private Integer estado;
	
	@NotBlank(message="El campo no puede estar vacio")
	private String pais;
	
	private String autoridad;
	
	private String gravedad;
	
	private Long expediente_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEspacio_publico() {
		return espacio_publico;
	}

	public void setEspacio_publico(String espacio_publico) {
		this.espacio_publico = espacio_publico;
	}

	public String getEspacio_particular() {
		return espacio_particular;
	}

	public void setEspacio_particular(String espacio_particular) {
		this.espacio_particular = espacio_particular;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNo_exterior() {
		return no_exterior;
	}

	public void setNo_exterior(Integer no_exterior) {
		this.no_exterior = no_exterior;
	}

	public Integer getNo_interior() {
		return no_interior;
	}

	public void setNo_interior(Integer no_interior) {
		this.no_interior = no_interior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public Integer getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Integer municipio) {
		this.municipio = municipio;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getAutoridad() {
		return autoridad;
	}

	public void setAutoridad(String autoridad) {
		this.autoridad = autoridad;
	}

	public String getGravedad() {
		return gravedad;
	}

	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}

	public Long getExpediente_id() {
		return expediente_id;
	}

	public void setExpediente_id(Long expediente_id) {
		this.expediente_id = expediente_id;
	}
	
	
	

}
