package com.cjm.spf.servicio;

import com.cjm.spf.domain.Agresor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.DatosAgresorDao;

@Service
public class AgresorServiceImpl implements AgresorService{

	@Autowired 
	DatosAgresorDao agresorDao;
	
	@Override
	@Transactional
	public void guardar(Agresor agresor) {
		
		agresorDao.save(agresor);
	}

	@Override
	public Agresor encontrarArchivo(Agresor agresor) {
		return agresorDao.findById(agresor.getId()).orElse(null);
	}

}
