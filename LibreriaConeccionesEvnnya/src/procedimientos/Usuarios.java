/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import conecciones.Pruebas_coneccion_evnnya;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jahir
 */
public class Usuarios {
    
    //VARIABLES TRAER USUARIO
    int id_usuarios;
    String nombres;
    String apellido_paterno;
    String apellido_materno;
    String fecha_nacimiento;
    String sexo;
    String departamento;
    String rol;
    String usuario;
    String contrasenia;
    int tipo_usuario;
    String fecha_alta;
    int estado_actual_asesor;
    String fecha_activacion_asesor;
    String especialidad_asesor;
    int status;
    int id_direccion;
    boolean existe_usuario;
    
    //VARIABLES LOGIN
    boolean login_exitoso;
    int login_id_usuario;
    String login_nombres;
    String login_apellido_paterno;
    String login_apellido_materno;
    String login_departamento;
    int login_tipo_usuario;
    
    //VARIABLES TRAER TODOS LOS DATOS
    List<String> ListaNombres = new ArrayList<String>();
    List<String> ListaApellidoPaterno = new ArrayList<String>();
    List<String> ListaApellidoMaterno = new ArrayList<String>();
    List<String> ListaDepartamento = new ArrayList<String>();
    List<String> ListaTipoUsuario = new ArrayList<String>();
    List<String> ListaUsuario = new ArrayList<String>();
    
    List<String> ListaNombresAux = new ArrayList<String>();
    List<String> ListaApellidoPaternoAux = new ArrayList<String>();
    List<String> ListaApellidoMaternoAux = new ArrayList<String>();
    List<String> ListaDepartamentoAux = new ArrayList<String>();
    List<String> ListaTipoUsuarioAux = new ArrayList<String>();
    List<String> ListaUsuarioAux = new ArrayList<String>();
    
    
    //AGREGAR USUARIO
    public void agregarUsuario(Connection con, String nombres, String apellido_paterno, String apellido_materno,
                                String fecha_nacimiento, String sexo, String departamento, String rol, String usuario,
                                String contrasenia, int tipo_usuario, String fecha_alta, int estado_actual_asesor,
                                String fecha_activacion_asesor, String especialidad_asesor, int estatus){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.AgregarUsuario(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?,?,?,?)}");
            
            pstmt.setString(1, nombres);
            pstmt.setString(2, apellido_paterno);
            pstmt.setString(3, apellido_materno);
            pstmt.setString(4, fecha_nacimiento);
            pstmt.setString(5, sexo);
            pstmt.setString(6, departamento);
            pstmt.setString(7, rol);
            pstmt.setString(8, usuario);
            pstmt.setString(9, contrasenia);
            pstmt.setInt(10, tipo_usuario);
            pstmt.setString(11, fecha_alta);
            pstmt.setInt(12, estado_actual_asesor);
            pstmt.setString(13, fecha_activacion_asesor);
            pstmt.setString(14, especialidad_asesor);
            pstmt.setInt(15, estatus);
            
            pstmt.execute();
            
