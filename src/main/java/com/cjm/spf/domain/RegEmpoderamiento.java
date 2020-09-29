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
@Table(name = "registro_empoderamiento")
public class RegEmpoderamiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date fecha;
    
    private String hora_entada;
    
    private String hora_salida;
    
    private Integer folio;

    private Long id_usuaria;
    
    private String escolaridad;
    
    private String certificado;
    
    private String est_actuales_escuela;
    
    private String est_actuales_horario;
    
    private String est_actuales_curso;
    
    private String ext_actuales_grado;
    
    private String exp_laboral;
    
    private String ocupacion;
    
    private String desarolla_negocio;
    
    private String habilidades;
    
    private String apoyo_escolar;
    
    private String apoyo_trabajo;
    
    private String canalizacion;
    
    private Long id_encargada;

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

	public String getHora_entada() {
		return hora_entada;
	}

	public void setHora_entada(String hora_entada) {
		this.hora_entada = hora_entada;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public Integer getFolio() {
		return folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	public Long getId_usuaria() {
		return id_usuaria;
	}

	public void setId_usuaria(Long id_usuaria) {
		this.id_usuaria = id_usuaria;
	}

	public String getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}

	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public String getEst_actuales_escuela() {
		return est_actuales_escuela;
	}

	public void setEst_actuales_escuela(String est_actuales_escuela) {
		this.est_actuales_escuela = est_actuales_escuela;
	}

	public String getEst_actuales_horario() {
		return est_actuales_horario;
	}

	public void setEst_actuales_horario(String est_actuales_horario) {
		this.est_actuales_horario = est_actuales_horario;
	}

	public String getEst_actuales_curso() {
		return est_actuales_curso;
	}

	public void setEst_actuales_curso(String est_actuales_curso) {
		this.est_actuales_curso = est_actuales_curso;
	}

	public String getExt_actuales_grado() {
		return ext_actuales_grado;
	}

	public void setExt_actuales_grado(String ext_actuales_grado) {
		this.ext_actuales_grado = ext_actuales_grado;
	}

	public String getExp_laboral() {
		return exp_laboral;
	}

	public void setExp_laboral(String exp_laboral) {
		this.exp_laboral = exp_laboral;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getDesarolla_negocio() {
		return desarolla_negocio;
	}

	public void setDesarolla_negocio(String desarolla_negocio) {
		this.desarolla_negocio = desarolla_negocio;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

	public String getApoyo_escolar() {
		return apoyo_escolar;
	}

	public void setApoyo_escolar(String apoyo_escolar) {
		this.apoyo_escolar = apoyo_escolar;
	}

	public String getApoyo_trabajo() {
		return apoyo_trabajo;
	}

	public void setApoyo_trabajo(String apoyo_trabajo) {
		this.apoyo_trabajo = apoyo_trabajo;
	}

	public String getCanalizacion() {
		return canalizacion;
	}

	public void setCanalizacion(String canalizacion) {
		this.canalizacion = canalizacion;
	}

	public Long getId_encargada() {
		return id_encargada;
	}

	public void setId_encargada(Long id_encargada) {
		this.id_encargada = id_encargada;
	}
    
    
    
}
