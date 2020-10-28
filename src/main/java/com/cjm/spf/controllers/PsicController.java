package com.cjm.spf.controllers;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cjm.spf.domain.Expediente;
import com.cjm.spf.domain.ExpPsic;
import com.cjm.spf.domain.Registro;
import com.cjm.spf.domain.ServiciosBrindados;
import com.cjm.spf.domain.SeguimientoPsic;
import com.cjm.spf.pojo.ValoracionPsicPojo;
import com.cjm.spf.domain.AgendaPsic;
import com.cjm.spf.pojo.SeguimientoPsicPOJO;
import com.cjm.spf.domain.ValoracionPsicInf;

import com.cjm.spf.servicio.*;

import com.cjm.spf.dao.ExpedienteDao;
import com.cjm.spf.dao.RegistroDao;
import com.cjm.spf.dao.SegPsicDao;

@Controller
@Slf4j
public class PsicController {
	
	@Autowired
	ExpedienteDao expedienteDao;
	
	@Autowired
	RegistroDao registroDao;
	
	@Autowired
	SegPsicDao seguimientoDao;
	
	@Autowired
	private ValPsicInfService valoracionInfService;
	
	@Autowired
	private AgendaPsicService agendaService;
	
	@Autowired
    private ExpedienteService expedienteService;
	
	@Autowired
	private RegistroService registroService;
	
	@Autowired
	private ServiciosBrindadosService serviciosService;
	
	@Autowired
	private ExpPsicService expPsicService;
	
	@Autowired
	private SegPsicService seguimientoService;
	
    
	@GetMapping("/expediente_psicologico/{id}")
	public String abrirExp(@PathVariable ("id") Long id, ValoracionPsicPojo valoracionPojo, Model model) {
		long identificador = id;
		valoracionPojo.setId_usuaria(identificador);
		model.addAttribute("valoracionPojo", valoracionPojo);
		String titulo = "Valoración psicologica";
		model.addAttribute("titulo", titulo);
		return "exp_psic";
	}
	
	@GetMapping("/registro_infantil_psic/{id}")
	public String valoracionInf(ValoracionPsicInf valoracion, Model model) {
		model.addAttribute("valoracion", valoracion);
		String titulo = "Valoración psicologica infantil";
		model.addAttribute("titulo", titulo);
		return "ValPsicInf";
	}
	
	@GetMapping("/conteo_mes_actual")
	public String conteoActual(Model model) {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int mes = localDate.getMonthValue();
		int anio = localDate.getYear();
		long conteo = expPsicService.contar(mes, anio);
		
		long seguimiento = seguimientoService.contar(mes, anio);
		
		model.addAttribute("seguimiento", seguimiento);
		model.addAttribute("conteo", conteo);
		return "InfMenPsic";
	}
	
	@PostMapping("/expPsic")
	public String guardar(@Valid ValoracionPsicPojo valoracionPojo, Errors errores, Model model ) {
		if(errores.hasErrors()) {
			return "exp_psic";
		}
		System.out.println(valoracionPojo);
		ExpPsic expPsic = new ExpPsic();
		expPsic.setCanalizada(valoracionPojo.getCanalizada());
		expPsic.setDx(valoracionPojo.getDx());
		expPsic.setFamiliar(valoracionPojo.getFamiliar());
		expPsic.setFamiliograma(valoracionPojo.getFamiliograma());
		expPsic.setUsuaria(valoracionPojo.getId_usuaria());
		expPsic.setIndividual(valoracionPojo.getIndividual());
		expPsic.setLaboral(valoracionPojo.getLaboral());
		expPsic.setMotivo_consulta(valoracionPojo.getMotivo_consulta());
		expPsic.setObjetivo(valoracionPojo.getObjetivo());
		expPsic.setObserv(valoracionPojo.getObserv());
		expPsic.setPsicologa(valoracionPojo.getPsicologa());
		expPsic.setSexual(valoracionPojo.getSexual());
		expPsic.setSocial(valoracionPojo.getSocial());
		expPsic.setTarea(valoracionPojo.getTarea());
		expPsic.setTipo_violencia(valoracionPojo.getTipo_violencia());
		expPsicService.guardar(expPsic);
		
		
		
		AgendaPsic agenda = new AgendaPsic();
		agenda.setFecha(valoracionPojo.getFecha());
		agenda.setUsuaria(valoracionPojo.getId_usuaria());
		agendaService.guardar(agenda);
		return "redirect:/";
		
	}
	
