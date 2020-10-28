package com.cjm.spf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.RLudico;

public interface RegistroLudicoDao extends JpaRepository<RLudico, Long>{
	
	RLudico findByNombreContaining(String nombre);
	
	RLudico findTopByOrderByIdDesc();
	
	List<RLudico> findByUsuaria(Long id);

}
