/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_mr;

/**
 *
 * @author jahir
 */
public class TablaVictima {
    private String nom,apePa,apeMa,sexo,
            escolaridad,relacion,correoE,
            telefonoFi, telefonoMo;
    private int edad;

    public TablaVictima(String nom, String apePa, String apeMa, String sexo, String escolaridad, String relacion, String correoE, String telefonoFi, String telefonoMo, int edad) {
        this.nom = nom;
        this.apePa = apePa;
        this.apeMa = apeMa;
        this.sexo = sexo;
        this.escolaridad = escolaridad;
        this.relacion = relacion;
        this.correoE = correoE;
        this.telefonoFi = telefonoFi;
        this.telefonoMo = telefonoMo;
        this.edad = edad;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getTelefonoFi() {
        return telefonoFi;
    }

    public void setTelefonoFi(String telefonoFi) {
        this.telefonoFi = telefonoFi;
    }

    public String getTelefonoMo() {
        return telefonoMo;
    }

    public void setTelefonoMo(String telefonoMo) {
        this.telefonoMo = telefonoMo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}
