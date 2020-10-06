package com.cjm.spf.servicio;

import com.cjm.spf.domain.RLudico;

public interface RLudicoService {
	
	public void guardar(RLudico registro);
	
	public RLudico encontrarNinio(String nombre);

}
