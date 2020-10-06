package com.cjm.spf.servicio;

import com.cjm.spf.domain.ServiciosBrindados;

public interface ServiciosBrindadosService {
	
	public void guardar(ServiciosBrindados servicios);
	
	public ServiciosBrindados encontrarExp(Long id);
	
	public ServiciosBrindados encontrarPsic(Integer numero);
	
	public void actualizar(ServiciosBrindados servicios);

}
