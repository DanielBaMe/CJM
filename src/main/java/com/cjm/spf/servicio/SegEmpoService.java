package com.cjm.spf.servicio;

import java.util.List;

import com.cjm.spf.domain.SeguimientoEmp;

public interface SegEmpoService {
	
	public void guardar(SeguimientoEmp seguimiento);
	
	public SeguimientoEmp findSeguimiento(SeguimientoEmp seguimiento); 
	
	public List<SeguimientoEmp> findSeguimientoS(Long id);
	
	public List<SeguimientoEmp> findSeguimientosAlMes(Integer mes, Integer anio);
	
}
