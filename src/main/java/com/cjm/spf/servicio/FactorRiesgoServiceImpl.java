package com.cjm.spf.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjm.spf.dao.FactorRiesgoDao;
import com.cjm.spf.dao.ExpedienteDao;

import com.cjm.spf.domain.FactorRiesgo;
import com.cjm.spf.domain.Expediente;

public class FactorRiesgoServiceImpl implements FactorRiesgoService{
	
	@Autowired
	FactorRiesgoDao riesgoDao;
	
	@Autowired
	ExpedienteDao expedienteDao;

	@Override
	public void guardar(FactorRiesgo riesgo) {
		Expediente exp = expedienteDao.findTopByOrderByIdDesc();
		riesgo.setId_agresor(exp.getId());
		riesgoDao .save(riesgo);
		
	}

	@Override
	public FactorRiesgo buscar(FactorRiesgo riesgo) {
		// TODO Auto-generated method stub
		return null;
	}

}
