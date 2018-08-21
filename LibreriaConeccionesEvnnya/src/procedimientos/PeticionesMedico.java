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
public class PeticionesMedico {
    
     //VARIABLES TRAER BANDEJA ENTRADA
    List<String> ListaIdPeticion = new ArrayList<String>();
    List<String> ListaFechaEnvio = new ArrayList<String>();
    List<String> ListaGravedad = new ArrayList<String>();
    List<String> ListaNombre = new ArrayList<String>();
    
    List<String> ListaIdPeticionAux = new ArrayList<String>();
    List<String> ListaFechaEnvioAux = new ArrayList<String>();
    List<String> ListaGravedadAux = new ArrayList<String>();
    List<String> ListaNombreAux = new ArrayList<String>();
    
    
    
    //TRAER BANDEJA DE ENTRADA EVALUACION MEDICO
    public void seleccionarBandejaPeticionesMed(Connection con){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarPeticionesMedico()}");
            
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
            
            System.out.println("SE TRAJO DATOS DE LA BANDEJA MEDICO");
            
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

    public List<String> getListaIdPeticionAux() {
        return ListaIdPeticionAux;
    }

    public void setListaIdPeticionAux(List<String> ListaIdPeticionAux) {
        this.ListaIdPeticionAux = ListaIdPeticionAux;
    }

    public List<String> getListaFechaEnvioAux() {
        return ListaFechaEnvioAux;
    }

    public void setListaFechaEnvioAux(List<String> ListaFechaEnvioAux) {
        this.ListaFechaEnvioAux = ListaFechaEnvioAux;
    }

    public List<String> getListaGravedadAux() {
        return ListaGravedadAux;
    }

    public void setListaGravedadAux(List<String> ListaGravedadAux) {
        this.ListaGravedadAux = ListaGravedadAux;
    }

    public List<String> getListaNombreAux() {
        return ListaNombreAux;
    }

    public void setListaNombreAux(List<String> ListaNombreAux) {
        this.ListaNombreAux = ListaNombreAux;
    }
    
}
