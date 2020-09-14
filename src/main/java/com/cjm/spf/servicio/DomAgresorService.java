package com.cjm.spf.servicio;

import com.cjm.spf.domain.DomicilioAgresor;

public interface DomAgresorService {
	
	 public void guardar(DomicilioAgresor domAgresor);
	    
	    public DomicilioAgresor encontrarRegistro(DomicilioAgresor domAgresor);

}
