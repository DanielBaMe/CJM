package com.cjm.spf.servicio;

import com.cjm.spf.domain.EfectosViolencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.efectosViolenciaDao;

@Service
public class eViolenciaServiceImpl implements eViolenciaService{
	
	@Autowired
	efectosViolenciaDao violenciaDao;

	@Override
	@Transactional
	public void guardar(EfectosViolencia violencia) {
		violenciaDao.save(violencia);
		
	}

}
