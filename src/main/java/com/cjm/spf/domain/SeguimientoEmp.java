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
@Table(name = "seguimiento_empoderamiento")
public class SeguimientoEmp implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date fecha;
    
    private String hora_e;
    
    private String hora_salida;
    
	private String seguimiento;
	
	private Long id_usuaira;
	
	private String observaciones;

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

	public String getSeguimiento() {
		return seguimiento;
	}

	public void setSeguimiento(String seguimiento) {
		this.seguimiento = seguimiento;
	}

	public Long getId_usuaira() {
		return id_usuaira;
	}

	public void setId_usuaira(Long id_usuaira) {
		this.id_usuaira = id_usuaira;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

}
