package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "folios")
public class Folio implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Positive
    private Long no_folio;
            
    private Long id_tipo_folio;
    
    private Integer id_status_folio;
    
    private String servicio;
    
    private String atencion;
    

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

	public Long getNo_folio() {
		return no_folio;
	}

	public void setNo_folio(Long no_folio) {
		this.no_folio = no_folio;
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
