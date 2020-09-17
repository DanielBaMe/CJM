package com.cjm.spf.servicio;

import com.cjm.spf.domain.SaludFisica;
import com.cjm.spf.domain.Expediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.SaludFisicaDao;
import com.cjm.spf.dao.ExpedienteDao;

@Service
public class SaludServiceImpl implements SaludService{

	@Autowired
	SaludFisicaDao saludDao;
	
	@Autowired
	ExpedienteDao expDao;
	
	@Override
	@Transactional
	public void guardar(SaludFisica salud) {
		
		Expediente expediente = expDao.findTopByOrderByIdDesc();
		salud.setExpediente_id(expediente.getId());
		saludDao.save(salud);
		
	}

}
