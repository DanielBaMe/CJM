package com.cjm.spf.servicio;

import com.cjm.spf.dao.ServicioBrindadoDao;
import com.cjm.spf.dao.ExpedienteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.domain.ServiciosBrindados;
import com.cjm.spf.domain.Expediente;

@Service
public class ServiciosBrindadosServiceImpl implements ServiciosBrindadosService{
	
	@Autowired
	ServicioBrindadoDao servicioDao;
	
	@Autowired
	ExpedienteDao expDao;

	@Override
	@Transactional
	public void guardar(ServiciosBrindados servicios) {
		Expediente expediente = expDao.findTopByOrderByIdDesc();
		servicios.setId_expediente(expediente.getId());
		servicioDao.save(servicios);
		
	}

}
