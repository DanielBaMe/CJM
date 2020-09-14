package com.cjm.spf.servicio;

import com.cjm.spf.domain.Folio;

public interface FolioService {
    
    public void guardar(Folio folio);
    
    public Folio encontrarRegistro(Folio folio);
}
