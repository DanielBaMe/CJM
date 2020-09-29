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
@Table(name = "seg_ord_protec")
public class SeguimientoOrdProtec implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long id_usuaria;
    
    private String numero_tel;
    
    private String hora;
    
    private String cumple_orden;
    
    private String atendio_llamada;
    
    private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_usuaria() {
		return id_usuaria;
	}

	public void setId_usuaria(Long id_usuaria) {
		this.id_usuaria = id_usuaria;
	}

	public String getNumero_tel() {
		return numero_tel;
	}

	public void setNumero_tel(String numero_tel) {
		this.numero_tel = numero_tel;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCumple_orden() {
		return cumple_orden;
	}

	public void setCumple_orden(String cumple_orden) {
		this.cumple_orden = cumple_orden;
	}

	public String getAtendio_llamada() {
		return atendio_llamada;
	}

	public void setAtendio_llamada(String atendio_llamada) {
		this.atendio_llamada = atendio_llamada;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
    

}
