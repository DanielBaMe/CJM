package com.cjm.spf.servicio;

import com.cjm.spf.domain.PerfilAgresor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjm.spf.dao.PerfilAgresorDao;

@Service
public class PerfilAgresorServiceImpl implements PerfilAgresorService{
	
	@Autowired
	PerfilAgresorDao perfilDao;

	@Override
	public void guardar(PerfilAgresor perfil) {
		perfilDao.save(perfil);
		
	}

	@Override
	public PerfilAgresor encontrarRegistro(PerfilAgresor perfil) {
		// TODO Auto-generated method stub
		return null;
	}

}
