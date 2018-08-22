/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios.Mensajes;

/**
 *
 * @author freyd
 */
public class Msj {
    private String Tipo;
    private String Msj;
    private String Detalles;

    public Msj() {
    }

    
    public Msj(String Tipo, String Msj, String Detalles) {
        this.Tipo = Tipo;
        this.Msj = Msj;
        this.Detalles = Detalles;
    }

    /**
     * @return the Tipo
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return the Msj
     */
    public String getMsj() {
        return Msj;
    }

    /**
     * @param Msj the Msj to set
     */
    public void setMsj(String Msj) {
        this.Msj = Msj;
    }

    /**
     * @return the Detalles
     */
    public String getDetalles() {
        return Detalles;
    }

    /**
     * @param Detalles the Detalles to set
     */
    public void setDetalles(String Detalles) {
        this.Detalles = Detalles;
    }

    @Override
    public String toString() {
        return "MsjTab{" + "Tipo=" + Tipo + ", Msj=" + Msj + ", Detalles=" + Detalles + '}';
    }
    
    
}
