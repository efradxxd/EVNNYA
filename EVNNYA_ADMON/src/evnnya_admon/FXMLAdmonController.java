/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_admon;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utilidades.DatosSesion;

/**
 *
 * @author lucia
 */
public class FXMLAdmonController implements Initializable {
    
    @FXML
    JFXButton btnAgregarUsuario, btnModificarUsuario;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    @FXML
    private void agregarUsuario(ActionEvent event) {
        try{
                FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLAgregarUsuario.fxml"));
                Parent padre= (Parent)nuevaVentana.load();
                Stage escenario= new Stage();
                escenario.setScene(new Scene(padre));
                escenario.setResizable(false);
                escenario.sizeToScene();
                escenario.show();
            }catch(Exception e){
            } 
    }
    @FXML
    private void modificarUsuario(ActionEvent event) {
        try{
                FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLModificarUsuario.fxml"));
                Parent padre= (Parent)nuevaVentana.load();
                Stage escenario= new Stage();
                escenario.setScene(new Scene(padre));
                escenario.setResizable(false);
                escenario.sizeToScene();
                escenario.show();
            }catch(Exception e){
            } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* File af = new File("C:\\evnnya\\archivo.evn");

        if (af.exists()) {
            
            DatosSesion datos_sesion = new DatosSesion();
            
            try {
                
                datos_sesion.traerDatos();
                Global.id = datos_sesion.getId();
                Global.nombres = datos_sesion.getNombres();
                Global.apellido_paterno = datos_sesion.getApe_paterno();
                Global.departamento = datos_sesion.getDepartamento();
                Global.tipo_usuario = datos_sesion.getTipo_usuario();
                
                System.out.println(Global.nombres);
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "ES NECESARIO QUE INICIE SESION");
            System.exit(0);
        }*/
    }    
    
}
