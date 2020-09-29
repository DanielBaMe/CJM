package com.cjm.spf.controllers;

import java.util.List;


import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import com.cjm.spf.domain.*;
import com.cjm.spf.dao.DatosAgresorDao;
import com.cjm.spf.dao.ExpedienteDao;

import com.cjm.spf.servicio.NuevoUsuarioService;
import com.cjm.spf.servicio.RegistroService;
import com.cjm.spf.servicio.eViolenciaService;
import com.cjm.spf.servicio.ExpedienteService;
import com.cjm.spf.servicio.NarracionService;
import com.cjm.spf.servicio.RFamiliaresService;
import com.cjm.spf.servicio.RedApoyoService;
import com.cjm.spf.servicio.SaludService;
import com.cjm.spf.servicio.AgresorService;
import com.cjm.spf.servicio.FijacionAService;
import com.cjm.spf.servicio.DomAgresorService;
import com.cjm.spf.servicio.PerfilAgresorService;
import com.cjm.spf.servicio.FactorRiesgoService;
import com.cjm.spf.servicio.ServiciosBrindadosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
	
	@Autowired
	ExpedienteDao expedienteDao;
	
	@Autowired
	DatosAgresorDao agresorDao;
	
	@Autowired
	private FactorRiesgoService fRiesgoService;

    @Autowired
    private RegistroService registroService;

    @Autowired
    private ExpedienteService expedienteService;
    
    @Autowired
    private NarracionService narracionService;
    
    @Autowired
    private RFamiliaresService familiaresService;
    
    @Autowired
    private RedApoyoService apoyoService;
    
    @Autowired
    private eViolenciaService violenciaService;
    
    @Autowired
    private SaludService saludService;
    
    @Autowired
    private FijacionAService fijacionService;
    
    @Autowired
    private AgresorService agresorService;
    
    @Autowired
    private DomAgresorService domService;
    
    @Autowired
    private PerfilAgresorService perfilAService;
    
    @Autowired
    private ServiciosBrindadosService serviciosService;
    

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        return "index";
    }

    @GetMapping("/crear")
    public String crear(NuevoUsuario usuario) {
        return "crear";
    }

    @GetMapping("/registrar")
    public String registro(Registro registro) {
        return "registro";
    }

    @GetMapping("/verRegistros")
    public String visualizar(Model model) {
        List<Registro> registros = registroService.listarRegistros();
        model.addAttribute("registros", registros);
        System.out.println(registros);
        return "verUsuarias";
    }

    @GetMapping("/formato")
    public String ejemplo(Registro registro) {
        return "ejemplo";
    }
    
    @GetMapping("/ver/{id}")
    public String editar(Registro registro, Model model) {
        registro = registroService.encontrarRegistro(registro);
        model.addAttribute("registros", registro);
        return "infoUsuaria";
    }

    @GetMapping("/abrirExpediente/{id}")
    public String expediente(Registro registro, Model model) {
        registro = registroService.encontrarRegistro(registro);
        model.addAttribute("registros", registro);
        return "expediente";
    }
    
    
    
    //////////////////////////////////////////////////////		POST		///////////////////////////////////////////////

    @PostMapping("/guardar")//Guardar registro de nueva usuaria
    public String guardar(@Valid Registro registro, Errors errores, Expediente expediente) {
        if (errores.hasErrors()) {
            return "registro";
        } else {
            String servicio = registro.getMotivo_visita();
            if ("expediente".equals(servicio)) {
                registroService.guardar(registro);
                return "expediente";
            } else {
                registroService.guardar(registro);
                return "redirect:/";
            }
        }
    }

    @PostMapping("/buscar")																	//Buscar usuaria existente
    public String encontrarUsuaria(String nombre, Model model) {
        Registro datos = registroService.encontrarUsuaria(nombre);
        model.addAttribute("registros", datos);
        System.out.println(datos);
        return "index";

    }

    @PostMapping("/guardarUsuario")															//guardar nuevo admin
    public String guardar(@Valid NuevoUsuario usuario, Errors errores) {
        if (errores.hasErrors()) {
            return "crear";
        }
        return "redirect:/";
    }

    @PostMapping("/crearExpediente")														//Crear nuevo expediente
    public String guardar(@Valid Expediente expediente, Errors errores, Model model, RFamiliares familiares) {
        if (errores.hasErrors()) {
            return "expediente";
        }
        model.addAttribute("familiares", familiares);
        expedienteService.guardar(expediente);
        return "familiares";
    }
    
    @PostMapping("/crear_relaciones_familiares")											//Crear relaciones familiares
    public String guardar(@Valid RFamiliares familiares, Errors errores, Model model, RedApoyo apoyo) {
        if (errores.hasErrors()) {
            return "familiares";
        }
        model.addAttribute("apoyo", apoyo);
        familiaresService.guardar(familiares);
        return "red_apoyo";
    }
    
    @PostMapping("/crear_red_apoyo")														//Crear red de apoyo
    public String guardar(@Valid RedApoyo apoyo, Errors errores, Narracion narracion) {
        if (errores.hasErrors()) {
            return "red_apoyo";
        }
        apoyoService.guardar(apoyo);
        return "narracionHechos";
    }
    
    
    @PostMapping("/crearNarracion")															//Crear nueva narracion
    public String guardar(@Valid Narracion narracion, Errors errores, EfectosViolencia violencia, Model model) {
        if (errores.hasErrors()) {
            return "narracionHechos";
        }
        model.addAttribute("violencia", violencia);
        narracionService.guardar(narracion);
        return "efectos_violencia";
    }
    
    @PostMapping("/crearEfectos")															//Crear nueva narracion
    public String guardar(@Valid EfectosViolencia violencia, Errors errores, SaludFisica salud, Model model) {
        if (errores.hasErrors()) {
            return "efectos_violencia";
        }
        model.addAttribute("salud", salud);
        violenciaService.guardar(violencia);
        return "Salud";
    }
    
    @PostMapping("/salud")																	//Crear nueva narracion
    public String guardar(@Valid SaludFisica salud, Errors errores, Filiacion filiacion ) {
        if (errores.hasErrors()) {
            return "Salud";
        }
        saludService.guardar(salud);
        return "Filiacion";
    }
    
    @PostMapping("/crear_filiacion")														//Crear nueva narracion
    public String guardar(@Valid Filiacion filiacion, Errors errores, Agresor agresor, Model model, Expediente expediente) {
        if (errores.hasErrors()) {
            return "Filiacion";
        }
        expediente = expedienteDao.findTopByOrderByIdDesc();
        filiacion.setId_perfil(expediente.getId());
        model.addAttribute("agresor", agresor);
        fijacionService.guardar(filiacion);
        return "DatosAgresor";
    }

    @PostMapping("/datos_agresor")															//Crear nueva narracion
    public String guardar(@Valid Agresor agresor, Errors errores, DomicilioAgresor domAgresor, Model model ) {
        if (errores.hasErrors()) {
            return "DatosAgresor";
        }
        model.addAttribute("domAgresor", domAgresor);
        agresorService.guardar(agresor);
        return "DomicilioAgresor";
    }
    
    @PostMapping("/domicilio_agresor")														//Crear nueva narracion
    public String guardar(@Valid DomicilioAgresor domAgresor, Errors errores, PerfilAgresor pAgresor, Model model ) {
        if (errores.hasErrors()) {
            return "DomicilioAgresor";
        }
        domService.guardar(domAgresor);
        model.addAttribute("pAgresor", pAgresor);
        return "PerfilAgresor";
    }
    
    @PostMapping("/perfil_agresor")															//Crear nueva narracion
    public String guardar(@Valid PerfilAgresor pAgresor, Errors errores, Filiacion filiacion) {
        if (errores.hasErrors()) {
            return "PerfilAgresor";
        }
        perfilAService.guardar(pAgresor);
        return "FiliacionAgresor";
    }
    
    
    @PostMapping("/filiacion_agresor")														//Crear filiacion del agresor
    public String guardar(@Valid Filiacion filiacion, Errors errores, Agresor agresor, Model model, FactorRiesgo fRiesgo) {
        if (errores.hasErrors()) {
            return "FiliacionAgresor";
        }
        agresor = agresorDao.findTopByOrderByIdDesc();
        filiacion.setId_perfil(agresor.getId());
        fijacionService.guardar(filiacion);
        model.addAttribute("fRiesgo", fRiesgo);
        return "factor_riesgo";
    }
    
    @PostMapping("/factor_riesgo")															//Crear factores de riesgo
    public String guardar(@Valid FactorRiesgo fRiesgo, Errors errores, ServiciosBrindados servicios) {
        if (errores.hasErrors()) {
            return "factor_riesgo";
        }
        fRiesgoService.guardar(fRiesgo);
        return "serviciosBrindados";
    }
    
    @PostMapping("/servicios_brindados")													//Registrar servicios brindados
    public String guardar(@Valid ServiciosBrindados servicios, Errors errores) {
        if (errores.hasErrors()) {
            return "serviciosBrindados";
        }
        serviciosService.guardar(servicios);
        return "redirect:/";
    }
    
    /*
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }*/
}
