/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html.to.pdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jahir
 */
public class HtmlToPdf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, DocumentException{
        
        /*******************REPORTE PDF***********************/
        //DATOS PARA LLENAR EL REPORTE GENERAL
        String[] datos_reporte = new String[32];
        datos_reporte[0] = "Aqui Expediente001";
        datos_reporte[1] = "Aqui folio002";
        datos_reporte[2] = "Aqui folio003";
        datos_reporte[3] = "Aqui folio004";
        datos_reporte[4] = "Aqui folio005";
        datos_reporte[5] = "Aqui folio006";
        datos_reporte[6] = "Aqui folio007";
        datos_reporte[7] = "Aqui folio008";
        datos_reporte[8] = "Aqui folio009";
        datos_reporte[9] = "Aqui folio010";
        datos_reporte[10] = "Aqui folio011";
        datos_reporte[11] = "Aqui folio012";
        datos_reporte[12] = "Aqui folio013";
        datos_reporte[13] = "Aqui folio014";
        datos_reporte[14] = "Aqui folio015";
        datos_reporte[15] = "Aqui folio016";
        datos_reporte[16] = "Aqui folio017";
        datos_reporte[17] = "Aqui folio018";
        datos_reporte[18] = "Aqui folio019";
        datos_reporte[19] = "Aqui folio020";
        datos_reporte[20] = "Aqui folio021";
        datos_reporte[21] = "Aqui folio022";
        datos_reporte[22] = "Aqui folio023";
        datos_reporte[23] = "Aqui folio024";
        datos_reporte[24] = "Aqui folio025";
        datos_reporte[25] = "Aqui folio026";
        datos_reporte[26] = "Aqui folio027";
        datos_reporte[27] = "Aqui folio028";
        datos_reporte[28] = "Aqui folio029";
        datos_reporte[29] = "Aqui folio030";
        datos_reporte[30] = "Aqui folio031";
        datos_reporte[31] = "Aqui folio032";
        
        //DATOS PARA LLENAR TIPO DE REPORTE
        String[] datos_tipo_reporte = new String[7];
        datos_tipo_reporte[0] = "h";
        datos_tipo_reporte[1] = "";
        datos_tipo_reporte[2] = "j";
        datos_tipo_reporte[3] = "";
        datos_tipo_reporte[4] = "d";
        datos_tipo_reporte[5] = "";
        datos_tipo_reporte[6] = "k";
        
        //DATOS PARA LLENAR SI ES FISICA O MORAL
        String[] datos_fisico_moral = new String[2];
        datos_fisico_moral[0] = "1";
        datos_fisico_moral[1] = "2";
        
        //DATOS PARA LLENAR DATOS VICTIMA
        String[][] datos_victima = new String[2][10];
        datos_victima[0][0] = "1";
        datos_victima[0][1] = "2";
        datos_victima[0][2] = "3";
        datos_victima[0][3] = "3";
        datos_victima[0][4] = "3";
        datos_victima[0][5] = "3";
        datos_victima[0][6] = "3";
        datos_victima[0][7] = "3";
        datos_victima[0][8] = "3";
        datos_victima[0][9] = "3";
        
        datos_victima[1][0] = "4";
        datos_victima[1][1] = "5";
        datos_victima[1][2] = "6";
        datos_victima[1][3] = "6";
        datos_victima[1][4] = "6";
        datos_victima[1][5] = "6";
        datos_victima[1][6] = "6";
        datos_victima[1][7] = "6";
        datos_victima[1][8] = "6";
        datos_victima[1][9] = "6";
        
        //DATOS PARA LLENAR DATOS AGRESOR
        String[][] datos_agresor = new String[2][12];
        datos_agresor[0][0] = "1";
        datos_agresor[0][1] = "2";
        datos_agresor[0][2] = "3";
        datos_agresor[0][3] = "4";
        datos_agresor[0][4] = "5";
        datos_agresor[0][5] = "6";
        datos_agresor[0][6] = "7";
        datos_agresor[0][7] = "8";
        datos_agresor[0][8] = "9";
        datos_agresor[0][9] = "10";
        datos_agresor[0][10] = "11";
        datos_agresor[0][11] = "12";
        
