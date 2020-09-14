package com.cjm.spf.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name="usuarios")
public class NuevoUsuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @NotEmpty(message="El campo no puede esta vacío.")
    private String nombre;
    
    @Column(nullable=false, unique=true)
    @NotEmpty(message="El campo no puede esta vacío.")
    private String username;
    
    @Column(nullable=false)
    @NotEmpty(message="El campo no puede esta vacío.")
    @Size(min=3)
    private String password;
    

    private Integer id_privilegio;
    

    private Integer id_area;
    

    private Integer id_status_usuario;


	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getId_privilegio() {
		return id_privilegio;
	}


	public void setId_privilegio(Integer id_privilegio) {
		this.id_privilegio = id_privilegio;
	}


	public Integer getId_area() {
		return id_area;
	}


	public void setId_area(Integer id_area) {
		this.id_area = id_area;
	}


	public Integer getId_status_usuario() {
		return id_status_usuario;
	}


	public void setId_status_usuario(Integer id_status_usuario) {
		this.id_status_usuario = id_status_usuario;
	}
    
    
    
}
