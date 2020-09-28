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
@Table(name = "seguimiento_juridico")
public class SeguimientoJuridico implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date fecha;
    
    private Long id_usuaria;
    
    private String hora_e;
    
    private String hora_s;
    
    private String seguimiento;

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

	public Long getId_usuaria() {
		return id_usuaria;
	}

	public void setId_usuaria(Long id_usuaria) {
		this.id_usuaria = id_usuaria;
	}

	public String getHora_e() {
		return hora_e;
	}

	public void setHora_e(String hora_e) {
		this.hora_e = hora_e;
	}

	public String getHora_s() {
		return hora_s;
	}

	public void setHora_s(String hora_s) {
		this.hora_s = hora_s;
	}

	public String getSeguimiento() {
		return seguimiento;
	}

	public void setSeguimiento(String seguimiento) {
		this.seguimiento = seguimiento;
	}
    
    

}
