package com.cjm.spf.servicio;

import java.util.List;

import com.cjm.spf.domain.SeguimientoPsic;

public interface SegPsicService {
	
	public void guardar(SeguimientoPsic seguimiento);
	
	public SeguimientoPsic encontrarUltimoFolio();
	
	public SeguimientoPsic encontrarUltimoSeguimiento(Long id);
	
	public SeguimientoPsic encontrarSeguimiento(Long id);
	
	public List<SeguimientoPsic> encontrarSeguimientosDeUsuaria(Long id);
	
	public Long contar(Integer mes, Integer anio);
}
