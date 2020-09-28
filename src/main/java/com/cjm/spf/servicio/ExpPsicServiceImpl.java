package com.cjm.spf.servicio;

import com.cjm.spf.domain.ExpPsic;
import com.cjm.spf.domain.Expediente;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjm.spf.dao.ExpPsicDao;
import com.cjm.spf.dao.ExpedienteDao;

@Service
public class ExpPsicServiceImpl implements ExpPsicService{
	
	@Autowired
	ExpPsicDao expDao;

	@Override
	@Transactional
	public void guardar(ExpPsic expediente) {
		expDao.save(expediente);
		
	}

}
