package com.cjm.spf.servicio;

import com.cjm.spf.dao.RedApoyoDao;
import com.cjm.spf.dao.ExpedienteDao;

import com.cjm.spf.domain.RedApoyo;
import com.cjm.spf.domain.Expediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RedApoyoServiceImpl implements RedApoyoService{
    
    @Autowired
    RedApoyoDao apoyoDao;
    
    @Autowired
    ExpedienteDao expedienteDao;

    @Override
    @Transactional
    public void guardar(RedApoyo apoyo) {
    	Expediente expediente = expedienteDao.findTopByOrderByIdDesc();
    	apoyo.setId_expediente(expediente.getId());
        apoyoDao.save(apoyo);
    }

    @Override
    @Transactional(readOnly = true)
    public RedApoyo encontrarRegistro(RedApoyo apoyo) {
        return apoyoDao.findById(apoyo.getId()).orElse(null);
    }
    
}
