
package modelo;

import java.io.IOException;
import datos.ArchivoTPaquetes;
import java.util.List;
import entidades.RegistroPaquetes;

public class RegistrodePaquetes {
    private ArchivoTPaquetes datos;
    
    public RegistrodePaquetes(){
        this.datos = new ArchivoTPaquetes();
    }

    public ArchivoTPaquetes getDatos() {
        return datos;
    }

    public void setDatos(ArchivoTPaquetes datos) {
        this.datos = datos;
    }
    
     public boolean registrar(RegistroPaquetes tp) throws IOException {
        return this.datos.escribir(tp);
    }
    
    public List<RegistroPaquetes> leer() throws IOException {
        return this.datos.leer();
    }
    
    public RegistroPaquetes eliminar(String nombre) throws IOException {
        return this.datos.eliminar(nombre);
    }
    
    public RegistroPaquetes buscar(String nombre) throws IOException {
        return this.datos.buscar(nombre);
    }
}
