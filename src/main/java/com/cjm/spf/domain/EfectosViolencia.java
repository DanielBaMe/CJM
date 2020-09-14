package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "efectos_violencia")
public class EfectosViolencia implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String efectos;
    
    private String efectos_fisicos;
    
    private String efectos_psic;
    
    private Long id_expediente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEfectos() {
		return efectos;
	}

	public void setEfectos(String efectos) {
		this.efectos = efectos;
	}

	public String getEfectos_fisicos() {
		return efectos_fisicos;
	}

	public void setEfectos_fisicos(String efectos_fisicos) {
		this.efectos_fisicos = efectos_fisicos;
	}

	public String getEfectos_psic() {
		return efectos_psic;
	}

	public void setEfectos_psic(String efectos_psic) {
		this.efectos_psic = efectos_psic;
	}

	public Long getId_expediente() {
		return id_expediente;
	}

	public void setId_expediente(Long id_expediente) {
		this.id_expediente = id_expediente;
	}
    
    
}
