/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecciones;


import procedimientos.EvaluacionMedico;
import procedimientos.Agresor;
import procedimientos.Archivos;
import procedimientos.Custodia;
import procedimientos.Denunciantes;
import procedimientos.Denuncias;
import procedimientos.Direcciones;
import procedimientos.EstadoMental;
import procedimientos.Expedientes;
import procedimientos.PeticionesMedico;
import procedimientos.PeticionesPsicologia;
import procedimientos.PeticionesTrabajoSocial;
import procedimientos.Recepcion;
import procedimientos.Reportes;
import procedimientos.Usuarios;
import procedimientos.Victima;
import procedimientos.Vulnerabilidad;
import utilidades.DatosSesion;


/**
 *
 * @author jahir
 */
public class Pruebas_coneccion_evnnya{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Conexion conexion = new Conexion();
        
        Direcciones direcciones = new Direcciones();
        Usuarios usuario = new Usuarios();
        Custodia custodia = new Custodia();
        Agresor agresor = new Agresor();
        Denunciantes denunciante = new Denunciantes();
        Victima victima = new Victima();
        Recepcion recepcion = new Recepcion();
        Archivos archivos = new Archivos();
        Expedientes expediente = new Expedientes();
        Vulnerabilidad vulnerabilidad = new Vulnerabilidad();
        Denuncias denuncias = new Denuncias();
        EstadoMental estadoMental = new EstadoMental();
        PeticionesPsicologia peticionesPsi = new PeticionesPsicologia();
        PeticionesTrabajoSocial trabajoSocial = new PeticionesTrabajoSocial();
        Reportes reportes = new Reportes();
        EvaluacionMedico evaluacionmed = new EvaluacionMedico();
        PeticionesMedico peticionesmed = new PeticionesMedico();
       
        
       DatosSesion datos = new DatosSesion();
       
        /*try {
            datos.cerrarSesion();
        } catch (Exception e) {
        }*/
        
        /*Documentos docs = new Documentos();
        docs.abrirArchivo();*/
        
        trabajoSocial.seleccionarVisitaDomiciliaria(conexion.cadena_conexion(), 1);
        System.out.println(trabajoSocial.getId_domicilio());
        
            /*datos.traerDatos();
            System.out.println(datos.getId());
            System.out.println(datos.getNombres());
            System.out.println(datos.getApe_paterno());
            System.out.println(datos.getApe_materno());
            System.out.println(datos.getDepartamento());
            System.out.println(datos.getTipo_usuario());*/
            
           //peticionesmed.seleccionarBandejaPeticionesMed(conexion.cadena_conexion());
            
            /*direcciones.agregarDireccion(conexion.cadena_conexion(), "ZONA AMARILLA", "2078", "MARGARITAS", 34040,
            "LA DE 20", "VICTORIA", "DURANGO", "TIENE 3 ESTACIONAMIENTOS DE COLOR AMARILLO",
            "MI_CORREO_2@HOTMAIL.COMX", "1850000", "6181000000");*/
            
            /*usuario.agregarUsuario(conexion.cadena_conexion(), "DENISSEA", "ORTEGAA", "SOLISA", "11/05/1998",
            "MUJERA", "DESARROLLOA", "ASISTENTEA", "DENISSE", "ADMIN", 1,
            "16/03/2018", 2, "03/01/2018", "PSICOLOGIA", 1);*/
            
            
            /*custodia.actualizarCustodia(conexion.cadena_conexion(), "MINERVA OLYHERX", "VILLEGASX", "TREVINOX", 38,
            "MUJERX", "SECUNDARIAX", "MAMAX", 2);*/
            
            /*agresor.actualizarAgresor(conexion.cadena_conexion(), "DIF/PPNNA-001-2018", "LUCIA GUADALUPEX", "NUNEZX", "YANEZX", 22,
            "MUJERX", "UNIVERSIDADX", "PROGRAMADORAX", "APPWARE-SSTX", "SOLTERAX", "NOVIAX", 3);*/
            
            /*denunciante.actualizarDenunciante(conexion.cadena_conexion(), 1, "JOSE LUISX", "MARTINEZX", "ENRIQUEZX", 32,
            "HOMBREX", "PRIMARIAX", "ABUELOX", 6);*/
            
            /*victima.actualizarVictima(conexion.cadena_conexion(), "DIF/PPNNA-002/2018", "LUISX", "TORRESX", "SOLISX", 12, "HOMBREX",
            "PRIMARIAX", "HIJOX", 1, 4);*/
            
