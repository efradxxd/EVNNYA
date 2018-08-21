/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_psic;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelos.BandejaEntrada;
import procedimientos.PeticionesPsicologia;
import conecciones.Conexion;
/**
 *
 * @author lucia
 */
public class FXMLDocumentController implements Initializable {
    Conexion con = new Conexion();
    PeticionesPsicologia psicologia = new PeticionesPsicologia();
  
    
    @FXML
    JFXButton btn_formato_terapia, btn_buscar, btn_cerrar_sesion, btn_ver, btnActualizar;
    
    
    public void TraerPeticiones(){
        psicologia.seleccionarBandejaPeticionesPsi(con.cadena_conexion());//Falta agregar parametro ID de usuario
    }
    @FXML
    void formatoTerapia() {
        
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLFormatoPsic.fxml"));
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
    void buscar(ActionEvent event) {
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLBuscar.fxml"));
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
    void btn_ver(ActionEvent event) {
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLDatosPsic.fxml"));
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
    void btn_BuscarPeticion(ActionEvent event) {
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLBuscarPeticion.fxml"));
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
        
       cargarTabla();
        
    }
    
    public void cargarTabla(){
        
        TableColumn<BandejaEntrada, String> columnExpediente = new TableColumn<>("Numero de expediente");
        columnExpediente.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("expediente"));
        
        TableColumn<BandejaEntrada, String> columnFecha = new TableColumn<>("Fecha");
        columnFecha.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("fecha"));
        
        TableColumn<BandejaEntrada, String> columnGravedad = new TableColumn<>("Gravedad");
        columnGravedad.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("gravedad"));
        
        TableColumn<BandejaEntrada, String> columnNombre = new TableColumn<>("Nombre del paciente");
        columnNombre.setCellValueFactory(new PropertyValueFactory<BandejaEntrada, String>("nombre_paciente"));

        ObservableList<BandejaEntrada> datos = FXCollections.observableArrayList();
        
        datos.add(new BandejaEntrada("The Thief", "Fuminori Nakamura","asdad","adfasd"));
        datos.add(new BandejaEntrada("Of Human Bondage", "Fuminori Nakamura","asdad","adfasd"));
        
        tablaBandeja.setItems(datos);
        tablaBandeja.getColumns().addAll(columnExpediente, columnFecha, columnGravedad, columnNombre);
        tablaBandeja.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

             
    }

    
    @FXML
    private TableColumn columnFecha;

    @FXML
    private TableColumn columnExpediente;

    @FXML
    private TableColumn columnNombre;

    @FXML
    private TableColumn columnGravedad;
    
    @FXML
    private TableView<BandejaEntrada> tablaBandeja = new TableView<>();
    
}
