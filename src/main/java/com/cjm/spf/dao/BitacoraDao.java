package com.cjm.spf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.Bitacora;

public interface BitacoraDao extends JpaRepository<Bitacora, Long>{
	
	//Bitacora findByNombre(String nombre);

}
