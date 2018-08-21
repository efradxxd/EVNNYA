package evnnya_recepcion;

import java.util.Calendar;

public class Herramientas {

    Herramientas() {

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

    public String obtenerHora() {
        Calendar fechaSistema = Calendar.getInstance();
        return fechaSistema.get(Calendar.HOUR) + ":" + (fechaSistema.get(Calendar.MINUTE)) + ":" + fechaSistema.get(Calendar.SECOND);
    }
}
