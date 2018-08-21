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
public class TabAgregar {
    
    String nombreP="",apellPP="",apellMP="",parentesco="";

    public TabAgregar(String nombreP, String apellPP, String apellMP, String parentesco) {
        this.nombreP = nombreP;
        this.apellPP = apellPP;
        this.apellMP = apellMP;
        this.parentesco = parentesco;
    }
    
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellPP() {
        return apellPP;
    }

    public void setApellPP(String apellPP) {
        this.apellPP = apellPP;
    }

    public String getApellMP() {
        return apellMP;
    }

    public void setApellMP(String apellMP) {
        this.apellMP = apellMP;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
    
    
    
}