            /*recepcion.agregarFichaRecepcion(conexion.cadena_conexion(), "JAHIR", "UNZUETA", "VILLEGAS", 22, "ALBAÑIL",
            "CASADO", "FAMILIAR", "SEXUAL", "LUCIA", "NUÑEZ", "YAÑEZ", "DESARROLLADORA",22,
            "JAHIR ESTA MUY GUAPO Y POR ESO LUCIA LO GOLPEO Y LO MALTRATO POR QUE LO QUERIA PARA ELLA",
            "DURANGO", 1, "22/05/2018");*/
            
            /*archivos.actualizarArchivo(conexion.cadena_conexion(), 2, "DIF/PPNNA-002/2018","C:\\DONDEXX",
            3, "12/10/2018", "12:05:24", "AQUI ES UN COMENTARIOXX", 1);*/
            
            /*expediente.agregarExpediente(conexion.cadena_conexion(), "DIF/PPNNA-003/2018", 2, "25/05/2018", "12:52:03", 1, "25",
            "12/01/2012", "PATRICIA", "ESCUELA", 3, 1, "LE PEGO EL NIÑO", "VENIA GOLPEADO", "DURANGO",
            1, "20/11/2015", "1");*/
            
            /*usuario.seleccionarUsuario(conexion.cadena_conexion(), "DENISSEOR");
            System.out.println(usuario.isExiste_usuario());*/
            
            /*usuario.loginUsuario(conexion.cadena_conexion(), "LUPE", "LUPE123");
            
            if(usuario.isLogin_exitoso()){
            
            System.out.println("id: " + usuario.getLogin_id_usuario());
            System.out.println("nombre: " + usuario.getLogin_nombres());
            System.out.println("ape pat: " + usuario.getLogin_apellido_paterno());
            System.out.println("ape mat: " + usuario.getLogin_apellido_materno());
            System.out.println("departamento: " + usuario.getLogin_departamento());
            System.out.println("tipo usuario: " + usuario.getLogin_tipo_usuario());
            
            }else{
            
            System.out.println("usuario y/o contraseña invalido");
            
            }*/
        
            /*usuario.seleccionarTodosUsuarios(conexion.cadena_conexion());
            List<String> ListaNombres = usuario.getListaNombres();
            
            for(int i=0; i < ListaNombres.size(); i++){
            System.out.println(ListaNombres.get(i));
            }*/
            
            /*vulnerabilidad.agregarVulnerabilidad(conexion.cadena_conexion(), "DIF/PPNNA-002/2018", "NO SE QUE PONER");*/
            
            /*direcciones.seleccionarDireccion(conexion.cadena_conexion(), usuario.getId_direccion());
            System.out.println("Id: " + direcciones.getId_direccion());
            System.out.println("Calle: " + direcciones.getCalle());
            System.out.println("Numero: "+ direcciones.getNumero());*/
            
            /*denuncias.agregarDenuncia(conexion.cadena_conexion(), 6, "DIF/PPNNA-003/2018", "01/12/2015", 4);*/
            /*estadoMental.agregarEstadoMental(conexion.cadena_conexion(), 1, 1, 1, "apariencia fisica", "conducta_motriz",
            "habla_lenguaje", "socializacion", "orientacion", "consciencia", "memoria", "percepcion",
            "pensamiento", "afecto_emocion", "ineteligencia", "resultado_tecnica", "conclusiones", "sugerencias");*/
            
            /*peticionesPsi.agregarPeticion(conexion.cadena_conexion(), "asd", 0, 0, 0, "asd", "asd", "asd", "asd", 0,
            "asd", 0, "asd", 0, "asd", "asdasd");*/
            
            /*victima.actualizarVictima(conexion.cadena_conexion(), "DIF/PPNNA-001-2018", "JAHIRX", "UNZUETAX", "SOTOX", 23,
            "HOMBREX", "PREPARATORIAX", "HIJOX", 2, "CHIHUAHUA", "28/02/2018", "MEXICANA",
            "ATEOX", "CASADO", 1, "NO VE", "TEPEHUANO", "TARAHUMARA", 5);*/
            
            /*victima.seleccionarVictima(conexion.cadena_conexion(), 5);
            System.out.println("num " + victima.getNumero_expediente());
            System.out.println("nombres: " + victima.getNombres());
            System.out.println("id reporte: " + victima.getId_reporte());*/
            
            /*victima.seleccionarListaVictimas(conexion.cadena_conexion(), "DIF/PPNNA-002/2018");
            List<String> ListaCorreo = new ArrayList<String>();
            List<String> ListaTelFijo = new ArrayList<String>();
            List<String> ListaTelMovil = new ArrayList<String>();
            List<String> ListaId = victima.getListaIdDireccion();
            
            ListaCorreo.clear();
            ListaTelFijo.clear();
            ListaTelMovil.clear();
            
            for(int i=0; i < ListaId.size(); i++){
            
            direcciones.seleccionarDireccion(conexion.cadena_conexion(), Integer.parseInt(ListaId.get(i)));
            ListaCorreo.add(direcciones.getCorreo_electronico());
            ListaTelFijo.add(direcciones.getTelefono_fijo());
            ListaTelMovil.add(direcciones.getTelefono_movil());
            
            }
            
            for(int i=0; i < ListaId.size(); i++){
            System.out.println(ListaTelFijo.get(i));
            }*/
        
