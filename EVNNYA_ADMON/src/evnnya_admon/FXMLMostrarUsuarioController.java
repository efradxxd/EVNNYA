package evnnya_admon;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import procedimientos.Direcciones;
import conecciones.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import procedimientos.Usuarios;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author lucia
 */
public class FXMLMostrarUsuarioController implements Initializable {
        
    @FXML
    private TableView <Usuario> tablaUsuarios = new TableView<>();
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarUsuarios();
    }    
   private void mostrarUsuarios(){
       
   TableColumn<Usuario, String> colUsuario = new TableColumn<>("Usuario");
   colUsuario.setMinWidth(100);
   colUsuario.setCellValueFactory(new PropertyValueFactory<Usuario,String>("usuarios"));
   
   TableColumn<Usuario, String> colDpto =  new TableColumn<>("Departamento");
   colDpto.setMinWidth(100);
   colDpto.setCellValueFactory(new PropertyValueFactory<Usuario,String>("departamento"));
   
   TableColumn<Usuario, String> colApeMa = new TableColumn<>("Apellido Materno");
   colApeMa.setMinWidth(200);
   colApeMa.setCellValueFactory(new PropertyValueFactory<Usuario,String>("apellidoMaterno"));
   
   TableColumn<Usuario,String> colNombre = new TableColumn<>("Nombre");
   colNombre.setCellValueFactory(new PropertyValueFactory<Usuario,String>("nombre"));
   colNombre.setMinWidth(200);
   
   TableColumn<Usuario,String> colApePa = new TableColumn<>("Apellido Paterno");
   colApePa.setCellValueFactory(new PropertyValueFactory<Usuario,String>("apellidoPaterno"));
   colApePa.setMinWidth(200);
   
   try{
        Usuarios usuariosMostrar = new Usuarios();
        Conexion conexion = new Conexion();
        usuariosMostrar.seleccionarTodosUsuarios(conexion.cadena_conexion());
        
        List <String> nombre = usuariosMostrar.getListaNombres();
        List <String> dpto = usuariosMostrar.getListaDepartamento();
        List <String> apellidoPaterno = usuariosMostrar.getListaApellidoPaterno();
        List <String> apellidoMaterno = usuariosMostrar.getListaApellidoMaterno();
        List <String> usuarios = usuariosMostrar.getListaUsuario();
        
        ObservableList<Usuario> tablaInterna = FXCollections.observableArrayList();
        
        for (int i = 0; i < nombre.size(); i++) 
            tablaInterna.add(new Usuario(nombre.get(i),dpto.get(i),apellidoPaterno.get(i),apellidoMaterno.get(i),usuarios.get(i)));
        
        //Tabla Gráfica
        tablaUsuarios.setItems(tablaInterna);        
        tablaUsuarios.getColumns().addAll(colNombre, colApePa, colApeMa, colDpto, colUsuario);
        tablaUsuarios.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      }catch(Exception e){
          
      }
    }
    
}
