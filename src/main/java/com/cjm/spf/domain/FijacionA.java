package com.cjm.spf.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "fijaciones")
public class FijacionA implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tez;
    
    private String ojos;
    
    private String cara;
    
    private String nariz;
    
    private String cabello;
    
    private String boca;
    
    private String estatura;
    
    private String senia_particular;
    
    private String id_perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTez() {
		return tez;
	}

	public void setTez(String tez) {
		this.tez = tez;
	}

	public String getOjos() {
		return ojos;
	}

	public void setOjos(String ojos) {
		this.ojos = ojos;
	}

	public String getCara() {
		return cara;
	}

	public void setCara(String cara) {
		this.cara = cara;
	}

	public String getNariz() {
		return nariz;
	}

	public void setNariz(String nariz) {
		this.nariz = nariz;
	}

	public String getCabello() {
		return cabello;
	}

	public void setCabello(String cabello) {
		this.cabello = cabello;
	}

	public String getBoca() {
		return boca;
	}

	public void setBoca(String boca) {
		this.boca = boca;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public String getSenia_particular() {
		return senia_particular;
	}

	public void setSenia_particular(String senia_particular) {
		this.senia_particular = senia_particular;
	}

	public String getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(String id_perfil) {
		this.id_perfil = id_perfil;
	}
    
    
    

}
