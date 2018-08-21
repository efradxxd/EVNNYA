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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jahir
 */
public class Direcciones {
    
    //VARIABLES TRAER DIRECCION
    int id_direccion;
    String calle;
    String numero;
    String colonia;
    int codigo_postal;
    String entre_callate;
    String entre_calle_dos;
    String municipio;
    String referencia_casa;
    String correo_electronico;
    String telefono_fijo;
    String telefono_movil;
    
    //AGREGAR DIRECCION
    public void agregarDireccion(Connection con, String calle, String numero, String colonia, int codigo_postal,
                                String entre_calle, String entre_calle_dos, String municipio, String referencia_casa,
                                String correo_electronico, String telefono_fijo, String telefono_movil){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarDireccion(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?)}");
            
            pstmt.setString(1, calle);
            pstmt.setString(2, numero);
            pstmt.setString(3, colonia);
            pstmt.setInt(4, codigo_postal);
            pstmt.setString(5, entre_calle);
            pstmt.setString(6, entre_calle_dos);
            pstmt.setString(7, municipio);
            pstmt.setString(8, referencia_casa);
            pstmt.setString(9, correo_electronico);
            pstmt.setString(10, telefono_fijo);
            pstmt.setString(11, telefono_movil);
            
            pstmt.execute();
            
                System.out.println("SE AGREGO DIRECCION CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //ACTUALIZAR DIRECCION
    public void actualizarDireccion(Connection con, String calle, String numero, String colonia, int codigo_postal,
                                String entre_calle, String entre_calle_dos, String municipio, String referencia_casa,
                                String correo_electronico, String telefono_fijo, String telefono_movil, int id_direccion){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarDireccion(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?)}");
            
            pstmt.setString(1, calle);
            pstmt.setString(2, numero);
            pstmt.setString(3, colonia);
            pstmt.setInt(4, codigo_postal);
            pstmt.setString(5, entre_calle);
            pstmt.setString(6, entre_calle_dos);
            pstmt.setString(7, municipio);
            pstmt.setString(8, referencia_casa);
            pstmt.setString(9, correo_electronico);
            pstmt.setString(10, telefono_fijo);
            pstmt.setString(11, telefono_movil);
            pstmt.setInt(12, id_direccion);
            
            pstmt.execute();
            
                System.out.println("SE MODIFICO DIRECCION CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //SELECCIONAR DIRECCION //POR MEDIO DEL ID DIRECCION
    public void seleccionarDireccion(Connection con, int id_direccion){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarDireccion("+id_direccion+")}");
            
            if(rs.next()){
                
                setId_direccion(rs.getInt(1));
                setCalle(rs.getString(2));
                setNumero(rs.getString(3));
                setColonia(rs.getString(4));
                setCodigo_postal(rs.getInt(5));
                setEntre_callate(rs.getString(6));
                setEntre_calle_dos(rs.getString(7));
                setMunicipio(rs.getString(8));
                setReferencia_casa(rs.getString(9));
                setCorreo_electronico(rs.getString(10));
                setTelefono_fijo(rs.getString(11));
                setTelefono_movil(rs.getString(12));
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //GETTERS AND SETTERS

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }
    
    
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getEntre_callate() {
        return entre_callate;
    }

    public void setEntre_callate(String entre_callate) {
        this.entre_callate = entre_callate;
    }

    public String getEntre_calle_dos() {
        return entre_calle_dos;
    }

    public void setEntre_calle_dos(String entre_calle_dos) {
        this.entre_calle_dos = entre_calle_dos;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getReferencia_casa() {
        return referencia_casa;
    }

    public void setReferencia_casa(String referencia_casa) {
        this.referencia_casa = referencia_casa;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(String telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public String getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(String telefono_movil) {
        this.telefono_movil = telefono_movil;
    }
    
    
}
