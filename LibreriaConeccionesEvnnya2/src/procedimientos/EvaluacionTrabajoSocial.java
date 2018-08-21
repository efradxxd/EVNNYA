/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import conecciones.Pruebas_coneccion_evnnya;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahir
 */
public class EvaluacionTrabajoSocial {

    //AGREGAR EVALUACION TS
    public void agregarEvaluacionTS(Connection con, String numero_expediente, int id_trabajador_social, String fecha_visita,
            String hora_visita, String fecha_alta, String hora_alta, int id_custodia,
            int tipo_valoracion,
            String tecnicas_utilizadas,
            String dinamica_familiar,
            int id_archivo_familiograma,
            int vivienda,
            int tipo_vivienda,
            int zona_vivienda,
            int sala,
            int comedor,
            int cocina,
            int banio,
            int habitaciones,
            int recamaras,
            int hacinamiento,
            String material_piso,
            String material_muro,
            String material_techo,
            String servicios_publicos,
            String antecedentes_problema,
            String entrevista_nnya,
            String diagnostico_social,
            String plan_accion,
            String observaviones,
            int id_peticion,
            int id_reporte
    ) {

        try {
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarEvaluacionTrabajoSocial(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,?,?)}");

            pstmt.setString(1, numero_expediente);
            pstmt.setInt(2, id_trabajador_social);
            pstmt.setString(3, fecha_visita);
            pstmt.setString(4, hora_visita);
            pstmt.setString(5, fecha_alta);
            pstmt.setString(6, hora_alta);
            pstmt.setInt(7, id_custodia);
            pstmt.setInt(8, tipo_valoracion);
            pstmt.setString(9, tecnicas_utilizadas);
            pstmt.setString(10, dinamica_familiar);
            pstmt.setInt(11, id_archivo_familiograma);
            pstmt.setInt(12, vivienda);
            pstmt.setInt(13, tipo_vivienda);
            pstmt.setInt(14, zona_vivienda);
            pstmt.setInt(15, sala);
            pstmt.setInt(16, comedor);
            pstmt.setInt(17, cocina);
            pstmt.setInt(18, banio);
            pstmt.setInt(19, habitaciones);
            pstmt.setInt(20, recamaras);
            pstmt.setInt(21, hacinamiento);
            pstmt.setString(22, material_piso);
            pstmt.setString(23, material_muro);
            pstmt.setString(24, material_techo);
            pstmt.setString(25, servicios_publicos);
            pstmt.setString(26, antecedentes_problema);
            pstmt.setString(27, entrevista_nnya);
            pstmt.setString(28, diagnostico_social);
            pstmt.setString(29, plan_accion);
            pstmt.setString(30, observaviones);
            pstmt.setInt(31, id_peticion);
            pstmt.setInt(32, id_reporte);

            pstmt.execute();

            System.out.println("SE AGREGO LA EVALUACION TS CORRECTAMENTE");

            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluacionTrabajoSocial.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //SELECCIONAR ULTIMO REPORTE
    public int seleccionarUltimoEvaluacionTS(Connection con) {

        int id_evaluacion = 0;

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarUltimoEvaluacionTS()}");

            if (rs.next()) {

                id_evaluacion = (rs.getInt(1));

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(EvaluacionMedico.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id_evaluacion;
    }

}
