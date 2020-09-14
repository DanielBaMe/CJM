package com.cjm.spf.dao;

import com.cjm.spf.domain.NuevoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CrearUsuario extends CrudRepository<NuevoUsuario, Long>{
    
}
