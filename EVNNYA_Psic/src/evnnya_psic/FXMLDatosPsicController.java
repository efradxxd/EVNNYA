/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_psic;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import conecciones.Conexion;
import static evnnya_psic.FXMLDocumentController.fila;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import procedimientos.Agresor;
import procedimientos.Custodia;
import procedimientos.PeticionesPsicologia;
import procedimientos.Victima;

/**
 * FXML Controller class
 *
 * @author lucia
 */
public class FXMLDatosPsicController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    JFXButton btnComenzarEvaluacion;

    @FXML
    void formatoTerapia(ActionEvent event) {
        try {
            FXMLLoader nuevaVentana = new FXMLLoader(getClass().getResource("FXMLFormatoPsic.fxml"));
            Parent padre = (Parent) nuevaVentana.load();
            Stage escenario = new Stage();
            escenario.setScene(new Scene(padre));
            escenario.setResizable(false);
            escenario.sizeToScene();
            escenario.show();
        } catch (Exception e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        insertarDatosTerapia();
        folio_vista.setText(String.valueOf(fila));
    }
    static int usuario = 2;
    static String tipo = "V";
    static String id_Personal;

    void insertarDatosTerapia() {
        PeticionesPsicologia peticion = new PeticionesPsicologia();
        Conexion conexion = new Conexion();
        peticion.seleccionarPeticionesPsicologiaIdPeticion(conexion.cadena_conexion(), FXMLDocumentController.fila);
        txt_FechEnv.setText(peticion.getFecha_envio());
        txt_AsesJ.setText(String.valueOf(peticion.getId_emisor()));
        txt_NomExp.setText(peticion.getNumero_expediente());

        if (peticion.getNombre_paciente().length() < 1) {

            if (Global.tipo_paciente.equalsIgnoreCase("victima")) {

                Victima victima = new Victima();
                victima.seleccionarVictima(conexion.cadena_conexion(), Integer.parseInt(Global.id_paciente));

                txt_Noms.setText(victima.getNombres());
                txt_ApeP.setText(victima.getApellido_paterno());
                txt_ApeM.setText(victima.getApellido_materno());

            } else if (Global.tipo_paciente.equalsIgnoreCase("agresor")) {

                Agresor agresor = new Agresor();
                agresor.seleccionarAgresor(conexion.cadena_conexion(), Integer.parseInt(Global.id_paciente));

                txt_Noms.setText(agresor.getNombre());
                txt_ApeP.setText(agresor.getApellido_paterno());
                txt_ApeM.setText(agresor.getApellido_materno());
                
            } else if (Global.tipo_paciente.equalsIgnoreCase("custodia")) {

                Custodia custodia = new Custodia();
                custodia.seleccionarCustodia(conexion.cadena_conexion(), Integer.parseInt(Global.id_paciente));

                txt_Noms.setText(custodia.getNombres());
                txt_ApeP.setText(custodia.getApellido_paterno());
                txt_ApeM.setText(custodia.getApellido_materno());
                
            }

        } else {

            txt_Noms.setText(peticion.getNombre_paciente());
            txt_ApeP.setText(peticion.getApellido_paterno_paciente());
            txt_ApeM.setText(peticion.getApellido_materno_paciente());

        }

        txt_Grav.setText(String.valueOf(peticion.getGravedad_peticion()));
        txt_IdP.setText(String.valueOf(peticion.getId_paciente()));
        txt_TipoP.setText(peticion.getTipo_paciente());
        txt_EstP.setText(peticion.getEstatus_peticion());
        txt_Desc.setText(peticion.getDescripcion());
        id_Personal = txt_IdP.getText();

        if (txt_TipoP.getText().equals("AGRESOR")) {
            tipo = "A";
        }

    }

    @FXML
    void guardarCambios(ActionEvent event) {
        PeticionesPsicologia peticion = new PeticionesPsicologia();
        Conexion conexion = new Conexion();
        String newEst = txt_EstP.getText();
        peticion.setEstatus_peticion(newEst);
        System.out.println("Guardando");
        peticion.actualizarEstatusPeticion(conexion.cadena_conexion(), newEst, fila);
    }

    @FXML
    private Label indice;
    @FXML
    private TextArea txt_Desc;

    @FXML
    private JFXTextField txt_IdP;

    @FXML
    private JFXTextField txt_TipoP;

    @FXML
    private JFXTextField txt_ApeM;

    @FXML
    private Label folio_vista;

    @FXML
    private JFXTextField txt_ApeP;

    @FXML
    private JFXTextField txt_FechEnv;

    @FXML
    private JFXTextField txt_Grav;

    @FXML
    private JFXButton btnGuardarCambios;

    @FXML
    private JFXTextField txt_Noms;

    @FXML
    private JFXTextField txt_AsesJ;

    @FXML
    private JFXTextField txt_EstP;

    @FXML
    private JFXTextField txt_NomExp;
}
