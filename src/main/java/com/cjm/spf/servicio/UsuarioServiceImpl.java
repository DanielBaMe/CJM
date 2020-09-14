package com.cjm.spf.servicio;

import java.util.List;
import com.cjm.spf.dao.CrearUsuario;
import com.cjm.spf.domain.NuevoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements NuevoUsuarioService{
    
    @Autowired
    private CrearUsuario usuarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<NuevoUsuario> listarUsuarios() {
        return (List<NuevoUsuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(NuevoUsuario usuario) {
       usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(NuevoUsuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public NuevoUsuario encontrarUsuario(NuevoUsuario usuario) {
         return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }
    
}
