/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_ts;

/**
 *
 * @author pablo
 */
public class Victimas {
    private String nombres;
    private String apePa;
    private String apeMa;
    private int edad;
    private String sexo;

    public Victimas(String nombres, String apePa, String apeMa, int edad, String sexo) {
        this.nombres = nombres;
        this.apePa = apePa;
        this.apeMa = apeMa;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApePa() {
        return apePa;
    }

    public void setApePa(String apePa) {
        this.apePa = apePa;
    }

    public String getApeMa() {
        return apeMa;
    }

    public void setApeMa(String apeMa) {
        this.apeMa = apeMa;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
