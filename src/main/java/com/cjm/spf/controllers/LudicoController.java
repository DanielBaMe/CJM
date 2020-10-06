package com.cjm.spf.controllers;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cjm.spf.domain.RLudico;
import com.cjm.spf.domain.Bitacora;
import com.cjm.spf.domain.CanalizacionLudico;

import com.cjm.spf.servicio.BitacoraService;
import com.cjm.spf.servicio.RLudicoService;
import com.cjm.spf.servicio.CanalizacionLudicoService;

@Controller
@Slf4j
public class LudicoController {
	
	@Autowired
	private CanalizacionLudicoService canalizacionService;
	
	@Autowired
	private BitacoraService bitacoraService;
	
	@Autowired
	private RLudicoService ludicoService;
	
	
	@GetMapping("/expediente_ludico/{id}")														//Crear expediente ludico
	public String abrirExp(@PathVariable ("id") Long id, RLudico registro, Model model) {
		long identificador = id;																
		registro.setUsuaria(identificador);
		model.addAttribute("registro", registro);
		return "exp_ludico";
	}
	
	
	@GetMapping("/canalizar_ludico/{id}")														//Crear canalizacion
	public String canalizarLudico(@PathVariable ("id") Long id, CanalizacionLudico registro, Model model) {
		long identificador = id;
		registro.setId_registro_ludico(identificador);;												//Buscar vistas
		model.addAttribute("registro", registro);
		return "canalizar_ludico";																//Buscar vista de canalizacion
	}
	
	@GetMapping("/bitacora_ludico/{id}")														//Crear bitacora
	public String bitacoraLudico(@PathVariable ("id") Long id, Bitacora bitacora, Model model) {
		long identificador = id;
		bitacora.setRegistro(identificador);												
		model.addAttribute("registro", bitacora);
		return "BitacoraLudico";																//Buscar vista de canalizacion
	}
	
	@PostMapping("/buscar_ninio")														//Buscar ninio registrado anteriormente
	public String buscarLudico(String nombre, Model model) {
		RLudico registro = ludicoService.encontrarNinio(nombre);											
		model.addAttribute("ludicos", registro);
		return "index";																
	}
	
	
	@PostMapping("/canalizar_exp_ludico")															
	public String guardar(@Valid CanalizacionLudico canalizacion, Errors errores) {
		if(errores.hasErrors()) {
			return "exp_ludico";
		}
		canalizacionService.guardar(canalizacion);
		return "redirect:/";
	}
	
	
	@PostMapping("/registro_ludico")																//Buscar vista bitacora
	public String guardar(@Valid RLudico registro, Errors errores, Model model, Bitacora bitacora) {
		if(errores.hasErrors()) {
			return "exp_ludico";
		}
		ludicoService.guardar(registro);															//tomar el id del registro para pasarlo a la llave foranea
		return "redirect:/";
	}
	
	@PostMapping("/bitacora_ludico")																		
	public String guardar(@Valid Bitacora bitacora, Errors errores) {
		if(errores.hasErrors()) {
			return "bitacora";
		}
		bitacoraService.guardar(bitacora);
		return "redirect:/";
	}
	

}
