package com.cjm.spf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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

import com.cjm.spf.dao.RegistroDao;

@Controller
@Slf4j
public class EmpoderamientoController {
	
	@Autowired
	RegistroDao registroDao;
	
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
	
	@GetMapping("/registro_emp/{id}")														//Crear expediente de empoderamiento
	public String abrirExp(@PathVariable ("id") Long id, RegEmpoderamiento registro, Model model) {
		long identificador = id;																
		registro.setUsuaria(identificador);
		model.addAttribute("empoderamiento", registro);
		return "RegistroEmpo";
	}
	
	@GetMapping("/informe_empoderamiento")														//Crear expediente de empoderamiento
	public String informeMensual( Model model) {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int mes = localDate.getMonthValue();
		int anio = localDate.getYear();
		List<RegEmpoderamiento> registros = registroEmpService.findUsuariasPrimeraVez(mes, anio);
		List<SeguimientoEmp> seguimientos = seguimientoService.findSeguimientosAlMes(mes, anio);
		model.addAttribute("registros", registros);
		model.addAttribute("seguimientos", seguimientos);
		return "InfMenEmp";
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
	
	@GetMapping("/perfil_emp/{id}")														//Perfil del area
	public String perfilEmpoderamiento(@PathVariable ("id") Long id,  Model model) {																
		Registro registro = registroDao.findById(id).orElse(null);
		Expediente expediente = expedienteService.encontrarPorId(id);
		
		RegEmpoderamiento empoderamiento = registroEmpService.findByUsuaria(id);
		
		if(empoderamiento == null) {
			model.addAttribute("registroEmp", null);
		}else {
			model.addAttribute("registroEmp", empoderamiento);
		}
		
		List <SeguimientoEmp> seguimientos = seguimientoService.findSeguimientoS(id);
		if(seguimientos.isEmpty()) {
			model.addAttribute("seguimientos", null);
		}else{
			model.addAttribute("seguimientos", seguimientos);
		}
		model.addAttribute("registro", registro);
		model.addAttribute("expediente", expediente);
		//return "PerfilEmpo";
		return "PerfilTs";
	}

}

