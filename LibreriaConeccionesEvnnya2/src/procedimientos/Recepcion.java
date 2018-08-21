/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import conecciones.Pruebas_coneccion_evnnya;

/**
 *
 * @author jahir
 */
public class Recepcion {
    //AGREGAR FICHA RECEPCION
    public void agregarFichaRecepcion(Connection con, String nombres_solicitante, String apellido_paterno_solicitante,
                                String apellido_materno_solicitante, int edad_solicitante, String ocupacion_solicitante,
                                String estado_civil_solicitante, String asesoria, String tipo_maltrato,
                                String nombres_contraparte, String apellido_paterno_contraparte,
                                String apellido_materno_contraparte, String ocupacion_contraparte,
                                int tipo_documento, String observaciones, String municipio_recibio,
                                int id_asesor_atendio, String fecha_recepcion){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarFichaRecepcion(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?,?,?,?,?,?)}");
            
            pstmt.setString(1, nombres_solicitante);
            pstmt.setString(2, apellido_paterno_solicitante);
            pstmt.setString(3, apellido_materno_solicitante);
            pstmt.setInt(4, edad_solicitante);
            pstmt.setString(5, ocupacion_solicitante);
            pstmt.setString(6, estado_civil_solicitante);
            pstmt.setString(7, asesoria);
            pstmt.setString(8, tipo_maltrato);
            pstmt.setString(9, nombres_contraparte);
            pstmt.setString(10, apellido_paterno_contraparte);
            pstmt.setString(11, apellido_materno_contraparte);
            pstmt.setString(12, ocupacion_contraparte);
            pstmt.setInt(13, tipo_documento);
            pstmt.setString(14, observaciones);
            pstmt.setString(15, municipio_recibio);
            pstmt.setInt(16, id_asesor_atendio);
            pstmt.setString(17, fecha_recepcion);
            
            pstmt.execute();
            
                System.out.println("SE AGREGO FICHA DE RECEPCION CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
}
