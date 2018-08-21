/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_psic;

/**
 *
 * @author nivec
 */
public class BandejaEntrada {
    
    private    String numeroExp="",fecha="",gravedad="",nombrePac="";


    public BandejaEntrada(String numeroExp, String fecha, String gravedad, String nombrePac) {
        this.numeroExp = numeroExp;
        this.fecha = fecha;
        this.gravedad = gravedad;
        this.nombrePac = nombrePac;
    }

    public String getNumeroExp() {
        return numeroExp;
    }

    public void setNumeroExp(String numeroExp) {
        this.numeroExp = numeroExp;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }
  

       
    
    
}
