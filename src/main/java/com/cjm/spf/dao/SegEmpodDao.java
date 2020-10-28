package com.cjm.spf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cjm.spf.domain.SeguimientoEmp;

public interface SegEmpodDao extends JpaRepository<SeguimientoEmp, Long>{
	
	//SeguimientoEmp findTopByUsuariaOrderByIdDesc(Long id);
	
	SeguimientoEmp findTopByUsuariaOrderByIdDesc(Long id);
	
	List<SeguimientoEmp> findByUsuaria(Long id);
	
	//List<SeguimientoEmp> findByMesAndAnio(Integer mes, Integer anio);
	
	@Query(value = "SELECT distinct * FROM seguimiento_empoderamiento se " 
			+ "			WHERE mes =:mes"
			+ "			AND anio =:anio  group by 5", nativeQuery = true)
	List<SeguimientoEmp> informeMensual(Integer mes, Integer anio);

}
