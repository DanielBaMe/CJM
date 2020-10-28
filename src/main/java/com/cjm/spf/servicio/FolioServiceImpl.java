package com.cjm.spf.servicio;

import com.cjm.spf.domain.Folio;
import com.cjm.spf.pojo.conteoTS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjm.spf.dao.FolioDao;

@Service
public class FolioServiceImpl implements FolioService{
	
	@Autowired
	FolioDao folioDao;

    @Override
    public void guardar(Folio folio) {
        folioDao.save(folio);
    }

    @Override
    public Folio encontrarRegistro(Folio folio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	@Transactional(readOnly = true)
	public Long hacerConteo(String servicio, Integer anio, Integer mes) {
		Long folio = folioDao.informeMensualByServicio(servicio, mes, anio);
		return folio;
	}
    
}
