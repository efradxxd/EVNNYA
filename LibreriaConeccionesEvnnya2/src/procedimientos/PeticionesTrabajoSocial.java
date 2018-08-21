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
    String id_folio;
    String domicilio_completo;
    String delegacion_municipal;
    
    //VARIABLES TRAER EXPEDIENTE POR ID_PETICION
    String expediente_desde_id;
    
    //VARIABLES TRAER BANDEJA ENTRADA COORDI
    List<String> ListaIdPeticionCoordi = new ArrayList<String>();
    List<String> ListaNumeroGravedadCoordi = new ArrayList<String>();
    List<String> ListaIdEmisorCoordi = new ArrayList<String>();
    List<String> ListaDelegacionCoordi = new ArrayList<String>();
    List<String> ListaDireccionCompletaCoordi = new ArrayList<String>();
    
    List<String> ListaIdPeticionCoordiAux = new ArrayList<String>();
    List<String> ListaNumeroGravedadCoordiAux = new ArrayList<String>();
    List<String> ListaIdEmisorCoordiAux = new ArrayList<String>();
    List<String> ListaDelegacionCoordiAux = new ArrayList<String>();
    List<String> ListaDireccionCompletaCoordiAux = new ArrayList<String>();
    
    //VARIABLES TRAER REASIGANACION VISITAS TS
    List<String> ListaIdPeticionVisita = new ArrayList<String>();
    List<String> ListaIdPeticionVisitaVisita = new ArrayList<String>();
    List<String> ListaFechaPeticionVisita = new ArrayList<String>();
    List<String> ListaFechaReasignacionVisita = new ArrayList<String>();
    List<String> ListaNombreCompletoVisita = new ArrayList<String>();
    List<String> ListaIdNuevoTSVisita = new ArrayList<String>();
    List<String> ListaMotivoReasignacionVisita = new ArrayList<String>();
    
    List<String> ListaIdPeticionVisitaAux = new ArrayList<String>();
    List<String> ListaIdPeticionVisitaVisitaAux = new ArrayList<String>();
    List<String> ListaFechaPeticionVisitaAux = new ArrayList<String>();
    List<String> ListaFechaReasignacionVisitaAux = new ArrayList<String>();
    List<String> ListaNombreCompletoVisitaAux = new ArrayList<String>();
    List<String> ListaIdNuevoTSVisitaAux = new ArrayList<String>();
    List<String> ListaMotivoReasignacionVisitaAux = new ArrayList<String>();
    
    
    
    
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
    
    
    public void seleccionarBandejaPeticionesTS(Connection con, int id_receptor){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarPeticionesTS('"+id_receptor+"')}");
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
    
    public void seleccionarBandejaPeticionesTSCoordi(Connection con){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarPeticionesTSCoordi()}");
            Statement stmt2 = con.createStatement();
            Statement stmt3 = con.createStatement();
            
            ListaIdPeticionCoordiAux.clear();
            ListaNumeroGravedadCoordiAux.clear();
            ListaIdEmisorCoordiAux.clear();
            ListaDelegacionCoordiAux.clear();
            ListaDireccionCompletaCoordiAux.clear();
            
            while(rs.next()){
                
                ListaIdPeticionCoordiAux.add(String.valueOf(rs.getInt(1)));
                ListaNumeroGravedadCoordiAux.add(String.valueOf(rs.getInt(2)));
                
                 
                 ResultSet rs2 = stmt2.executeQuery("{Call dbo.SeleccionarDireccion("+rs.getInt(4)+")}");
                 ResultSet rs3 = stmt3.executeQuery("{Call dbo.SeleccionarUsuarioId("+rs.getInt(3)+")}");
                 
                    if(rs2.next()){
                
                        ListaDireccionCompletaCoordiAux.add(rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getString(4)+", " + rs2.getString(8));
                        ListaDelegacionCoordiAux.add(rs2.getString(8));
                        
                    }
                    
                    if(rs3.next()){
                
                        ListaIdEmisorCoordiAux.add(rs3.getString(1));
                        
                    }
                    
                    
                
            }
            
            setListaIdPeticionCoordi(ListaIdPeticionCoordiAux);
            setListaNumeroGravedadCoordi(ListaNumeroGravedadCoordiAux);
            setListaIdEmisorCoordi(ListaIdEmisorCoordiAux);
            setListaDelegacionCoordi(ListaDelegacionCoordiAux);
            setListaDireccionCompletaCoordi(ListaDireccionCompletaCoordiAux);
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //ACTUALIZAR ESTATUS DE PETICION VISITA
    public void actualizarEstatusPeticionVisita(Connection con, int id_coordinador, int id_receptor, int apertura_mensaje,
                                                String fecha_apertura, int id_peticion){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarPeticionesTSVisita(?,?,?,?,?)}");
            
            pstmt.setInt(1, id_coordinador);
            pstmt.setInt(2, id_receptor);
            pstmt.setInt(3, apertura_mensaje);
            pstmt.setString(4, fecha_apertura);
            pstmt.setInt(5, id_peticion);
            
            pstmt.execute();
            
                System.out.println("SE MODIFICO ESTATUS PETICION CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //TRAER LISTA PETICIONES REASIGNAR TS VISITA
    public void seleccionarReasignacionTSVisita(Connection con){
        
        try {
            
            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarReasignacionTSVisita()}");
            
            ListaIdPeticionVisitaAux.clear();
            ListaIdPeticionVisitaVisitaAux.clear();
            ListaFechaPeticionVisitaAux.clear();
            ListaFechaReasignacionVisitaAux.clear();
            ListaNombreCompletoVisitaAux.clear();
            ListaIdNuevoTSVisitaAux.clear();
            ListaMotivoReasignacionVisitaAux.clear();
            
            while(rs.next()){
                
                ListaIdPeticionVisitaAux.add(String.valueOf(rs.getInt(1)));
                ListaIdPeticionVisitaVisitaAux.add(String.valueOf(rs.getInt(2)));
                ListaFechaPeticionVisitaAux.add(rs.getString(3));
                ListaFechaReasignacionVisitaAux.add(rs.getString(4));
                ListaIdNuevoTSVisitaAux.add(String.valueOf(rs.getInt(6)));
                ListaMotivoReasignacionVisitaAux.add(rs.getString(7));
                
                ResultSet rs2 = stmt2.executeQuery("{Call dbo.SeleccionarUsuarioId("+ rs.getInt(5) +")}");
                
                if(rs2.next()){
                    
                    ListaNombreCompletoVisitaAux.add(rs2.getString(1));
                    
                }
                
            }
            
            setListaIdPeticionVisita(ListaIdPeticionVisitaAux);
            setListaIdPeticionVisitaVisita(ListaIdPeticionVisitaVisitaAux);
            setListaFechaPeticionVisita(ListaFechaPeticionVisitaAux);
            setListaFechaReasignacionVisita(ListaFechaReasignacionVisitaAux);
            setListaNombreCompletoVisita(ListaNombreCompletoVisitaAux);
            setListaIdNuevoTSVisita(ListaIdNuevoTSVisitaAux);
            setListaMotivoReasignacionVisita(ListaMotivoReasignacionVisitaAux);
            
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

    public List<String> getListaIdDomicilioAux() {
        return ListaIdDomicilioAux;
    }

    public void setListaIdDomicilioAux(List<String> ListaIdDomicilioAux) {
        this.ListaIdDomicilioAux = ListaIdDomicilioAux;
    }

    public List<String> getListaDireccionCompletaAux() {
        return ListaDireccionCompletaAux;
    }

    public void setListaDireccionCompletaAux(List<String> ListaDireccionCompletaAux) {
        this.ListaDireccionCompletaAux = ListaDireccionCompletaAux;
    }

    public List<String> getListaNumeroExpedienteAux() {
        return ListaNumeroExpedienteAux;
    }

    public void setListaNumeroExpedienteAux(List<String> ListaNumeroExpedienteAux) {
        this.ListaNumeroExpedienteAux = ListaNumeroExpedienteAux;
    }

    public List<String> getListaFolioAux() {
        return ListaFolioAux;
    }

    public void setListaFolioAux(List<String> ListaFolioAux) {
        this.ListaFolioAux = ListaFolioAux;
    }

    public List<String> getListaEstatusAux() {
        return ListaEstatusAux;
    }

    public void setListaEstatusAux(List<String> ListaEstatusAux) {
        this.ListaEstatusAux = ListaEstatusAux;
    }

    public List<String> getListaIdPeticionCoordi() {
        return ListaIdPeticionCoordi;
    }

    public void setListaIdPeticionCoordi(List<String> ListaIdPeticionCoordi) {
        this.ListaIdPeticionCoordi = ListaIdPeticionCoordi;
    }

    public List<String> getListaNumeroGravedadCoordi() {
        return ListaNumeroGravedadCoordi;
    }

    public void setListaNumeroGravedadCoordi(List<String> ListaNumeroGravedadCoordi) {
        this.ListaNumeroGravedadCoordi = ListaNumeroGravedadCoordi;
    }

    public List<String> getListaIdEmisorCoordi() {
        return ListaIdEmisorCoordi;
    }

    public void setListaIdEmisorCoordi(List<String> ListaIdEmisorCoordi) {
        this.ListaIdEmisorCoordi = ListaIdEmisorCoordi;
    }

    public List<String> getListaDelegacionCoordi() {
        return ListaDelegacionCoordi;
    }

    public void setListaDelegacionCoordi(List<String> ListaDelegacionCoordi) {
        this.ListaDelegacionCoordi = ListaDelegacionCoordi;
    }

    public List<String> getListaDireccionCompletaCoordi() {
        return ListaDireccionCompletaCoordi;
    }

    public void setListaDireccionCompletaCoordi(List<String> ListaDireccionCompletaCoordi) {
        this.ListaDireccionCompletaCoordi = ListaDireccionCompletaCoordi;
    }

    public List<String> getListaIdPeticionVisita() {
        return ListaIdPeticionVisita;
    }

    public void setListaIdPeticionVisita(List<String> ListaIdPeticionVisita) {
        this.ListaIdPeticionVisita = ListaIdPeticionVisita;
    }

    public List<String> getListaIdPeticionVisitaVisita() {
        return ListaIdPeticionVisitaVisita;
    }

    public void setListaIdPeticionVisitaVisita(List<String> ListaIdPeticionVisitaVisita) {
        this.ListaIdPeticionVisitaVisita = ListaIdPeticionVisitaVisita;
    }

    public List<String> getListaFechaPeticionVisita() {
        return ListaFechaPeticionVisita;
    }

    public void setListaFechaPeticionVisita(List<String> ListaFechaPeticionVisita) {
        this.ListaFechaPeticionVisita = ListaFechaPeticionVisita;
    }

    public List<String> getListaFechaReasignacionVisita() {
        return ListaFechaReasignacionVisita;
    }

    public void setListaFechaReasignacionVisita(List<String> ListaFechaReasignacionVisita) {
        this.ListaFechaReasignacionVisita = ListaFechaReasignacionVisita;
    }

    public List<String> getListaNombreCompletoVisita() {
        return ListaNombreCompletoVisita;
    }

    public void setListaNombreCompletoVisita(List<String> ListaNombreCompletoVisita) {
        this.ListaNombreCompletoVisita = ListaNombreCompletoVisita;
    }

    public List<String> getListaIdNuevoTSVisita() {
        return ListaIdNuevoTSVisita;
    }

    public void setListaIdNuevoTSVisita(List<String> ListaIdNuevoTSVisita) {
        this.ListaIdNuevoTSVisita = ListaIdNuevoTSVisita;
    }

    public List<String> getListaMotivoReasignacionVisita() {
        return ListaMotivoReasignacionVisita;
    }

    public void setListaMotivoReasignacionVisita(List<String> ListaMotivoReasignacionVisita) {
        this.ListaMotivoReasignacionVisita = ListaMotivoReasignacionVisita;
    }

    public String getId_folio() {
        return id_folio;
    }

    public void setId_folio(String id_folio) {
        this.id_folio = id_folio;
    }

    public String getDomicilio_completo() {
        return domicilio_completo;
    }

    public void setDomicilio_completo(String domicilio_completo) {
        this.domicilio_completo = domicilio_completo;
    }

    public String getDelegacion_municipal() {
        return delegacion_municipal;
    }

    public void setDelegacion_municipal(String delegacion_municipal) {
        this.delegacion_municipal = delegacion_municipal;
    }
    
    
    
}
