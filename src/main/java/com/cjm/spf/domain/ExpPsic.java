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
@Table(name = "valoracion_psic")
public class ExpPsic implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    
    private String folio;
    
    private Long id_usuaria;
    
    private String motivo_consulta;
    
    private String familiar;
    
    private String tipo_violencia;
    
    private String tarea;
    
    private String observ;
    
    private String dx;
    
    private String objetivo;
    
    private String canalizada;
    
    private String psicologa;
    
    private String familiograma;
    
    private String laboral;
    
    private String social;
    
    private String sexual;
    
    private String individual;

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

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Long getId_usuaria() {
		return id_usuaria;
	}

	public void setId_usuaria(Long id_usuaria) {
		this.id_usuaria = id_usuaria;
	}

	public String getMotivo_consulta() {
		return motivo_consulta;
	}

	public void setMotivo_consulta(String motivo_consulta) {
		this.motivo_consulta = motivo_consulta;
	}

	public String getFamiliar() {
		return familiar;
	}

	public void setFamiliar(String familiar) {
		this.familiar = familiar;
	}

	public String getTipo_violencia() {
		return tipo_violencia;
	}

	public void setTipo_violencia(String tipo_violencia) {
		this.tipo_violencia = tipo_violencia;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getObserv() {
		return observ;
	}

	public void setObserv(String observ) {
		this.observ = observ;
	}

	public String getDx() {
		return dx;
	}

	public void setDx(String dx) {
		this.dx = dx;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getCanalizada() {
		return canalizada;
	}

	public void setCanalizada(String canalizada) {
		this.canalizada = canalizada;
	}

	public String getPsicologa() {
		return psicologa;
	}

	public void setPsicologa(String psicologa) {
		this.psicologa = psicologa;
	}

	public String getFamiliograma() {
		return familiograma;
	}

	public void setFamiliograma(String familiograma) {
		this.familiograma = familiograma;
	}

	public String getLaboral() {
		return laboral;
	}

	public void setLaboral(String laboral) {
		this.laboral = laboral;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

	public String getSexual() {
		return sexual;
	}

	public void setSexual(String sexual) {
		this.sexual = sexual;
	}

	public String getIndividual() {
		return individual;
	}

	public void setIndividual(String individual) {
		this.individual = individual;
	}
    
    
}
