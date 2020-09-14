package com.cjm.spf.servicio;

import com.cjm.spf.domain.Narracion;

public interface NarracionService {
	
	public void guardar(Narracion narracion);

	public Narracion encontrarNarracion(Narracion narracion);

}
