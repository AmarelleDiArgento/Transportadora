/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tabs;

import java.io.Serializable;

/**
 *
 * @author freyd
 */
public class VehiculoTab implements Serializable {

    private String Placa;
    private String Marca;
    private int Modelo;
    private String Chasis;
    private int Pasajeros;
    private String nitEmpresa;
    private int DatoHojaVehi;

    public VehiculoTab(String Placa, String Marca, int Modelo, String Chasis, int Pasajeros, String nitEmpresa, int DatoHojaVehi) {
        this.Placa = Placa;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Chasis = Chasis;
        this.Pasajeros = Pasajeros;
        this.nitEmpresa = nitEmpresa;
        this.DatoHojaVehi = DatoHojaVehi;
    }

    /**
     * @return the Placa
     */
    public String getPlaca() {
        return Placa;
    }

    /**
     * @param Placa the Placa to set
     */
    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    /**
     * @return the Marca
     */
    public String getMarca() {
        return Marca;
    }

    /**
     * @param Marca the Marca to set
     */
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    /**
     * @return the Modelo
     */
    public int getModelo() {
        return Modelo;
    }

    /**
     * @param Modelo the Modelo to set
     */
    public void setModelo(int Modelo) {
        this.Modelo = Modelo;
    }

    /**
     * @return the Chasis
     */
    public String getChasis() {
        return Chasis;
    }

    /**
     * @param Chasis the Chasis to set
     */
    public void setChasis(String Chasis) {
        this.Chasis = Chasis;
    }

    /**
     * @return the Pasajeros
     */
    public int getPasajeros() {
        return Pasajeros;
    }

    /**
     * @param Pasajeros the Pasajeros to set
     */
    public void setPasajeros(int Pasajeros) {
        this.Pasajeros = Pasajeros;
    }

    /**
     * @return the nitEmpresa
     */
    public String getNitEmpresa() {
        return nitEmpresa;
    }

    /**
     * @param nitEmpresa the nitEmpresa to set
     */
    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    /**
     * @return the DatoHojaVehi
     */
    public int getDatoHojaVehi() {
        return DatoHojaVehi;
    }

    /**
     * @param DatoHojaVehi the DatoHojaVehi to set
     */
    public void setDatoHojaVehi(int DatoHojaVehi) {
        this.DatoHojaVehi = DatoHojaVehi;
    }

    @Override
    public String toString() {
        return "VehiculoTab{" + "Placa=" + getPlaca() + ", Marca=" + getMarca() + ", Modelo=" + getModelo() + ", Chasis=" + getChasis() + ", Pasajeros=" + getPasajeros() + ", nitEmpresa=" + getNitEmpresa() + ", DatoHojaVehi=" + getDatoHojaVehi() + '}';
    }

}
