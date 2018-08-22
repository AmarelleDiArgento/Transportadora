/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Tabs;

import java.io.Serializable;

/**
 *
 * @author freyd
 */
public class EmpresaTab implements Serializable {

    private String Nit;
    private String RazonSoc;
    private String Representante;
    private String Telefono;
    private String Direccion;
    private boolean Estado;

    public EmpresaTab(String Nit, String RazonSoc, String Representante, String Telefono, String Direccion, boolean Estado) {
        this.Nit = Nit;
        this.RazonSoc = RazonSoc;
        this.Representante = Representante;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Estado = Estado;
    }

    /**
     * @return the Nit
     */
    public String getNit() {
        return Nit;
    }

    /**
     * @param Nit the Nit to set
     */
    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    /**
     * @return the RazonSoc
     */
    public String getRazonSoc() {
        return RazonSoc;
    }

    /**
     * @param RazonSoc the RazonSoc to set
     */
    public void setRazonSoc(String RazonSoc) {
        this.RazonSoc = RazonSoc;
    }

    /**
     * @return the Representante
     */
    public String getRepresentante() {
        return Representante;
    }

    /**
     * @param Representante the Representante to set
     */
    public void setRepresentante(String Representante) {
        this.Representante = Representante;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * @return the Estado
     */
    public boolean isEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "EmpresaTab{" + "Nit=" + Nit + ", RazonSoc=" + RazonSoc + ", Representante=" + Representante + ", Telefono=" + Telefono + ", Direccion=" + Direccion + ", Estado=" + Estado + '}';
    }

        
}
