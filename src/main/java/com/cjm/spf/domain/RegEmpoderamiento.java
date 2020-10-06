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
    
    private String hora_entrada;
    
    private String hora_salida;
    
    private Integer folio;

    private Long usuaria;
    
    private String escolaridad;
    
    private String certificado;
    
    private String est_actuales_escuela;
    
    private String est_actuales_horario;
    
    private String est_actuales_curso;
    
    private String est_actuales_grado;
    
    private String exp_laboral;
    
    private String ultimo_empleo;
    
    private String ocupacion;
    
    private String desarrolla_negocio;
    
    private String habilidades;
    
    private String apoyo_escolar;
    
    private String apoyo_trabajo;
    
    private String canalizacion;
    
    

	public String getUltimo_empleo() {
		return ultimo_empleo;
	}

	public void setUltimo_empleo(String ultimo_empleo) {
		this.ultimo_empleo = ultimo_empleo;
	}

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

	public String getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
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

	public Long getUsuaria() {
		return usuaria;
	}

	public void setUsuaria(Long usuaria) {
		this.usuaria = usuaria;
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

	public String getEst_actuales_grado() {
		return est_actuales_grado;
	}

	public void setEst_actuales_grado(String est_actuales_grado) {
		this.est_actuales_grado = est_actuales_grado;
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

	public String getDesarrolla_negocio() {
		return desarrolla_negocio;
	}

	public void setDesarrolla_negocio(String desarrolla_negocio) {
		this.desarrolla_negocio = desarrolla_negocio;
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

    
    
}
