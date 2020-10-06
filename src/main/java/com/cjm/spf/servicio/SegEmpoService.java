package com.cjm.spf.servicio;

import com.cjm.spf.domain.SeguimientoEmp;

public interface SegEmpoService {
	
	public void guardar(SeguimientoEmp seguimiento);
	
	public SeguimientoEmp findSeguimiento(SeguimientoEmp seguimiento); 
	
}
