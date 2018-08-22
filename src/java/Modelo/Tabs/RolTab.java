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
public class RolTab implements Serializable{
    private int ID;
    private String Nombre;
    private String Descripcion;
    private boolean Estado;

    public RolTab(String Nombre, String Descripcion, boolean Estado) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public RolTab(int ID, String Nombre, String Descripcion, boolean Estado) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
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
        return "RolTab{" + "ID=" + ID + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Estado=" + Estado + '}';
    }
    
    
    
    
    
}
