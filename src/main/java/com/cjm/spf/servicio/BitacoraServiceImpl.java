package com.cjm.spf.servicio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.BitacoraDao;
import com.cjm.spf.domain.Bitacora;

@Service
public class BitacoraServiceImpl implements BitacoraService{

	@Autowired
	BitacoraDao bitacoraDao;
	
	@Override
	@Transactional
	public void guardar(Bitacora bitacora) {
		Date fecha = new Date();
		bitacora.setFecha(fecha);
		bitacoraDao.save(bitacora);
		
	}

	@Override
	@Transactional(readOnly= true)
	public Bitacora findRegistro(String nombre) throws UsernameNotFoundException{
		Long id = (long)1;
		Bitacora bitacora = bitacoraDao.findById(id).orElse(null);
		if(bitacora == null) {
			throw new UsernameNotFoundException(nombre);
		}
		return bitacora;
	}

}