                System.out.println("SE AGREGO USUARIO CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //ACTUALIZAR USUARIO
    public void actualizarUsuario(Connection con, String nombres, String apellido_paterno, String apellido_materno,
                                String fecha_nacimiento, String sexo, String departamento, String rol, String usuario,
                                String contrasenia, int tipo_usuario, String fecha_alta, int estado_actual_asesor,
                                String fecha_activacion_asesor, String especialidad_asesor, int estatus,
                                int id_direccion){
        
        try {
            
            CallableStatement pstmt = con.prepareCall("{call dbo.ActualizarUsuario(?,?,?,?,?,"
                                                                                + "?,?,?,?,?,"
                                                                                + "?,?,?,?,?,?)}");
            
            pstmt.setString(1, nombres);
            pstmt.setString(2, apellido_paterno);
            pstmt.setString(3, apellido_materno);
            pstmt.setString(4, fecha_nacimiento);
            pstmt.setString(5, sexo);
            pstmt.setString(6, departamento);
            pstmt.setString(7, rol);
            pstmt.setString(8, usuario);
            pstmt.setString(9, contrasenia);
            pstmt.setInt(10, tipo_usuario);
            pstmt.setString(11, fecha_alta);
            pstmt.setInt(12, estado_actual_asesor);
            pstmt.setString(13, fecha_activacion_asesor);
            pstmt.setString(14, especialidad_asesor);
            pstmt.setInt(15, estatus);
            pstmt.setInt(16, id_direccion);
            
            pstmt.execute();
            
                System.out.println("SE MODIFICO USUARIO CORRECTAMENTE");
            
            pstmt.close();
            
        } catch (Exception e) {
            Logger.getLogger(Pruebas_coneccion_evnnya.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //SELECCIONAR USUARIO //POR MEDIO DEL USUARIO
    public void seleccionarUsuario(Connection con, String usuario){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarUsuario('"+usuario+"')}");
            
            if(rs.next()){
                
                setExiste_usuario(true);
                setId_usuarios(rs.getInt(1));
                setNombres(rs.getString(2));
                setApellido_paterno(rs.getString(3));
                setApellido_materno(rs.getString(4));
                setFecha_nacimiento(rs.getString(5));
                setSexo(rs.getString(6));
                setDepartamento(rs.getString(7));
                setRol(rs.getString(8));
                setUsuario(rs.getString(9));
                setContrasenia(rs.getString(10));
                setTipo_usuario(rs.getInt(11));
                setFecha_alta(rs.getString(12));
                setEstado_actual_asesor(rs.getInt(13));
                setFecha_activacion_asesor(rs.getString(14));
                setEspecialidad_asesor(rs.getString(15));
                setStatus(rs.getInt(16));
                setId_direccion(rs.getInt(17));
                
            }else{
                
                setExiste_usuario(false);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //LOGIN USUARIO
    public void loginUsuario(Connection con, String usuario, String contrasenia){
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.LoginUsuario('"+usuario+"','"+contrasenia+"')}");
            
            if(rs.next()){
                
                setLogin_exitoso(true);
                setLogin_id_usuario(rs.getInt(1));
                setLogin_nombres(rs.getString(2));
                setLogin_apellido_paterno(rs.getString(3));
                setLogin_apellido_materno(rs.getString(4));
                setLogin_departamento(rs.getString(5));
                setLogin_tipo_usuario(rs.getInt(6));
                
            }else{
                
                setLogin_exitoso(false);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //SELECCIONAR TODOS LOS USUARIOS
    public void seleccionarTodosUsuarios(Connection con){
        
            ListaNombresAux.clear();
            ListaApellidoPaternoAux.clear();
            ListaApellidoMaternoAux.clear();
            ListaDepartamentoAux.clear();
            ListaTipoUsuarioAux.clear();
            ListaUsuarioAux.clear();
        
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{Call dbo.SeleccionarTodosUsuarios}");
            
            while(rs.next()){
                
                ListaNombresAux.add(rs.getString(1));
                ListaApellidoPaternoAux.add(rs.getString(2));
                ListaApellidoMaternoAux.add(rs.getString(3));
                ListaDepartamentoAux.add(rs.getString(4));
                ListaTipoUsuarioAux.add(String.valueOf(rs.getInt(5)));
                ListaUsuarioAux.add(rs.getString(6));
                
            }
            
            setListaNombres(ListaNombresAux);
            setListaApellidoPaterno(ListaApellidoPaternoAux);
            setListaApellidoMaterno(ListaApellidoMaternoAux);
            setListaDepartamento(ListaDepartamentoAux);
            setListaTipoUsuario(ListaTipoUsuarioAux);
            setListaUsuario(ListaUsuarioAux);
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public int getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(int id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public int getEstado_actual_asesor() {
        return estado_actual_asesor;
    }

    public void setEstado_actual_asesor(int estado_actual_asesor) {
        this.estado_actual_asesor = estado_actual_asesor;
    }

    public String getFecha_activacion_asesor() {
        return fecha_activacion_asesor;
    }

    public void setFecha_activacion_asesor(String fecha_activacion_asesor) {
        this.fecha_activacion_asesor = fecha_activacion_asesor;
    }

    public String getEspecialidad_asesor() {
        return especialidad_asesor;
    }

    public void setEspecialidad_asesor(String especialidad_asesor) {
        this.especialidad_asesor = especialidad_asesor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public boolean isExiste_usuario() {
        return existe_usuario;
    }

    public void setExiste_usuario(boolean existe_usuario) {
        this.existe_usuario = existe_usuario;
    }
    
    

    public int getLogin_id_usuario() {
        return login_id_usuario;
    }

    public void setLogin_id_usuario(int login_id_usuario) {
        this.login_id_usuario = login_id_usuario;
    }

    public String getLogin_nombres() {
        return login_nombres;
    }

    public void setLogin_nombres(String login_nombres) {
        this.login_nombres = login_nombres;
    }

    public String getLogin_apellido_paterno() {
        return login_apellido_paterno;
    }

    public void setLogin_apellido_paterno(String login_apellido_paterno) {
        this.login_apellido_paterno = login_apellido_paterno;
    }

    public String getLogin_apellido_materno() {
        return login_apellido_materno;
    }

    public void setLogin_apellido_materno(String login_apellido_materno) {
        this.login_apellido_materno = login_apellido_materno;
    }

    public String getLogin_departamento() {
        return login_departamento;
    }

    public void setLogin_departamento(String login_departamento) {
        this.login_departamento = login_departamento;
    }

    public int getLogin_tipo_usuario() {
        return login_tipo_usuario;
    }

    public void setLogin_tipo_usuario(int login_tipo_usuario) {
        this.login_tipo_usuario = login_tipo_usuario;
    }

    public boolean isLogin_exitoso() {
        return login_exitoso;
    }

    public void setLogin_exitoso(boolean login_exitoso) {
        this.login_exitoso = login_exitoso;
    }

    public List<String> getListaNombres() {
        return ListaNombres;
    }

    public void setListaNombres(List<String> ListaNombres) {
        this.ListaNombres = ListaNombres;
    }

    public List<String> getListaApellidoPaterno() {
        return ListaApellidoPaterno;
    }

    public void setListaApellidoPaterno(List<String> ListaApellidoPaterno) {
        this.ListaApellidoPaterno = ListaApellidoPaterno;
    }

    public List<String> getListaApellidoMaterno() {
        return ListaApellidoMaterno;
    }

    public void setListaApellidoMaterno(List<String> ListaApellidoMaterno) {
        this.ListaApellidoMaterno = ListaApellidoMaterno;
    }

    public List<String> getListaDepartamento() {
        return ListaDepartamento;
    }

    public void setListaDepartamento(List<String> ListaDepartamento) {
        this.ListaDepartamento = ListaDepartamento;
    }

    public List<String> getListaTipoUsuario() {
        return ListaTipoUsuario;
    }

    public void setListaTipoUsuario(List<String> ListaTipoUsuario) {
        this.ListaTipoUsuario = ListaTipoUsuario;
    }

    public List<String> getListaUsuario() {
        return ListaUsuario;
    }

    public void setListaUsuario(List<String> ListaUsuario) {
        this.ListaUsuario = ListaUsuario;
    }
    
    
    
}
