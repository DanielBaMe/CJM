package com.cjm.spf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.ServiciosBrindados;

public interface ServicioBrindadoDao extends JpaRepository<ServiciosBrindados, Long>{
	
	ServiciosBrindados findByExpediente(Long id);
	
	ServiciosBrindados findByPsicologia(Integer numero);
	
	ServiciosBrindados findByJuridico(Integer numero);
	
	ServiciosBrindados findByMedico(Integer numero);
	
	ServiciosBrindados findByMp(Integer numero);

}
