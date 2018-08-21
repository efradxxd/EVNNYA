package evnnya_reporte;

import conecciones.Conexion;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import procedimientos.Victima;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import java.sql.Connection;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.text.TabableView;
import procedimientos.Agresor;
import procedimientos.Custodia;
import procedimientos.Direcciones;
import procedimientos.Reportes;
import procedimientos.Usuarios;
import procedimientos.Denunciantes;
import procedimientos.Vulnerabilidad;

/**
 *
 * @author lucia
 */
public class FXMLDocumentController implements Initializable {

    int reporte = 97;
    
    public String Noexpediente;
    public String Fechareporte;
    public String Oficio;
    public String TipoReporte;
    public String recibio;
    public String Envia;
    public String Noreporte;
    public String Nombre;
    public String Escolaridad;
    public String Calle;
    public String Numero;
    public String Colonia;
    public String CodigoPostal;
    public String TelefonoFijo;
    public String TelefonoMovil;
    public String Correo;
    public String Municipio;
    public String Dcalle;
    public String Dnumero;
    public String Dcolonia;
    public String DCodigoPostal;
    public String DMunicipio;
    public String Dentrecalle;
    public String Dycalle;
    public String Referencia;
    public String CNombre;
    public String CEscolaridad;
    public String Ccorreo;
    public String Ccalle;
    public String CcodigoPostal;
    public String CEdad;
    public String CSexo;
    public String CRelacion;
    public String CTelfijo;
    public String CTelmovil;
    public String CNumero;
    public String Ccolonia;
    public String CMunicipio;

    @FXML
    private JFXCheckBox checkLibertadConvic;

    @FXML
    private Label txtCodigoP;

    @FXML
    private Label txtDcodigoP;

    @FXML
    private JFXCheckBox checkIntimidad;

    @FXML
    private Label txtsexo;

    @FXML
    private Label txtTiporeporte;

    @FXML
    private Label txtEdad;

    @FXML
    private Label txtNoreport;

    @FXML
    private Label txtTelefonofij;

    @FXML
    private Label txtDmunicipio;

    @FXML
    private JFXCheckBox checkNodiscriminado;

    private TableColumn<TablaVictimas, Integer> colTelMovill;

    @FXML
    private Label txtNooficio;

    @FXML
    private Label txtEdadC;

    @FXML
    private Label txtColoniaC;

    @FXML
    private JFXCheckBox checkPrioridad;

    @FXML
    private Label txtNombre;

    @FXML
    private Label txtColonia;

    @FXML
    private Label txtDnumero;

    @FXML
    private Label txtFechaoficio;

    private TableColumn<TablaVictimas, String> colCorreo;

    @FXML
    private JFXCheckBox checkIdentidad;

    @FXML
    private Label txtCorreoC;

    @FXML
    private JFXCheckBox checkDescanso;

    @FXML
    private Label txtDcolonia;

    @FXML
    private Label txtEscolaridadC;

    @FXML
    private TableView<TablaVictimas> tablaVictimas = new TableView<>();

    @FXML
    private TextArea txtReferencia;

    private TableColumn<TablaVictimas, String> colEdad;

    @FXML
    private Label txtCalleC;

    @FXML
    private Label txtSexoC;

    @FXML
    private Label txtTelefonomovilC;

    @FXML
    private TextArea txtReseña;

    @FXML
    private JFXCheckBox checkReunion;

    @FXML
    private Label txtCodigoPC;

    private TableColumn<TablaVictimas, String> colRelacionAgresor;

    @FXML
    private Label txtMunicipioC;

    @FXML
    private JFXCheckBox checkSeguridadju;

    private TableColumn<TablaVictimas, String> columnaNombre;

    @FXML
    private TextArea txtObservaciones;

    private TableColumn<TablaVictimas, String> colEscolaridad;

    @FXML
    private JFXCheckBox check_Libertadexp;
    @FXML
    private Label txtMunipio;

    @FXML
    private JFXCheckBox checkVidalibre;

    @FXML
    private Label txtRelacionvictimaC;

    @FXML
    private TableView<TablaAgresor> tablaAgresor = new TableView<>();

    @FXML
    private JFXCheckBox checkVivirfam;

    @FXML
    private Label txtEnvia;

    @FXML
    private JFXCheckBox checkParticipacion;

    @FXML
    private Label txtNoexpediente;

    @FXML
    private JFXCheckBox checkMigrantes;

    @FXML
    private JFXCheckBox checkVida;

    @FXML
    private JFXCheckBox checkProteccionsalud;

    @FXML
    private Label txtTelefonomovil;

    @FXML
    private Label txtTipopersona;

