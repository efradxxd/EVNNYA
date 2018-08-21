/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_ts;

/**
 *
 * @author str4ng3r
 */
public class BuscarPeticion {
    private String folioPeticion,numeroExpediente,fecha,estatus;

    public BuscarPeticion(String folioPeticion, String numeroExpediente, String fecha, String estatus) {
        this.folioPeticion = folioPeticion;
        this.numeroExpediente = numeroExpediente;
        this.fecha = fecha;
        this.estatus = estatus;
    }

    public String getFolioPeticion() {
        return folioPeticion;
    }

    public void setFolioPeticion(String folioPeticion) {
        this.folioPeticion = folioPeticion;
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

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
