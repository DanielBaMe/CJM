package com.cjm.spf.servicio;

import com.cjm.spf.domain.ExpPsic;

public interface ExpPsicService {
	
	public void guardar(ExpPsic expediente);
	
	public ExpPsic encontrarExpPsic(Long id);
	
	public Long contar(Integer mes, Integer anio);

}
