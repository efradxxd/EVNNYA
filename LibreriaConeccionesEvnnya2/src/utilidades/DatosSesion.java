/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jahir
 */
public class DatosSesion {
    
    //VARIABLES PARA DATOS DE SESION
    String id;
    String nombres;
    String ape_paterno;
    String ape_materno;
    String departamento;
    String tipo_usuario;
    boolean existe_archivo;
    
    //VARIABLE NOMENGLATURA
    String nomenglatura;
    
    public void traerDatos() throws FileNotFoundException, IOException{
        
        File af = new File("C:\\evnnya\\archivo.evn");
        
        if(af.exists()){
            
            StringBuilder contentBuilder = new StringBuilder();
                BufferedReader in = new BufferedReader(new FileReader("C:\\evnnya\\archivo.evn"));
                String str;
                
                while ((str = in.readLine()) != null) {
                    contentBuilder.append(str);
                }
                
            in.close();
            
            String content = contentBuilder.toString();
            
            System.out.println(content);
            
            String limpiar = content.replace("\n", "");
            String[] parts = limpiar.split("-");
             setId(parts[0].replace("ID=[", "").replace("]", ""));
             setNombres(parts[1].replace("NOMBRES=[", "").replace("]", ""));
             setApe_paterno(parts[2].replace("APELLIDO_PATERNO=[", "").replace("]", ""));
             setApe_materno(parts[3].replace("APELLIDO_MATERNO=[", "").replace("]", ""));
             setDepartamento(parts[4].replace("DEPARTAMENTO=[", "").replace("]", ""));
             setTipo_usuario(parts[5].replace("TIPO_USUARIO=[", "").replace("]", ""));
            
            
            
            //JOptionPane.showMessageDialog(null, departamento);
            
        }else{
            JOptionPane.showMessageDialog(null, "ES NECESARIO QUE INICIE SESION DESDE \"INICIAR SESION\"");
        }
        
    }
    
    public void cerrarSesion(){
        
        File fichero = new File("C:\\evnnya\\archivo.evn");
        
        if (fichero.delete()){
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        }else{
            System.out.println("El fichero no puede ser borrado");   
        }
        
    }
    
    public String crearNomenglatura(){
        
        String nomen = getDepartamento().substring(0, 3) + "-" + getId() + "-";
        
        return nomen;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public boolean isExiste_archivo() {
        return existe_archivo;
    }

    public void setExiste_archivo(boolean existe_archivo) {
        this.existe_archivo = existe_archivo;
    }

    public String getNomenglatura() {
        return nomenglatura;
    }

    public void setNomenglatura(String nomenglatura) {
        this.nomenglatura = nomenglatura;
    }
    
    
    
}
