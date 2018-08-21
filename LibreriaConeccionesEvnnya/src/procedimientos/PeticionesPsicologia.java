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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jahir
 */
public class PeticionesPsicologia {
    
    
    //VARIABLES TRAER BANDEJA ENTRADA
    List<String> ListaIdPeticion = new ArrayList<String>();
    List<String> ListaFechaEnvio = new ArrayList<String>();
    List<String> ListaGravedad = new ArrayList<String>();
    List<String> ListaNombre = new ArrayList<String>();
    
    List<String> ListaIdPeticionAux = new ArrayList<String>();
    List<String> ListaFechaEnvioAux = new ArrayList<String>();
    List<String> ListaGravedadAux = new ArrayList<String>();
    List<String> ListaNombreAux = new ArrayList<String>();
    
    //AGREGAR PETICION PSICOLOGIA
    public void agregarPeticion(Connection con, String fecha_envio, int id_emisor, int id_coordinador, int id_receptor,
                                String numero_expediente, String nombre_paciente, String apellido_paterno_paciente,
                                String apellido_materno_paciente, int gravedad_peticion, String descripcion,
                                int apertura_mensaje, String fecha_apertura, int id_paciente, String tipo_paciente,
                                String estatus_peticion) {
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarPeticionesPsicologia(?,?,?,?)}");
            
            pstmt.setString(1, fecha_envio);
            pstmt.setInt(2, id_emisor);
      
            
            pstmt.execute();
            
                System.out.println("SE AGREGO PETICION A PSICOLOGIA CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
        
    }
    
    //TRAER BANDEJA DE ENTRADA PSICOLOGIA
    public void seleccionarBandejaPeticionesPsi(Connection con){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarPeticionesPsicologia()}");
            
            ListaIdPeticionAux.clear();
            ListaFechaEnvioAux.clear();
            ListaGravedadAux.clear();
            ListaNombreAux.clear();
            
            while(rs.next()){
                
                ListaIdPeticionAux.add(String.valueOf(rs.getInt(1)));
                ListaFechaEnvioAux.add(rs.getString(2));
                ListaGravedadAux.add(String.valueOf(rs.getInt(3)));
                ListaNombreAux.add(rs.getString(4));
                
            }
            
            setListaIdPeticion(ListaIdPeticionAux);
            setListaFechaEnvio(ListaFechaEnvioAux);
            setListaGravedad(ListaGravedadAux);
            setListaNombre(ListaNombreAux);
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<String> getListaIdPeticion() {
        return ListaIdPeticion;
    }

    public void setListaIdPeticion(List<String> ListaIdPeticion) {
        this.ListaIdPeticion = ListaIdPeticion;
    }

    public List<String> getListaFechaEnvio() {
        return ListaFechaEnvio;
    }

    public void setListaFechaEnvio(List<String> ListaFechaEnvio) {
        this.ListaFechaEnvio = ListaFechaEnvio;
    }

    public List<String> getListaGravedad() {
        return ListaGravedad;
    }

    public void setListaGravedad(List<String> ListaGravedad) {
        this.ListaGravedad = ListaGravedad;
    }

    public List<String> getListaNombre() {
        return ListaNombre;
    }

    public void setListaNombre(List<String> ListaNombre) {
        this.ListaNombre = ListaNombre;
    }
    
    
    
}
