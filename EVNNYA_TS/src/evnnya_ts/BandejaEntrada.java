/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_ts;

/**
 *
 * @author pablo
 */
public class BandejaEntrada {

    private String numeroFolio,fecha,direccion;

    public BandejaEntrada(String numeroFolio, String fecha, String direccion) {
        this.numeroFolio = numeroFolio;
        this.fecha = fecha;
        this.direccion = direccion;
    }

    public String getNumeroFolio() {
        return numeroFolio;
    }

    public void setNumeroFolio(String numeroFolio) {
        this.numeroFolio = numeroFolio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
