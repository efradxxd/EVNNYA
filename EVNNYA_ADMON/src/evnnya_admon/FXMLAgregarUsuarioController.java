package evnnya_admon;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import conecciones.Conexion;
import procedimientos.Usuarios;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;
import conecciones.Conexion;
import java.time.format.DateTimeFormatter;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import procedimientos.Usuarios;
import procedimientos.Direcciones;

public class FXMLAgregarUsuarioController implements Initializable {
    
    Herramientas herramienta = new Herramientas();
    ToggleGroup esta1Group = new ToggleGroup();
    ToggleGroup esta2Group = new ToggleGroup();
    String nombre,apePa,apeMa,nacim,sexo,calle,colonia,telefonoFijo,correoElectronico,numero,telefonoMovil,municipio,dpto,rol
            ,contra,especialidad, usuarios;
    int esta1,esta2,asesor,codigoPostal,tipoUsua;
    int cantidadDeElementos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        validarCampos();
        asignarGrupos();
        String[] sexo = new String[]{"DESCONOCIDO","HOMBRE","MUJER"};
        String[] dpt = new String[]{"ADMINISTRACION","ASESOR JURIDICO","CASA HOGAR","COORDINACION A. JURIDICOS",
                                    "COORDINACION D. MUNICIPALES","COORDINACION PSICOTERAPIA", "COORDINACION TRABAJO SOCIAL",
                                    "DELEGADO MUNICIPAL", "MESA RECEPTORA", "MICASA", "PSICOTERAPIA", "RECEPCION",
                                    "REFUGIO ESPERANZA","TRABAJO SOCIAL"};
        String[] tipoUsuario = new String[]{"DESCONOCIDO","ADMINISTRADOR","USUARIO NORMAL","COORDINADOR"};
        String[] municipios = new String[]{"NINGUNO","Coneto de Comonfort","Cuencamé" ,"Victoria de Durango","El Oro","Gómez Palacio","Gral. Simón Boívar","Guadalupe Victoria","Guanaceví","Hidalgo","Indé","Lerdo","Mapimí","Mezquital","Nazas","Nombre de Dios","Nuevo Ideal","Ocampo","Otáez","Pánuco de Coronado","Peñón Blanco","Poanas","Pueblo Nuevo","Rodeo","San Bernardo","San Dimas","San Juan de Guadalupe","San Juan del Río","San Luis del Cordero","San Pedro del Gallo","Santa Clara","Santiago Papasquiaro","Súchil","Tamazula","Tepehuanes","Tlahualilo","Topia","Vicente Guerrero"};
        comboMunicipio.getItems().addAll(municipios);
        comboMunicipio.setValue(municipios[0]);
        comboSexo.getItems().addAll(sexo);
        comboSexo.setValue(sexo[0]);
        comboTipoUsuario.getItems().addAll(tipoUsuario);
        comboTipoUsuario.setValue(tipoUsuario[0]);
        comboDpto.getItems().addAll(dpt);
        comboDpto.setValue(dpt[0]);    
    }    
    
    @FXML
    private void agregarUsuario(){
        try{
        nombre = txtNombre.getText();
        apePa = txtApePa.getText();
        apeMa = txtApeMa.getText();
        nacim = dateFecha.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        sexo = (String) comboSexo.getValue();
        dpto = (String) comboDpto.getValue();
        rol = txtRol.getText();
        usuarios = txtUsuario.getText();
        contra = txtContra.getText();
        calle = txtCalle.getText();
        colonia = txtColonia.getText();
        numero = txtNumero.getText();
        telefonoFijo = txtTelefono.getText();
        telefonoMovil = txtTelefono2.getText();
        codigoPostal = Integer.parseInt(txtCodigoPostal.getText());
        especialidad = txtEspecialidad.getText();
        municipio = (String)comboMunicipio.getValue();
        correoElectronico =  txtCorreo.getText();
        tipoUsua = herramienta.posicionDeUnCombo(comboTipoUsuario);
        if (rBtnTrue1.isSelected()) 
            esta1 = 1;
        else
            esta1 = 0;
        if(rBtntrue2.isSelected())
            esta2 = 1;
        else
            esta2 = 0;
        try{
        if (obligarCampos()) {     
        Direcciones direcciones = new Direcciones();
        Conexion conexion = new Conexion();
        Usuarios usuarioAgregar = new Usuarios();
        usuarioAgregar.seleccionarTodosUsuarios(conexion.cadena_conexion());
        cantidadDeElementos = usuarioAgregar.getListaApellidoMaterno().size();
        direcciones.agregarDireccion(conexion.cadena_conexion(), calle, numero, colonia, codigoPostal,"" , "", municipio, "",
                correoElectronico, telefonoFijo, telefonoMovil);
        usuarioAgregar.agregarUsuario(conexion.cadena_conexion(), nombre, apePa, apeMa, nacim, sexo, dpto, rol, usuarios,
                contra, tipoUsua, herramienta.obtenerFechaSistema(), esta2, "27/03/2100", especialidad, esta1);
        usuarioAgregar.seleccionarTodosUsuarios(conexion.cadena_conexion());
        if (cantidadDeElementos != usuarioAgregar.getListaNombres().size()) {
            JOptionPane.showMessageDialog(null, "El usuario se agrego satisfactoriamente");
            cantidadDeElementos = usuarioAgregar.getListaNombres().size();
            inicializar();
        }else
            JOptionPane.showMessageDialog(null, "ERROR:\nEl usuario esta repetido ó algún problema de conexión.");
            }else
            JOptionPane.showMessageDialog(null, "TODOS LOS DATOS SON OBLIGATORIOS.\n"
                    + "EXCEPTUANDO EL SEGMENTO DE ASESOR JURIDICO"); 
        }catch(Exception a){
                
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR EN LA LECTURA DE DATOS\n"+e);
        }
    }
    
    private boolean obligarCampos(){
        try{
        System.out.println("Herramientas{" + "nombre=" + nombre + ", apePa=" + apePa + ", apeMa=" + apeMa + ", nacim=" + nacim + ", sexo=" + sexo + ", calle=" + calle + ", colonia=" + colonia + ", telefonoFijo=" + telefonoFijo + ", correoElectronico=" + correoElectronico + ", numero=" + numero + ", telefonoMovil=" + telefonoMovil + ", municipio=" + municipio + ", dpto=" + dpto + ", nombreTipoUsua=" + tipoUsua + ", rol=" + rol + ", contra=" + contra + ", especialidad=" + especialidad + ", usuarios=" + usuarios + ", codigoPostal=" + codigoPostal + '}');
        return  !"".equals(dpto) && !"".equals(apeMa) && !"".equals(apePa) && !"".equals(calle) && !"".equals(colonia) &&
                !"".equals(String.valueOf(codigoPostal)) && !"".equals(contra) && !nacim.equals("") && !nombre.equals("")
                && !"".equals(String.valueOf(tipoUsua)) && !numero.equals("") && !correoElectronico.equals("") && !rol.equals("")
                && !sexo.equals("") && !telefonoFijo.equals("") && !telefonoMovil.equals("");
        }catch(Exception e){
        return false;
        }
    }
    
    private void inicializar(){
        txtApeMa.setText("");
        txtApePa.setText("");
        txtCalle.setText("");
        txtCodigoPostal.setText("");
        txtColonia.setText("");
        txtContra.setText("");
        txtCorreo.setText("");
        txtEspecialidad.setText("");
        txtNombre.setText("");
        txtNumero.setText("");
        txtRol.setText("");
        txtTelefono.setText("");
        txtTelefono2.setText("");
        txtUsuario.setText("");
        comboDpto.getSelectionModel().select(0);
        comboMunicipio.getSelectionModel().select(0);
        comboSexo.getSelectionModel().select(0);
        comboTipoUsuario.getSelectionModel().select(0);
        rBtnFalse1.setSelected(false);
        rBtnFalse2.setSelected(false);
        rBtnTrue1.setSelected(false);
        rBtntrue2.setSelected(false);
    }
    
    public void validarCampos(){
        txtCodigoPostal = herramienta.validar(txtCodigoPostal);
        txtTelefono = herramienta.validar(txtTelefono);
        txtTelefono2 = herramienta.validar(txtTelefono2);
    }
    
    private void asignarGrupos(){
        rBtnFalse1.setToggleGroup(esta1Group);
        rBtnTrue1.setToggleGroup(esta1Group);
        rBtntrue2.setToggleGroup(esta2Group);
        rBtnFalse2.setToggleGroup(esta2Group);
    }
    
    @FXML
    private JFXTextField txtNumero;

    @FXML
    private JFXCheckBox checlkAsesor;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXTextField txtColonia;

    @FXML
    private JFXRadioButton rBtnFalse2;

    @FXML
    private JFXRadioButton rBtnFalse1;

    @FXML
    private JFXTextField txtApeMa;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private JFXRadioButton rBtnTrue1;

    @FXML
    private JFXComboBox comboMunicipio;

    @FXML
    private JFXComboBox comboSexo;

    @FXML
    private JFXButton btnAgregar;

    @FXML
    private DatePicker dateFecha;

    @FXML
    private JFXComboBox comboDpto;

    @FXML
    private JFXTextField txtCorreo;

    @FXML
    private JFXTextField txtEspecialidad;

    @FXML
    private JFXTextField txtUsuario;

    @FXML
    private JFXTextField txtCalle;

    @FXML
    private JFXTextField txtContra;

    @FXML
    private JFXTextField txtApePa;

    @FXML
    private JFXTextField txtCodigoPostal;

    @FXML
    private JFXComboBox comboTipoUsuario;

    @FXML
    private JFXTextField txtRol;

    @FXML
    private JFXRadioButton rBtntrue2;

    @FXML
    private JFXTextField txtTelefono2;
}
