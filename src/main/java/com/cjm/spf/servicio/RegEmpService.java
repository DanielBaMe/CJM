package com.cjm.spf.servicio;

import java.util.List;
import com.cjm.spf.domain.RegEmpoderamiento;

public interface RegEmpService {
	
	public void guardar(RegEmpoderamiento regEmpoderamiento);
	
	public List<RegEmpoderamiento> listarRegistros();
	
	public RegEmpoderamiento findRegistro(RegEmpoderamiento registro);
	
	public RegEmpoderamiento findByNombre(String nombre);
	
	public RegEmpoderamiento findByUsuaria(Long id);
	
	public List<RegEmpoderamiento> findUsuariasPrimeraVez(Integer mes, Integer anio);

}
