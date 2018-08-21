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
import javax.swing.JOptionPane;

/**
 *
 * @author jahir
 */
public class Asesores {
    
    //VARIABLES TRAER NOMBRES ASESOR
    List<String> ListaIdAsesor = new ArrayList<String>();
    List<String> ListaNombreCompleto = new ArrayList<String>();
    List<String> ListaEspecialidadAsesor = new ArrayList<String>();
    
    List<String> ListaIdAsesorAux = new ArrayList<String>();
    List<String> ListaNombreCompletoAux = new ArrayList<String>();
    List<String> ListaEspecialidadAsesorAux = new ArrayList<String>();
    
    //TRAER ASESOR NOMBRE COMPLETO
    public void seleccionarAsesorNombre(Connection con){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarNombreAsesores()}");
            
            ListaIdAsesorAux.clear();
            ListaNombreCompletoAux.clear();
            ListaEspecialidadAsesorAux.clear();
            
            while(rs.next()){
                
                ListaIdAsesorAux.add(String.valueOf(rs.getInt(1)));
                ListaNombreCompletoAux.add(rs.getString(2));
                ListaEspecialidadAsesorAux.add(rs.getString(3));
                
            }
            
            setListaIdAsesor(ListaIdAsesorAux);
            setListaNombreCompleto(ListaNombreCompletoAux);
            setListaEspecialidadAsesor(ListaEspecialidadAsesorAux);
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }

    public List<String> getListaIdAsesor() {
        return ListaIdAsesor;
    }

    public void setListaIdAsesor(List<String> ListaIdAsesor) {
        this.ListaIdAsesor = ListaIdAsesor;
    }

    public List<String> getListaNombreCompleto() {
        return ListaNombreCompleto;
    }

    public void setListaNombreCompleto(List<String> ListaNombreCompleto) {
        this.ListaNombreCompleto = ListaNombreCompleto;
    }

    public List<String> getListaEspecialidadAsesor() {
        return ListaEspecialidadAsesor;
    }

    public void setListaEspecialidadAsesor(List<String> ListaEspecialidadAsesor) {
        this.ListaEspecialidadAsesor = ListaEspecialidadAsesor;
    }
    
    
        
}
