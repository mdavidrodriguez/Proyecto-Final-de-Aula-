package entidades;

public class RegistroR extends RegistroP {

    private String ciudad;
    private String pais;
    private int NumVivienda;

    public RegistroR() {
    }

    public RegistroR(String ciudad, String pais, int NumVivienda, int numPaquete, int dia, int mes, int ano, String nombre, String CalleYCarrera, String telefono) {
        super(numPaquete, dia, mes, ano, nombre, CalleYCarrera, telefono);
        this.ciudad = ciudad;
        this.pais = pais;
        this.NumVivienda = NumVivienda;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the NumVivienda
     */
    public int getNumVivienda() {
        return NumVivienda;
    }

    /**
     * @param NumVivienda the NumVivienda to set
     */
    public void setNumVivienda(int NumVivienda) {
        this.NumVivienda = NumVivienda;
    }

    public String getDatosArchivoRemitente() {
        return super.getDatosArchivoRegistro()+";"+this.pais + ";" + this.ciudad + ";" + this.NumVivienda;
    }
}
