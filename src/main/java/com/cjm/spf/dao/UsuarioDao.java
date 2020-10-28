package com.cjm.spf.dao;

import java.util.Optional;
import com.cjm.spf.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByUsername (String username);
    
    //Usuario finByUsername(String nombre);
}
