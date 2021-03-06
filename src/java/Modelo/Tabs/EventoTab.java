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
public class EventoTab implements Serializable {

    private Long ID;
    private String Nombre;

    public EventoTab(String Nombre) {
        this.Nombre = Nombre;
    }

    public EventoTab(Long ID, String Nombre) {
        this.ID = ID;
        this.Nombre = Nombre;
    }

    public Long getID() {
        return ID;
    }

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

    @Override
    public String toString() {
        return "EventoTab{" + "ID=" + ID + ", Nombre=" + Nombre + '}';
    }

    
}
