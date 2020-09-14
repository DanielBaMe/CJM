package com.cjm.spf.servicio;

import com.cjm.spf.domain.Agresor;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjm.spf.dao.DatosAgresorDao;

public class AgresorServiceImpl implements AgresorService{

	@Autowired 
	DatosAgresorDao agresorDao;
	
	@Override
	public void guardar(Agresor agresor) {
		
		agresorDao.save(agresor);
	}

	@Override
	public Agresor encontrarArchivo(Agresor agresor) {
		return agresorDao.findById(agresor.getId()).orElse(null);
	}

}
