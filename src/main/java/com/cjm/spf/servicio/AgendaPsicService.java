package com.cjm.spf.servicio;

import com.cjm.spf.domain.AgendaPsic;

public interface AgendaPsicService {
	
	public void guardar(AgendaPsic agenda);
	
	public AgendaPsic buscar(Long id);

}
