/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import conecciones.Pruebas_coneccion_evnnya;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahir
 */
public class EvaluacionTrabajoSocial {
    
    //AGREGAR EVALUACION TS
    public void agregarEvaluacionTS(Connection con, int id_evaluacion, String numero_expedinte, int id_trabajador_social, String fecha_visita, String hora_visita,
                                    String fecha_alta, String hora_alta, int id_paciente_victima, int id_paciente_custodia, int id_paciente_agresor, String nombre_paciente,
                                    String apellido_paterno_paciente, String apellido_materno_paciente, String fecha_nacimiento, String lugar_nacimiento,
                                    String nacionalidad, String sexo, String idioma, String grupo_etnico, String religion, String discapacidad, String tipo_discapacidad,
                                    String escolaridad, int id_direccion, int id_custodia, int tipo_valoracion, String tecnicas_utilizadas, String dinamica_familiar,
                                    int id_archivo_familiograma, int vivienda, int tipo_vivienda, int zona_vivienda, int sala, int comedor, int cocina, int banio,
                                    int habitaciones, int recamaras, int hacinamiento, String material_piso, String material_muro, String material_techo,
                                    String servicios_publicos, String antecedentes_problema, String entrevista_nnya, String diagnostico_social, String plan_accion,
                                    String observaciones){
            
        try {
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarEvaluacionTS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            pstmt.setInt(1, id_evaluacion);
            pstmt.setString(2, numero_expedinte);
            pstmt.setInt(3, id_trabajador_social);
            pstmt.setString(4, fecha_visita);
            pstmt.setString(5, hora_visita);
            pstmt.setString(6, fecha_alta);
            pstmt.setString(7, hora_alta);
            pstmt.setInt(8, id_paciente_victima);
            pstmt.setInt(9, id_paciente_custodia);
            pstmt.setInt(10, id_paciente_agresor);
            pstmt.setString(11, nombre_paciente);
            pstmt.setString(12, apellido_paterno_paciente);
            pstmt.setString(13, apellido_materno_paciente);
            pstmt.setString(14, fecha_nacimiento);
            pstmt.setString(15, lugar_nacimiento);
            pstmt.setString(16, nacionalidad);
            pstmt.setString(17, sexo);
            pstmt.setString(18, idioma);
            pstmt.setString(19, grupo_etnico);
            pstmt.setString(20, religion);
            pstmt.setString(21, discapacidad);
            pstmt.setString(22, tipo_discapacidad);
            pstmt.setString(23, escolaridad);
            pstmt.setInt(24, id_direccion);
            pstmt.setInt(25, id_custodia);
            pstmt.setInt(26, tipo_valoracion);
            pstmt.setString(27, tecnicas_utilizadas);
            pstmt.setString(28, dinamica_familiar);
            pstmt.setInt(29, id_archivo_familiograma);
            pstmt.setInt(30, vivienda);
            pstmt.setInt(31, tipo_vivienda);
            pstmt.setInt(32, zona_vivienda);
            pstmt.setInt(33, sala);
            pstmt.setInt(34, comedor);
            pstmt.setInt(35, cocina);
            pstmt.setInt(36, banio);
            pstmt.setInt(37, habitaciones);
            pstmt.setInt(38, recamaras);
            pstmt.setInt(39, hacinamiento);
            pstmt.setString(40, material_piso);
            pstmt.setString(41, material_muro);
            pstmt.setString(42, material_techo);
            pstmt.setString(43, servicios_publicos);
            pstmt.setString(44, antecedentes_problema);
            pstmt.setString(45, entrevista_nnya);
            pstmt.setString(46, diagnostico_social);
            pstmt.setString(47, plan_accion);
            pstmt.setString(48, observaciones);
            
            
            
            pstmt.execute();
            
            System.out.println("SE REALIZO LA EVALUACION TS CORRECTAMENTE");
            
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluacionTrabajoSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
