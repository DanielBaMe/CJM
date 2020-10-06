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
    
    private Long expediente;
    
    private Integer psicologia;
    
    private Integer juridico;
    
    private Integer medico;
    
    private Integer mp;
    
    private Integer empoderamiento;
    
    private Integer dh;
    
    private Integer id_status_servicio_brindado;
    
    

	public Integer getDh() {
		return dh;
	}

	public void setDh(Integer dh) {
		this.dh = dh;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getExpediente() {
		return expediente;
	}

	public void setExpediente(Long id_expediente) {
		this.expediente = id_expediente;
	}

	public Integer getPsicologia() {
		return psicologia;
	}

	public void setPsicologia(Integer psicologia) {
		this.psicologia = psicologia;
	}

	public Integer getJuridico() {
		return juridico;
	}

	public void setJuridico(Integer juridico) {
		this.juridico = juridico;
	}

	public Integer getMedico() {
		return medico;
	}

	public void setMedico(Integer medico) {
		this.medico = medico;
	}

	public Integer getMp() {
		return mp;
	}

	public void setMp(Integer mp) {
		this.mp = mp;
	}

	public Integer getEmpoderamiento() {
		return empoderamiento;
	}

	public void setEmpoderamiento(Integer empoderamiento) {
		this.empoderamiento = empoderamiento;
	}

	public Integer getId_status_servicio_brindado() {
		return id_status_servicio_brindado;
	}

	public void setId_status_servicio_brindado(Integer id_status_servicio_brindado) {
		this.id_status_servicio_brindado = id_status_servicio_brindado;
	}
    
    
}
