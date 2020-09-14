package com.cjm.spf.servicio;

import com.cjm.spf.domain.PerfilAgresor;

public interface PerfilAgresorService {
	
public void guardar(PerfilAgresor perfil);
    
    public PerfilAgresor encontrarRegistro(PerfilAgresor perfil);

}
