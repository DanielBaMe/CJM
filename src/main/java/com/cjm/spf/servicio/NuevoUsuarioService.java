package com.cjm.spf.servicio;

import java.util.List;
import com.cjm.spf.domain.NuevoUsuario;

public interface NuevoUsuarioService {
    
    public List<NuevoUsuario> listarUsuarios();
    
    public void guardar(NuevoUsuario usuario);
    
    public void eliminar(NuevoUsuario usuario);
    
    public NuevoUsuario encontrarUsuario(NuevoUsuario usuario);
    
}
