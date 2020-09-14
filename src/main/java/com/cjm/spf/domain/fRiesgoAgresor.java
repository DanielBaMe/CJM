package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "factor_riesgo")
public class fRiesgoAgresor implements Serializable{

	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String efecto_droga;
    
    private String frecuencia_consumo;
    
    private String cual;
    
    private String armas;
    
    private Long id_perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEfecto_droga() {
		return efecto_droga;
	}

	public void setEfecto_droga(String efecto_droga) {
		this.efecto_droga = efecto_droga;
	}

	public String getFrecuencia_consumo() {
		return frecuencia_consumo;
	}

	public void setFrecuencia_consumo(String frecuencia_consumo) {
		this.frecuencia_consumo = frecuencia_consumo;
	}

	public String getCual() {
		return cual;
	}

	public void setCual(String cual) {
		this.cual = cual;
	}

	public String getArmas() {
		return armas;
	}

	public void setArmas(String armas) {
		this.armas = armas;
	}

	public Long getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(Long id_perfil) {
		this.id_perfil = id_perfil;
	}
    
    
	
}
