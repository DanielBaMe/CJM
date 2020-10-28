package com.cjm.spf.dao;

import com.cjm.spf.domain.Folio;
import com.cjm.spf.pojo.conteoTS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FolioDao extends JpaRepository<Folio, Long>{
    Folio findTopByServicioOrderByIdDesc(String servicio);
    
    Folio findTopByServicio(String servicio);
    
    Long countByMesAndAnio(Integer mes, Integer anio);
    
    @Query(value = "SELECT count(*) as total FROM folios fl " 
			+ "			WHERE  servicio =:servicio AND mes =:mes"
			+ "			AND anio =:anio", nativeQuery = true)
	Long informeMensualByServicio(String servicio, Integer mes, Integer anio);
}
