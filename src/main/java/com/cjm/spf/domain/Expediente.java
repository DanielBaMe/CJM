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
    
    private Long id_expediente_usuaria;
    
    private Long id_familiares;
    
    private Long id_domicilio_actual;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String leer;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String escribir;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String escolaridad;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String tipo_vivienda;
    
    private Long id_red_apoyo;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String tipo_apoyo;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String servicio_medico;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String actividad;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String fuente_ingreso;
    
    private String ingreso_mensual;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String tipo_violencia;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String ambito_violencia;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String victima_delincuencia;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String victima_trata;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String conoce_agresor;
    
    @NotBlank(message="El campo no puede estar vacion")
    private String info_adicional;
    
    private Long id_datos_agresor;
    
    private Long id_salud;
    
    private Long id_narracion;
    
    private Long id_fijacion;

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

	public Long getId_expediente_usuaria() {
		return id_expediente_usuaria;
	}

	public void setId_expediente_usuaria(Long id_expediente_usuaria) {
		this.id_expediente_usuaria = id_expediente_usuaria;
	}

	public Long getId_familiares() {
		return id_familiares;
	}

	public void setId_familiares(Long id_familiares) {
		this.id_familiares = id_familiares;
	}

	public Long getId_domicilio_actual() {
		return id_domicilio_actual;
	}

	public void setId_domicilio_actual(Long id_domicilio_actual) {
		this.id_domicilio_actual = id_domicilio_actual;
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

	public Long getId_red_apoyo() {
		return id_red_apoyo;
	}

	public void setId_red_apoyo(Long id_red_apoyo) {
		this.id_red_apoyo = id_red_apoyo;
	}

	public String getTipo_apoyo() {
		return tipo_apoyo;
	}

	public void setTipo_apoyo(String tipo_apoyo) {
		this.tipo_apoyo = tipo_apoyo;
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

	public Long getId_datos_agresor() {
		return id_datos_agresor;
	}

	public void setId_datos_agresor(Long id_datos_agresor) {
		this.id_datos_agresor = id_datos_agresor;
	}

	public Long getId_salud() {
		return id_salud;
	}

	public void setId_salud(Long id_salud) {
		this.id_salud = id_salud;
	}

	public Long getId_narracion() {
		return id_narracion;
	}

	public void setId_narracion(Long id_narracion) {
		this.id_narracion = id_narracion;
	}

	public Long getId_fijacion() {
		return id_fijacion;
	}

	public void setId_fijacion(Long id_fijacion) {
		this.id_fijacion = id_fijacion;
	}
    
    
}
