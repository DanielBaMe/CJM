package com.cjm.spf.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.domain.ValoracionPsicInf;

import com.cjm.spf.dao.ValPsicInfDao;

@Service
public class ValPsicInfServiceImpl implements ValPsicInfService{
	
	@Autowired
	ValPsicInfDao valoracionDao;

	@Override
	@Transactional
	public void guardar(ValoracionPsicInf valoracion) {
		valoracion.setAnio(Calendar.getInstance().get(Calendar.YEAR));
		valoracion.setMes(Calendar.getInstance().get(Calendar.MONTH));
		valoracion.setDia(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		valoracionDao.save(valoracion);
		
	}

	@Override
	@Transactional(readOnly = true)
	public ValoracionPsicInf buscarPorId(Long id) {
		ValoracionPsicInf valoracion = valoracionDao.findById(id).orElse(null);
		return valoracion;
	}

	@Override
	@Transactional(readOnly = true)
	public ValoracionPsicInf buscarNombre(String nombre) {
		ValoracionPsicInf valoracion = valoracionDao.findByNombre(nombre);
		return valoracion;
	}

}
