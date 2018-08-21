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
import javax.swing.JOptionPane;

/**
 *
 * @author jahir
 */
public class ReportePDF {
    
    String texto_html = "";
    
       
    public String leerReporteHTML(String[] datos_reporte, String[] tipo_reporte, String[] fisica_moral, String[][] datos_victima, String [][] datos_agresor) throws FileNotFoundException, IOException{
        
        String texto_remplazado = "";
        
        StringBuilder contentBuilder = new StringBuilder();
        BufferedReader in = new BufferedReader(new FileReader("C:\\evnnya\\documentos\\reporte.html"));
        String str;
        while ((str = in.readLine()) != null) {
            contentBuilder.append(str);
        }
        in.close();
            String content = contentBuilder.toString();
            
            System.out.println(content);
        
            //REMPLAZAR VARIABLES DEL HTML
            content = content.replace("%NumeroExpediente%", datos_reporte[0]);
            content = content.replace("%NumeroFolio%", datos_reporte[1]);
            content = content.replace("%FechaAlta%", datos_reporte[2]);
            content = content.replace("%HoraAlta%", datos_reporte[3]);
            content = content.replace("%NombreRecibio%", datos_reporte[4]);
            content = content.replace("%NumeroOficio%", datos_reporte[5]);
            content = content.replace("%FechaOficio%", datos_reporte[6]);
            content = content.replace("%NombreEnvia%", datos_reporte[7]);
            content = content.replace("%NombreDenunciante%", datos_reporte[8]);
            content = content.replace("%EdadDenunciante%", datos_reporte[9]);
            content = content.replace("%SexoDenunciante%", datos_reporte[10]);
            content = content.replace("%EscolaridadDenunciante%", datos_reporte[11]);
            content = content.replace("%RelacionVictimaDenunciante%", datos_reporte[12]);
            content = content.replace("%CalleDenunciante%", datos_reporte[13]);
            content = content.replace("%NumeroDenunciante%", datos_reporte[14]);
            content = content.replace("%ColoniaDenunciante%", datos_reporte[15]);
            content = content.replace("%CodigoDenunciante%", datos_reporte[16]);
            content = content.replace("%TelefonoFijoDenunciante%", datos_reporte[17]);
            content = content.replace("%MovilDenunciante%", datos_reporte[18]);
            content = content.replace("%MunicipioDenunciante%", datos_reporte[19]);
            content = content.replace("%CorreoDenunciante%", datos_reporte[20]);
            content = content.replace("%NombreCustodia%", datos_reporte[21]);
            content = content.replace("%EdadCustodia%", datos_reporte[22]);
            content = content.replace("%SexoCustodia%", datos_reporte[23]);
            content = content.replace("%EscolaridadCustodia%", datos_reporte[24]);
            content = content.replace("%RelacionVictimaCustodia%", datos_reporte[25]);
            content = content.replace("%CorreoCustodia%", datos_reporte[26]);
            content = content.replace("%TelefonoFijoCustodia%", datos_reporte[27]);
            content = content.replace("%MovilCustodia%", datos_reporte[28]);
            content = content.replace("%Domicilio Custodia%", datos_reporte[29]);
            content = content.replace("%ResenaSituacion%", datos_reporte[30]);
            content = content.replace("%Observaciones%", datos_reporte[31]);
            
            //REMPLAZAR TIPO REPORTE
            if(!tipo_reporte[0].equals("")){
                content = content.replace("<span class=\"div-circulo-seleccionado\" id=\"anonimo\">&nbsp;&nbsp;&nbsp;&nbsp;</span>", "<span class=\"div-circulo-seleccionado\" id=\"anonimo\">&nbsp;X&nbsp;</span>");
            }
            if(!tipo_reporte[1].equals("")){
                content = content.replace("<span class=\"div-circulo-seleccionado\" id=\"publico\">&nbsp;&nbsp;&nbsp;&nbsp;</span>", "<span class=\"div-circulo-seleccionado\" id=\"publico\">&nbsp;X&nbsp;</span>");
            }
            if(!tipo_reporte[2].equals("")){
                content = content.replace("<span class=\"div-circulo-seleccionado\" id=\"privado\">&nbsp;&nbsp;&nbsp;&nbsp;</span>", "<span class=\"div-circulo-seleccionado\" id=\"privado\">&nbsp;X&nbsp;</span>");
            }
            if(!tipo_reporte[3].equals("")){
                content = content.replace("<span class=\"div-circulo-seleccionado\" id=\"via\">&nbsp;&nbsp;&nbsp;&nbsp;</span>", "<span class=\"div-circulo-seleccionado\" id=\"via\">&nbsp;X&nbsp;</span>");
            }
            if(!tipo_reporte[4].equals("")){
                content = content.replace("<span class=\"div-circulo-seleccionado\" id=\"escrita\">&nbsp;&nbsp;&nbsp;&nbsp;</span>", "<span class=\"div-circulo-seleccionado\" id=\"escrita\">&nbsp;X&nbsp;</span>");
            }
            if(!tipo_reporte[5].equals("")){
                content = content.replace("<span class=\"div-circulo-seleccionado\" id=\"personal\">&nbsp;&nbsp;&nbsp;&nbsp;</span>", "<span class=\"div-circulo-seleccionado\" id=\"personal\">&nbsp;X&nbsp;</span>");
            }
            if(!tipo_reporte[6].equals("")){
                content = content.replace("<span class=\"div-circulo-seleccionado\" id=\"directa\">&nbsp;&nbsp;&nbsp;&nbsp;</span>", "<span class=\"div-circulo-seleccionado\" id=\"directa\">&nbsp;X&nbsp;</span>");
            }
            
            //REEMPLAZAR FISICA O MORAL
            if(!fisica_moral[0].equals("1")){
                content = content.replace("<span class=\"div-circulo-seleccionado\" id=\"fisica\">&nbsp;&nbsp;&nbsp;&nbsp;</span>", "<span class=\"div-circulo-seleccionado\" id=\"fisica\">&nbsp;X&nbsp;</span>");
            }
            if(!fisica_moral[1].equals("1")){
                content = content.replace("<span class=\"div-circulo-seleccionado\" id=\"moral\">&nbsp;&nbsp;&nbsp;&nbsp;</span>", "<span class=\"div-circulo-seleccionado\" id=\"moral\">&nbsp;X&nbsp;</span>");
            }
            
            //AGREGAR DATOS VICTIMA
            
            String add_victima = "";
            
            for(int i = 0; i < datos_victima.length; i++){
                
                add_victima = add_victima + "<p class=\"font-size\">Nombre: <span class=\"negritas\">"+ datos_victima[i][0] +"</span></p>\n" +
                                    "        <p class=\"font-size\">\n" +
                                    "            Edad: <span class=\"negritas\">"+ datos_victima[i][1] +"</span>&nbsp;&nbsp;&nbsp; Sexo: <span class=\"negritas\">"+ datos_victima[i][2] +"</span>&nbsp;&nbsp;&nbsp; Escolaridad: <span class=\"negritas\">"+ datos_victima[i][3] +"</span>\n" +
                                    "        </p>\n" +
                                    "        <p class=\"font-size\">\n" +
                                    "            Relaci&oacute;n con el agresor: <span class=\"negritas\">"+ datos_victima[i][4] +"</span>&nbsp;&nbsp;&nbsp; Correo: <span class=\"negritas\">"+ datos_victima[i][5] +"</span>\n" +
                                    "        </p>\n" +
                                    "        <p class=\"font-size\">\n" +
                                    "            Tel&eacute;fono fijo: <span class=\"negritas\">"+ datos_victima[i][6] +"</span>&nbsp;&nbsp;&nbsp; Tel&eacute;fono m&oacute;vil: <span class=\"negritas\">"+ datos_victima[i][7] +"</span>\n" +
                                    "        </p>\n" +
                                    "        <p class=\"font-size\">\n" +
                                    "            Direcci&oacute;n: <span class=\"negritas\">"+ datos_victima[i][8] +"</span>\n" +
                                    "        </p>\n" +
                                    "        <p class=\"font-size\">\n" +
                                    "            Referencia: <span class=\"negritas\">"+ datos_victima[i][9] +"</span>\n" +
                                    "        </p>\n" +
                                    "\n" +
                                    "        <center>\n" +
                                    "            <h6 class=\"separador\">\n" +
                                    "                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                                    "            </h6>\n" +
                                    "        </center>";
                
            }
            
            content = content.replace("<aqui-victima></aqui-victima>", add_victima);
            
            //AGREGAR DATOS DEL AGRESOR
            
            String add_agresor = "";
            
            for(int i = 0; i < datos_agresor.length; i++){
                
                add_agresor = add_agresor + "<p class=\"font-size\">Nombre: <span class=\"negritas\">"+ datos_agresor[i][0] +"</span></p>\n" +
                                            "        <p class=\"font-size\">\n" +
                                            "            Edad: <span class=\"negritas\">"+ datos_agresor[i][1] +"</span>&nbsp;&nbsp;&nbsp; Sexo: <span class=\"negritas\">"+ datos_agresor[i][2] +"</span>&nbsp;&nbsp;&nbsp; Escolaridad: <span class=\"negritas\">"+ datos_agresor[i][3] +"</span>\n" +
                                            "        </p>\n" +
                                            "        <p class=\"font-size\">\n" +
                                            "            Ocupaci&oacute;n: <span class=\"negritas\">"+ datos_agresor[i][4] +"</span>&nbsp;&nbsp;&nbsp; Lugar de trabajo: <span class=\"negritas\">"+ datos_agresor[i][5] +"</span>\n" +
                                            "        </p>\n" +
                                            "        <p class=\"font-size\">\n" +
                                            "            Estado civil: <span class=\"negritas\">"+ datos_agresor[i][6] +"</span>&nbsp;&nbsp;&nbsp; Relaci&oacute;n con la v&iacute;ctima: <span class=\"negritas\">"+ datos_agresor[i][7] +"</span>&nbsp;&nbsp;&nbsp;\n" +
                                            "        </p>\n" +
                                            "        <p class=\"font-size\">\n" +
                                            "            Correo: <span class=\"negritas\">"+ datos_agresor[i][8] +"</span>\n" +
                                            "        </p>\n" +
                                            "        <p class=\"font-size\">\n" +
                                            "            Tel&eacute;fono fijo: <span class=\"negritas\">"+ datos_agresor[i][9] +"</span>&nbsp;&nbsp;&nbsp; Tel&eacute;fono m&oacute;vil: <span class=\"negritas\">"+ datos_agresor[i][10] +"</span>\n" +
                                            "        </p>\n" +
                                            "        <p class=\"font-size\">\n" +
                                            "            Direcci&oacute;n: <span class=\"negritas\">"+ datos_agresor[i][11] +"</span>\n" +
                                            "        </p>"
                                            + "        <center>\n" +
                                            "            <h6 class=\"separador\">\n" +
                                            "                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                                            "            </h6>\n" +
                                            "        </center>";
                
            }
            
            content = content.replace("<datos-agresor></datos-agresor>", add_agresor);
            
            
            texto_remplazado = content;
            
        return texto_remplazado;    
        
    }
    
