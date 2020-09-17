package com.cjm.spf.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjm.spf.dao.FijacionADao;
import com.cjm.spf.dao.ExpedienteDao;

import com.cjm.spf.domain.Filiacion;
import com.cjm.spf.domain.Expediente;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FijacionAServiceImpl implements FijacionAService{

	@Autowired
	FijacionADao fijacionDao;
	
	@Autowired
	ExpedienteDao expDao;
	
	@Override
	@Transactional
	public void guardar(Filiacion fijacion) {
		Expediente exp = expDao.findTopByOrderByIdDesc();
		fijacion.setId_perfil(exp.getId());
		fijacionDao.save(fijacion);
		
	}

	@Override
	public Filiacion encontrar(Filiacion fijacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
