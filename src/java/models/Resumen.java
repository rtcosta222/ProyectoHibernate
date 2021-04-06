/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author lscar
 */
public class Resumen {
    private int numpersonas;
    private int maxsalario;
    private int minsalario;

    public int getNumpersonas() {
        return numpersonas;
    }

    public void setNumpersonas(int numpersonas) {
        this.numpersonas = numpersonas;
    }

    public int getMaxsalario() {
        return maxsalario;
    }

    public void setMaxsalario(int maxsalario) {
        this.maxsalario = maxsalario;
    }

    public int getMinsalario() {
        return minsalario;
    }

    public void setMinsalario(int minsalario) {
        this.minsalario = minsalario;
    }
}
