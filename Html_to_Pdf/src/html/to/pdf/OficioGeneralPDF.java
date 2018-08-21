/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html.to.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class OficioGeneralPDF {
    
    String texto_html = "";
    
       
    public String leerOficioGeneralHTML(String[] datos) throws FileNotFoundException, IOException{
        
        String texto_remplazado = "";
        
        StringBuilder contentBuilder = new StringBuilder();
        BufferedReader in = new BufferedReader(new FileReader("C:\\evnnya\\documentos\\oficio_general.html"));
        String str;
        while ((str = in.readLine()) != null) {
            contentBuilder.append(str);
        }
        in.close();
            String content = contentBuilder.toString();
            
            System.out.println(content);
        
            //REMPLAZAR VARIABLES DEL HTML
            content = content.replace("%1%", datos[0]);
            content = content.replace("%2%", datos[1]);
            content = content.replace("%3%", datos[2]);
            content = content.replace("%4%", datos[3]);
            content = content.replace("%5%", datos[4]);
            content = content.replace("%6%", datos[5]);
            content = content.replace("%7%", datos[6]);
            content = content.replace("%nombre%", datos[7]);
            content = content.replace("%cargo%", datos[8]);
            content = content.replace("%Firma%", datos[9]);
            content = content.replace("%Copia para%", datos[10]);
            
            texto_remplazado = content;
            
        return texto_remplazado;    
        
    }
    
    public void escribirOficioGeneralHTML(String nombre_archivo, String content){
        
        //CREACION DEL ARCHIVO HTML
        BufferedWriter bw = null;
	FileWriter fw = null;

            try {

		

		fw = new FileWriter("C:\\evnnya\\documentos\\oficio_general_generado.html");
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
            
            String url_html = "C:\\evnnya\\documentos\\oficio_general_generado.html";
            String url_pdf = "C:\\evnnya\\documentos\\oficio_general_generado.pdf";
        
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
