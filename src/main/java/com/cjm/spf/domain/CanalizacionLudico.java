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
@Table(name = "canalizacion")
public class CanalizacionLudico implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String no_canalizacion;
    
    private String no_caso;
    
    private Date fecha;
    
    private Long id_exp_usuaria;
    
    private String area_canalizar;
    
    private String motivo;
    
    private Long id_registro_ludico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNo_canalizacion() {
		return no_canalizacion;
	}

	public void setNo_canalizacion(String no_canalizacion) {
		this.no_canalizacion = no_canalizacion;
	}

	public String getNo_caso() {
		return no_caso;
	}

	public void setNo_caso(String no_caso) {
		this.no_caso = no_caso;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getId_exp_usuaria() {
		return id_exp_usuaria;
	}

	public void setId_exp_usuaria(Long id_exp_usuaria) {
		this.id_exp_usuaria = id_exp_usuaria;
	}

	public String getArea_canalizar() {
		return area_canalizar;
	}

	public void setArea_canalizar(String area_canalizar) {
		this.area_canalizar = area_canalizar;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Long getId_registro_ludico() {
		return id_registro_ludico;
	}

	public void setId_registro_ludico(Long id_registro_ludico) {
		this.id_registro_ludico = id_registro_ludico;
	}

    
}
