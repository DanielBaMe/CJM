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
@Table(name = "valoracion_psic")
public class ExpPsic implements Serializable{
	
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

    private Long folio;
    
    @Column(name="usuaria",unique=true)
    private Long usuaria;
    
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

	public Long getFolio() {
		return folio;
	}

	public void setFolio(Long folio) {
		this.folio = folio;
	}

	public Long getUsuaria() {
		return usuaria;
	}

	public void setUsuaria(Long usuaria) {
		this.usuaria = usuaria;
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
