package com.cjm.spf.servicio;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
		
		SeguimientoPsic seg1 = seguimientoDao.findTopByOrderByFolioDesc();
		if(seg1 == null) {
			seguimiento.setFolio((long)1);
		}else {
			seguimiento.setFolio(seg1.getFolio() + 1);
		}
		
		SeguimientoPsic seg2 = seguimientoDao.findTopByUsuariaOrderByIdDesc(seguimiento.getUsuaria());
		System.out.println(seg2);
		if(seg2 == null) {
			seguimiento.setNo_sesion(1);;
		}else {
			seguimiento.setNo_sesion(seg2.getNo_sesion() + 1);
		}
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		seguimiento.setDia(localDate.getDayOfMonth());
		seguimiento.setMes(localDate.getMonthValue());
		seguimiento.setAnio(localDate.getYear());
		
		seguimientoDao.save(seguimiento);
		
	}

	@Override
	@Transactional(readOnly=true)
	public SeguimientoPsic encontrarUltimoFolio() {
		SeguimientoPsic seguimiento = seguimientoDao.findTopByOrderByFolioDesc();
		return seguimiento;
	}



	@Override
	@Transactional(readOnly=true)
	public SeguimientoPsic encontrarSeguimiento(Long id) {
		SeguimientoPsic seguimiento = seguimientoDao.findById(id).orElse(null);
		return seguimiento;
	}

	@Override
	@Transactional(readOnly=true)
	public SeguimientoPsic encontrarUltimoSeguimiento(Long id) {
		SeguimientoPsic seguimiento = seguimientoDao.findTopByUsuariaOrderByIdDesc(id);
		return seguimiento;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SeguimientoPsic> encontrarSeguimientosDeUsuaria(Long id) {
		return (List<SeguimientoPsic>) seguimientoDao.findByUsuaria(id) ;
	}

	@Override
	@Transactional(readOnly = true)
	public Long contar(Integer mes, Integer anio) {
		Long conteo = seguimientoDao.countByMesAndAnio(mes, anio);
		return conteo;
	}

}
