package com.cjm.spf.servicio;

import com.cjm.spf.domain.Filiacion;

public interface FijacionAService {
	
	public void guardar (Filiacion fijacion);
	
	public Filiacion encontrar(Filiacion fijacion);

}
