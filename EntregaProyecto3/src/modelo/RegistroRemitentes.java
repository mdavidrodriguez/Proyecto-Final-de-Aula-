package modelo;

import datos.ArchivoRemitentes;
import entidades.RegistroR;
import java.io.IOException;
import java.util.List;

public class RegistroRemitentes {

    private ArchivoRemitentes datos;
    
    public RegistroRemitentes() {
        this.datos = new ArchivoRemitentes();
        
    }
    
    public ArchivoRemitentes getDatos() {
        return datos;
    }
    
    public void setDatos(ArchivoRemitentes datos) {
        this.datos = datos;
    }

    public boolean registrar(RegistroR r) throws IOException {
        return this.datos.escribir(r);
    }
    
    public List<RegistroR> leer() throws IOException {
        return this.datos.leer();
    }
    
    public RegistroR eliminar(String nombre) throws IOException {
        return this.datos.eliminar(nombre);
    }
    
    public RegistroR buscar(String nombre) throws IOException {
        return this.datos.buscar(nombre);
    }
    
}
