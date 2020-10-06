package com.cjm.spf.servicio;

import com.cjm.spf.domain.Bitacora;

public interface BitacoraService {
	
	public void guardar(Bitacora bitacora);
	
	public Bitacora findRegistro(String nombre);
	

}
