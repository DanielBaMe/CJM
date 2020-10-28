package com.cjm.spf.servicio;

import java.util.List;

import com.cjm.spf.domain.PeritajesPsic;

public interface PeritajePsicService {
	
	public void guardar(PeritajesPsic peritaje);
	
	public List<PeritajesPsic> listarPeritajesUsuaria(Long id);
	
	public Long contar(Integer mes, Integer anio);

}
