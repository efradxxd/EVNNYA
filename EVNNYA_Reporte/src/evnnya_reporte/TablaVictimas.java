/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_reporte;

/**
 *
 * @author dkcha
 */
public class TablaVictimas {
    private String nombre;
   private String edad;
   private String sexo;
   private String relacion;
   private String escolaridad;
   private String correo;
   private int telfijo;
   private int telmovil;

    public TablaVictimas(String nombre, String edad, String sexo, String relacion, String escolaridad, String correo, int telfijo, int telmovil) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.relacion = relacion;
        this.escolaridad = escolaridad;
        this.correo = correo;
        this.telfijo = telfijo;
        this.telmovil = telmovil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelfijo() {
        return telfijo;
    }

    public void setTelfijo(int telfijo) {
        this.telfijo = telfijo;
    }

    public int getTelmovil() {
        return telmovil;
    }

    public void setTelmovil(int telmovil) {
        this.telmovil = telmovil;
    }


}