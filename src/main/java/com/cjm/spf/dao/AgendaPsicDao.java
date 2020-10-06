package com.cjm.spf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.AgendaPsic;

public interface AgendaPsicDao extends JpaRepository<AgendaPsic, Long>{
	
	AgendaPsic findByUsuaria(Long id);
	
}