    @FXML
    private Label txtRecibio;

    @FXML
    private JFXButton btnImprimir;

    @FXML
    private Label txtDycalle;

    @FXML
    private JFXCheckBox checkIgualdadsus;

    private TableColumn<TablaVictimas, String> colSexo;

    @FXML
    private Label txtRelacionvic;

    private TableColumn<TablaVictimas, Integer> colTelFijo;

    @FXML
    private Label txtCorreo;

    @FXML
    private Label txtDentrecalle;

    @FXML
    private Label txtTelefonofijoC;

    @FXML
    private Label txtEscolaridad;

    @FXML
    private Label txtCalle;

    @FXML
    private Label txtHorareporte;

    @FXML
    private Label txtFechareporte;

    @FXML
    private Label txtNumeroC;

    @FXML
    private JFXCheckBox checkCondicionesbien;

    @FXML
    private JFXCheckBox checkTic;

    @FXML
    private JFXCheckBox checkEducacion;

    @FXML
    private JFXCheckBox checkInclusionniños;

    @FXML
    private Label txtDcalle;

    @FXML
    private Label txtNombreC;

    public FXMLDocumentController() {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarTabla();
        seleccionarReportes();
        Tablaagresor();
    }

    private void mostrarTabla() {

        TableColumn<TablaVictimas, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<TablaVictimas, String> colCorreo = new TableColumn<>("Correo");
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        TableColumn<TablaVictimas, String> colEdad = new TableColumn<>("Edad");
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        TableColumn<TablaVictimas, String> colEscolaridad = new TableColumn<>("Escolaridad");
        colEscolaridad.setCellValueFactory(new PropertyValueFactory<>("escolaridad"));
        TableColumn<TablaVictimas, String> colSexo = new TableColumn<>("Sexo");
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        TableColumn<TablaVictimas, String> colRelacionAgresor = new TableColumn<>("Relacion");
        colRelacionAgresor.setCellValueFactory(new PropertyValueFactory<>("relacion"));
        TableColumn<TablaVictimas, String> colTelFijo = new TableColumn<>("Telfijo");
        colTelFijo.setCellValueFactory(new PropertyValueFactory<>("telfijo"));
        TableColumn<TablaVictimas, String> colTelMovil = new TableColumn<>("TelMovil");
        colTelMovil.setCellValueFactory(new PropertyValueFactory<>("telmovil"));

        try {
            Conexion conexion = new Conexion();
            Victima victima = new Victima();
             Direcciones direccion = new Direcciones();
            victima.seleccionarListaVictimasReporte(conexion.cadena_conexion(), reporte);
            List<String> listaNombres = victima.getListaNombres();
            List<String> listaEdad = victima.getListaEdad();
            List<String> listaEscolariad = victima.getListaEscolaridad();
            List<String> listaRelacion = victima.getListaRelacionAgresor();
            List<String> listaSexo = victima.getListaSexo();
            List<String> listaCorreo = new ArrayList<String>();
            List<String> listaTelefonoFijo = new ArrayList<String>();
            List<String> listaTelefonoMovil = new ArrayList<String>();
            List<String> listaId = victima.getListaIdDireccion();
            for (int i = 0; i < listaId.size(); i++) {
                direccion.seleccionarDireccion(conexion.cadena_conexion(), Integer.parseInt(listaId.get(i)));
                listaCorreo.add(direccion.getCorreo_electronico());
                
               
                    listaTelefonoFijo.add(direccion.getTelefono_fijo());
                    listaTelefonoMovil.add(direccion.getTelefono_movil());
                
            }
            ObservableList<TablaVictimas> tablaInterna = FXCollections.observableArrayList();
            for (int i = 0; i < listaNombres.size(); i++) {
                tablaInterna.add(new TablaVictimas(listaNombres.get(i), listaEdad.get(i), listaSexo.get(i),
                        listaRelacion.get(i), listaEscolariad.get(i),/*listaCorreo.get(i)*/"", /*listaTelefonoFijo.get(i)*/ 0, 0/*listaTelefonoMovil.get(i)*/));
            }
            tablaVictimas.setItems(tablaInterna);
            tablaVictimas.getColumns().addAll(colNombre, colEdad, colSexo, colRelacionAgresor, colEscolaridad);
            
            direccion.seleccionarDireccion(conexion.cadena_conexion(), Integer.parseInt(listaId.get(0)));
            
            txtDcalle.setText(direccion.getCalle());
            txtDnumero.setText(direccion.getNumero());
            txtDcolonia.setText(direccion.getColonia());
            txtDcodigoP.setText(direccion.getCodigo_postal()+"");
            txtDmunicipio.setText(direccion.getMunicipio());
            txtDentrecalle.setText(direccion.getEntre_callate());
            txtDycalle.setVisible(false);
            txtReferencia.setText(direccion.getReferencia_casa());

        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }

    }

