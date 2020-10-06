package com.cjm.spf.servicio;

import com.cjm.spf.domain.CanalizacionLudico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.CanalizacionDao;

@Service
public class CanalizacionLudicoServiceImpl implements CanalizacionLudicoService{
	
	@Autowired
	CanalizacionDao canalizacionDao;

	@Override
	@Transactional
	public void guardar(CanalizacionLudico canalizacion) {
		canalizacionDao.save(canalizacion);
		
	}

}
