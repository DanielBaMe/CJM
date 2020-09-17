package com.cjm.spf.web;

import java.util.List;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import com.cjm.spf.domain.*;

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
    private RegistroService registroService;
    
    @Autowired
    private NuevoUsuarioService usuarioNuevo;

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

    @PostMapping("/buscar")//Buscar usuaria existente
    public String encontrarUsuaria(String nombre, Model model) {
        Registro datos = registroService.encontrarUsuaria(nombre);
        model.addAttribute("registros", datos);
        System.out.println(datos);
        return "index";

    }

    @PostMapping("/guardarUsuario")//guardar nuevo admin
    public String guardar(@Valid NuevoUsuario usuario, Errors errores) {
        if (errores.hasErrors()) {
            return "crear";
        }
        System.out.println(usuario);
        //nuevoUsuario.guardar(usuario);
        return "redirect:/";
    }

    @PostMapping("/crearExpediente")//Crear nuevo expediente
    public String guardar(@Valid Expediente expediente, Errors errores, RFamiliares familiares) {
        if (errores.hasErrors()) {
            return "expediente";
        }
        expedienteService.guardar(expediente);
        return "familiares";
    }
    
    @PostMapping("/crear_relaciones_familiares")//Crear relaciones familiares
    public String guardar(@Valid RFamiliares familiares, Errors errores, RedApoyo apoyo) {
        if (errores.hasErrors()) {
            return "familiares";
        }
        familiaresService.guardar(familiares);
        return "red_apoyo";
    }
    
    @PostMapping("/crear_red_apoyo")//Crear red de apoyo
    public String guardar(@Valid RedApoyo apoyo, Errors errores, Narracion narracion) {
        if (errores.hasErrors()) {
            return "apoyo";
        }
        apoyoService.guardar(apoyo);
        return "narracionHechos";
    }
    
    
    @PostMapping("/crearNarracion")//Crear nueva narracion
    public String guardar(@Valid Narracion narracion, Errors errores, EfectosViolencia violencia) {
        if (errores.hasErrors()) {
            return "narracionHechos";
        }
        narracionService.guardar(narracion);
        return "efectos_violencia";
    }
    
    @PostMapping("/crearEfectos")//Crear nueva narracion
    public String guardar(@Valid EfectosViolencia violencia, Errors errores, SaludFisica salud) {
        if (errores.hasErrors()) {
            return "efectos_violencia";
        }
        violenciaService.guardar(violencia);
        return "Salud";
    }
    
    @PostMapping("/salud")//Crear nueva narracion
    public String guardar(@Valid SaludFisica salud, Errors errores, Filiacion filiacion ) {
        if (errores.hasErrors()) {
            return "Salud";
        }
        saludService.guardar(salud);
        return "Filiacion";
    }
    
    @PostMapping("/crear_filiacion")//Crear nueva narracion
    public String guardar(@Valid Filiacion filiacion, Errors errores, Agresor agresor ) {
        if (errores.hasErrors()) {
            return "Filiacion";
        }
        fijacionService.guardar(filiacion);
        return "DatosAgresor";
    }

    @PostMapping("/agresor")//Crear nueva narracion
    public String guardar(@Valid Agresor agresor, Errors errores, DomicilioAgresor domAgresor ) {
        if (errores.hasErrors()) {
            return "DatosAgresor";
        }
        agresorService.guardar(agresor);
        return "DomicilioAgresor";
    }
    
    @PostMapping("/domicilio_agresor")//Crear nueva narracion
    public String guardar(@Valid DomicilioAgresor domAgresor, Errors errores, PerfilAgresor pAgresor ) {
        if (errores.hasErrors()) {
            return "DomicilioAgresor";
        }
        domService.guardar(domAgresor);
        return "PerfilAgresor";
    }
    
    @PostMapping("/perfil_agresor")//Crear nueva narracion
    public String guardar(@Valid PerfilAgresor pAgresor, Errors errores, Filiacion filiacion) {
        if (errores.hasErrors()) {
            return "PerfilAgresor";
        }
        perfilAService.guardar(pAgresor);
        return "Filiacion";
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
