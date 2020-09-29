package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "perfil_agresor")
public class PerfilAgresor implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String princ_actividad;
    
    private String princ_ingreso;
    
    private String ingreso_mensual;
    
    private Long id_agresor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrinc_actividad() {
		return princ_actividad;
	}

	public void setPrinc_actividad(String princ_actividad) {
		this.princ_actividad = princ_actividad;
	}

	public String getPrinc_ingreso() {
		return princ_ingreso;
	}

	public void setPrinc_ingreso(String princ_ingreso) {
		this.princ_ingreso = princ_ingreso;
	}

	public String getIngreso_mensual() {
		return ingreso_mensual;
	}

	public void setIngreso_mensual(String ingreso_mensual) {
		this.ingreso_mensual = ingreso_mensual;
	}

	public Long getId_agresor() {
		return id_agresor;
	}

	public void setId_agresor(Long id_agresor) {
		this.id_agresor = id_agresor;
	}
    
    
}
