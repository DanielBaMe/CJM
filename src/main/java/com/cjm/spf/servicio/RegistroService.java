package com.cjm.spf.servicio;

import java.util.List;
import com.cjm.spf.domain.Registro;

public interface RegistroService {
    public List<Registro> listarRegistros();
    
    public void guardar(Registro registro);
    
    public Registro encontrarRegistro(Registro registro);
    
    public List<Registro> encontrarUsuaria(String nombre);
    
    public List<Registro> encontrarAPaterno(String nombre);
    
    public List<Registro> encontrarAMaterno(String nombre);
    
}