        datos_agresor[1][0] = "13";
        datos_agresor[1][1] = "14";
        datos_agresor[1][2] = "15";
        datos_agresor[1][3] = "16";
        datos_agresor[1][4] = "17";
        datos_agresor[1][5] = "18";
        datos_agresor[1][6] = "19";
        datos_agresor[1][7] = "20";
        datos_agresor[1][8] = "21";
        datos_agresor[1][9] = "22";
        datos_agresor[1][10] = "23";
        datos_agresor[1][11] = "24";
        
        
        //ReportePDF reporte_pdf = new ReportePDF();
        //reporte_pdf.escribirReporteHTML("nombre_pdf",reporte_pdf.leerReporteHTML(datos_reporte, datos_tipo_reporte, datos_fisico_moral, datos_victima, datos_agresor));
        
        /*******************REPORTE PDF***********************/
        
        /*******************OFICIO_GENERAL***********************/
        
        String[] datos = new String [11];
        
        datos[0] = "Fecha Creacion";
        datos[1] = "Numero de Oficio";
        datos[2] = "Asunto";
        datos[3] = "Numero Expediente";
        datos[4] = "Nombre Dirigido A";
        datos[5] = "Cargo Puesto";
        datos[6] = "Texto";
        datos[7] = "Nombre";
        datos[8] = "cargo";
        datos[9] = "Firma";
        datos[10] = "Copia para";
        
        
        //OficioGeneralPDF oficio_general = new OficioGeneralPDF();
        
        //oficio_general.escribirOficioGeneralHTML("hola_oficio_general", oficio_general.leerOficioGeneralHTML(datos));
        
        /*******************OFICIO_GENERAL***********************/
        
        
        
        /*******************OFICIO_GENERAL***********************/
        
        String[] datos_anexo_uno = new String [35];
        
        datos_anexo_uno[0] = "Dato 1";
        datos_anexo_uno[1] = "Dato 2";
        datos_anexo_uno[2] = "Dato 3";
        datos_anexo_uno[3] = "Dato 4";
        datos_anexo_uno[4] = "Dato 5";
        datos_anexo_uno[5] = "Dato 6";
        datos_anexo_uno[6] = "Dato 7";
        datos_anexo_uno[7] = "Dato 8";
        datos_anexo_uno[8]= "Dato 9";
        datos_anexo_uno[9] = "Dato 10";
        datos_anexo_uno[10] = "Dato 11";
        datos_anexo_uno[11] = "Dato 12";
        datos_anexo_uno[12] = "Dato 13";
        datos_anexo_uno[13] = "Dato 14";
        datos_anexo_uno[14] = "Dato 15";
        datos_anexo_uno[15] = "Dato 16";
        datos_anexo_uno[16] = "Dato 17";
        datos_anexo_uno[17] = "Dato 18";
        datos_anexo_uno[18] = "Dato 19";
        datos_anexo_uno[19] = "Dato 20";
        datos_anexo_uno[20] = "Dato 21";
        datos_anexo_uno[21] = "Dato 22";
        datos_anexo_uno[22] = "Dato 23";
        datos_anexo_uno[23] = "Dato 24";
        datos_anexo_uno[24] = "Dato 25";
        datos_anexo_uno[25] = "Dato 26";
        datos_anexo_uno[26] = "Dato 27";
        datos_anexo_uno[27] = "Dato 28";
        datos_anexo_uno[28] = "Dato 29";
        datos_anexo_uno[29] = "Dato 30";
        datos_anexo_uno[30] = "Dato 31";
        datos_anexo_uno[31] = "Dato 32";
        datos_anexo_uno[32] = "Dato 33";
        datos_anexo_uno[33] = "Dato 34";
        datos_anexo_uno[34] = "Dato 35";
        
        
        
        
        
        
        AnexoUnoPDF anexo_uno = new AnexoUnoPDF();
        
        anexo_uno.escribirAnexoUnoHTML("asi_se_a_llamar", anexo_uno.leerAnexoUnoHTML(datos_anexo_uno));
        
        /*******************OFICIO_GENERAL***********************/
        
    }
    
}
