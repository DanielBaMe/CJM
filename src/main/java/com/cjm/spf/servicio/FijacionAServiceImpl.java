package com.cjm.spf.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import com.cjm.spf.dao.FijacionADao;
import com.cjm.spf.domain.FijacionA;

public class FijacionAServiceImpl implements FijacionAService{

	@Autowired
	FijacionADao fijacionDao;
	
	@Override
	public void guardar(FijacionA fijacion) {
		fijacionDao.save(fijacion);
		
	}

	@Override
	public FijacionA encontrar(FijacionA fijacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
