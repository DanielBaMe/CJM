package com.cjm.spf.servicio;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.domain.SeguimientoEmp;

import com.cjm.spf.dao.SegEmpodDao;

@Service
public class SegEmpoServiceImpl implements SegEmpoService{
	
	@Autowired
	SegEmpodDao seguimientoDao;
	

	@Override
	public void guardar(SeguimientoEmp seguimiento) {
		SeguimientoEmp seg = seguimientoDao.findTopByUsuariaOrderByIdDesc(seguimiento.getUsuaria());
		
		if(seg == null) {
			seguimiento.setSeguimiento(1);
		}else {
			int suma = seg.getSeguimiento() + 1;
			seguimiento.setSeguimiento(suma);
		}
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		seguimiento.setDia(localDate.getDayOfMonth());
		seguimiento.setMes(localDate.getMonthValue());
		seguimiento.setAnio(localDate.getYear());
		seguimientoDao.save(seguimiento);
	}

	@Override
	public SeguimientoEmp findSeguimiento(SeguimientoEmp seguimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SeguimientoEmp> findSeguimientoS(Long id) {
		
		return (List<SeguimientoEmp>) seguimientoDao.findByUsuaria(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SeguimientoEmp> findSeguimientosAlMes(Integer mes, Integer anio) {
		List<SeguimientoEmp> seguimientos = seguimientoDao.informeMensual(mes, anio);
		return seguimientos;
	}

}
