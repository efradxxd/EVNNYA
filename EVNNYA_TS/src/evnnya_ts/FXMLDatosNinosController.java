package evnnya_ts;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import procedimientos.Victima;
import conecciones.Conexion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lucia
 */
public class FXMLDatosNinosController implements Initializable {
    public String nombre, genero, apellidoPaterno, apellidoMaterno, lugarNacimiento, nacionalidad,idioma,grupoEtnico,religion,cual,fecha, escolaridad;
    public int discapacidad;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
        //Es para validar (bloquear letras y dejar solo numeros)
        //txtNombre = herramientas.validar(txtNombre);
        comboGenero.getItems().addAll(herramientas.getSexo());
        comboEscolaridad.getItems().addAll(herramientas.getEscolaridad());
        comboEscolaridad.setValue(herramientas.getEscolaridad()[0]);
        comboGenero.setValue(herramientas.getSexo()[0]);
 
    }    
    Herramientas herramientas = new Herramientas();
    
    @FXML
    private void actualizarDatos(ActionEvent event){
        nombre = txtNombre.getText().trim();
        apellidoPaterno = txtNombre1.getText().trim();
        apellidoMaterno = txtNombre11.getText().trim();
        fecha = herramientas.obtenerFechaDatePicker(date);
        lugarNacimiento = txtNacimiento.getText().trim();
        nacionalidad = txtNacionalidad.getText().trim();
        genero = comboGenero.getValue().trim();
        idioma = txtIdioma.getText().trim();
        grupoEtnico = txtGrupoEtnico.getText().trim();
        religion = txtReligion.getText().trim();
        cual = txtCual.getText().trim();
        escolaridad = comboEscolaridad.getValue().trim();
        
        if(checkDiscapacidadTrue.isSelected()==true){
            discapacidad = 1;
        }else{
            discapacidad =0;            
        }

        System.out.println("debug{" + "nombre=" + nombre + ", genero=" + genero + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", lugarNacimiento=" + lugarNacimiento + ", nacionalidad=" + nacionalidad + ", idioma=" + idioma + ", grupoEtnico=" + grupoEtnico + ", religion=" + religion + ", cual=" + cual + ", fecha=" + fecha + ", escolaridad=" + escolaridad + ", discapacidad=" + discapacidad + '}');
        Conexion conexion = new Conexion();
        Victima victima = new Victima();
        victima.actualizarNinoNina(conexion.cadena_conexion(), "DIF/PPNNA-002/2018", nombre, apellidoPaterno, apellidoMaterno, 0, genero, escolaridad, "", 0, lugarNacimiento, fecha, nacionalidad, religion, "", discapacidad, cual, idioma, grupoEtnico, 0);
        
        txtNombre.setText(""); 
        comboGenero.setValue(""); 
        txtNombre1.setText("");
        txtNombre11.setText(""); 
        txtNacimiento.setText(""); 
        txtNacionalidad.setText(""); 
        txtIdioma.setText(""); 
        txtGrupoEtnico.setText(""); 
        txtReligion.setText(""); 
        txtCual.setText(""); 
        date.setValue( LocalDate.parse(herramientas.obtenerFechaSistema(), formatter)); 
        comboEscolaridad.setValue(""); 
        checkDiscapacidadTrue.setSelected(false);
        checkDiscapacidadFalse.setSelected(false);
        
    }
    
    @FXML
    private void checkButton(ActionEvent event){
        if (checkDiscapacidadTrue.isSelected()==true) {
            checkDiscapacidadFalse.setSelected(false);
            
        }else{
            checkDiscapacidadTrue.setSelected(true);
        }
          
    }
        @FXML
    private void checkButton1(ActionEvent event){
        if (checkDiscapacidadFalse.isSelected()==true) {
            checkDiscapacidadTrue.setSelected(false);
            
        }else{
            checkDiscapacidadFalse.setSelected(true);
        }
          
    }
    
    
    
    @FXML
    private void botonCancelar(ActionEvent event){
    herramientas.cerrarPantalla(btnCancelar);
    }
    @FXML
    private DatePicker date;

    @FXML
    private JFXCheckBox checkDiscapacidadFalse;

    @FXML
    private JFXTextField txtNombre11;

    @FXML
    private JFXTextField txtIdioma;

    @FXML
    private JFXTextField txtNacimiento;

    @FXML
    private JFXTextField txtReligion;

    @FXML
    private JFXTextField txtNacionalidad;

    @FXML
    private JFXCheckBox checkDiscapacidadTrue;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXTextField txtGrupoEtnico;

    @FXML
    private JFXTextField txtCual;

    @FXML
    private JFXComboBox<String> comboEscolaridad;

    @FXML
    private JFXTextField txtNombre1;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXComboBox<String> comboGenero;

    @FXML
    private JFXButton btnActualizar;
    
}
