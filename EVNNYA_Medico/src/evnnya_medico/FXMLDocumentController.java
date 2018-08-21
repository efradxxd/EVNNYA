/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_medico;

import com.jfoenix.controls.JFXButton;
import conecciones.Conexion;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import procedimientos.PeticionesMedico;

/**
 *
 * @author lucia
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarTablaBandejaEntrada();
        
    }    
    
   
    @FXML
    void datosConsulta() {
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLDatosConsulta.fxml"));
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
    void buscarAnexo() {
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLBuscarAnexo.fxml"));
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
    void buscarPeticiones() {
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
    
    
    
    ObservableList<EntradaMedico> tablaInterna = FXCollections.observableArrayList();
      @FXML
    private void mostrarTablaBandejaEntrada() {
        if (tablaInterna.size() != 0) {
            tablaInterna = FXCollections.observableArrayList();
        }

        try {
            PeticionesMedico peticion = new PeticionesMedico();
            Conexion conexion = new Conexion();
            peticion.seleccionarBandejaPeticionesMed(conexion.cadena_conexion());

            List<String> numeroDeFolio = peticion.getListaIdPeticion();
            List<String> fecha = peticion.getListaFechaEnvio();
            List<String> gravedad = peticion.getListaGravedad();
            List<String> nombrePaciente = peticion.getListaNombre();    
            System.out.println(fecha.size());
            for (int i = 0; i < numeroDeFolio.size(); i++) {
              tablaInterna.add(new EntradaMedico(fecha.get(i),
                        gravedad.get(i),
                        nombrePaciente.get(i),
                        numeroDeFolio.get(i)));
            }
            columFolio.setCellValueFactory(new PropertyValueFactory<EntradaMedico, String>("FolioP"));
            columFecha.setCellValueFactory(new PropertyValueFactory<EntradaMedico, String>("fecha"));
            columNombre.setCellValueFactory(new PropertyValueFactory<EntradaMedico, String>("nombre"));
            columGrav.setCellValueFactory(new PropertyValueFactory<EntradaMedico, String>("gravedad"));
                              
            tabla_bandeja_entrada.setItems(tablaInterna);
            
            
            
            
            
            
            
            
            
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        
    }
    
    
        @FXML
    private TableColumn<EntradaMedico,String> columNombre;

    @FXML
    private JFXButton btnBuscarPeticion;

    @FXML
    private TableColumn<EntradaMedico,String> columFecha;

    @FXML
    private JFXButton btnCerrarSesion;

    @FXML
    private JFXButton btnVer;

    @FXML
    private TableColumn<EntradaMedico,String> columFolio;

    @FXML
    private TableView<EntradaMedico> tabla_bandeja_entrada=new TableView<>();

    @FXML
    private TableColumn<EntradaMedico,String> columGrav;

    @FXML
    private JFXButton btnBuscarAnexo;

    @FXML
    private JFXButton btnActualizar;
}
