package com.cjm.spf.controllers;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import com.cjm.spf.domain.*;
import com.cjm.spf.dao.DatosAgresorDao;
import com.cjm.spf.dao.ExpedienteDao;
import com.cjm.spf.dao.FolioDao;
import com.cjm.spf.dao.DomicilioAgresorDao;
import com.cjm.spf.pojo.conteoTS;

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
import com.cjm.spf.servicio.ExpPsicService;
import com.cjm.spf.servicio.SegPsicService;
import com.cjm.spf.servicio.RegEmpService;
import com.cjm.spf.servicio.SegEmpoService;
import com.cjm.spf.servicio.FolioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
	
	@Autowired
	private FolioService folioService;
	
	@Autowired
	DomicilioAgresorDao domADao;
	
	@Autowired
	ExpedienteDao expedienteDao;
	
	@Autowired
	DatosAgresorDao agresorDao;
	
	@Autowired
	FolioDao folioDao;
	
	@Autowired
	private RegEmpService regEmpService;
	
	@Autowired
	private SegEmpoService segEmpService;
	
	@Autowired
	private SegPsicService seguimientoPsicService;
	
	@Autowired
	private ExpPsicService expPsicService;
	
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
    
    @GetMapping("/prueba")
    public String prueba(Model model, Expediente expediente) {
    	expediente.setUsuaria((long) 1);
    	return "index_prueba";
    }
    
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
        return "preRegistro";
    }
    
    ///////////////////////////////////////////////
    
//    @GetMapping("/preRegistro")
//    public String preRegistro(Registro registro) {
//        return "preRegistro";
//    }
    
//    @GetMapping("/expediente")
//    public String expediente(Expediente expediente, Model model) {
//    	expediente.setUsuaria((long) 1);
//        return "expediente";
//    }
    
    /////////////////////////////////////////////

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
    
