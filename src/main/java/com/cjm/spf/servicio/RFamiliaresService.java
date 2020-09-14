package com.cjm.spf.servicio;

import com.cjm.spf.domain.RFamiliares;

public interface RFamiliaresService {
    
    public void guardar(RFamiliares familiares);
    
    public RFamiliares encontrarRegistro(RFamiliares familiares);
}
