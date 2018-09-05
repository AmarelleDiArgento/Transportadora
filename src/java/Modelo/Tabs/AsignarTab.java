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
public class AsignarTab implements Serializable {

    private Long RolId;
    private Long PerID;
    private int Leer;
    private boolean Nuevo;
    private boolean Modificar;
    private boolean Eliminar;

    private PermisoTab Permiso;
    private RolTab Rol;

    public AsignarTab(Long RolId, Long PerID, int Leer, boolean Nuevo, boolean Modificar, boolean Eliminar) {
        this.RolId = RolId;
        this.PerID = PerID;
        this.Leer = Leer;
        this.Nuevo = Nuevo;
        this.Modificar = Modificar;
        this.Eliminar = Eliminar;
    }

    /**
     * @return the RolId
     */
    public Long getRolId() {
        return RolId;
    }

    /**
     * @param RolId the RolId to set
     */
    public void setRolId(Long RolId) {
        this.RolId = RolId;
    }

    /**
     * @return the PerID
     */
    public Long getPerID() {
        return PerID;
    }

    /**
     * @param PerID the PerID to set
     */
    public void setPerID(Long PerID) {
        this.PerID = PerID;
    }

    /**
     * @return the Leer
     */
    public int getLeer() {
        return Leer;
    }

    /**
     * @param Leer the Leer to set
     */
    public void setLeer(int Leer) {
        this.Leer = Leer;
    }

    /**
     * @return the Nuevo
     */
    public boolean isNuevo() {
        return Nuevo;
    }

    /**
     * @param Nuevo the Nuevo to set
     */
    public void setNuevo(boolean Nuevo) {
        this.Nuevo = Nuevo;
    }

    /**
     * @return the Modificar
     */
    public boolean isModificar() {
        return Modificar;
    }

    /**
     * @param Modificar the Modificar to set
     */
    public void setModificar(boolean Modificar) {
        this.Modificar = Modificar;
    }

    /**
     * @return the Eliminar
     */
    public boolean isEliminar() {
        return Eliminar;
    }

    /**
     * @param Eliminar the Eliminar to set
     */
    public void setEliminar(boolean Eliminar) {
        this.Eliminar = Eliminar;
    }

    /**
     * @return the Permiso
     */
    public PermisoTab getPermiso() {
        return Permiso;
    }

    /**
     * @param Permiso the Permiso to set
     */
    public void setPermiso(PermisoTab Permiso) {
        this.Permiso = Permiso;
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
    public void setRol(RolTab Rol) {
        this.Rol = Rol;
    }

    @Override
    public String toString() {
        return "AsignarTab{" + "RolId=" + RolId + ", PerID=" + PerID + ", Leer=" + Leer + ", Nuevo=" + Nuevo + ", Modificar=" + Modificar + ", Eliminar=" + Eliminar + ", Permiso=" + Permiso + ", Rol=" + Rol + '}';
    }

}