    private void seleccionarReportes() {
        Conexion conexion = new Conexion();
        Reportes report = new Reportes();
        Victima vic = new Victima();
        reporte rep = new reporte();
        Agresor ag = new Agresor();
        Custodia custodia = new Custodia();
        Direcciones direccion = new Direcciones();
        Usuarios usuario = new Usuarios();
        Denunciantes denunciante = new Denunciantes();
        
        report.seleccionarReportes(conexion.cadena_conexion(), reporte);
        
        /*****************COMPLETAR DATOS REPORTE ******************/
        
        txtHorareporte.setText(report.getHora_creacion().replace(".0000000", ""));
        txtFechaoficio.setText(report.getFecha_oficio());
        txtTiporeporte.setText(report.getEtapa_actual());
        txtReseña.setText(report.getResenia_situacion());   
        txtObservaciones.setText(report.getObservacion_situacion());
        
        Usuarios usuarioId = new Usuarios();
        usuarioId.seleccionarUsuarioId(conexion.cadena_conexion(), report.getId_usuario_recibio());
        
        txtRecibio.setText(usuarioId.getNombre_completo_usuario());
        
        /*****************COMPLETAR DATOS REPORTE ******************/
        
        denunciante.seleccionarDenuncianteIdReporte(conexion.cadena_conexion(), reporte);
        
        custodia.seleccionarCustodia(conexion.cadena_conexion(), report.getId_custodia());
        
        int denu = Integer.parseInt(denunciante.getId_direccion());
        
        direccion.seleccionarDireccion(conexion.cadena_conexion(), denu);
        txtNoexpediente.setText(report.getNumero_expediente_pertenece());
        txtFechareporte.setText(report.getFecha_oficio());
        txtNooficio.setText(report.getNumero_oficio());
        
        /*****************COMPLETAR DATOS DENUNCIANTE ******************/
        
        if(denunciante.getTipo_denunciante().equals("0")){
            txtTipopersona.setText("PERSONA FISICA");
        }
        if(denunciante.getTipo_denunciante().equals("1")){
            txtTipopersona.setText("PERSONA MORAL");
        }
        
        txtRelacionvic.setText(denunciante.getRelacion_victima());
        txtEdad.setText(denunciante.getEdad());
        txtsexo.setText(denunciante.getSexo());
        
        /*****************COMPLETAR DATOS DENUNCIANTE ******************/
        
        //txtRecibio.setText();
        txtEnvia.setText(report.getQuien_envia_oficio());
        txtNoreport.setText(reporte+"");
        txtNombre.setText(denunciante.getNombres()+" "+denunciante.getApellido_paterno()+" "+denunciante.getApellido_materno());
        txtEscolaridad.setText(denunciante.getEscolaridad());
        txtCalle.setText(direccion.getCalle());
        txtNumeroC.setText(direccion.getNumero());
        txtColonia.setText(direccion.getColonia());
        txtCodigoP.setText(String.valueOf(direccion.getCodigo_postal()));
        txtTelefonofij.setText(direccion.getTelefono_fijo());
        txtTelefonomovil.setText(direccion.getTelefono_movil());
        txtCorreo.setText(direccion.getCorreo_electronico());
        txtMunipio.setText(direccion.getMunicipio());
        
        
        
        //
        
        int direccioncustodia = Integer.parseInt(custodia.getId_direccion());
        direccion.seleccionarDireccion(conexion.cadena_conexion(), direccioncustodia);
        
        txtNombreC.setText(custodia.getNombres()+" "+custodia.getApellido_paterno()+" "+custodia.getApellido_materno());
        txtEscolaridadC.setText(custodia.getEscolaridad());
        txtCorreoC.setText(direccion.getCorreo_electronico());
        txtCalleC.setText(direccion.getCalle());
        txtCodigoPC.setText(String.valueOf(direccion.getCodigo_postal()));
        txtEdadC.setText(custodia.getEdad());
        txtSexoC.setText(custodia.getSexo());
        txtRelacionvictimaC.setText(custodia.getRelacion_victima());
        txtTelefonofijoC.setText(direccion.getTelefono_fijo());
        txtTelefonomovilC.setText(direccion.getTelefono_movil());
        txtNumeroC.setText(direccion.getNumero());
        txtColoniaC.setText(direccion.getColonia());
        txtMunicipioC.setText(direccion.getMunicipio());
        
        Vulnerabilidad vulnerabilidad = new Vulnerabilidad();
        vulnerabilidad.seleccionarVulnerabilidadReporte(conexion.cadena_conexion(), reporte);
        
        List<String> ListaVulnerabilidad = vulnerabilidad.getListaVulnerabilidad();
        
        for(int i = 0; i < ListaVulnerabilidad.size(); i++){
            
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a la protección de la salud y a la seguridad social")){
                checkProteccionsalud.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a no ser discriminado")){
                checkNodiscriminado.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a la identidad")){
                checkIdentidad.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a una vida libre de violencia y a la integridad personal")){
                checkVidalibre.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a la igualdad sustantiva")){
                checkIgualdadsus.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho de prioridad")){
                checkPrioridad.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a vivir en condiciones de bienestar y a un sano desarrollo integral")){
                checkCondicionesbien.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a vivir en familia")){
                checkVivirfam.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a la vida, a la supervivencia y al desarrollo")){
                checkVida.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a la libertad de convicciones éticas, pensamiento, conciencia, religión y cultura")){
                checkLibertadConvic.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho al descanso y al esparcimiento")){
                checkDescanso.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a la educación")){
                checkEducacion.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a la inclusión de niñas, niños y adolecentes con discapacidad")){
                checkInclusionniños.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a la intimidad")){
                checkIntimidad.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho de asociación y reunión")){
                checkReunion.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho de participación")){
                checkParticipacion.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a la libertad de expresión y de acceso a la información")){
                check_Libertadexp.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho al acceso a las TIC")){
                checkTic.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho de niñas, niños y adolecentes migrantes")){
                checkMigrantes.setSelected(true);
            }
            if(ListaVulnerabilidad.get(i).equalsIgnoreCase("Derecho a la seguridad jurídica y al debido proceso")){
                checkSeguridadju.setSelected(true);
            }
            
            checkProteccionsalud.setDisable(true);
            checkNodiscriminado.setDisable(true);
            checkIdentidad.setDisable(true);
            checkVidalibre.setDisable(true);
            checkIgualdadsus.setDisable(true);
            checkPrioridad.setDisable(true);
            checkCondicionesbien.setDisable(true);
            checkVivirfam.setDisable(true);
            checkVida.setDisable(true);
            checkLibertadConvic.setDisable(true);
            checkDescanso.setDisable(true);
            checkEducacion.setDisable(true);
            checkInclusionniños.setDisable(true);
            checkIntimidad.setDisable(true);
            checkReunion.setDisable(true);
            checkParticipacion.setDisable(true);
            check_Libertadexp.setDisable(true);
            checkTic.setDisable(true);
            checkMigrantes.setDisable(true);
            checkSeguridadju.setDisable(true);
            
        }
        
    }

    private void Tablaagresor() {
        TableColumn<TablaAgresor, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setMinWidth(100);
        colNombre.setCellValueFactory(new PropertyValueFactory<>("NombreA"));
        TableColumn<TablaAgresor, String> colEdad = new TableColumn<>("Edad");
        colEdad.setMinWidth(100);
        colEdad.setCellValueFactory(new PropertyValueFactory<>("EdadA"));
        TableColumn<TablaAgresor, String> colSexo = new TableColumn<>("Sexo");
        colSexo.setMinWidth(100);
        colSexo.setCellValueFactory(new PropertyValueFactory<>("SexoA"));
        TableColumn<TablaAgresor, String> colEscolaridad = new TableColumn<>("Escolaridad");
        colEscolaridad.setMinWidth(100);
        colEscolaridad.setCellValueFactory(new PropertyValueFactory<>("EscolaridadA"));
        TableColumn<TablaAgresor, String> colOcupacion = new TableColumn<>("Ocupacion");
        colOcupacion.setMinWidth(100);
        colOcupacion.setCellValueFactory(new PropertyValueFactory<>("OcupacionA"));
        TableColumn<TablaAgresor, String> colLugar = new TableColumn<>("Lugar de trabajo");
        colLugar.setMinWidth(100);
        colLugar.setCellValueFactory(new PropertyValueFactory<>("LugarA"));
        TableColumn<TablaAgresor, String> colEstado = new TableColumn<>("Estado civil");
        colEstado.setMinWidth(100);
        colEstado.setCellValueFactory(new PropertyValueFactory<>("EstadoA"));
        TableColumn<TablaAgresor, String> colRelacion = new TableColumn<>("Relacion con victima");
        colRelacion.setMinWidth(100);
        colRelacion.setCellValueFactory(new PropertyValueFactory<>("RelacionA"));
        TableColumn<TablaAgresor, String> colCorreo = new TableColumn<>("Correo");
        colCorreo.setMinWidth(100);
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("CorreoA"));
        TableColumn<TablaAgresor, String> colTelfijo = new TableColumn<>("Telefono fijo");
        colTelfijo.setMinWidth(100);
        colTelfijo.setCellValueFactory(new PropertyValueFactory<>("TelfijoA"));
        TableColumn<TablaAgresor, String> colTelmovil = new TableColumn<>("Telefono movil");
        colTelmovil.setMinWidth(100);
        colTelmovil.setCellValueFactory(new PropertyValueFactory<>("TelmovilA"));
        TableColumn<TablaAgresor, String> colCalle = new TableColumn<>("Calle");
        colCalle.setMinWidth(100);
        colCalle.setCellValueFactory(new PropertyValueFactory<>("CalleA"));
        TableColumn<TablaAgresor, String> colNumero = new TableColumn<>("Numero");
        colNumero.setMinWidth(100);
        colNumero.setCellValueFactory(new PropertyValueFactory<>("NumeroA"));
        TableColumn<TablaAgresor, String> colColonia = new TableColumn<>("Colonia");
        colColonia.setMinWidth(100);
        colColonia.setCellValueFactory(new PropertyValueFactory<>("ColoniaA"));
        TableColumn<TablaAgresor, String> colCodigo = new TableColumn<>("Codigo Postal");
        colCodigo.setMinWidth(100);
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("CodigoA"));
        TableColumn<TablaAgresor, String> colMunicipio = new TableColumn<>("Municipio");
        colMunicipio.setMinWidth(100);
        colMunicipio.setCellValueFactory(new PropertyValueFactory<>("MunicipioA"));

        try {
            Conexion conexion = new Conexion();
            Agresor agresor = new Agresor();
            Direcciones direccion = new Direcciones();
            agresor.seleccionarListaAgresoresReporte(conexion.cadena_conexion(), reporte);
            List<String> listaNombres = agresor.getListaNombres();
            List<String> listaEdad = agresor.getListaEdad();
            List<String> listaSexo = agresor.getListaSexo();
            List<String> listaEscolaridad = agresor.getListaEscolaridad();
            List<String> listaOcupacion = agresor.getListaOcupacion();
            List<String> listaLugar = agresor.getListaLugarTrabajo();
            List<String> listaEstado = agresor.getListaEstadoCivil();
            List<String> listaRelacion = agresor.getListaRelacionVictima();
            List<String> listaID = agresor.getListaIdDireccion();
            List<String> listaCorreo = new ArrayList<String>();
            List<String> listaTelfijo = new ArrayList<String>();
            List<String> listaTelmovil = new ArrayList<String>();
            List<String> listaCalle = new ArrayList<String>();
            List<String> listaNumero = new ArrayList<String>();
            List<String> listaColonia = new ArrayList<String>();
            List<Integer> listaCp = new ArrayList<Integer>();
            List<String> listaMunicipio = new ArrayList<String>();
            ObservableList<TablaAgresor> tablaInterna = FXCollections.observableArrayList();

            for (int i = 0; i < listaID.size(); i++) {
                direccion.seleccionarDireccion(conexion.cadena_conexion(), Integer.parseInt(listaID.get(i)));
                listaCorreo.add(direccion.getCorreo_electronico());
                listaTelfijo.add(direccion.getTelefono_fijo());
                listaTelmovil.add(direccion.getTelefono_movil());
                listaCalle.add(direccion.getCalle());
                listaNumero.add(direccion.getNumero());
                listaColonia.add(direccion.getColonia());
                listaCp.add(direccion.getCodigo_postal());
                listaMunicipio.add(direccion.getMunicipio());
            }

            for (int i = 0; i < listaID.size(); i++) {
                tablaInterna.add(new TablaAgresor(listaNombres.get(i), listaEdad.get(i), listaSexo.get(i), listaEscolaridad.get(i), listaOcupacion.get(i),
                        listaLugar.get(i), listaEstado.get(i), listaRelacion.get(i), listaCorreo.get(i), listaTelfijo.get(i), listaTelmovil.get(i), listaCalle.get(i),
                        listaNumero.get(i), listaColonia.get(i), listaCp.get(i), listaMunicipio.get(i)));
            }

            tablaAgresor.setItems(tablaInterna);
            tablaAgresor.getColumns().addAll(colNombre, colEdad, colSexo, colEscolaridad, colOcupacion,
                    colLugar, colEstado, colRelacion, colCorreo, colTelfijo, colTelmovil,
                    colCalle, colNumero, colColonia, colCodigo, colMunicipio);
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }
}