    public void escribirReporteHTML(String nombre_archivo, String content){
        
        //CREACION DEL ARCHIVO HTML
        BufferedWriter bw = null;
	FileWriter fw = null;

            try {

		

		fw = new FileWriter("C:\\evnnya\\documentos\\reporte_creado.html");
		bw = new BufferedWriter(fw);
		bw.write(content);

		System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
                }
            
            String url_html = "C:\\evnnya\\documentos\\reporte_creado.html";
            String url_pdf = "C:\\evnnya\\documentos\\reporte_creado.pdf";
        
        try {
            
            crearReportePDF(url_html, url_pdf);
            subirReporte(url_pdf, nombre_archivo+".pdf");
            
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void crearReportePDF(String url_html, String url_pdf) throws FileNotFoundException, DocumentException, IOException{
        
        //CREAR PDF
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(url_pdf));
        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(url_html)); 
        //step 5
         document.close();
 
        System.out.println( "PDF Created!" );
        
    }
    
    public void subirReporte(String url_pdf, String destino){
        
        //SUBIR ARCHIVO AL SERVIDOR
        Path origenPath = FileSystems.getDefault().getPath(url_pdf);
        Path destinoPath = FileSystems.getDefault().getPath("\\\\10.6.245.10\\archivos\\" + destino);

        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(null, "Archivo PDF Creado exitosamente");
        } catch (IOException e) {
            System.err.println(e);
        }
        
    }
    
}
