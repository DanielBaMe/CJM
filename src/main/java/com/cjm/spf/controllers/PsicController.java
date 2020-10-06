package com.cjm.spf.controllers;

import java.io.FileNotFoundException;

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
	
    @PostMapping("/buscar_usuaria")																	//Buscar usuaria existente
    public String encontrarUsuaria(String nombre, Model model) throws FileNotFoundException {
        
    	Registro datos = registroService.encontrarUsuaria(nombre);
		Expediente exp = expedienteService.encontrarPorId(datos.getId());
		if(exp != null) {
			ServiciosBrindados serv = serviciosService.encontrarExp(exp.getId());
			if(serv.getPsicologia() > 0) {
				 model.addAttribute("registros", datos); 
			}
		}
		return "index";
        
    }
    
	@GetMapping("/expediente_psicologico/{id}")
	public String abrirExp(@PathVariable ("id") Long id, ValoracionPsicPojo valoracionPojo, Model model) {
		long identificador = id;
		valoracionPojo.setId_usuaria(identificador);
		model.addAttribute("valoracionPojo", valoracionPojo);
		return "exp_psic";
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
	
    
	@GetMapping("/seguimiento_psic/{id}") // Seguimiento psicologico									//Vista Seguimiento
	public String crearSeguimiento(@PathVariable ("id") Long id, SeguimientoPsicPOJO seguimiento, Model model) {
		seguimiento.setUsuaria(id);
		model.addAttribute("seguimiento", seguimiento);
		return "SegPsic";
	}
    
    @PostMapping("/nuevo_seguimiento")																	//Guardar seguimiento
    public String guardar_seguimiento(SeguimientoPsicPOJO seguimiento, Model model, AgendaPsic agenda) {
    	
    	agenda.setFecha(seguimiento.getFecha());
    	agenda.setUsuaria(seguimiento.getUsuaria());
    	agenda.setPsicologa(seguimiento.getPsicologa());
    	agendaService.guardar(agenda);
    	
    	SeguimientoPsic seguimientoPsic = new SeguimientoPsic();
    	
    	SeguimientoPsic primero = seguimientoDao.findById((long)1).orElse(null);
    	
    	System.out.println(primero);
    	
    	if(primero == null) {
    		seguimientoPsic.setFolio((long) 1);
    		seguimientoPsic.setNo_sesion(1);
    		seguimientoPsic.setH_entrada(seguimiento.getH_entrada());
        	seguimientoPsic.setH_salida(seguimiento.getH_salida());
        	seguimientoPsic.setObjetivo(seguimiento.getObjetivo());
        	seguimientoPsic.setPsicologa(seguimiento.getPsicologa());
        	seguimientoPsic.setTarea(seguimiento.getTarea());
        	seguimientoPsic.setUsuaria(seguimiento.getUsuaria());
        	

        	seguimientoService.guardar(seguimientoPsic);
    		
    	}else {
    		SeguimientoPsic folio = seguimientoService.encontrarUltimoFolio();
        	SeguimientoPsic sesion = seguimientoService.encontrarUltimoSeguimiento(seguimiento.getUsuaria());
        	
        	seguimientoPsic.setFolio(folio.getFolio() + 1);
        	seguimientoPsic.setNo_sesion(sesion.getNo_sesion() + 1);
        	seguimientoPsic.setH_entrada(seguimiento.getH_entrada());
        	seguimientoPsic.setH_salida(seguimiento.getH_salida());
        	seguimientoPsic.setObjetivo(seguimiento.getObjetivo());
        	seguimientoPsic.setPsicologa(seguimiento.getPsicologa());
        	seguimientoPsic.setTarea(seguimiento.getTarea());
        	seguimientoPsic.setUsuaria(seguimiento.getUsuaria());
        	

        	seguimientoService.guardar(seguimientoPsic);
    	}

    	seguimientoService.guardar(seguimientoPsic);
        return "redirect:/";
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
