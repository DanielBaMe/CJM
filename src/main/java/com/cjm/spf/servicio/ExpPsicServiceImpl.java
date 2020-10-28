package com.cjm.spf.servicio;

import com.cjm.spf.domain.ExpPsic;
import com.cjm.spf.domain.Expediente;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

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
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		expediente.setDia(localDate.getDayOfMonth());
		expediente.setMes(localDate.getMonthValue());
		expediente.setAnio(localDate.getYear());
		ExpPsic anterior = expDao.findTopByOrderByIdDesc();
		if(anterior == null) {
			expediente.setFolio((long)1);
		}else {
			expediente.setFolio(anterior.getFolio() + 1);
		}
		expDao.save(expediente);
		
	}

	@Override
	public ExpPsic encontrarExpPsic(Long id) {
		ExpPsic expediente = expDao.findByUsuaria(id);
		return expediente;
	}


	@Override
	@Transactional(readOnly=true)
	public Long contar(Integer mes, Integer anio) {
		Long contar = expDao.countByMesAndAnio(mes, anio);
		return contar;
	}

}
