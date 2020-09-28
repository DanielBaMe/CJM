package com.cjm.spf.controllers;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cjm.spf.domain.Expediente;
import com.cjm.spf.domain.ExpPsic;
import com.cjm.spf.domain.Registro;

import com.cjm.spf.servicio.*;

import com.cjm.spf.dao.ExpedienteDao;

@Controller
@Slf4j
public class PsicController {
	
	@Autowired
	ExpedienteDao expedienteDao;
	
	@Autowired
    private ExpedienteService expedienteService;
	
	@Autowired
	private RegistroService registroService;
	
//    @PostMapping("/buscar")																	//Buscar usuaria existente
//    public String encontrarUsuaria(String nombre, Model model) {
//        Registro datos = registroService.encontrarUsuaria(nombre);
//        model.addAttribute("registros", datos);
//        System.out.println(datos);
//        return "index";
//    }
    
    @PostMapping("/crear_exp/{id}")													//Crear expediente
    public String expediente(Long id, ExpPsic expediente, Model model) {
    	Expediente expedienteTs = expedienteDao.findByUsuaria(id);
    	expediente.setId_usuaria(expedienteTs.getUsuaria());
        model.addAttribute("expediente", expediente);
        System.out.println(expediente);
        return "expPsic";
    }
	
//    @PostMapping("/expediente_psicologico")													//Crear expediente
//    public String guardar(@Valid ExpPsic expediente, Model model) {
//        Registro datos = registroService.encontrarUsuaria(nombre);
//        model.addAttribute("registros", datos);
//        System.out.println(datos);
//        return "index";
//    }
    
    /*
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    */
}
