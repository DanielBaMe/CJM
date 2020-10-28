package com.cjm.spf.servicio;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.cjm.spf.dao.RegEmpDao;

import com.cjm.spf.domain.RegEmpoderamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.domain.RegEmpoderamiento;

@Service
public class RegEmpServiceImpl implements RegEmpService{
	
	@Autowired
	RegEmpDao registroDao;

	@Override
	@Transactional
	public void guardar(RegEmpoderamiento regEmpoderamiento) {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		regEmpoderamiento.setDia(localDate.getDayOfMonth());
		regEmpoderamiento.setMes(localDate.getMonthValue());
		regEmpoderamiento.setAnio(localDate.getYear());
		RegEmpoderamiento registro = registroDao.findTopByOrderByIdDesc();
		if(registro == null) {
			regEmpoderamiento.setFolio(1);
		}else {
			int suma = registro.getFolio() + 1;
			regEmpoderamiento.setFolio(suma);
		}
		registroDao.save(regEmpoderamiento);
		
	}

	@Override
	@Transactional
	public List<RegEmpoderamiento> listarRegistros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public RegEmpoderamiento findRegistro(RegEmpoderamiento registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public RegEmpoderamiento findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public RegEmpoderamiento findByUsuaria(Long id) {
		RegEmpoderamiento registro = registroDao.findByUsuaria(id);
		return registro;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RegEmpoderamiento> findUsuariasPrimeraVez(Integer mes, Integer anio) {
		List<RegEmpoderamiento> registros = registroDao.findByMesAndAnio(mes, anio);
		return registros;
	}

}
