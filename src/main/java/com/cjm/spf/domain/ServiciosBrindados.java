package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "servicios_brindados")
public class ServiciosBrindados implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long id_expediente;
    
    private String psicologia;
    
    private String juridico;
    
    private String medico;
    
    private String mp;
    
    private String empoderamiento;
    
    private Integer id_status_servicio_brindado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_expediente() {
		return id_expediente;
	}

	public void setId_expediente(Long id_expediente) {
		this.id_expediente = id_expediente;
	}

	public String getPsicologia() {
		return psicologia;
	}

	public void setPsicologia(String psicologia) {
		this.psicologia = psicologia;
	}

	public String getJuridico() {
		return juridico;
	}

	public void setJuridico(String juridico) {
		this.juridico = juridico;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getMp() {
		return mp;
	}

	public void setMp(String mp) {
		this.mp = mp;
	}

	public String getEmpoderamiento() {
		return empoderamiento;
	}

	public void setEmpoderamiento(String empoderamiento) {
		this.empoderamiento = empoderamiento;
	}

	public Integer getId_status_servicio_brindado() {
		return id_status_servicio_brindado;
	}

	public void setId_status_servicio_brindado(Integer id_status_servicio_brindado) {
		this.id_status_servicio_brindado = id_status_servicio_brindado;
	}
    
    
}
