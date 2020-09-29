package com.cjm.spf.servicio;

import com.cjm.spf.domain.PerfilAgresor;
import com.cjm.spf.domain.Agresor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.PerfilAgresorDao;
import com.cjm.spf.dao.DatosAgresorDao;

@Service
public class PerfilAgresorServiceImpl implements PerfilAgresorService{
	
	@Autowired
	PerfilAgresorDao perfilDao;
	
	@Autowired
	DatosAgresorDao agresorDao;

	@Override
	@Transactional
	public void guardar(PerfilAgresor perfil) {
		Agresor agresor = agresorDao.findTopByOrderByIdDesc();
		perfil.setId_agresor(agresor.getId());
		perfilDao.save(perfil);
		
	}

	@Override
	public PerfilAgresor encontrarRegistro(PerfilAgresor perfil) {
		// TODO Auto-generated method stub
		return null;
	}

}
