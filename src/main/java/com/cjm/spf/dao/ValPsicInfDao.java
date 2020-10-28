package com.cjm.spf.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.ValoracionPsicInf;

public interface ValPsicInfDao extends JpaRepository<ValoracionPsicInf, Long>{
	
	Optional<ValoracionPsicInf> findById(Long id);
	
	ValoracionPsicInf findByUsuaria(Long id);
	
	ValoracionPsicInf findByNombre(String nombre);

}
