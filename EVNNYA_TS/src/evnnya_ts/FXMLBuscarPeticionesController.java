/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_ts;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import procedimientos.PeticionesTrabajoSocial;
import conecciones.Conexion;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TablePosition;

public class FXMLBuscarPeticionesController implements Initializable {

    @FXML
    JFXButton btnVerPeticion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    public void verPeticiones(){
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLDatosVisita.fxml"));
            Parent padre= (Parent)nuevaVentana.load();
            Stage escenario= new Stage();
            escenario.setScene(new Scene(padre));
            escenario.setResizable(false);
            escenario.sizeToScene();
            escenario.show();
        }catch(Exception e){
        
        }
    }       
    int posicionColumna = 0;
    private void listenerTabla(){
    final ObservableList<TablePosition> selectedCells = tablaFolios.getSelectionModel().getSelectedCells();
    selectedCells.addListener(new ListChangeListener<TablePosition>() {
        @Override
        public void onChanged(ListChangeListener.Change change) {
            for (TablePosition pos : selectedCells) {
               System.out.println("Cell selected in row "+pos.getRow()+" and column "+pos.getColumn());
                posicionColumna = pos.getRow();
            }
            if (posicionColumna== 0) {
                 Object folio  = tablaFolios.getItems().get(tablaFolios.getFocusModel().getFocusedIndex());
            }
        }
    }); 
    }
    private void mostrarTabla(){
        
        
        
       
        Conexion conexion = new Conexion();
        PeticionesTrabajoSocial peticionTrabajoSocial = new PeticionesTrabajoSocial();
        peticionTrabajoSocial.seleccionarBandejaPeticionesTS(conexion.cadena_conexion());
        
        folioPeticion.setCellValueFactory(new PropertyValueFactory<BuscarPeticion,String>("folioPeticion"));
        numeroExoediente.setCellValueFactory(new PropertyValueFactory<BuscarPeticion,String>("numeroExpediente"));
        fecha.setCellValueFactory(new PropertyValueFactory<BuscarPeticion,String>("fecha"));
        
        ObservableList<BuscarPeticion> tablaInterna = FXCollections.observableArrayList();
        
        List <String> folio;
        List <String> numeroExpediente;
        List <String> fecha;
        List <String> estatus;
        
        
    //    for (int i = 0; i < fecha.size(); i++) 
    //        tablaInterna.add(new BuscarPeticion(folio.get(i), numeroExpediente.get(i), fecha.get(i), estatus.get(i)));
            
        tablaFolios.setItems(tablaInterna);
        
    }
    
    
    @FXML
    private JFXButton listoButon;
    
    @FXML
    private JFXTextField txtFolioBuscar;

    @FXML
    private TableView<BuscarPeticion> tablaFolios = new TableView<>();

    @FXML
    private TableColumn<BuscarPeticion, String> folioPeticion;

    @FXML
    private TableColumn<BuscarPeticion, String> numeroExoediente;

    @FXML
    private TableColumn<BuscarPeticion, String> fecha;

    @FXML
    private TableColumn<BuscarPeticion, String> estatus;
}
