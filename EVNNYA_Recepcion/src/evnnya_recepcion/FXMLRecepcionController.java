package evnnya_recepcion;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import conecciones.Conexion;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import procedimientos.Direcciones;
import procedimientos.Recepcion;
import utilidades.DatosSesion;

public class FXMLRecepcionController implements Initializable {

    Herramientas herramienta = new Herramientas();
    //Solicitante
    public String nombre, apellidoPa, apellidoMa, calle, colonia, contraParte;
    public int codigoPostal, numero, edad;
    public String municipio, conOcupacion, asesoria, edoCivil, maltrato;
    //Contra Parte
    public String conNombre, conApellidoPa, conApellidoMa, ocupacion, observaciones;
    
    String[] array_asesor = new String[]{"NINGUNO", "JORGE LUIS HERNANDEZ SOLIS", "MARIA DEL CARMEN FERNANDEZ FERNANDEZ",
                                                "CARLOS MORALES CARRILLO"};
    
    String[] municipios = new String[]{"NINGUNO", "Coneto de Comonfort", "Cuencamé", "Victoria de Durango", "El Oro", "Gómez Palacio", "Gral. Simón Boívar", "Guadalupe Victoria", "Guanaceví", "Hidalgo", "Indé", "Lerdo", "Mapimí", "Mezquital", "Nazas", "Nombre de Dios", "Nuevo Ideal", "Ocampo", "Otáez", "Pánuco de Coronado", "Peñón Blanco", "Poanas", "Pueblo Nuevo", "Rodeo", "San Bernardo", "San Dimas", "San Juan de Guadalupe", "San Juan del Río", "San Luis del Cordero", "San Pedro del Gallo", "Santa Clara", "Santiago Papasquiaro", "Súchil", "Tamazula", "Tepehuanes", "Tlahualilo", "Topia", "Vicente Guerrero"};
            
    String[] array_procurador = new String[]{"NINGUNO", "M.D. RAQUEL LEILA ARREOLA FALLAD", "MA. ELIZABETH ENRIQUEZ SOTO",
                                                    "LIC. JOSE LUIS HERRERA HERRERA"};

