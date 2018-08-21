/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_psic;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import procedimientos.PeticionesMedico;

/**
 * FXML Controller class
 *
 * @author jahir
 */
public class FXMLBuscarPeticionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    void verPeticion(ActionEvent event) {
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
    
    int tamanioLista;
    ObservableList<BuscarAnxF> tablaInterna = FXCollections.observableArrayList();

//    @FXML
//    private void mostrarTablaBuscarAnexo() {
//        if (tablaInterna.size() != 0) {
//            tablaInterna = FXCollections.observableArrayList();
//        }
//
//        try {
//            PeticionesPsocologia peticion = new PeticionesPsocologia();
//            Conexion conexion = new Conexion();
//            peticion.seleccionarBandejaPeticionesMed(conexion.cadena_conexion(),1/*int id_receptor*/);
//            
//            //peticion.                            FALTA_PROCEDIMIENTO
//            List<String> folio = peticion.getListaIdPeticion();
//            List<String> fecha = peticion.getListaFechaEnvio();
//            List<String> numeroE = peticion.getListaGravedad();
//            List<String> estat = peticion.getListaGravedad();
//            tamanioLista = fecha.size();
//            for (int i = 0; i < folio.size(); i++) {
//                tablaInterna.add(new BuscarAnxF(folio.get(i), numeroE.get(i),fecha.get(i),estat.get(i)));
//            }
//            colFolio.setCellValueFactory(new PropertyValueFactory<BuscarAnxF, String>("folio"));
//            colNumero.setCellValueFactory(new PropertyValueFactory<BuscarAnxF, String>("numeroE"));
//            colFecha.setCellValueFactory(new PropertyValueFactory<BuscarAnxF, String>("fecha"));
//            colEstatus.setCellValueFactory(new PropertyValueFactory<BuscarAnxF, String>("estat"));
//            
//            tablaFolios.setItems(tablaInterna);
//        } catch (Exception e) {
//            System.out.println("Error" + e);
//        }
//    }
    
     @FXML
    private TableColumn<BuscarAnxF, String> colEstatus;
    @FXML
    private TableView<BuscarAnxF> tablaFolios= new TableView<>();

    @FXML
    private TableColumn<BuscarAnxF, String> colFecha;

    @FXML
    private JFXTextField txtFolioBuscar;

    @FXML
    private TableColumn<BuscarAnxF, String> colNumero;

    @FXML
    private TableColumn<BuscarAnxF, String> colFolio;

    @FXML
    private JFXButton btnVerPeticion;
}
