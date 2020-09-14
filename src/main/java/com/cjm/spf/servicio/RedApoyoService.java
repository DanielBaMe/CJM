package com.cjm.spf.servicio;

import com.cjm.spf.domain.RedApoyo;

public interface RedApoyoService {
    
    public void guardar(RedApoyo apoyo);
    
    public RedApoyo encontrarRegistro(RedApoyo apoyo);
    
}
