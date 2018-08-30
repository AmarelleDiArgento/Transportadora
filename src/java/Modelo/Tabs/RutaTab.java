
package Modelo.Tabs;

import java.io.Serializable;
import java.sql.Time;

public class RutaTab implements Serializable{
    private Long Id;
    private String nombre;
    private Time HoraIni;
    private Time HoraFin;
    private float km;
    private String LugarInicio;
    private String LugarFin;
    private boolean Estado;

    public RutaTab(String nombre, Time HoraIni, Time HoraFin, float km, String LugarInicio, String LugarFin, boolean Estado) {
        this.nombre = nombre;
        this.HoraIni = HoraIni;
        this.HoraFin = HoraFin;
        this.km = km;
        this.LugarInicio = LugarInicio;
        this.LugarFin = LugarFin;
        this.Estado = Estado;
    }

    public RutaTab(Long Id, String nombre, Time HoraIni, Time HoraFin, float km, String LugarInicio, String LugarFin, boolean Estado) {
        this.Id = Id;
        this.nombre = nombre;
        this.HoraIni = HoraIni;
        this.HoraFin = HoraFin;
        this.km = km;
        this.LugarInicio = LugarInicio;
        this.LugarFin = LugarFin;
        this.Estado = Estado;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Time getHoraIni() {
        return HoraIni;
    }

    public void setHoraIni(Time HoraIni) {
        this.HoraIni = HoraIni;
    }

    public Time getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(Time HoraFin) {
        this.HoraFin = HoraFin;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public String getLugarInicio() {
        return LugarInicio;
    }

    public void setLugarInicio(String LugarInicio) {
        this.LugarInicio = LugarInicio;
    }

    public String getLugarFin() {
        return LugarFin;
    }

    public void setLusarFin(String LugarFin) {
        this.LugarFin = LugarFin;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "RutaTab{" + "Id=" + Id + ", nombre=" + nombre + ", HoraIni=" + HoraIni + ", HoraFin=" + HoraFin + ", km=" + km + ", LugarInicio=" + LugarInicio + ", LugarFin=" + LugarFin + ", Estado=" + Estado + '}';
    }
    
    
    
}