//    @GetMapping("/ver/{id}")
//    public String editar(Registro registro, Model model) {
//        registro = registroService.encontrarRegistro(registro);
//        model.addAttribute("registros", registro);
//        return "infoUsuaria";
//    }
    
    @GetMapping("/perfil_usuaria/{id}")
    public String perfilusuaria(Registro registro, Model model) {
    	registro = registroService.encontrarRegistro(registro);						//Registro de primera vez de la usuaria
    	Expediente exp = expedienteService.encontrarPorId(registro.getId());		//Se busca el exp de la usuaria
    	model.addAttribute("registro", registro);									//Enviamos los datos grales de la usuaria
    	
    	if(exp != null) {	//Si existe un expediente..
    		model.addAttribute("expedienteTS", exp);								//Envio del expediente
    		RegEmpoderamiento regEmp = regEmpService.findByUsuaria(registro.getId());
			SeguimientoEmp segEmp = new SeguimientoEmp();
			segEmp.setId(registro.getId());
			List <SeguimientoEmp> seguimientoEmp = segEmpService.findSeguimientoS(segEmp.getId());
			
			if(seguimientoEmp.isEmpty()) { 											//Si no hay seguimientos en empoderamiento
				model.addAttribute("psicseguimientos", null);
				model.addAttribute("registroemp", regEmp);
			}else {																	//Cuando si hay seguimientos
				int segemp = seguimientoEmp.size();
				model.addAttribute("psicseguimientos", segemp);
				model.addAttribute("registroemp", regEmp);
			}
			
			model.addAttribute("expedienteTS", exp);
			ExpPsic expPsic = expPsicService.encontrarExpPsic(registro.getId());
			List<SeguimientoPsic> registros = seguimientoPsicService.encontrarSeguimientosDeUsuaria(registro.getId());
			
			
			if(registros.isEmpty()) {  												//Si no hay seguimientos psicologicos
				model.addAttribute("pseguimientos", null);
				model.addAttribute("pexpediente", expPsic);
			}else {																	//Cuando si los hay
				int segpsic = registros.size();
				model.addAttribute("pseguimientos", segpsic);
		        model.addAttribute("pexpediente", expPsic);
			}

			
		}else {  																	//Si no existe un expediente
			model.addAttribute("pseguimientos", null);
	        model.addAttribute("pexpediente", null);
	        model.addAttribute("expedienteTS", null);
	        model.addAttribute("psicseguimientos", null);
			model.addAttribute("registroemp", null);
		}
    	
        return "PerfilTs";
    }

    @GetMapping("/abrirExpediente/{id}")
    public String expediente(Registro registro, Model model) {
        registro = registroService.encontrarRegistro(registro);
        model.addAttribute("registros", registro);
        return "index_prueba";
    }
    
    @GetMapping("/conteoMensual")
    public String conteo(Model model) {
    	Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		int mes = localDate.getMonthValue();
		int anio = localDate.getYear();
		Long expedientes = folioService.hacerConteo("expediente",anio, mes);
		Long info = folioService.hacerConteo("informacion", anio, mes);
		Long asesoria = folioService.hacerConteo("asesoria", anio, mes);
        model.addAttribute("expedientes", expedientes);
        model.addAttribute("info", info);
        model.addAttribute("asesoria", asesoria);
        return "infMenTS";
    }
    
    @GetMapping("/registro_expediente/{id}")
    public String abrir_expediente(@PathVariable("id") Long id, Model model) {
        Folio folio = new Folio();
        Folio num = folioDao.findTopByServicioOrderByIdDesc("expediente");
        Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		folio.setDia(localDate.getDayOfMonth());
		folio.setMes(localDate.getMonthValue());
		folio.setAnio(localDate.getYear());
        if(num == null){
            folio.setUsuaria(id);
            folio.setId_status_folio(1);
            folio.setId_tipo_folio((long)1);
            folio.setServicio("expediente");
            folio.setAtencion("cjm");
        }else{
            long variable = num.getId_tipo_folio() + 1;
            folio.setUsuaria(id);
            folio.setId_status_folio(1);
            folio.setId_tipo_folio(variable);
            folio.setServicio("expediente");
            folio.setAtencion("cjm");
        }
        folioDao.save(folio);
        Expediente expediente = new Expediente();
        model.addAttribute("expediente", expediente);
        return "expediente";
    }
    
    //////////////////////////////////////////////////////		POST		///////////////////////////////////////////////

    @PostMapping("/guardar")																//Guardar registro de nueva usuaria
    public String guardar(@Valid Registro registro, Errors errores, Expediente expediente, Model model) {
        if (errores.hasErrors()) {
            return "preRegistro";
        } else {
            String servicio = registro.getMotivo_visita();
            if ("expediente".equals(servicio)) {
                registroService.guardar(registro);
                return "expediente";
            } else {
                registroService.guardar(registro);
                model.addAttribute("registrado", true);
                
                return "redirect:/";
            }
        }
    }

    @PostMapping("/buscar")																	//Buscar usuaria existente por nombre
    public String buscarPorNombre(String nombre, Model model) throws FileNotFoundException{
        List<Registro> datos = registroService.encontrarUsuaria(nombre);
        if(datos.isEmpty()) {
        	model.addAttribute("registros", null);
        }else {
        	 model.addAttribute("registros", datos);
        }
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
    
    @PostMapping("/crearEfectos")															//Crear efectos de violencia
    public String guardar(@Valid EfectosViolencia violencia, Errors errores, SaludFisica salud, Model model) {
        if (errores.hasErrors()) {
            return "efectos_violencia";
        }
        model.addAttribute("salud", salud);
        violenciaService.guardar(violencia);
        return "Salud";
    }
    
    @PostMapping("/nueva_salud")																	//Crear nuevo estado de salud
    public String guardar(@Valid SaludFisica salud, Errors errores, Filiacion filiacion, Model model ) {
        if (errores.hasErrors()) {
            return "Salud";
        }
        saludService.guardar(salud);
        model.addAttribute("filiacion", filiacion);
        return "Filiacion";
    }
    
    @PostMapping("/crear_filiacion")														//Crear nueva filiacion
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

    @PostMapping("/datos_agresor")															//Crear nuevo expediente de agresor
    public String guardar(@Valid Agresor agresor, Errors errores, DomicilioAgresor domAgresor, Model model ) {
        if (errores.hasErrors()) {
            return "DatosAgresor";
        }
        model.addAttribute("domAgresor", domAgresor);
        agresorService.guardar(agresor);
        return "DomicilioAgresor";
    }
    
    @PostMapping("/domicilio_agresor")														//Crear nuevo dom agresor
    public String guardar(@Valid DomicilioAgresor domAgresor, Errors errores, PerfilAgresor pAgresor, Model model ) {
        if (errores.hasErrors()) {
            return "DomicilioAgresor";
        }
        domService.guardar(domAgresor);
        model.addAttribute("pAgresor", pAgresor);
        return "PerfilAgresor";
    }
    
    @PostMapping("/perfil_agresor")															//Crear perfil agresor
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
    
    
}
