/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author jahir
 */
public class BandejaEntrada {
    
     private String expediente;
     private String fecha;
     private String gravedad;
    private String nombre_paciente;
    
    public BandejaEntrada(){
        
    }
    
    public BandejaEntrada(String exp, String fec, String grav, String nombre) {
        this.expediente = exp;
        this.fecha = fec;
        this.gravedad = grav;
        this.nombre_paciente = nombre; //To change body of generated methods, choose Tools | Templates.
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
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

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    
    
    
}
