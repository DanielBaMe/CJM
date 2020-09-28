package com.cjm.spf.dao;

import com.cjm.spf.domain.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpedienteDao extends JpaRepository<Expediente, Long>{
    Expediente findTopByOrderByIdDesc();
    
    Expediente findByUsuaria(Long id);
}
