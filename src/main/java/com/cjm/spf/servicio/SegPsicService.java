package com.cjm.spf.servicio;

import com.cjm.spf.domain.SeguimientoPsic;

public interface SegPsicService {
	
	public void guardar(SeguimientoPsic seguimiento);
	
	public SeguimientoPsic encontrarUltimoFolio();
	
	public SeguimientoPsic encontrarUltimoSeguimiento(Long id);
	
	public SeguimientoPsic encontrarSeguimiento(Long id);

}
