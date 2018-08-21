package evnnya_admon;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import conecciones.Conexion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import procedimientos.Direcciones;
import procedimientos.Usuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLModificarUsuarioController implements Initializable {
    
    Herramientas herramienta = new Herramientas();
    ToggleGroup esta1Group = new ToggleGroup();
    ToggleGroup esta2Group = new ToggleGroup();
    String nombre,apePa,apeMa,nacim,sexo,calle,colonia,telefonoFijo,correoElectronico,
            numero,codigoPostal,telefonoMovil,municipio,dpto,nombreUsu,rol,contra,
            especialidad,usuarios;
    int esta1,esta2,asesor,id_dire,tipoUsua,cantidadDeElementos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        asignarGrupos();
        String[] sexo = new String[]{"DESCONOCIDO","HOMBRE","MUJER"};
        String[] dpt = new String[]{"ADMINISTRACION","ASESOR JURIDICO","CASA HOGAR","COORDINACION A. JURIDICOS",
                                    "COORDINACION D. MUNICIPALES","COORDINACION PSICOTERAPIA", "COORDINACION TRABAJO SOCIAL",
                                    "DELEGADO MUNICIPAL", "MESA RECEPTORA", "MICASA", "PSICOTERAPIA", "RECEPCION",
                                    "REFUGIO ESPERANZA","TRABAJO SOCIAL"};
        String[] tipoUsuario = new String[]{"DESCONOCIDO","ADMINISTRADOR","USUARIO NORMAL"};
        String[] municipios = new String[]{"NINGUNO","Coneto de Comonfort","Cuencamé" ,"Victoria de Durango","El Oro","Gómez Palacio","Gral. Simón Boívar","Guadalupe Victoria","Guanaceví","Hidalgo","Indé","Lerdo","Mapimí","Mezquital","Nazas","Nombre de Dios","Nuevo Ideal","Ocampo","Otáez","Pánuco de Coronado","Peñón Blanco","Poanas","Pueblo Nuevo","Rodeo","San Bernardo","San Dimas","San Juan de Guadalupe","San Juan del Río","San Luis del Cordero","San Pedro del Gallo","Santa Clara","Santiago Papasquiaro","Súchil","Tamazula","Tepehuanes","Tlahualilo","Topia","Vicente Guerrero"};
        comboMunicipio.getItems().addAll(municipios);
        comboMunicipio.setValue(municipios[0]);
        txtTelefonoFijo = herramienta.validar(txtTelefonoFijo);
        txtCelular = herramienta.validar(txtCelular);
        comboSexo.getItems().addAll(sexo);
        comboSexo.setValue(sexo[0]);
        txtCodigoPostal = herramienta.validar(txtCodigoPostal);
        comboTipoUsuario.getItems().addAll(tipoUsuario);
        comboTipoUsuario.setValue(tipoUsuario[0]);
        comboDpto.getItems().addAll(dpt);
        comboDpto.setValue(dpt[0]);    
        btnModificar.setDisable(true);
    }    
    @FXML
    private void btnModificarUsuario(ActionEvent event){
        try{
          nombre = txtNombre.getText().toUpperCase();
          apePa = txtApePa.getText().toUpperCase();
          apeMa = txtApeMa.getText().toUpperCase();
          sexo = (String)comboSexo.getValue();
          nacim = dateFechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          correoElectronico = txtCorreo.getText().toUpperCase();
          telefonoFijo = txtTelefonoFijo.getText().toUpperCase();
          numero = txtNumero.getText().toUpperCase();
          codigoPostal = txtCodigoPostal.getText().toUpperCase();
          municipio = (String)comboMunicipio.getValue();
          codigoPostal = txtCodigoPostal.getText().toUpperCase();
          telefonoMovil = txtCelular.getText().toUpperCase();
          dpto = (String) comboDpto.getValue();
          tipoUsua = herramienta.posicionDeUnCombo(comboTipoUsuario);
          rol = txtRol.getText().toUpperCase();
          contra = txtContra.getText().toUpperCase();
          calle = txtCalle.getText();
          colonia = txtColonia.getText().toUpperCase();
          especialidad = txtEspecialidad.getText().toUpperCase();
          if (rBtnEstaFalse1.isSelected()) 
            esta1 = 0;
         else
            esta1 = 1;
         if (rBtnEstaFalse2.isSelected()) 
            esta2 = 0;
         else
             esta2 = 1;
        if (checkBoxAsesor.isSelected()) 
            asesor = 1;
        else
            asesor = 0;
        if (obligarCampos()) {
         Direcciones direcciones = new Direcciones();
         Conexion conexionUsuario = new Conexion();
         Usuarios modificarUsuario = new Usuarios();
         direcciones.actualizarDireccion(conexionUsuario.cadena_conexion(), calle, numero, colonia, Integer.parseInt(codigoPostal),"" ,
                                         "", municipio, "",correoElectronico, telefonoFijo, telefonoMovil, id_dire);
         modificarUsuario.actualizarUsuario(conexionUsuario.cadena_conexion(),nombre,apePa,apeMa,nacim,sexo,
                                            dpto,rol,usuarios,contra,tipoUsua,herramienta.obtenerFechaSistema(),
                                            esta2,"27/03/2100",especialidad,esta1,id_dire);
         modificarUsuario.seleccionarTodosUsuarios(conexionUsuario.cadena_conexion());
       
            JOptionPane.showMessageDialog(null, "El usuario se agrego satisfactoriamente");
            inicializar();
            txtNombreUsuario.setText("");

        
        }else{
            JOptionPane.showMessageDialog(null, "TODOS LOS DATOS SON OBLIGATORIOS.\n"
                 + "EXCEPTUANDO EL SEGMENTO DE ASESOR JURIDICO"); 
        }
        }catch(Exception e){
          btnModificar.setDisable(false);
          JOptionPane.showMessageDialog(null, "Los datos no fueron escritos correctamente");
        }
    }
    
    @FXML
    private void mostrarUsuarios(ActionEvent event){
         try{
            System.out.println("VENTANA USUARIO");
                FXMLLoader nuevaVentana= new FXMLLoader(getClass().getResource("FXMLMostrarUsuario.fxml"));
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
    private void buscarUsuarios(ActionEvent event){
        try{
        Conexion conexionUsuario = new Conexion();
        Usuarios buscarUsuario = new Usuarios();
        usuarios = txtUsuario.getText();
        buscarUsuario.seleccionarUsuario(conexionUsuario.cadena_conexion(), usuarios);
        id_dire = buscarUsuario.getId_direccion();
           if (buscarUsuario.isExiste_usuario()) {
             Direcciones direcciones = new Direcciones();
             direcciones.seleccionarDireccion(conexionUsuario.cadena_conexion(), id_dire);
             //Parametros de usuario
             btnModificar.setDisable(false);
             comboSexo.setValue(buscarUsuario.getSexo());
             txtApeMa.setText(buscarUsuario.getApellido_materno());
             txtApePa.setText(buscarUsuario.getApellido_paterno());
             txtContra.setText(buscarUsuario.getContrasenia());
             txtRol.setText(buscarUsuario.getRol());
             comboDpto.setValue(buscarUsuario.getDepartamento());
             txtNombreUsuario.setText(buscarUsuario.getUsuario());
             txtEspecialidad.setText(buscarUsuario.getEspecialidad_asesor());
             checkBoxAsesor.setSelected(herramienta.convertirIntToBoolean(buscarUsuario.getEstado_actual_asesor()));
             txtNombre.setText(buscarUsuario.getNombres()); 
             comboSexo.setValue(buscarUsuario.getSexo());
             txtEspecialidad.setText(buscarUsuario.getEspecialidad_asesor());
             comboTipoUsuario.getSelectionModel().select(buscarUsuario.getTipo_usuario());
            //Parametros de dirección
             comboMunicipio.setValue(direcciones.getMunicipio());
             txtCorreo.setText(direcciones.getCorreo_electronico());
             txtTelefonoFijo.setText(direcciones.getTelefono_fijo());
             txtCelular.setText(direcciones.getTelefono_movil());
             txtNumero.setText(direcciones.getNumero());
             txtCodigoPostal.setText(Integer.toString(direcciones.getCodigo_postal()));
             txtColonia.setText(direcciones.getColonia());
             txtCalle.setText(direcciones.getCalle());
               
               if (buscarUsuario.getStatus()==0) 
                   rBtnEstaTrue1.setSelected(true);
               else
                   rBtnEstaFalse2.setSelected(true);
               
               if (buscarUsuario.getEstado_actual_asesor()==0) 
                   checkBoxAsesor.setSelected(true);
               else
                   checkBoxAsesor.setSelected(false);
               
               if (buscarUsuario.getEstado_actual_asesor()==1) 
                   rBtnEstaTrue2.setSelected(true);
               else
                   rBtnEstaFalse2.setSelected(false);
 
             dateFechaNacimiento.setValue(LocalDate.parse(buscarUsuario.getFecha_nacimiento()));  
            }else{
               JOptionPane.showMessageDialog(null, "El usuario no existe");
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "El usuario no fue encontrado");
        }
    }     
    
    private void asignarGrupos(){
        rBtnEstaFalse1.setToggleGroup(esta1Group);
        rBtnEstaTrue1.setToggleGroup(esta1Group);
        rBtnEstaTrue2.setToggleGroup(esta2Group);
        rBtnEstaFalse2.setToggleGroup(esta2Group);
    }
    
    private boolean obligarCampos(){
        try{
        System.out.println("Herramientas{" + "nombre=" + nombre + ", apePa=" + apePa + ", apeMa=" + apeMa + ", nacim=" + nacim + ", sexo=" + sexo + ", calle=" + calle + ", colonia=" + colonia + ", telefonoFijo=" + telefonoFijo + ", correoElectronico=" + correoElectronico + ", numero=" + numero + ", telefonoMovil=" + telefonoMovil + ", municipio=" + municipio + ", dpto=" + dpto + ", nombreTipoUsua=" + tipoUsua + ", rol=" + rol + ", contra=" + contra + ", codigoPostal=" + codigoPostal + '}');
        return  !"".equals(dpto) && !"".equals(apeMa) && !"".equals(apePa) && !"".equals(calle) && !"".equals(colonia) &&
                !"".equals(String.valueOf(codigoPostal)) && !"".equals(contra) && !nacim.equals("") && !nombre.equals("")
                && !"".equals(String.valueOf(tipoUsua)) && !numero.equals("") && !correoElectronico.equals("") && !rol.equals("")
                && !sexo.equals("") && !telefonoFijo.equals("") && !telefonoMovil.equals("");
        }catch(Exception e){
            System.out.println("ObligarCampos "+e);
        return false;
        }
    }
    
    private void inicializar(){
        comboDpto.getSelectionModel().select(0);
        comboMunicipio.getSelectionModel().select(0);
        comboSexo.getSelectionModel().select(0);
        comboTipoUsuario.getSelectionModel().select(0);
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
        txtTelefonoFijo.setText("");
        txtCelular.setText("");
        txtUsuario.setText("");
        rBtnEstaFalse1.setSelected(false);
        rBtnEstaFalse2.setSelected(false);
        rBtnEstaTrue1.setSelected(false);
        rBtnEstaTrue2.setSelected(false);
    }
    
    private void validarCampos(){
        txtTelefonoFijo = herramienta.validar(txtTelefonoFijo);
        txtCelular = herramienta.validar(txtCelular);
        
    }
    
    @FXML
    private JFXRadioButton rBtnEstaTrue1;

    @FXML
    private JFXRadioButton rBtnEstaTrue2;

    @FXML
    private DatePicker dateFechaNacimiento;

    @FXML
    private JFXRadioButton rBtnEstaFalse1;

    @FXML
    private JFXTextField txtNumero,txtNombreUsuario;

    @FXML
    private JFXRadioButton rBtnEstaFalse2;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXTextField txtColonia;

    @FXML
    private JFXTextField txtApeMa;

    @FXML
    private JFXComboBox comboTipoUsuario;

    @FXML
    private JFXCheckBox checkBoxAsesor;

    @FXML
    private JFXTextField txtEspecialidad;

    @FXML
    private JFXTextField txtCelular;

    @FXML
    private JFXComboBox comboMunicipio;

    @FXML
    private JFXComboBox comboSexo;

    @FXML
    private JFXTextField txtUsuario;

    @FXML
    private JFXTextField txtTelefonoFijo;

    @FXML
    private JFXComboBox comboDpto;

    @FXML
    private JFXTextField txtCorreo;

    @FXML
    private JFXTextField txtCalle;

    @FXML
    private JFXTextField txtContra;

    @FXML
    private JFXTextField txtApePa;

    @FXML
    private JFXTextField txtCodigoPostal;

    @FXML
    private JFXTextField txtRol;

    @FXML
    private JFXButton btnModificar;
}
