package com.cjm.spf.dao;

import com.cjm.spf.domain.Folio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolioDao extends JpaRepository<Folio, Long>{
    Folio findTopByServicioOrderByIdDesc(String servicio);
    
    Folio findTopByServicio(String servicio);
}
