/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import conecciones.Conexion;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import procedimientos.Usuarios;

/**
 *
 * @author jahir
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnClose;

    @FXML
    private Button btnAceptar;

    @FXML
    private JFXPasswordField txtContrasena;

    @FXML
    private JFXTextField txtUsuario;

    @FXML
    private void handleLogin(ActionEvent event) {

        File af = new File("C:\\evnnya\\archivo.evn");

        if (!af.exists()) {

            Conexion con = new Conexion();
            Usuarios usuarios = new Usuarios();

            usuarios.loginUsuario(con.cadena_conexion(), txtUsuario.getText(), txtContrasena.getText());

            if (usuarios.isLogin_exitoso()) {

                //CREACION DEL ARCHIVO EVN
                BufferedWriter bw = null;
                FileWriter fw = null;

                try {

                    fw = new FileWriter("C:\\evnnya\\archivo.evn");
                    bw = new BufferedWriter(fw);
                    bw.write("ID=[" + usuarios.getLogin_id_usuario() + "]-\n"
                            + "NOMBRES=[" + usuarios.getLogin_nombres() + "]-\n"
                            + "APELLIDO_PATERNO=[" + usuarios.getLogin_apellido_paterno() + "]-\n"
                            + "APELLIDO_MATERNO=[" + usuarios.getLogin_apellido_materno() + "]-\n"
                            + "DEPARTAMENTO=[" + usuarios.getLogin_departamento() + "]-\n"
                            + "TIPO_USUARIO=[" + usuarios.getLogin_tipo_usuario() + "]-");

                    System.out.println("Se creo el Archivo sin problemas");

                    if (usuarios.getLogin_departamento().equalsIgnoreCase("RECEPCION")) {

                        try {
                            
                            Process proc = Runtime.getRuntime().exec("java -jar \\\\10.6.245.10\\archivos\\EVNNYA_RECEPCION\\EVNNYA_Recepcion.jar");
                            
                            
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "ERROR: VERIFIQUE CARPETA RAIZ DEL SISTEMA");
                        }

                    }else if(usuarios.getLogin_departamento().equalsIgnoreCase("MESA RECEPTORA")){
                        
                    }
                    else {

                        System.out.println("no fue compatible con ningun departamento");

                    }

                } catch (IOException e) {

                    e.printStackTrace();

                } finally {
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                        if (fw != null) {
                            fw.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            } else {

                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA ERRONEA");

            }

        } else {

            JOptionPane.showMessageDialog(null, "NO SE PUEDE INICIAR SESION CUANDO UN USUARIO YA ESTA ACTIVO");

        }

    }

    @FXML
    private void handleClose(ActionEvent event) {
        System.exit(1);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("INICIO");
    }

}
