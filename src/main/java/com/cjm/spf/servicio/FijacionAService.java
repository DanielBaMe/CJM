package com.cjm.spf.servicio;

import com.cjm.spf.domain.FijacionA;

public interface FijacionAService {
	
	public void guardar (FijacionA fijacion);
	
	public FijacionA encontrar(FijacionA fijacion);

}
