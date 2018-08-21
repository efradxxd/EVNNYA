/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_ts;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import conecciones.Conexion;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import procedimientos.PeticionesTrabajoSocial;
import procedimientos.Direcciones;
import procedimientos.Usuarios;

public class FXMLDatosVisitaController implements Initializable {
    static int id_direccion;

    public static String getEstatusPeticion() {
        return estatusPeticion;
    }

    public static void setEstatusPeticion(String estatusPeticion) {
        FXMLDatosVisitaController.estatusPeticion = estatusPeticion;
    }
    static String estatusPeticion; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id_direccion = FXMLDocumentController.getId_direccion();
        System.out.println("id direccion1; "+id_direccion);
        llenarFormulario();
    }    

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }
    private void llenarFormulario(){
        
        PeticionesTrabajoSocial peticion = new PeticionesTrabajoSocial();
        Conexion conexion = new Conexion();
        Direcciones direcciones = new Direcciones();
        Usuarios usuario = new Usuarios();
        
        
        
        direcciones.seleccionarDireccion(conexion.cadena_conexion(), id_direccion);
        peticion.seleccionarVisitaDomiciliaria(conexion.cadena_conexion(), id_direccion);
        
        int id_emisor = Integer.parseInt(peticion.getId_emisor());
        
        System.out.println("Emisor: "+ id_emisor);
        
        usuario.seleccionarUsuario(conexion.cadena_conexion(), String.valueOf(id_emisor));
        
        txtAsesor.setText(usuario.getNombres()+" "+usuario.getApellido_paterno()+" "+usuario.getApellido_materno());
        NoExpediente.setText(peticion.getId_peticion());
        fechaRecibi.setText(peticion.getFecha_envio());
        txtAsesor.setText(peticion.getId_receptor());
        txtNumero.setText(peticion.getFecha_maxima_visita());
        txtCalle.setText(peticion.getGravedad_peticion());
        txtFechaMaxVisita.setText(peticion.getNumero_expediente());
        
        txtCodigoPostal.setText(direcciones.getNumero());
        txtCalle.setText(direcciones.getCalle());
        txtYCalle.setText(direcciones.getNumero());
        txtEntreCalle.setText(direcciones.getColonia());
        txtColonia.setText(direcciones.getColonia());
        txtYCalle1.setText(String.valueOf(direcciones.getEntre_callate()));
        txtCodigoPostal.setText(String.valueOf(direcciones.getCodigo_postal()));
        txtYCalle11.setText(direcciones.getMunicipio());
        
        estatusPeticion = txtGravedadVisita.getText();
        
        
        areaObjetivoVisita.setText(peticion.getDescripcion());
        areaReferenciaDomicilio.setText(direcciones.getReferencia_casa());
        
        
    }
    
    @FXML
    private void crearReporteVisita(){
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
    @FXML
    private void cerrarPantalla(){
        Herramientas herra = new Herramientas();
        herra.cerrarPantalla(btnAceptar1);
    }
    @FXML
    private void guardarCambios(){
        PeticionesTrabajoSocial actualizar = new PeticionesTrabajoSocial();
        if(txtGravedadVisita.getText().equals("Rellene estatus actual de peticion")){
            Conexion cone = new Conexion();
            actualizar.actualizarEstatusPeticion(cone.cadena_conexion(), estatusPeticion, id_direccion);
            JOptionPane.showMessageDialog(null, "Estatus actualizado");
        
        }else
        JOptionPane.showMessageDialog(null, "Porfavor actualize el estado de la peticion");
    }

    @FXML
    private JFXTextField txtAsesor,txtNombre;

    @FXML
    private JFXTextField txtGravedadVisita;

    @FXML
    private JFXTextField txtFechaMaxVisita;

    @FXML
    private JFXTextField txtCalle;

    @FXML
    private JFXTextField txtNumero;

    @FXML
    private JFXTextField txtColonia;

    @FXML
    private JFXTextField txtCodigoPostal;

    @FXML
    private JFXTextField txtEntreCalle;
    
    @FXML
    private Label fechaRecibi;
    @FXML
    private JFXTextField txtYCalle;

    @FXML
    private TextArea areaReferenciaDomicilio;

    @FXML
    private TextArea areaObjetivoVisita;

    @FXML
    private JFXButton btnGenerarFormato;

    @FXML
    private JFXButton btnAceptar1;

    @FXML
    private JFXTextField txtYCalle1;

    @FXML
    private JFXTextField txtYCalle11;

    @FXML
    private JFXButton btnGenerarFormato1;

    @FXML
    private Label NoExpediente;



}
