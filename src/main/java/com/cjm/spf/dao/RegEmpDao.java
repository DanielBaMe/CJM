package com.cjm.spf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.RegEmpoderamiento;

public interface RegEmpDao extends JpaRepository<RegEmpoderamiento, Long>{

	RegEmpoderamiento findTopByOrderByIdDesc();
	
	RegEmpoderamiento findByUsuaria(Long id);
	
	List<RegEmpoderamiento> findByMesAndAnio(Integer mes, Integer anio);
	
}
