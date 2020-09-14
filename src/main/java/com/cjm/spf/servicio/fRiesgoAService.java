package com.cjm.spf.servicio;

import com.cjm.spf.domain.fRiesgoAgresor;

public interface fRiesgoAService {
	
	public void guardar(fRiesgoAgresor factorA);
	
	public fRiesgoAgresor encontrar(fRiesgoAgresor riesgo);

}
