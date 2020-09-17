package com.cjm.spf.servicio;

import com.cjm.spf.domain.FactorRiesgo;

public interface FactorRiesgoService {
	
	public void guardar(FactorRiesgo riesgo);
	
	public FactorRiesgo buscar(FactorRiesgo riesgo);

}
