package com.cjm.spf.servicio;

import com.cjm.spf.domain.Expediente;

public interface ExpedienteService {
    
    public void guardar(Expediente expediente);
    
    public Expediente encontrarExpediente(Expediente expediente);
    
    public Expediente encontrarPorId(Long id);
}