            /*custodia.agregarCustodia(conexion.cadena_conexion(), "ff", "dd", "sd", 22, "HOMBRE", "PREPA", "TIO", "28/02/2018", "casdado", "espanol", "raza", "no cree", 0, "no ve");*/
           
            /*PeticionesTrabajoSocial pet_ts = new PeticionesTrabajoSocial();
            
            pet_ts.seleccionarBandejaPeticionesTS(conexion.cadena_conexion());
            
            List<String> ListaNombres = pet_ts.getListaDireccionCompleta();
            List<String> Listaape = pet_ts.getListaIdPeticion();
            
            for(int i=0; i < ListaNombres.size(); i++){
            System.out.println(Listaape.get(i)+": "+ListaNombres.get(i));
            }*/
            
            /*trabajoSocial.seleccionarVisitaDomiciliaria(conexion.cadena_conexion(), 14);
            System.out.println(trabajoSocial.getId_peticion());
            System.out.println(trabajoSocial.getFecha_envio());
            System.out.println(trabajoSocial.getTipo_persona_visita());*/
            
            //System.out.println(reportes.seleccionarUltimoReporte(conexion.cadena_conexion()));
            //victima.actualizarNinoNina(conexion.cadena_conexion(), "DIF/PPNNA-002/2018", "nombre", "apeido paterno", "apeido materno", 0, "asd", "zxc", "", 0, "zczx", "21/05/2018", "india", "ateo", "", 0, "sf", "sdf", "qwe", 0);
            
            
            /*Reportes test = new Reportes();
            
            test.seleccionarReportes(conexion.cadena_conexion(), 16);
        
            test.getId_reporte();
            test.getNumero_expediente_pertenece();
            test.getResenia_situacion();
            test.getEtapa_actual();
        
            System.out.println(test.getId_reporte());
            System.out.println(test.getNumero_expediente_pertenece());
            System.out.println(test.getResenia_situacion());
            System.out.println(test.getEtapa_actual());*/
            
            /*custodia.seleccionarCustodia(conexion.cadena_conexion(), 3);
            System.out.println(custodia.getNombres());
            System.out.println(custodia.getApellido_materno());
            System.out.println(custodia.getApellido_paterno());*/
            
            //System.out.println(custodia.seleccionarUltimoCustodia(conexion.cadena_conexion()));
            //victima.agregarVictima(conexion.cadena_conexion(), numero_expediente, nombres, apellido_paterno, apellido_materno, 0, sexo, escolaridad, relacion_agresor, lugar_nacimiento, fecha_nacimiento, nacionalidad, religion, estado_civil, 0, cual_discapacidad, idioma_dialecto, grupo_etnico);
            
            /*peticionesPsi.seleccionarBandejaPeticionesPsi(conexion.cadena_conexion());
            List<String> ListaNombres = peticionesPsi.getListaIdPeticion();
            List<String> Listaape = peticionesPsi.getListaNombre();
            
            for(int i=0; i < ListaNombres.size(); i++){
            System.out.println(Listaape.get(i)+": "+ListaNombres.get(i));
            }*/
            
            /*agresor.seleccionarAgresor(conexion.cadena_conexion(), 3);
            System.out.println(agresor.getId_agresor());
            System.out.println(agresor.getNumero_expediente());
            System.out.println(agresor.getId_reporte());*/
            
            /*evaluacionmed.agregarEvaluacionMedico(conexion.cadena_conexion(), "DIF/PPNNA-002/2018", 0, "02/02/2012", "05:32", "03/02/2012", "12:45",
            1, 1, 1, "TONITO", "Mendoza", "lozano", "24/04/19999", "Macho", "soltero", "Prepa", "Judio", 1, 1,
            "Juana", "De arco", "Royal", "Duena", 1, 1, 1, 1, 1, "tierra", "paja", "ventana", "smn", "IDK",
            "no", "nada", 1);*/
            
            /*System.out.println("54");
            peticionesmed.seleccionarBandejaPeticionesMed(conexion.cadena_conexion());
            List<String> ListaNombres = peticionesPsi.getListaIdPeticion();
            List<String> Listaape = peticionesPsi.getListaNombre();
            
            for(int i=0; i < ListaNombres.size(); i++){
            System.out.println(Listaape.get(i)+": "+ListaNombres.get(i));
            }*/       
            
            
    
        }
    
}
