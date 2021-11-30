package entidades;

public class RegistroD extends RegistroP {

    private int CodPostal;
    private int NumVivienda;

    public RegistroD() {
    }

    public RegistroD(int CodPostal, int NumVivienda, int numPaquete, int dia, int mes, int ano, String nombre, String CalleYCarrera, String telefono) {
        super(numPaquete, dia, mes, ano, nombre, CalleYCarrera, telefono);
        this.CodPostal = CodPostal;
        this.NumVivienda = NumVivienda;
    }

    /**
     * @return the CodPostal
     */
    public int getCodPostal() {
        return CodPostal;
    }

    /**
     * @param CodPostal the CodPostal to set
     */
    public void setCodPostal(int CodPostal) {
        this.CodPostal = CodPostal;
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

    public String getDatosArchivoDestinatario() {
        return super.getDatosArchivoRegistro() + ";" + this.CodPostal + ";" + this.NumVivienda;
    }

}
