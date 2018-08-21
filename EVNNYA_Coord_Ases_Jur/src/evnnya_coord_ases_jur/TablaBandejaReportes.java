/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_coord_ases_jur;

/**
 *
 * @author jahir
 */
public class TablaBandejaReportes {
    private String numero_reporte, fecha_recepcion, nombre_victima, 
            vulneracion_derecho;

    
    public TablaBandejaReportes(String numero_reporte, String fecha_recepcion, String nombre_victima, String vulneracion_derecho) {
        this.numero_reporte = numero_reporte;
        this.fecha_recepcion = fecha_recepcion;
        this.nombre_victima = nombre_victima;
        this.vulneracion_derecho = vulneracion_derecho;
    }

    public String getNumero_reporte() {
        return numero_reporte;
    }

    public void setNumero_reporte(String numero_reporte) {
        this.numero_reporte = numero_reporte;
    }

    public String getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(String fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public String getNombre_victima() {
        return nombre_victima;
    }

    public void setNombre_victima(String nombre_victima) {
        this.nombre_victima = nombre_victima;
    }

    public String getVulneracion_derecho() {
        return vulneracion_derecho;
    }

    public void setVulneracion_derecho(String vulneracion_derecho) {
        this.vulneracion_derecho = vulneracion_derecho;
    }
    
    
    
}
