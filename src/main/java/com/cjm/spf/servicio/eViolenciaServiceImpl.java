package com.cjm.spf.servicio;

import com.cjm.spf.domain.EfectosViolencia;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjm.spf.dao.efectosViolenciaDao;

public class eViolenciaServiceImpl implements eViolenciaService{
	
	@Autowired
	efectosViolenciaDao violenciaDao;

	@Override
	public void guardar(EfectosViolencia violencia) {
		violenciaDao.save(violencia);
		
	}

}
