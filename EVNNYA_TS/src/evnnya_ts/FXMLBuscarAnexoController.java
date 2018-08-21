                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    package evnnya_ts;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import conecciones.Conexion;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import procedimientos.PeticionesTrabajoSocial;


public class FXMLBuscarAnexoController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {                                                                                                                                 
        mostrarTabla();
    }
    
    @FXML
    void buscarAnexo(ActionEvent event) {
        try{
            FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLFormatoTS.fxml"));
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
            if (posicionColumna  == 0) {
                Object folio  = tablaFolios.getItems().get(tablaFolios.getFocusModel().getFocusedIndex());
                txtFolioBuscar.setText((String) folio);
            }
        }
    }); 
    }
    
    
    
    
    private void mostrarTabla(){
        
        folio.setCellValueFactory(new PropertyValueFactory<BandejaEntrada,String>("numeroFolio"));
        numeroExpediente.setCellValueFactory(new PropertyValueFactory<BandejaEntrada,String>("direccion"));
        fecha.setCellValueFactory(new PropertyValueFactory<BandejaEntrada,String>("fecha"));
        
        Conexion con = new Conexion();
        PeticionesTrabajoSocial peticion = new PeticionesTrabajoSocial();
        peticion.seleccionarBandejaPeticionesTS(con.cadena_conexion());
        
        List <String> lFolio = peticion.getListaNumeroExpediente();
        List <String> lNumeroEspediente = peticion.getListaNumeroExpediente();
        List <String> lFecha = peticion.getListaFechaEnvio();
        
        
        try{
            
            ObservableList<BandejaEntrada> tablaInterna = FXCollections.observableArrayList();   
            for (int i = 0; i < lFolio.size(); i++) {
                System.out.println(lFolio.get(i)+"Fecha: "+lFecha.get(i)+"Numero expedientes :"+lNumeroEspediente.get(i));
            }
            for (int i = 0; i < lFolio.size(); i++) 
                tablaInterna.add(new BandejaEntrada(lFolio.get(i), lFecha.get(i), lNumeroEspediente.get(i))) ;
            
            tablaFolios.setItems(tablaInterna);
    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }
    
    
    @FXML
    private TableView<BandejaEntrada> tablaFolios;

    @FXML
    private JFXTextField txtFolioBuscar;

    @FXML
    private JFXButton btnVerAnexo;
    
    @FXML
    private TableColumn<BandejaEntrada, String> folio;

    @FXML
    private TableColumn<BandejaEntrada, String> numeroExpediente;

    @FXML
    private TableColumn<BandejaEntrada, String> fecha;

    
}
