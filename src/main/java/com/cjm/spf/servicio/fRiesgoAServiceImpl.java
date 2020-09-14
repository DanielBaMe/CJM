package com.cjm.spf.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjm.spf.dao.fRiesgoAgresorDao;
import com.cjm.spf.domain.fRiesgoAgresor;

public class fRiesgoAServiceImpl implements fRiesgoAService{
	
	@Autowired
	fRiesgoAgresorDao riesgoDao;

	@Override
	public void guardar(fRiesgoAgresor factorA) {
		riesgoDao.save(factorA);
		
	}

	@Override
	public fRiesgoAgresor encontrar(fRiesgoAgresor riesgo) {
		// TODO Auto-generated method stub
		return null;
	}

}
