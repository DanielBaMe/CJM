package com.cjm.spf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjm.spf.domain.RegEmpoderamiento;

public interface RegEmpDao extends JpaRepository<RegEmpoderamiento, Long>{

	RegEmpoderamiento findTopByOrderByIdDesc();
	
}
