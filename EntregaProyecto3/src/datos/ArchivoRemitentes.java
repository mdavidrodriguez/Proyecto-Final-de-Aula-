package datos;

import entidades.RegistroR;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class ArchivoRemitentes {

    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoRemitentes() {
        this.archivo = new File("ArchivoRemitente.dat");
    }

    public ArchivoRemitentes(String name) {
        this.archivo = new File(name);
    }

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    /**
     * @return the aEscritura
     */
    public FileWriter getaEscritura() {
        return aEscritura;
    }

    /**
     * @param aEscritura the aEscritura to set
     */
    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    /**
     * @return the aLectura
     */
    public Scanner getaLectura() {
        return aLectura;
    }

    /**
     * @param aLectura the aLectura to set
     */
    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }

    public RegistroR leerRegistroR(String linea[]) {
        RegistroR r = new RegistroR();
        r.setNumPaquete(Integer.valueOf(linea[0]));
        r.setDia(Integer.valueOf(linea[1]));
        r.setMes(Integer.valueOf(linea[2]));
        r.setAno(Integer.valueOf(linea[3]));
        r.setNombre(linea[4]);
        r.setCalleYCarrera(linea[5]);
        r.setTelefono(linea[6]);
        r.setPais(linea[7]);
        r.setCiudad(linea[8]);
        r.setNumVivienda(Integer.valueOf(linea[9]));
        return r;

    }

    public List<RegistroR> leer() {
        List<RegistroR> lista = null;
        try {
            this.aLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while (this.aLectura.hasNext()) {
                String linea[] = this.aLectura.nextLine().split(";");
                RegistroR r = this.leerRegistroR(linea);
                lista.add(r);
            }
            return lista;

        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer el archivo");
            return null;
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }

    }

    public RegistroR buscar(String nombre) throws IOException {
        RegistroR buscado = null;

        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                RegistroR r = this.leerRegistroR(this.aLectura.nextLine().split(";"));
                if (r.getNombre().equals(nombre)) {
                    buscado = r;
                    break;
                }
            }
            return buscado;
        } catch (FileNotFoundException ex) {
            throw new IOException("No fue posible abrir el archivo para leer");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
    }

    public RegistroR eliminar(String nombre) throws IOException { // 123

        RegistroR eliminado = null;
        List<RegistroR> listadoRemitentes = this.leer();
        ArchivoRemitentes archivoTmp = new ArchivoRemitentes("ListadoRemitentesTmp.dat");
        for (RegistroR r : listadoRemitentes) {
            if (r.getNombre().equals(nombre)) {
                eliminado = r;
            } else {
                archivoTmp.escribir(r);
            }
        }

        if (!archivoTmp.archivo.exists()) {
            archivoTmp.archivo.createNewFile();
        }

        if (this.archivo.delete()) {
            if (archivoTmp.archivo.renameTo(this.archivo)) {
                return eliminado;
            } else {
                throw new IOException("El archivo temporal no fue renombrado");
            }

        } else {
            throw new IOException("El archivo original no fue eliminado");
        }

    }

    public boolean escribir(RegistroR r) {

        PrintWriter escritor = null;
        boolean exito = false;
        try {
            this.aEscritura = new FileWriter(this.archivo, true);
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(r.getDatosArchivoRemitente());
            exito = true;

        } catch (IOException ioe) {
            System.out.println("Error al abrir el archvio en modo escritura");
            exito = false;
        } finally {
            if (escritor != null) {
                escritor.close();
            }

            if (this.aEscritura != null) {
                try {
                    this.aEscritura.close();
                } catch (IOException io) {
                    System.out.println(io);
                }
            }

            return exito;
        }

    }
}
