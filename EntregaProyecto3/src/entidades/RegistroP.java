package entidades;

public class RegistroP {

    private int numPaquete;
    private int dia, mes, ano;
    private String nombre;
    private String CalleYCarrera;
    private String telefono;

    public RegistroP() {
    }

    public RegistroP(int numPaquete, int dia, int mes, int ano, String nombre, String CalleYCarrera, String telefono) {
        this.numPaquete = numPaquete;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.nombre = nombre;
        this.CalleYCarrera = CalleYCarrera;
        this.telefono = telefono;
    }

    /**
     * @return the numPaquete
     */
    public int getNumPaquete() {
        return numPaquete;
    }

    /**
     * @param numPaquete the numPaquete to set
     */
    public void setNumPaquete(int numPaquete) {
        this.numPaquete = numPaquete;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the CalleYCarrera
     */
    public String getCalleYCarrera() {
        return CalleYCarrera;
    }

    /**
     * @param CalleYCarrera the CalleYCarrera to set
     */
    public void setCalleYCarrera(String CalleYCarrera) {
        this.CalleYCarrera = CalleYCarrera;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDatosArchivoRegistro() {
        return this.getNumPaquete() + ";" + this.getDia() + ";" +this.getMes() + ";"
                + this.getAno()+ ";" + this.getNombre() + ";" + this.getCalleYCarrera()
                + ";" + this.getTelefono();
    }

}
