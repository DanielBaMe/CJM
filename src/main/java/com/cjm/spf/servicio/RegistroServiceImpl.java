package com.cjm.spf.servicio;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


import com.cjm.spf.dao.RegistroDao;
import com.cjm.spf.dao.FolioDao;


import com.cjm.spf.domain.Registro;
import com.cjm.spf.domain.Folio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroServiceImpl implements RegistroService{
    
    @Autowired
    private RegistroDao registrodao;
    
    @Autowired
    private FolioDao foliodao;

    @Override
    @Transactional
    public void guardar(Registro registro) {
        Date objDate = new Date();
        registro.setFecha(objDate);
        registro.setId_status_usuaria_datos_generales(1);
        
        registrodao.save(registro);
        
        Registro id_usuaria = registrodao.findTopByOrderByIdDesc();
        Folio folio = new Folio();
        Folio num = foliodao.findTopByServicioOrderByIdDesc(registro.getMotivo_visita());
        if(num == null){
            folio.setUsuaria(id_usuaria.getId());
            folio.setId_status_folio(1);
            folio.setId_tipo_folio((long)1);
            folio.setServicio(registro.getMotivo_visita());
            folio.setAtencion(registro.getTipo_atencion());
            
        }else{
            long variable = num.getId_tipo_folio() + 1;
            folio.setUsuaria(id_usuaria.getId());
            folio.setId_status_folio(1);
            folio.setId_tipo_folio(variable);
            folio.setServicio(registro.getMotivo_visita());
            folio.setAtencion(registro.getTipo_atencion());
        }
        Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		folio.setDia(localDate.getDayOfMonth());
		folio.setMes(localDate.getMonthValue());
		folio.setAnio(localDate.getYear());
        foliodao.save(folio);
    }

    @Override
    @Transactional(readOnly = true)
    public Registro encontrarRegistro(Registro registro) {
        return registrodao.findById(registro.getId()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Registro> encontrarUsuaria(String nombre) throws UsernameNotFoundException{
        ;
        return (List<Registro>) registrodao.findByNombreContaining(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Registro> listarRegistros() {
        return (List<Registro>) registrodao.findAll();
    }

	@Override
	@Transactional(readOnly = true)
	public List<Registro> encontrarAPaterno(String apaterno) {
		return (List <Registro>) registrodao.findByPaternoContaining(apaterno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Registro> encontrarAMaterno(String amaterno) {
		
		return (List<Registro>) registrodao.findByMaternoContaining(amaterno);
	}
}
