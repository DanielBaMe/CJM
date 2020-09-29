package com.cjm.spf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cjm.spf.domain.Agresor;

public interface DatosAgresorDao extends JpaRepository<Agresor, Long>{
	Agresor findTopByOrderByIdDesc();
}
