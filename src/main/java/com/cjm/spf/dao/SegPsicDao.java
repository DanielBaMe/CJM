package com.cjm.spf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.SeguimientoPsic;

public interface SegPsicDao extends JpaRepository<SeguimientoPsic, Long>{
	
	SeguimientoPsic findTopByOrderByFolioDesc();
	
	SeguimientoPsic findTopByUsuariaOrderByIdDesc(Long id);
	
	List<SeguimientoPsic> findByUsuaria(Long id);
	
	Long countByMesAndAnio(Integer mes, Integer anio);

}
