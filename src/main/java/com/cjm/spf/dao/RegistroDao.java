package com.cjm.spf.dao;

import com.cjm.spf.domain.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroDao extends JpaRepository<Registro, Long>{

    Registro findTopByOrderByIdDesc();
    
    Registro findByNombre(String nombre);
    
}
