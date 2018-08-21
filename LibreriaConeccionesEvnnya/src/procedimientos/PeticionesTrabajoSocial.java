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

/**
 *
 * @author jahir
 */
public class PeticionesTrabajoSocial {
    
    //VARIABLES TRAER BANDEJA ENTRADA
    List<String> ListaIdPeticion = new ArrayList<String>();
    List<String> ListaFechaEnvio = new ArrayList<String>();
    List<String> ListaIdDomicilio = new ArrayList<String>();
    List<String> ListaDireccionCompleta = new ArrayList<String>();
    List<String> ListaNumeroExpediente = new ArrayList<String>();
    List<String> ListaFolio = new ArrayList<String>();
    List<String> ListaEstatus = new ArrayList<String>();
    
    List<String> ListaIdPeticionAux = new ArrayList<String>();
    List<String> ListaFechaEnvioAux = new ArrayList<String>();
    List<String> ListaIdDomicilioAux = new ArrayList<String>();
    List<String> ListaDireccionCompletaAux = new ArrayList<String>();
    List<String> ListaNumeroExpedienteAux = new ArrayList<String>();
    List<String> ListaFolioAux = new ArrayList<String>();
    List<String> ListaEstatusAux = new ArrayList<String>();
    
    //VARIABLES PARA TRAER VISITA DOMICILIARIA
    String id_peticion;
    String fecha_envio;
    String fecha_maxima_visita;
    String id_emisor;
    String id_coordinador;
    String id_receptor;
    String numero_expediente;
    String gravedad_peticion;
    String descripcion;
    String apertura_mensaje;
    String fecha_apertura;
    String id_domicilio;
    String estatus_peticion;
    String id_persona_visita;
    String tipo_persona_visita;
    
    //VARIABLES TRAER EXPEDIENTE POR ID_PETICION
    String expediente_desde_id;
    
