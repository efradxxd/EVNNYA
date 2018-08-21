/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_medico;

/**
 *
 * @author nivec
 */
public class EntradaMedico {
    
    
    private  String fecha,gravedad,nombre,folioP;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFolioP() {
        return folioP;
    }

    public void setFolioP(String folioP) {
        this.folioP = folioP;
    }

    public EntradaMedico(String fecha, String gravedad, String nombre, String folioP) {
        this.fecha = fecha;
        this.gravedad = gravedad;
        this.nombre = nombre;
        this.folioP = folioP;
    }
    
    
    
}
