package com.cjm.spf.servicio;

import java.util.Date;
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
public class RegsitroServiceImpl implements RegistroService{
    
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
            folio.setNo_folio(id_usuaria.getId());
            folio.setId_status_folio(1);
            folio.setId_tipo_folio((long)1);
            folio.setServicio(registro.getMotivo_visita());

        }else{
            long variable = num.getId_tipo_folio() + 1;
            folio.setNo_folio(id_usuaria.getId());
            folio.setId_status_folio(1);
            folio.setId_tipo_folio(variable);
            folio.setServicio(registro.getMotivo_visita());
        }
        
        foliodao.save(folio);
    }

    @Override
    @Transactional(readOnly = true)
    public Registro encontrarRegistro(Registro registro) {
        return registrodao.findById(registro.getId()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Registro encontrarUsuaria(String nombre) throws UsernameNotFoundException{
        Registro registro = registrodao.findByNombre(nombre);
        if(registro == null){
            throw new UsernameNotFoundException(nombre);
        }
        return registro;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Registro> listarRegistros() {
        return (List<Registro>) registrodao.findAll();
    }
}
