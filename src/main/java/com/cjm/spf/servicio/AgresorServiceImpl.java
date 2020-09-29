package com.cjm.spf.servicio;

import com.cjm.spf.domain.Agresor;
import com.cjm.spf.domain.Expediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.DatosAgresorDao;
import com.cjm.spf.dao.ExpedienteDao;

@Service
public class AgresorServiceImpl implements AgresorService{

	@Autowired 
	DatosAgresorDao agresorDao;
	
	@
	Autowired
	ExpedienteDao expedienteDao;
	
	@Override
	@Transactional
	public void guardar(Agresor agresor) {
		Expediente expediente = expedienteDao.findTopByOrderByIdDesc();
		System.out.println(expediente);
		agresor.setId_expediente(expediente.getId());
		agresorDao.save(agresor);
	}

	@Override
	public Agresor encontrarArchivo(Agresor agresor) {
		return agresorDao.findById(agresor.getId()).orElse(null);
	}

}
