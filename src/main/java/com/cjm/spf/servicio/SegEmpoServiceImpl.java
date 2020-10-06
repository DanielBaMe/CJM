package com.cjm.spf.servicio;

import java.util.Date;

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
		Date fecha = new Date();
		SeguimientoEmp seg = seguimientoDao.findTopByUsuariaOrderByIdDesc(seguimiento.getUsuaria());
		System.out.println(seguimiento);
		
		if(seg == null) {
			seguimiento.setSeguimiento(1);
		}else {
			int suma = seg.getSeguimiento() + 1;
			seguimiento.setSeguimiento(suma);
		}
		seguimiento.setFecha(fecha);
		seguimientoDao.save(seguimiento);
	}

	@Override
	public SeguimientoEmp findSeguimiento(SeguimientoEmp seguimiento) {
		// TODO Auto-generated method stub
		return null;
	}

}
