package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "seguimiento_empoderamiento")
public class SeguimientoEmp implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonFormat(pattern="yyyy")
    private Integer anio;
    
    @JsonFormat(pattern="MM")
    private Integer mes;
    
    @JsonFormat(pattern="dd")
    private Integer dia;
    
    private String hora_e;
    
    private String hora_salida;
    
	private Integer seguimiento;
	
	private Long usuaria;
	
	private String observaciones;
	
	

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHora_e() {
		return hora_e;
	}

	public void setHora_e(String hora_e) {
		this.hora_e = hora_e;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public Integer getSeguimiento() {
		return seguimiento;
	}

	public void setSeguimiento(Integer seguimiento) {
		this.seguimiento = seguimiento;
	}

	public Long getUsuaria() {
		return usuaria;
	}

	public void setUsuaria(Long usuaria) {
		this.usuaria = usuaria;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

}
