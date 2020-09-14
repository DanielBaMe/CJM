package com.cjm.spf.dao;

import com.cjm.spf.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RolDao extends JpaRepository<Rol, Long>{

}
