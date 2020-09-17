package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "salud_fisica")
public class SaludFisica implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String embarazada;
    
    private String enfermedad;
    
    private String problema_caminar;
    
    private String problema_ver;
    
    private String problema_aprender;
    
    private String problema_escuchar;
    
    private String problema_baniarse;
    
    private String problema_emocional;
    
    private String causa_dificultad;
    
    private String motivos_dificultad;
    
    private Long expediente_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmbarazada() {
		return embarazada;
	}

	public void setEmbarazada(String embarazada) {
		this.embarazada = embarazada;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getProblema_caminar() {
		return problema_caminar;
	}

	public void setProblema_caminar(String problema_caminar) {
		this.problema_caminar = problema_caminar;
	}

	public String getProblema_ver() {
		return problema_ver;
	}

	public void setProblema_ver(String problema_ver) {
		this.problema_ver = problema_ver;
	}

	public String getProblema_aprender() {
		return problema_aprender;
	}

	public void setProblema_aprender(String problema_aprender) {
		this.problema_aprender = problema_aprender;
	}

	public String getProblema_escuchar() {
		return problema_escuchar;
	}

	public void setProblema_escuchar(String problema_escuchar) {
		this.problema_escuchar = problema_escuchar;
	}

	public String getProblema_baniarse() {
		return problema_baniarse;
	}

	public void setProblema_baniarse(String problema_baniarse) {
		this.problema_baniarse = problema_baniarse;
	}

	public String getProblema_emocional() {
		return problema_emocional;
	}

	public void setProblema_emocional(String problema_emocional) {
		this.problema_emocional = problema_emocional;
	}

	public String getCausa_dificultad() {
		return causa_dificultad;
	}

	public void setCausa_dificultad(String causa_dificultad) {
		this.causa_dificultad = causa_dificultad;
	}

	public Long getExpediente_id() {
		return expediente_id;
	}

	public void setExpediente_id(Long expediente_id) {
		this.expediente_id = expediente_id;
	}

	public String getMotivos_dificultad() {
		return motivos_dificultad;
	}

	public void setMotivos_dificultad(String motivos_dificultad) {
		this.motivos_dificultad = motivos_dificultad;
	}
    
    
}
