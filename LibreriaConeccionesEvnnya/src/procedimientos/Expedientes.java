/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import conecciones.Pruebas_coneccion_evnnya;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahir
 */
public class Expedientes {
    
    //AGREGAR EXPEDIENTE
    public void agregarExpediente(Connection con, String numero_expedinte, int tipo_documento, String fecha_creacion,
                                String hora_creacion, int id_usuario_recibio, String numero_oficio,
                                String fecha_oficio, String quien_envia_oficio, String medio_reporte,
                                int anonimato, int id_custodia, String resenia_situacion,
                                String observacion_situacion, String lugar_receptor, int id_usuario_asesor,
                                String fecha_asignacion_asesor, String etapa_actual){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarExpediente(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?)}");
            
            pstmt.setString(1, numero_expedinte);
            pstmt.setInt(2, tipo_documento);
            pstmt.setString(3, fecha_creacion);
            pstmt.setString(4, hora_creacion);
            pstmt.setInt(5, id_usuario_recibio);
            pstmt.setString(6, numero_oficio);
            pstmt.setString(7, fecha_oficio);
            pstmt.setString(8, quien_envia_oficio);
            pstmt.setString(9, medio_reporte);
            pstmt.setInt(10, anonimato);
            pstmt.setInt(11, id_custodia);
            pstmt.setString(12, resenia_situacion);
            pstmt.setString(13, observacion_situacion);
            pstmt.setString(14, lugar_receptor);
            pstmt.setInt(15, id_usuario_asesor);
            pstmt.setString(16, fecha_asignacion_asesor);
            pstmt.setString(17, etapa_actual);        
            
            pstmt.execute();
            
                System.out.println("SE AGREGO EXPEDIENTE CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