	@GetMapping("/canalizar_usuaria_ts/{id}")															//Canarlizar usuaria a empoderamiento
    public String buscarUsuaria(Registro registro, Model model) {
        registro = registroService.encontrarRegistro(registro);
        Expediente exp = expedienteService.encontrarPorId(registro.getId());
        ServiciosBrindados serv = serviciosService.encontrarExp(exp.getId());
        serv.setEmpoderamiento(1);
        serviciosService.actualizar(serv);
        return "CanalizacionTs";
    }
	
    
	@GetMapping("/seguimiento_psic/{id}") 																// Seguimiento psicologico									
	public String crearSeguimiento(SeguimientoPsicPOJO seguimiento, Model model) {
		//SeguimientoPsic seguimientoPsic = new SeguimientoPsic();
		//seguimientoPsic.setUsuaria(id);
		model.addAttribute("seguimiento", seguimiento);
		String titulo = "Seguimiento psicologico";
		model.addAttribute("titulo", titulo);
		return "SegPsic";
	}
    
    @PostMapping("/nuevo_seguimiento")																	//Guardar seguimiento
    public String guardar_seguimiento(SeguimientoPsicPOJO seguimiento, Model model, AgendaPsic agenda) {
    	
    	agenda.setFecha(seguimiento.getFecha());
    	agenda.setUsuaria(seguimiento.getUsuaria());
    	agenda.setPsicologa(seguimiento.getPsicologa());
    	agendaService.guardar(agenda);
    	
    	SeguimientoPsic seguimientoPsic = new SeguimientoPsic();
    	
		seguimientoPsic.setH_entrada(seguimiento.getH_entrada());
    	seguimientoPsic.setH_salida(seguimiento.getH_salida());
    	seguimientoPsic.setObjetivo(seguimiento.getObjetivo());
    	seguimientoPsic.setPsicologa(seguimiento.getPsicologa());
    	seguimientoPsic.setTarea(seguimiento.getTarea());
    	seguimientoPsic.setUsuaria(seguimiento.getUsuaria());
    	seguimientoPsic.setObservaciones(seguimiento.getObservaciones());
    	seguimientoPsic.setSesion(seguimiento.getSesion());
    	
    	seguimientoService.guardar(seguimientoPsic);
        return "redirect:/";
    }
    
    @GetMapping("/ver_psic/{id}")
    public String editar(@PathVariable ("id") Long id, Model model){
    	Registro datos = registroDao.findById(id).orElse(null);									//Datos pre registro
		Expediente exp = expedienteService.encontrarPorId(datos.getId());						//Expediente hecho en TS
		ExpPsic expPsic = new ExpPsic();														//Expediente Psicologico
		model.addAttribute("registro", datos); 
		if(exp != null) {
			
			model.addAttribute("expedienteTS", exp);
			expPsic = expPsicService.encontrarExpPsic(datos.getId());
			List<SeguimientoPsic> registros = seguimientoService.encontrarSeguimientosDeUsuaria(id);
			if(registros.isEmpty()) {
				model.addAttribute("seguimientos", null);
				model.addAttribute("expediente", expPsic);
			}else {
				model.addAttribute("seguimientos", registros);
		        model.addAttribute("expediente", expPsic);
			}

			
		}else {
			model.addAttribute("seguimientos", null);
	        model.addAttribute("expediente", null);
	        model.addAttribute("expedienteTS", null);
		}
		String titulo = "Expediente psicologico";
		model.addAttribute("titulo", titulo);
        //return "PerfilPsic";
		return "PerfilTs";
    }
    
}
