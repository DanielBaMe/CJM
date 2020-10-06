package com.cjm.spf.servicio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.RegistroLudicoDao;

import com.cjm.spf.domain.RLudico;

@Service
public class RLudicoServiceImpl implements RLudicoService{
	
	@Autowired
	RegistroLudicoDao ludicoDao;

	@Override
	@Transactional
	public void guardar(RLudico registro) {
		Date fecha = new Date();
		registro.setFecha(fecha);
		RLudico primero = ludicoDao.findTopByOrderByIdDesc();
		if(primero == null) {
			registro.setFolio((long)1);
		}else {
			registro.setFolio(primero.getFolio() + 1);
		}
		ludicoDao.save(registro);
		
	}

	@Override
	@Transactional(readOnly = true)
	public RLudico encontrarNinio(String nombre) {
		RLudico registro = ludicoDao.findByNombreContaining(nombre);
		return registro;
	}

}