    public void agregarPeticionTrabajoSocial(Connection con, String fecha_envio, String fecha_maxima_visita, int id_emisor,
                                      int id_coordinar, int id_receptor, String numero_expediente,
                                      int gravedad_peticion, String peticion, int apertura_mensaje,
                                      String fechaAperura, int id_domicilio, String estatus_peticion,
                                      int id_persona_visita, String tipo_persona_visita){
        try {
                                                                                            //14
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarPeticionTrabajoSocial(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            pstmt.setString(1, fecha_envio);
            pstmt.setString(2, fecha_maxima_visita);
            pstmt.setInt(3, id_emisor);
            pstmt.setInt(4, id_coordinar);
            pstmt.setInt(5, id_receptor);
            pstmt.setString(6, numero_expediente);
            pstmt.setInt(7, gravedad_peticion);
            pstmt.setString(8, peticion);
            pstmt.setInt(9, apertura_mensaje);
            pstmt.setString(10, fechaAperura);
            pstmt.setInt(11, id_domicilio);
            pstmt.setString(12, estatus_peticion);
            pstmt.setInt(13, id_persona_visita);
            pstmt.setString(14, tipo_persona_visita);
            
            pstmt.execute();
            
            System.out.println("SE AGREGO CORRECTAMENTE :v Pablo");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
           
    }
    
    
    public void seleccionarBandejaPeticionesTS(Connection con){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarPeticionesTS()}");
            Statement stmt2 = con.createStatement();
            
            ListaIdPeticionAux.clear();
            ListaFechaEnvioAux.clear();
            ListaIdDomicilioAux.clear();
            ListaDireccionCompletaAux.clear();
            ListaNumeroExpedienteAux.clear();
            ListaFolioAux.clear();
            ListaEstatusAux.clear();
            
            while(rs.next()){
                
                ListaIdPeticionAux.add(String.valueOf(rs.getInt(1)));
                ListaFechaEnvioAux.add(rs.getString(2));
                ListaIdDomicilioAux.add(String.valueOf(rs.getInt(3)));
                ListaNumeroExpedienteAux.add(rs.getString(4));
                ListaFolioAux.add(String.valueOf(rs.getInt(5)));
                ListaEstatusAux.add(rs.getString(6));
                
                 
                 ResultSet rs2 = stmt2.executeQuery("{Call dbo.SeleccionarDireccion("+rs.getInt(3)+")}");
                 
                    if(rs2.next()){
                
                        ListaDireccionCompletaAux.add(rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getString(4)+", " + rs2.getString(8));
                
                    }
                
            }
            
            setListaIdPeticion(ListaIdPeticionAux);
            setListaFechaEnvio(ListaFechaEnvioAux);
            setListaIdDomicilio(ListaIdDomicilioAux);
            setListaDireccionCompleta(ListaDireccionCompletaAux);
            setListaNumeroExpediente(ListaNumeroExpedienteAux);
            setListaFolio(ListaFolioAux);
            setListaEstatus(ListaEstatusAux);
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //SELECCIONAR VISITA DOMICILIARIA // POR MEDIO DE FOLIO
    public void seleccionarVisitaDomiciliaria(Connection con, int folio){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarVisitaDomiciliaria("+folio+")}");
            
            if(rs.next()){
                
                setId_peticion(String.valueOf(rs.getInt(1)));
                setFecha_envio(rs.getString(2));
                setFecha_maxima_visita(rs.getString(3));
                setId_emisor(String.valueOf(rs.getInt(4)));
                setId_coordinador(String.valueOf(rs.getInt(5)));
                setId_receptor(String.valueOf(rs.getInt(6)));
                setNumero_expediente(rs.getString(7));
                setGravedad_peticion(rs.getString(8));
                setDescripcion(rs.getString(9));
                setApertura_mensaje(String.valueOf(rs.getInt(10)));
                setFecha_apertura(rs.getString(11));
                setId_domicilio(String.valueOf(rs.getInt(12)));
                setEstatus_peticion(rs.getString(13));
                setId_persona_visita(String.valueOf(rs.getString(14)));
                setTipo_persona_visita(rs.getString(15));
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //ACTUALIZAR ESTATUS DE PETICION
    public void actualizarEstatusPeticion(Connection con, String estatus_peticion, int id_peticion){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarEstatusPeticionesTS(?,?)}");
            
            pstmt.setString(1, estatus_peticion);
            pstmt.setInt(2, id_peticion);
            
            pstmt.execute();
            
                System.out.println("SE MODIFICO ESTATUS PETICION CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //TRAER EXPEDIENTE DESDE ID_PETICION
    public void seleccionarExpediente(Connection con, int id_reporte){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarEsxpedientePeticionTS("+id_reporte+")}");
            
            if(rs.next()){
                
                setExpediente_desde_id(rs.getString(1));
                
            }
            
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

    public List<String> getListaIdDomicilio() {
        return ListaIdDomicilio;
    }

    public void setListaIdDomicilio(List<String> ListaIdDomicilio) {
        this.ListaIdDomicilio = ListaIdDomicilio;
    }

    public List<String> getListaDireccionCompleta() {
        return ListaDireccionCompleta;
    }

    public void setListaDireccionCompleta(List<String> ListaDireccionCompleta) {
        this.ListaDireccionCompleta = ListaDireccionCompleta;
    }

    public List<String> getListaNumeroExpediente() {
        return ListaNumeroExpediente;
    }

    public void setListaNumeroExpediente(List<String> ListaNumeroExpediente) {
        this.ListaNumeroExpediente = ListaNumeroExpediente;
    }

    public List<String> getListaFolio() {
        return ListaFolio;
    }

    public void setListaFolio(List<String> ListaFolio) {
        this.ListaFolio = ListaFolio;
    }

    public List<String> getListaEstatus() {
        return ListaEstatus;
    }

    public void setListaEstatus(List<String> ListaEstatus) {
        this.ListaEstatus = ListaEstatus;
    }
    
    

    public String getId_peticion() {
        return id_peticion;
    }

    public void setId_peticion(String id_peticion) {
        this.id_peticion = id_peticion;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getFecha_maxima_visita() {
        return fecha_maxima_visita;
    }

    public void setFecha_maxima_visita(String fecha_maxima_visita) {
        this.fecha_maxima_visita = fecha_maxima_visita;
    }

    public String getId_emisor() {
        return id_emisor;
    }

    public void setId_emisor(String id_emisor) {
        this.id_emisor = id_emisor;
    }

    public String getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(String id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getId_receptor() {
        return id_receptor;
    }

    public void setId_receptor(String id_receptor) {
        this.id_receptor = id_receptor;
    }

    public String getNumero_expediente() {
        return numero_expediente;
    }

    public void setNumero_expediente(String numero_expediente) {
        this.numero_expediente = numero_expediente;
    }

    public String getGravedad_peticion() {
        return gravedad_peticion;
    }

    public void setGravedad_peticion(String gravedad_peticion) {
        this.gravedad_peticion = gravedad_peticion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getApertura_mensaje() {
        return apertura_mensaje;
    }

    public void setApertura_mensaje(String apertura_mensaje) {
        this.apertura_mensaje = apertura_mensaje;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public String getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(String id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getEstatus_peticion() {
        return estatus_peticion;
    }

    public void setEstatus_peticion(String estatus_peticion) {
        this.estatus_peticion = estatus_peticion;
    }

    public String getId_persona_visita() {
        return id_persona_visita;
    }

    public void setId_persona_visita(String id_persona_visita) {
        this.id_persona_visita = id_persona_visita;
    }

    public String getTipo_persona_visita() {
        return tipo_persona_visita;
    }

    public void setTipo_persona_visita(String tipo_persona_visita) {
        this.tipo_persona_visita = tipo_persona_visita;
    }

    public String getExpediente_desde_id() {
        return expediente_desde_id;
    }

    public void setExpediente_desde_id(String expediente_desde_id) {
        this.expediente_desde_id = expediente_desde_id;
    }
    
    
    
}
