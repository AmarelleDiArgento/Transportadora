/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tabs;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author freyd
 */
public class RolTab implements Serializable {

    private Long ID;
    private String Nombre;
    private String Descripcion;
    private int Jerarquia;
    private boolean Estado;
    private List<AsignarTab> accesos;

    public RolTab(String Nombre, String Descripcion, int Jerarquia, boolean Estado) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Jerarquia = Jerarquia;
        this.Estado = Estado;
    }

    public RolTab(Long ID, String Nombre, String Descripcion, int Jerarquia, boolean Estado) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Jerarquia = Jerarquia;
        this.Estado = Estado;
    }

    /**
     * @return the ID
     */
    public Long getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Jerarquia
     */
    public int getJerarquia() {
        return Jerarquia;
    }

    /**
     * @param Jerarquia the Jerarquia to set
     */
    public void setJerarquia(int Jerarquia) {
        this.Jerarquia = Jerarquia;
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
     * @return the accesos
     */
    public List<AsignarTab> getAccesos() {
        return accesos;
    }

    /**
     * @param accesos the accesos to set
     */
    public void setAccesos(List<AsignarTab> accesos) {
        this.accesos = accesos;
    }

    @Override
    public String toString() {
        return "RolTab{" + "ID=" + ID + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Jerarquia=" + Jerarquia + ", Estado=" + Estado + ", accesos=" + accesos + '}';
    }

}
