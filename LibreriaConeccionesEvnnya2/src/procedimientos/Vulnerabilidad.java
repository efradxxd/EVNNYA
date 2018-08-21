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
public class Vulnerabilidad {
    
    //VARIBALES VULNERABILIDAD REPORTE
    List<String> ListaVulnerabilidad = new ArrayList<String>();
    List<String> ListaVulnerabilidadAux = new ArrayList<String>();
    
    //AGREGAR VULNERABILIDAD
    public void agregarVulnerabilidad(Connection con, String numero_expedinte, String tipo_vulnerabilidad, int id_reporte) {
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarVulnerabilidad(?,?,?)}");
            
            pstmt.setString(1, numero_expedinte);
            pstmt.setString(2, tipo_vulnerabilidad);
            pstmt.setInt(3, id_reporte);
      
            
            pstmt.execute();
            
                System.out.println("SE AGREGO VULNERABILIDAD CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //TRAER VULNERABILIDAD POR ID REPORTE
    public void seleccionarVulnerabilidadReporte(Connection con, int id_reporte){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarVulnerabilidadReporte('"+id_reporte+"')}");
            
            ListaVulnerabilidadAux.clear();
            
            while(rs.next()){
                
                ListaVulnerabilidadAux.add(rs.getString(1));
                
            }
            
            setListaVulnerabilidad(ListaVulnerabilidadAux);
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }

    public List<String> getListaVulnerabilidad() {
        return ListaVulnerabilidad;
    }

    public void setListaVulnerabilidad(List<String> ListaVulnerabilidad) {
        this.ListaVulnerabilidad = ListaVulnerabilidad;
    }
    
    
}
