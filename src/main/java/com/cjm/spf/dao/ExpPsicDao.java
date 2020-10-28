package com.cjm.spf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.ExpPsic;

public interface ExpPsicDao extends JpaRepository<ExpPsic, Long>{
	
	ExpPsic findTopByOrderByIdDesc();
	
	ExpPsic findByUsuaria(Long id);
	
	Long countByMesAndAnio(Integer mes, Integer anio);

}
