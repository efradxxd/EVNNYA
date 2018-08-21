
package evnnya_medico;

/**
 *
 * @author nivec
 */
public class BuscarAnexo {
    
    private String folio,numeroE,fecha;

    public BuscarAnexo(String folio, String numeroE, String fecha) {
        this.folio = folio;
        this.numeroE = numeroE;
        this.fecha = fecha;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNumeroE() {
        return numeroE;
    }

    public void setNumeroE(String numeroE) {
        this.numeroE = numeroE;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    

    
    
    
    
}
