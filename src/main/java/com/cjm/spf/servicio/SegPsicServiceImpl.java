package com.cjm.spf.servicio;

import java.util.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.domain.SeguimientoPsic;

import com.cjm.spf.dao.SegPsicDao;

@Service
public class SegPsicServiceImpl implements SegPsicService{
	
	@Autowired
	SegPsicDao seguimientoDao;
	
	@Override
	@Transactional
	public void guardar(SeguimientoPsic seguimiento) {
		Date fecha = new Date();
		seguimiento.setFecha(fecha);
		seguimientoDao.save(seguimiento);
		
	}

	@Override
	@Transactional(readOnly=true)
	public SeguimientoPsic encontrarUltimoFolio() {
		SeguimientoPsic seguimiento = seguimientoDao.findTopByOrderByFolioDesc();
		return seguimiento;
	}



	@Override
	public SeguimientoPsic encontrarSeguimiento(Long id) {
		SeguimientoPsic seguimiento = seguimientoDao.findById(id).orElse(null);
		return seguimiento;
	}

	@Override
	public SeguimientoPsic encontrarUltimoSeguimiento(Long id) {
		SeguimientoPsic seguimiento = seguimientoDao.findTopByUsuariaOrderByIdDesc(id);
		return seguimiento;
	}

}
