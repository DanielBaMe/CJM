package com.cjm.spf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.RLudico;

public interface RegistroLudicoDao extends JpaRepository<RLudico, Long>{
	
	RLudico findByNombreContaining(String nombre);
	
	RLudico findTopByOrderByIdDesc();

}