    @FXML
    private void botonAceptar(ActionEvent event) {
        try {
            municipio = ((String) comboMunicipio.getValue()).toUpperCase();
            edad = Integer.parseInt(txtEdad.getText());
            apellidoMa = txtApellidoMa.getText().toUpperCase();
            apellidoPa = txtApellidoPa.getText().toUpperCase();
            calle = txtCalle.getText().toUpperCase();
            codigoPostal = Integer.parseInt(txtCodigoPostal.getText());
            colonia = txtColonia.getText().toUpperCase();
            conApellidoMa = txtConApeMa.getText().toUpperCase();
            conApellidoPa = txtConApellidoPa.getText().toUpperCase();
            conNombre = txtConNombre.getText().toUpperCase();
            nombre = txtNombre.getText().toUpperCase();
            numero = Integer.parseInt(txtNumero.getText());
            conOcupacion = txtConOcupacion.getText().toUpperCase();
            ocupacion = txtOcupacion.getText().toUpperCase();
            observaciones = txtObservaciones.getText().toUpperCase();
            System.out.println("Herramientas{" + "nombre=" + nombre + ", apellidoPa=" + apellidoPa + ", apellidoMa=" + apellidoMa + ", calle=" + calle + ", colonia=" + colonia + ", contraParte=" + contraParte + ", codigoPostal=" + codigoPostal + ", numero=" + numero + ", edad=" + edad + ", municipio=" + municipio + ", conOcupacion=" + conOcupacion + ", asesoria=" + asesoria + ", edoCivil=" + edoCivil + ", maltrato=" + maltrato + ", conNombre=" + conNombre + ", conApellidoPa=" + conApellidoPa + ", conApellidoMa=" + conApellidoMa + ", ocupacion=" + ocupacion + ", observaciones=" + observaciones + '}');
            System.out.println(herramienta.obtenerFechaSistema());
            //ENVIAR AL SERVIDOR

            Conexion conexion = new Conexion();
            Recepcion recepcion = new Recepcion();
            Direcciones direccion = new Direcciones();

            direccion.agregarDireccion(conexion.cadena_conexion(), calle, Integer.toString(numero), colonia, codigoPostal, "", "", municipio, "", "", "", "");
            recepcion.agregarFichaRecepcion(conexion.cadena_conexion(), nombre, apellidoPa, apellidoMa, edad, ocupacion, edoCivil,
                    asesoria, maltrato, conNombre, conApellidoPa, conApellidoMa, conOcupacion, 1, observaciones, "VICTORIA DE DURANGO", Integer.parseInt(Global.id), herramienta.obtenerFechaSistema());
            JOptionPane.showMessageDialog(null, "Exito en agregar la ficha");
        } catch (Exception e) {
            try {
                nombre = txtNombre.getText().toUpperCase();
            } catch (Exception ed) {

            }
            if (!nombre.equals("")) {
                Conexion conexion = new Conexion();
                Recepcion recepcion = new Recepcion();
                Direcciones direccion = new Direcciones();
                direccion.agregarDireccion(conexion.cadena_conexion(), calle, Integer.toString(numero), colonia, codigoPostal, "", "", municipio, "", "", "", "");
                recepcion.agregarFichaRecepcion(conexion.cadena_conexion(), nombre, apellidoPa, apellidoMa, edad, ocupacion, edoCivil, asesoria, maltrato, conNombre, conApellidoPa, conApellidoMa, conOcupacion, 1, observaciones, "VICTORIA DE DURANGO", Integer.parseInt(Global.id), herramienta.obtenerFechaSistema());
                JOptionPane.showMessageDialog(null, "Exito en agregar la ficha");
            } else {
                JOptionPane.showMessageDialog(null, "Datos obligatorios:\n*NOMBRE");
            }
        }
        asignarValorInicialVariables();
        reiniciarCampos();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    private void asignarGrupos() {
        //GRUPO ESTADO CIVIL
        rBtnCasado.setToggleGroup(grupoEstadoCivil);
        rBtnUnionLibre.setToggleGroup(grupoEstadoCivil);
        rBtnHijos.setToggleGroup(grupoEstadoCivil);
        rBtnSoltero.setToggleGroup(grupoEstadoCivil);
        //GRUPO ASESORÍA
        rBtnJuridica.setToggleGroup(grupoAsesoria);
        rBtnFamiliar.setToggleGroup(grupoAsesoria);
        rBtnPension.setToggleGroup(grupoAsesoria);
        rBtnVoluntario.setToggleGroup(grupoAsesoria);
        rBtnNecesario.setToggleGroup(grupoAsesoria);
        rBtnOrdCivil.setToggleGroup(grupoAsesoria);
        rBtnOtros.setToggleGroup(grupoAsesoria);
        //GRUPO MALTRATO
        rBtnMaltratoSexual.setToggleGroup(grupoMaltrato);
        rBtnMaltratoEmocional.setToggleGroup(grupoMaltrato);
        rBtnMaltratoGrave.setToggleGroup(grupoMaltrato);
        rBtnMaltratoLeve.setToggleGroup(grupoMaltrato);
        rBtnMaltratoPatrimonial.setToggleGroup(grupoMaltrato);
        //GRUPO CONTRA PARTE
        rBtnCavim.setToggleGroup(grupoContraParte);
        rBtnCitatorio.setToggleGroup(grupoContraParte);
        rBtnDenuncia.setToggleGroup(grupoContraParte);
        rBtnComparecencia.setToggleGroup(grupoContraParte);

    }

    @FXML
    private void getEdoCivil(ActionEvent event) {
        edoCivil = herramienta.obtenerElString(event.getSource().toString()).toUpperCase();
        System.out.println(edoCivil);
    }

    @FXML
    private void getAsesoria(ActionEvent event) {
        asesoria = herramienta.obtenerElString(event.getSource().toString()).toUpperCase();
        System.out.println(asesoria);
    }

    @FXML
    private void getMaltrato(ActionEvent event) {
        maltrato = herramienta.obtenerElString(event.getSource().toString()).toUpperCase();
        System.out.println(maltrato);
    }

    @FXML
    private void contraParte(ActionEvent event) {
        contraParte = herramienta.obtenerElString(event.getSource().toString()).toUpperCase();
        System.out.println(contraParte);
    }

    @FXML
    public void verFicha(ActionEvent event) {

        pnlJuridicos.setVisible(false);
        pnlProcuraduria.setVisible(false);
        pnlFicha.setVisible(true);

    }

    @FXML
    public void verProcuraduria(ActionEvent event) {

        pnlJuridicos.setVisible(false);
        pnlFicha.setVisible(false);
        pnlProcuraduria.setVisible(true);

    }

    @FXML
    public void verJuridicos(ActionEvent event) {

        pnlProcuraduria.setVisible(false);
        pnlFicha.setVisible(false);
        pnlJuridicos.setVisible(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        File af = new File("C:\\evnnya\\archivo.evn");

        if (af.exists()) {

            DatosSesion datos_sesion = new DatosSesion();

            try {

                datos_sesion.traerDatos();
                Global.id = datos_sesion.getId();
                Global.nombres = datos_sesion.getNombres();
                Global.apellido_paterno = datos_sesion.getApe_paterno();
                Global.departamento = datos_sesion.getDepartamento();
                Global.tipo_usuario = datos_sesion.getTipo_usuario();

                System.out.println(Global.nombres);

            } catch (IOException ex) {
                Logger.getLogger(FXMLRecepcionController.class.getName()).log(Level.SEVERE, null, ex);
            }

            asignarGrupos();
            asignarValorInicialVariables();
            txtEdad.setOnKeyTyped(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    char car = event.getCharacter().charAt(0);
                    if (Character.isLetter(car)) {
                        event.consume();
                    }
                }

            });
            txtCodigoPostal.setOnKeyTyped(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    char car = event.getCharacter().charAt(0);
                    if (Character.isLetter(car)) {
                        event.consume();
                    }
                }

            });
            comboMunicipio.setValue(municipios[0]);
            comboMunicipio.getItems().addAll(municipios);
            
