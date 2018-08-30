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
public class PermisoTab implements Serializable {

    private Long ID;
    private String Nombre;
    private String Url;
    private boolean Estado;

    public PermisoTab(String Nombre, String Url, boolean Estado) {
        this.Nombre = Nombre;
        this.Url = Url;
        this.Estado = Estado;
    }

    public PermisoTab(Long ID, String Nombre, String Url, boolean Estado) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Url = Url;
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
     * @return the Url
     */
    public String getUrl() {
        return Url;
    }

    /**
     * @param Url the Url to set
     */
    public void setUrl(String Url) {
        this.Url = Url;
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
    
    
}
