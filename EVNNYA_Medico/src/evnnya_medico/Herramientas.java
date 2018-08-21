package evnnya_medico;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

public class Herramientas {

    private final String[] sexo = new String[]{"DESCONOCIDO", "HOMBRE", "MUJER"};
    private final String[] dpt = new String[]{"DESCONOCIDO", "Psicológia", "Medico", "Trabajo Social", "Mesa receptora", "Recepción", "Asesor Júridico"};
    private final String[] tipoUsuario = new String[]{"DESCONOCIDO", "Administrador", "Usuario Normal"};
    private final String[] municipios = new String[]{"NINGUNO", "001 Canatlán", "002 Canelas", "003 Coneto de Comonfort", "004 Cuencamé", "005 Durango", "006 Gral. Simón Boívar", "007 Gómez Palacio", "008 Guadalupe Victoria", "009 Guanaceví", "010 Hidalgo", "011 Indé", "012 Lerdo", "012 Mapimi", "013 Mapimí", "014 Mezquital", "015 Nazas", "016 Nombre de dios", "017 Ocampo", "018 El Oro", "019 Otáez", "020 Panuco de Coronado", "021 Peñón Blanco", "022 Poanas", "023 Pueblo Nuevo", "024 Rodeo", "025 San Bernando", "026 San Dimas", "027 San Juan Guadalupe", "028 San Juan del Río", "029 San Luis del Cordero", "030 San Pedro del Gallo", "031 Santa Clara", "032 Tamazula", "033 Tepehuanes", "034 Tamazula", "035 Tepehuanes", "036 Tlahualilo", "037 Topia", "038 Vicente Guerrero", "039 Nuevo Ideal", "040 Victoria Durango"};
    private final String[] edoCivil = new String[]{"Unión Libre", "Soltero", "Casado", "Divorciado", "Separado", "Viudo"};
    private final String[] escolaridad = new String[]{"Ninguna", "Primaria Incompleta", "Primaria Completa", "Secundaria Incompleta", "Secundaria Completa", "Estudios Técnicos con primaria", "Preparatoria incompleta", "Preparatoria Completa", "Estudios técnicos con preparatoria", "Licenciatura incompleta", "Licenciatura Completa", "Postgrado"};

    public String[] getEdoCivil() {
        return edoCivil;
    }

    /**
     *
     * @return el valor de la fecha del sistema
     */
    public String[] getEscolaridad() {
        return escolaridad;
    }

    public String obtenerFechaSistema() {
        Calendar fechaSistema = Calendar.getInstance();
        return fechaSistema.get(Calendar.DAY_OF_MONTH) + "/" + (fechaSistema.get(Calendar.MONTH) + 1) + "/" + fechaSistema.get(Calendar.YEAR);
    }

    public String obtenerElString(String cadena) {
        int posicion[] = new int[2];
        //Guarda las posiciones de lo que esta entre comillas
        for (int i = 0, j = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '\'') {
                posicion[j] = i;
                j++;
            }
        }
        return cadena.substring(posicion[0] + 1, posicion[1]);
    }

    public boolean convertirIntToBoolean(int convertir) {
        return (convertir == 1);
    }

    public JFXTextField validar(JFXTextField variable) {
        variable.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);
                if (Character.isLetter(car)) {
                    event.consume();
                }
            }

        });
        return variable;
    }

    public int posicionDeUnCombo(JFXComboBox combo) {
        return Integer.valueOf(combo.getSelectionModel().getSelectedIndex());
    }

    public String obtenerFechaDatePicker(DatePicker fecha) {
        return fecha.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String getHoraActual() {
        Date hoy = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(hoy);
    }

    public String quitarNotacionCientifica(double val) {
        Locale.setDefault(Locale.US);
        DecimalFormat num = new DecimalFormat("#,###.00");
        return num.format(val);
    }

    public String obtenerValoresRadioButon(ToggleGroup group) {
        if (group.getSelectedToggle() != null) {

            System.out.println(group.getSelectedToggle().getUserData().toString());

        }
        return obtenerElString(group.getSelectedToggle().getUserData().toString());
    }

    public String[] getSexo() {
        return sexo;
    }

    public String[] getDpt() {
        return dpt;
    }

    public String[] getTipoUsuario() {
        return tipoUsuario;
    }

    public String[] getMunicipios() {
        return municipios;
    }

}
