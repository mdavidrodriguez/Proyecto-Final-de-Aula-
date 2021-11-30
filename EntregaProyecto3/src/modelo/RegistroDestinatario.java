
package modelo;

import datos.ArchivoDestinatarios;
import entidades.RegistroD;
import java.io.IOException;
import java.util.List;


public class RegistroDestinatario {
    private ArchivoDestinatarios datos;
    
    public RegistroDestinatario(){
        this.datos = new ArchivoDestinatarios();
    }
     public ArchivoDestinatarios getDatos() {
        return datos;
    }

    public void setDatos(ArchivoDestinatarios datos) {
        this.datos = datos;
    }

    public boolean registrar(RegistroD rd) throws IOException {
        return this.datos.escribir(rd);
    }
    
    public List<RegistroD> leer() throws IOException {
        return this.datos.leer();
    }
    
    public RegistroD eliminar(String nombre) throws IOException {
        return this.datos.eliminar(nombre);
    }
    
    public RegistroD buscar(String nombre) throws IOException {
        return this.datos.buscar(nombre);
    }
}
