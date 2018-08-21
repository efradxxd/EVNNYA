/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahir
 */
public class PeticionesJuridicos {
    
    //VARIABLES TRAER LISTA PETICIONOES JURIDICO
    List<String> ListaIdPeticion = new ArrayList<String>();
    List<String> ListaFechaEnvio = new ArrayList<String>();
    List<String> ListaNumeroExpediente = new ArrayList<String>();
    List<String> ListaGravedadPeticion = new ArrayList<String>();
    List<String> ListaIdFolioDocumento = new ArrayList<String>();
    List<String> ListaEstatusPeticion = new ArrayList<String>();
    
    List<String> ListaIdPeticionAux = new ArrayList<String>();
    List<String> ListaFechaEnvioAux = new ArrayList<String>();
    List<String> ListaNumeroExpedienteAux = new ArrayList<String>();
    List<String> ListaGravedadPeticionAux = new ArrayList<String>();
    List<String> ListaIdFolioDocumentoAux = new ArrayList<String>();
    List<String> ListaEstatusPeticionAux = new ArrayList<String>();
    
    //TRAER NOMBRES DE VICTIMAS CON EXPEDIENTE
    public void seleccionarListaPeticionesJuridico(Connection con, int id_receptor) {

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarListaPeticionesJuridico('" + id_receptor + "')}");

            ListaIdPeticionAux.clear();
            ListaFechaEnvioAux.clear();
            ListaNumeroExpedienteAux.clear();
            ListaGravedadPeticionAux.clear();
            ListaIdFolioDocumentoAux.clear();
            ListaEstatusPeticionAux.clear();
            
            while(rs.next()) {

                ListaIdPeticionAux.add(String.valueOf(rs.getInt(1)));
                ListaFechaEnvioAux.add(rs.getString(2));
                ListaNumeroExpedienteAux.add(rs.getString(3));
                ListaGravedadPeticionAux.add(String.valueOf(rs.getInt(4)));
                ListaIdFolioDocumentoAux.add(String.valueOf(rs.getInt(5)));
                ListaEstatusPeticionAux.add(String.valueOf(rs.getInt(6)));

            }
            
            setListaIdPeticion(ListaIdPeticionAux);
            setListaFechaEnvio(ListaFechaEnvioAux);
            setListaNumeroExpediente(ListaNumeroExpedienteAux);
            setListaGravedadPeticion(ListaGravedadPeticionAux);
            setListaIdFolioDocumento(ListaIdFolioDocumentoAux);
            setListaEstatusPeticion(ListaEstatusPeticionAux);

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

    public List<String> getListaNumeroExpediente() {
        return ListaNumeroExpediente;
    }

    public void setListaNumeroExpediente(List<String> ListaNumeroExpediente) {
        this.ListaNumeroExpediente = ListaNumeroExpediente;
    }

    public List<String> getListaGravedadPeticion() {
        return ListaGravedadPeticion;
    }

    public void setListaGravedadPeticion(List<String> ListaGravedadPeticion) {
        this.ListaGravedadPeticion = ListaGravedadPeticion;
    }

    public List<String> getListaIdFolioDocumento() {
        return ListaIdFolioDocumento;
    }

    public void setListaIdFolioDocumento(List<String> ListaIdFolioDocumento) {
        this.ListaIdFolioDocumento = ListaIdFolioDocumento;
    }

    public List<String> getListaEstatusPeticion() {
        return ListaEstatusPeticion;
    }

    public void setListaEstatusPeticion(List<String> ListaEstatusPeticion) {
        this.ListaEstatusPeticion = ListaEstatusPeticion;
    }
    
    
    
}
