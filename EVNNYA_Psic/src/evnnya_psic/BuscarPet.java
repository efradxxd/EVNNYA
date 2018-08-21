/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evnnya_psic;

/**
 *
 * @author nivec
 */
public class BuscarPet {
    String folioP="",numeroE="",fech="",estat="";

    public BuscarPet(String folioP, String numeroE, String fech,String estat) {
        this.folioP = folioP;
        this.numeroE = numeroE;
        this.fech = fech;
        this.estat=estat;
    }
    public String getFolioP() {
        return folioP;
    }

    public void setFolioP(String folioP) {
        this.folioP = folioP;
    }

    public String getNumeroE() {
        return numeroE;
    }

    public void setNumeroE(String numeroE) {
        this.numeroE = numeroE;
    }

    public String getFech() {
        return fech;
    }

    public void setFech(String fech) {
        this.fech = fech;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
    
    
    
}
