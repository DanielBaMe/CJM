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
@Table(name = "folios")
public class Folio implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Positive
    private Long usuaria;
            
    private Long id_tipo_folio;
    
    private Integer id_status_folio;
    
    private String servicio;
    
    private String atencion;
    
    @JsonFormat(pattern="yyyy")
    private Integer anio;
    
    @JsonFormat(pattern="MM")
    private Integer mes;
    
    @JsonFormat(pattern="dd")
    private Integer dia;
    
    

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

	public void setDia(int i) {
		this.dia = i;
	}

	public String getAtencion() {
		return atencion;
	}

	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuaria() {
		return usuaria;
	}

	public void setUsuaria(Long usuaria) {
		this.usuaria = usuaria;
	}

	public Long getId_tipo_folio() {
		return id_tipo_folio;
	}

	public void setId_tipo_folio(Long id_tipo_folio) {
		this.id_tipo_folio = id_tipo_folio;
	}

	public Integer getId_status_folio() {
		return id_status_folio;
	}

	public void setId_status_folio(Integer id_status_folio) {
		this.id_status_folio = id_status_folio;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
    
    
}