            comboMunicipioP.setValue(municipios[0]);
            comboMunicipioP.getItems().addAll(municipios);
            
            comboMunicipioJ.setValue(municipios[0]);
            comboMunicipioJ.getItems().addAll(municipios);
            
            
            comboProcurador.setValue(array_procurador[0]);
            comboProcurador.getItems().addAll(array_procurador);
            
            
            comboAsesor.setValue(array_asesor[0]);
            comboAsesor.getItems().addAll(array_asesor);

        } else {
            JOptionPane.showMessageDialog(null, "DEBE INICIAR SESION PRIMERO");
            System.exit(0);
        }

    }

    private void asignarValorInicialVariables() {
        nombre = "";
        apellidoMa = "";
        apellidoPa = "";
        calle = colonia = "";
        contraParte = "";
        municipio = "";
        conOcupacion = "";
        asesoria = "";
        edoCivil = "";
        maltrato = "";
        conNombre = "";
        conApellidoPa = "";
        conApellidoMa = "";
        ocupacion = "";
        observaciones = "";
        codigoPostal = numero = edad = 0;
    }

    private void reiniciarCampos() {
        comboMunicipio.setValue(municipios[0]);
        txtApellidoMa.setText("");
        txtApellidoPa.setText("");
        txtCalle.setText("");
        txtCodigoPostal.setText("");
        txtColonia.setText("");
        txtConApeMa.setText("");
        txtConApellidoPa.setText("");
        txtConNombre.setText("");
        txtConOcupacion.setText("");
        txtConOcupacion.setText("");
        txtEdad.setText("");
        txtNombre.setText("");
        txtNumero.setText("");
        txtObservaciones.setText("");
        txtOcupacion.setText("");
        rBtnCasado.setSelected(false);
        rBtnCavim.setSelected(false);
        rBtnCitatorio.setSelected(false);
        rBtnComparecencia.setSelected(false);
        rBtnDenuncia.setSelected(false);
        rBtnFamiliar.setSelected(false);
        rBtnHijos.setSelected(false);
        rBtnJuridica.setSelected(false);
        rBtnMaltratoEmocional.setSelected(false);
        rBtnMaltratoGrave.setSelected(false);
        rBtnMaltratoLeve.setSelected(false);
        rBtnMaltratoPatrimonial.setSelected(false);
        rBtnMaltratoSexual.setSelected(false);
        rBtnNecesario.setSelected(false);
        rBtnOrdCivil.setSelected(false);
        rBtnOtros.setSelected(false);
        rBtnPension.setSelected(false);
        rBtnSoltero.setSelected(false);
        rBtnUnionLibre.setSelected(false);
        rBtnVoluntario.setSelected(false);
    }
    
    @FXML
    private void enviarDatosP() {
        comboMunicipioP.setValue(municipios[0]);
        txtApellidoMaP.setText("");
        txtApellidoPaP.setText("");
        txtCalleP.setText("");
        txtCodigoPostalP.setText("");
        txtColoniaP.setText("");
        txtEdadP.setText("");
        txtNombreP.setText("");
        txtNumeroP.setText("");
        txtObservacionesP.setText("");
        comboProcurador.setValue(array_procurador[0]);
        
        JOptionPane.showMessageDialog(null, "SE AGREGO EXITOSAMENTE.");
        
    }
    
    @FXML
    private void enviarDatosJ() {
        
        comboMunicipioJ.setValue(municipios[0]);
        txtApellidoMaJ.setText("");
        txtApellidoPaJ.setText("");
        txtCalleJ.setText("");
        txtCodigoPostalJ.setText("");
        txtColoniaJ.setText("");
        txtEdadJ.setText("");
        txtNombreJ.setText("");
        txtNumeroJ.setText("");
        txtObservacionesJ.setText("");
        comboAsesor.setValue(array_asesor[0]);
        
        JOptionPane.showMessageDialog(null, "SE AGREGO EXITOSAMENTE.");
        
    }
    
    @FXML
    JFXTextField txtEdad, txtNombre, txtApellidoPa, txtApellidoMa, txtCalle,
            txtNumero, txtColonia, txtCodigoPostal, txtOcupacion,
            
            txtEdadP, txtNombreP, txtApellidoPaP, txtApellidoMaP, txtCalleP,
            txtNumeroP, txtColoniaP, txtCodigoPostalP,
            
            txtEdadJ, txtNombreJ, txtApellidoPaJ, txtApellidoMaJ, txtCalleJ,
            txtNumeroJ, txtColoniaJ, txtCodigoPostalJ;
    @FXML
    JFXRadioButton rBtnCasado, rBtnUnionLibre, rBtnSoltero, rBtnHijos;
    @FXML
    JFXComboBox comboMunicipio, comboMunicipioP, comboMunicipioJ, comboProcurador, comboAsesor;
    @FXML
    TextArea txtObservaciones, txtObservacionesP, txtObservacionesJ;
    //Asesoría
    @FXML
    JFXRadioButton rBtnJuridica, rBtnFamiliar, rBtnPension, rBtnVoluntario, rBtnNecesario,
            rBtnOrdCivil, rBtnOtros;
    //Maltrato
    @FXML
    JFXRadioButton rBtnMaltratoLeve, rBtnMaltratoSexual, rBtnMaltratoGrave,
            rBtnMaltratoPatrimonial, rBtnMaltratoEmocional;
    //CONTRAPARTE
    @FXML
    JFXTextField txtConNombre, txtConApellidoPa, txtConApeMa, txtConOcupacion;
    @FXML
    JFXRadioButton rBtnCitatorio, rBtnCavim, rBtnDenuncia, rBtnComparecencia;
    //Final de pantalla
    @FXML
    JFXButton btnAceptar, btnFicha, btnProcuraduria, btnJuridicos, btnAceptarP, btnAceptarJ;

    @FXML
    Pane pnlFicha, pnlProcuraduria, pnlJuridicos;

    ToggleGroup grupoEstadoCivil = new ToggleGroup();
    ToggleGroup grupoAsesoria = new ToggleGroup();
    ToggleGroup grupoMaltrato = new ToggleGroup();
    ToggleGroup grupoContraParte = new ToggleGroup();

}
