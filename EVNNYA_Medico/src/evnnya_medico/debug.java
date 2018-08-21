/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_medico;

/**
 *
 * @author nivec
 */
public class debug {
        //DATOS GENERALES DE NIÑO, NIÑA O ADOLESCENTE
    String nombreVictima="", apellido1Victima="", apellido2Victima="",  sexoVictima="", 
            eCivilVictima="", escolaridad="", religion="";
    int evMedica=-1, tipoInterrogatorio=-1 , edadVictima=0;
    String nombreAcomp="", apellidoAcomp="", apellido2Acomp="", relacionMenor="";
    //ANTECEDENTES PERSONALES NO PATOLOGICOS
    int activFisica=-1, alimentacion=-1, aseoPers=-1, aseoBucal=-1, noAseoBucal=0;
    String pisoVivienda="", techoVivienda="", ventilacionVivienda="",tipoZoonosis="", 
            inmunizaciones="", inspeccionGeneral="";
    int zoonosis=-1;
    
    //EXPLORACION FISICA PARTE 1 
           
    double signoTA=0, signoFC=0.0, signoFR=0.0, signoPulso=0.0, temperatura=0.0,estatura=0.0, peso=0.0, 
            IMC=0.0, ICC=0.0;
    int cabeza=-1, cara=-1, craneo=-1, cuello=-1, oidoDer=-1, oidoIzq=-1, visionComatica=-1, reflejosOc=-1,
            regionPrecordial=-1, camposPulmo=-1, visceromegalias=-1, hernias=-1,genitourinario=-1, regionPerineal=-1,
            coordinacion=-1,sensibilidadSistNerv=-1,marcha=-1,paresCraneales=-1, equilibrio=-1;
    //EXPLORACION FISICA PARTE 2 
    int insufVen=-1, ulveraciones=-1, escoliosis=-1, xifosis=-1, cicatrices=-1, nevos=-1, tatuajes=-1, integridad=-1, 
            fuerzaMusc=-1, tono=-1, sensibilidadExtrem=-1, rot=-1, articulaciones=-1, arcosMov=-1, discapacidad=-1;
    String descripcion="";
    //OBSERVACIONES
    String observaciones="";
    //NOTA AGREGADA
    String notaAgregaga="";


    
}
