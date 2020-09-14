package com.cjm.spf.servicio;

import com.cjm.spf.domain.DomicilioAgresor;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjm.spf.dao.DomicilioAgresorDao;

public class DomAgresorServiceImpl implements DomAgresorService{
	
	@Autowired
	DomicilioAgresorDao domAgresorDao;

	@Override
	public void guardar(DomicilioAgresor domAgresor) {
		domAgresorDao.save(domAgresor);
		
	}

	@Override
	public DomicilioAgresor encontrarRegistro(DomicilioAgresor domAgresor) {
		// TODO Auto-generated method stub
		return null;
	}

}
