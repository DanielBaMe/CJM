package com.cjm.spf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileNotFoundException;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import com.cjm.spf.domain.Expediente;
import com.cjm.spf.domain.RegEmpoderamiento;
import com.cjm.spf.domain.Registro;
import com.cjm.spf.domain.SeguimientoEmp;
import com.cjm.spf.domain.ServiciosBrindados;

import com.cjm.spf.servicio.RegistroService;
import com.cjm.spf.servicio.ServiciosBrindadosService;
import com.cjm.spf.servicio.ExpedienteService;
import com.cjm.spf.servicio.RegEmpService;
import com.cjm.spf.servicio.SegEmpoService;

@Controller
@Slf4j
public class EmpoderamientoController {
	
	@Autowired
	private SegEmpoService seguimientoService;
	
	@Autowired
	private RegEmpService registroEmpService;
	
	@Autowired
    private ExpedienteService expedienteService;
	
	@Autowired
	private RegistroService registroService;
	
	@Autowired
	private ServiciosBrindadosService serviciosService;
	
	@PostMapping("/usuaria_empoderamiento")																	//Buscar usuaria existente
    public String encontrarUsuaria(String nombre, Model model) throws FileNotFoundException {
        
    	Registro datos = registroService.encontrarUsuaria(nombre);
		Expediente exp = expedienteService.encontrarPorId(datos.getId());
		if(exp != null) {
			ServiciosBrindados serv = serviciosService.encontrarExp(exp.getId());
			if(serv.getEmpoderamiento() > 0) {
				 model.addAttribute("registros", datos); 
			}
		}
		return "index";
        
    }
	
	@GetMapping("/registro_emp/{id}")														//Crear expediente de empoderamiento
	public String abrirExp(@PathVariable ("id") Long id, RegEmpoderamiento registro, Model model) {
		long identificador = id;																
		registro.setUsuaria(identificador);
		model.addAttribute("empoderamiento", registro);
		return "RegistroEmpo";
	}
	
	@PostMapping("/registro_empoderamiento")															
	public String guardar(@Valid RegEmpoderamiento empoderamiento, Errors errores) {
		if(errores.hasErrors()) {
			return "RegistroEmpo";
		}
		registroEmpService.guardar(empoderamiento);
		return "redirect:/";
	}
	
	@GetMapping("/seguimiento_emp/{id}")														//Crear seguimiento de empoderamiento
	public String abrirSeg(@PathVariable ("id") Long id, SeguimientoEmp seguimiento, Model model) {
		long identificador = id;																
		seguimiento.setUsuaria(identificador);
		model.addAttribute("seguimiento", seguimiento);
		return "segEmpoderamiento";
	}
	
	@PostMapping("/seguimiento_empoderamiento")													//Guardar seguimiento		
	public String guardar(@Valid SeguimientoEmp seguimiento, Errors errores) {
		if(errores.hasErrors()) {
			return "segEmpoderamiento";
		}
		seguimientoService.guardar(seguimiento);
		return "redirect:/";
	}

}
