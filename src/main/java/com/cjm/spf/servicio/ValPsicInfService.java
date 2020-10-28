package com.cjm.spf.servicio;

import com.cjm.spf.domain.ValoracionPsicInf;

public interface ValPsicInfService {
	
	public void guardar(ValoracionPsicInf valoracion);
	
	public ValoracionPsicInf buscarPorId(Long id);
	
	public ValoracionPsicInf buscarNombre(String nombre);

}
