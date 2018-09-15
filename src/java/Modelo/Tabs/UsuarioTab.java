/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tabs;

import Modelo.Implementar.Admin;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author freyd
 */
public class UsuarioTab implements Serializable {

    private String TipoDocumento;
    private String NumDocumento;
    private String Nombres;
    private String Telefono;
    private String Direccion;
    private String Eps;
    private String Arl;
    private String Correo;
    private String Contrasena;
    private String Foto;
    private Long idRol;
    private String nitEmpresa;
    private boolean Estado;

    private RolTab Rol;

    public UsuarioTab(String TipoDocumento, String NumDocumento, String Nombres, String Telefono, String Direccion, String Eps, String Arl, String Correo, String Contrasena, String Foto, Long idRol, String nitEmpresa, boolean Estado) {
        this.TipoDocumento = TipoDocumento;
        this.NumDocumento = NumDocumento;
        this.Nombres = Nombres;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Eps = Eps;
        this.Arl = Arl;
        this.Correo = Correo;
        this.Contrasena = Contrasena;
        this.Foto = Foto;
        this.idRol = idRol;
        this.nitEmpresa = nitEmpresa;
        this.Estado = Estado;
    }

    /**
     * @return the TipoDocumento
     */
    public String getTipoDocumento() {
        return TipoDocumento;
    }

    /**
     * @param TipoDocumento the TipoDocumento to set
     */
    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    /**
     * @return the NumDocumento
     */
    public String getNumDocumento() {
        return NumDocumento;
    }

    /**
     * @param NumDocumento the NumDocumento to set
     */
    public void setNumDocumento(String NumDocumento) {
        this.NumDocumento = NumDocumento;
    }

    /**
     * @return the Nombres
     */
    public String getNombres() {
        return Nombres;
    }

    /**
     * @param Nombres the Nombres to set
     */
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
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
     * @return the Eps
     */
    public String getEps() {
        return Eps;
    }

    /**
     * @param Eps the Eps to set
     */
    public void setEps(String Eps) {
        this.Eps = Eps;
    }

    /**
     * @return the Arl
     */
    public String getArl() {
        return Arl;
    }

    /**
     * @param Arl the Arl to set
     */
    public void setArl(String Arl) {
        this.Arl = Arl;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    /**
     * @return the Contrasena
     */
    public String getContrasena() {
        return Contrasena;
    }

    /**
     * @param Contrasena the Contrasena to set
     */
    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    /**
     * @return the Foto
     */
    public String getFoto() {
        return Foto;
    }

    /**
     * @param Foto the Foto to set
     */
    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    /**
     * @return the idRol
     */
    public Long getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Long idRol) {
        this.idRol = idRol;
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

    /**
     * @return the Rol
     */
    public RolTab getRol() {

        return Rol;
    }

    /**
     * @param Rol the Rol to set
     */
    public void setRol(RolTab Rol) throws SQLException {
        Admin a = new Admin();
        this.Rol = a.getRol().one(idRol);
    }

    @Override
    public String toString() {
        return "UsuarioTab{" + "TipoDocumento=" + TipoDocumento + ", NumDocumento=" + NumDocumento + ", Nombres=" + Nombres + ", Telefono=" + Telefono + ", Direccion=" + Direccion + ", Eps=" + Eps + ", Arl=" + Arl + ", Correo=" + Correo + ", Contrasena=" + Contrasena + ", Foto=" + Foto + ", idRol=" + idRol + ", nitEmpresa=" + nitEmpresa + ", Estado=" + Estado + '}';
    }

}
