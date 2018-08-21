package evnnya_ts;

public class BuscarAnexo {
    private String folio,numeroExpediente,fecha;

    public BuscarAnexo(String folio, String numeroExpediente, String fecha) {
        this.folio = folio;
        this.numeroExpediente = numeroExpediente;
        this.fecha = fecha;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
