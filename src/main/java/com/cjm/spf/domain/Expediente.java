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
@Table(name = "expediente_1")
public class Expediente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="fecha", updatable=false)
    private Date fecha;
    
    @NotBlank(message="El campo no puede esta vacío.")
    private String h_entrada;
    
    @NotBlank(message="El campo no puede esta vacío.")
    private String h_salida;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String nombre_entrevistador;
    
    private Long usuaria;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String leer;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String escribir;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String escolaridad;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String tipo_vivienda;
    
    
    @NotBlank(message="El campo no puede estar vacio")
    private String servicio_medico;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String actividad;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String fuente_ingreso;
    
    private String ingreso_mensual;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String tipo_violencia;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String ambito_violencia;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String victima_delincuencia;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String victima_trata;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String conoce_agresor;
    
    @NotBlank(message="El campo no puede estar vacio")
    private String info_adicional;

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

	public String getH_entrada() {
		return h_entrada;
	}

	public void setH_entrada(String h_entrada) {
		this.h_entrada = h_entrada;
	}

	public String getH_salida() {
		return h_salida;
	}

	public void setH_salida(String h_salida) {
		this.h_salida = h_salida;
	}

	public String getNombre_entrevistador() {
		return nombre_entrevistador;
	}

	public void setNombre_entrevistador(String nombre_entrevistador) {
		this.nombre_entrevistador = nombre_entrevistador;
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

	public String getTipo_vivienda() {
		return tipo_vivienda;
	}

	public void setTipo_vivienda(String tipo_vivienda) {
		this.tipo_vivienda = tipo_vivienda;
	}


	public String getServicio_medico() {
		return servicio_medico;
	}

	public void setServicio_medico(String servicio_medico) {
		this.servicio_medico = servicio_medico;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getFuente_ingreso() {
		return fuente_ingreso;
	}

	public void setFuente_ingreso(String fuente_ingreso) {
		this.fuente_ingreso = fuente_ingreso;
	}

	public String getIngreso_mensual() {
		return ingreso_mensual;
	}

	public void setIngreso_mensual(String ingreso_mensual) {
		this.ingreso_mensual = ingreso_mensual;
	}

	public String getTipo_violencia() {
		return tipo_violencia;
	}

	public void setTipo_violencia(String tipo_violencia) {
		this.tipo_violencia = tipo_violencia;
	}

	public String getAmbito_violencia() {
		return ambito_violencia;
	}

	public void setAmbito_violencia(String ambito_violencia) {
		this.ambito_violencia = ambito_violencia;
	}

	public String getVictima_delincuencia() {
		return victima_delincuencia;
	}

	public void setVictima_delincuencia(String victima_delincuencia) {
		this.victima_delincuencia = victima_delincuencia;
	}

	public String getVictima_trata() {
		return victima_trata;
	}

	public void setVictima_trata(String victima_trata) {
		this.victima_trata = victima_trata;
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

	public Long getUsuaria() {
		return usuaria;
	}

	public void setUsuaria(Long id_expediente_usuaria) {
		this.usuaria = id_expediente_usuaria;
	}

	
    
}
