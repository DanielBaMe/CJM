package com.cjm.spf.servicio;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.cjm.spf.domain.Expediente;
import com.cjm.spf.domain.Narracion;

import com.cjm.spf.dao.ExpedienteDao;
import com.cjm.spf.dao.NarracionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NarracionServiceImpl implements NarracionService{
	
	@Autowired
    private ExpedienteDao expedienteDao;
    
    @Autowired
    private NarracionDao narracionDao;

	@Override
	public void guardar(Narracion narracion) {
		Expediente expediente =expedienteDao.findTopByOrderByIdDesc();
		narracion.setExpediente_id(expediente.getId());
		narracionDao.save(narracion);		
	}

	@Override
	public Narracion encontrarNarracion(Narracion narracion) {
		return narracionDao.findById(narracion.getId()).orElse(null);
	}

}
