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
public class Global {
    
    public static String id;
    public static String nombres;
    public static String apellido_paterno;
    public static String apellido_materno;
    public static String departamento;
    public static String tipo_usuario;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Global.id = id;
    }

    public static String getNombres() {
        return nombres;
    }

    public static void setNombres(String nombres) {
        Global.nombres = nombres;
    }

    public static String getApellido_paterno() {
        return apellido_paterno;
    }

    public static void setApellido_paterno(String apellido_paterno) {
        Global.apellido_paterno = apellido_paterno;
    }

    public static String getApellido_materno() {
        return apellido_materno;
    }

    public static void setApellido_materno(String apellido_materno) {
        Global.apellido_materno = apellido_materno;
    }

    public static String getDepartamento() {
        return departamento;
    }

    public static void setDepartamento(String departamento) {
        Global.departamento = departamento;
    }

    public static String getTipo_usuario() {
        return tipo_usuario;
    }

    public static void setTipo_usuario(String tipo_usuario) {
        Global.tipo_usuario = tipo_usuario;
    }
    
}
