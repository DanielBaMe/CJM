package com.cjm.spf.servicio;

import com.cjm.spf.domain.RFamiliares;
import com.cjm.spf.domain.Expediente;

import com.cjm.spf.dao.RFamiliaresDao;
import com.cjm.spf.dao.ExpedienteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RFamiliaresServiceImpl implements RFamiliaresService{
    
    @Autowired
    RFamiliaresDao familiaresDao;
    
    @Autowired
    ExpedienteDao expedienteDao;

    @Override
    @Transactional
    public void guardar(RFamiliares familiares) {
    	Expediente expediente = expedienteDao.findTopByOrderByIdDesc();
    	familiares.setId_expediente(expediente.getId());
        familiaresDao.save(familiares);
    }

    @Override
    @Transactional(readOnly = true)
    public RFamiliares encontrarRegistro(RFamiliares familiares) {
        return familiaresDao.findById(familiares.getId()).orElse(null);
    }
    
}
