package com.cjm.spf.domain;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "usuaria_datos_generales")
public class Registro implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank (message="El campo no puede esta vacío.")
    private String nombre;
    
    @NotBlank (message="El campo no puede esta vacío.")
    private String paterno;
    
    @NotBlank (message="El campo no puede esta vacío.")
    private String materno;
    
    @NotNull(message="El campo no puede esta vacío.")
    @Positive
    private Integer edad;
    
    @Size(min=1, max=30)
    @NotBlank (message="El campo no puede esta vacío.")
    private String calle;
    
    @NotNull(message="El campo no puede esta vacío.")
    private Integer numero_exterior;
    
    private Integer numero_interior;
    
    @Size(min=5, max=30)
    @NotBlank (message="El campo no puede estar vacío.")
    private String colonia;
    
    @NotNull(message="El campo no puede estar vacío.")
    private Integer id_municipio;
    
    @NotNull(message="El campo no puede estar vacío.")
    private Integer id_estado;
    
    @NotNull(message="El campo no puede estar vacío.")
    private Integer codigo_postal;
    
    
    @NotNull(message="El campo no puede estar vacío.")
    private Integer id_estado_civil;
    
    @Size(min=10, max=10)
    @NotBlank (message="El campo no puede estar vacío.")
    private String telefono;
    
    @Column(name="curp",unique=true)
    @Size(min=5, max=18)
    @NotBlank (message="El campo no puede estar vacío.")
    private String curp;
    
    private Integer id_status_usuaria_datos_generales;
    
    @NotBlank(message="El campo no puede estar vacío.")
    private String hora_ingreso;
    
    @NotBlank(message="El campo no puede estar vacío.")
    private String hora_egreso;
    
    @NotBlank(message="El campo no puede estar vacío.")
    private String motivo_visita;
    
    @Column(name="fecha", updatable=false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fecha;
    
    @NotBlank
    private String tipo_atencion;
    
    

	public String getTipo_atencion() {
		return tipo_atencion;
	}

	public void setTipo_atencion(String tipo_atencion) {
		this.tipo_atencion = tipo_atencion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno =paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero_exterior() {
		return numero_exterior;
	}

	public void setNumero_exterior(Integer numero_exterior) {
		this.numero_exterior = numero_exterior;
	}

	public Integer getNumero_interior() {
		return numero_interior;
	}

	public void setNumero_interior(Integer numero_interior) {
		this.numero_interior = numero_interior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public Integer getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Integer id_municipio) {
		this.id_municipio = id_municipio;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public Integer getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(Integer codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public Integer getId_estado_civil() {
		return id_estado_civil;
	}

	public void setId_estado_civil(Integer id_estado_civil) {
		this.id_estado_civil = id_estado_civil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Integer getId_status_usuaria_datos_generales() {
		return id_status_usuaria_datos_generales;
	}

	public void setId_status_usuaria_datos_generales(Integer id_status_usuaria_datos_generales) {
		this.id_status_usuaria_datos_generales = id_status_usuaria_datos_generales;
	}

	public String getHora_ingreso() {
		return hora_ingreso;
	}

	public void setHora_ingreso(String hora_ingreso) {
		this.hora_ingreso = hora_ingreso;
	}

	public String getHora_egreso() {
		return hora_egreso;
	}

	public void setHora_egreso(String hora_egreso) {
		this.hora_egreso = hora_egreso;
	}

	public String getMotivo_visita() {
		return motivo_visita;
	}

	public void setMotivo_visita(String motivo_visita) {
		this.motivo_visita = motivo_visita;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
}
