package com.cjm.spf.servicio;

import java.util.List;

import com.cjm.spf.domain.Folio;
import com.cjm.spf.pojo.conteoTS;

public interface FolioService {
    
    public void guardar(Folio folio);
    
    public Folio encontrarRegistro(Folio folio);
    
    public Long hacerConteo(String servicio, Integer anio, Integer mes);
}
