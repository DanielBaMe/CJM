package com.cjm.spf.servicio;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.PeritajesPsicDao;

import com.cjm.spf.domain.PeritajesPsic;

@Service
public class PeritajePsicServiceImpl implements PeritajePsicService{
	
	@Autowired
	PeritajesPsicDao peritajeDao;
	

	@Override
	public void guardar(PeritajesPsic peritaje) {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		peritaje.setDia(localDate.getDayOfMonth());
		peritaje.setMes(localDate.getMonthValue());
		peritaje.setAnio(localDate.getYear());
		peritajeDao.save(peritaje);
		
	}

	@Override
	public List<PeritajesPsic> listarPeritajesUsuaria(Long id) {
		List<PeritajesPsic> peritajes = peritajeDao.findByUsuaria(id);
		return peritajes;
	}

	@Override
	public Long contar(Integer mes, Integer anio) {
		Long conteo = peritajeDao.countByMesAndAnio(mes, anio);
		return conteo;
	}

}
