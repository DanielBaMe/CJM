package com.cjm.spf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.PeritajesPsic;
import com.cjm.spf.domain.SeguimientoPsic;

public interface PeritajesPsicDao extends JpaRepository<PeritajesPsic, Long>{
	
	Long countByMesAndAnio(Integer mes, Integer anio);
	
	List<PeritajesPsic> findByUsuaria(Long id);

}
