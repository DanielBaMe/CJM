package com.cjm.spf.servicio;

import com.cjm.spf.domain.DomicilioAgresor;
import com.cjm.spf.domain.Agresor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.DomicilioAgresorDao;
import com.cjm.spf.dao.DatosAgresorDao;

@Service
public class DomAgresorServiceImpl implements DomAgresorService{
	
	@Autowired
	DomicilioAgresorDao domAgresorDao;
	
	@Autowired
	DatosAgresorDao dAgresorDao;

	@Override
	@Transactional
	public void guardar(DomicilioAgresor domAgresor) {
		domAgresorDao.save(domAgresor);
		
	}

	@Override
	public DomicilioAgresor encontrarRegistro(DomicilioAgresor domAgresor) {
		// TODO Auto-generated method stub
		return null;
	}

}
