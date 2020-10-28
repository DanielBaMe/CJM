package com.cjm.spf.dao;

import com.cjm.spf.domain.Registro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroDao extends JpaRepository<Registro, Long>{

    Registro findTopByOrderByIdDesc();
    
    List<Registro> findByNombreContaining(String nombre);
    
    List<Registro> findByPaternoContaining(String nombre); 
    
    List<Registro> findByMaternoContaining(String nombre);
    
}
