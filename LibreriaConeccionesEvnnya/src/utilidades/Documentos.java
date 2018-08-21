/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.IOException;

/**
 *
 * @author jahir
 */
public class Documentos {
    
    public void abrirArchivo(){
        
        //ruta del archivo en el pc
        String file = new String("\\\\10.6.245.10\\archivos\\nombre_pdf.pdf"); 
   
        try{ 
         //definiendo la ruta en la propiedad file
        Runtime.getRuntime().exec("cmd /c start "+file);
     
        }catch(IOException e){
             e.printStackTrace();
        }
        
    }
    
}
