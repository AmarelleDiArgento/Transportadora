
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

    public RutaTab(String nombre, Time HoraIni, Time HoraFin, float km, String LugarInicio, String LusarFin) {
        this.nombre = nombre;
        this.HoraIni = HoraIni;
        this.HoraFin = HoraFin;
        this.km = km;
        this.LugarInicio = LugarInicio;
        this.LugarFin = LusarFin;
    }

    public RutaTab(Long Id, String nombre, Time HoraIni, Time HoraFin, float km, String LugarInicio, String LugarFin) {
        this.Id = Id;
        this.nombre = nombre;
        this.HoraIni = HoraIni;
        this.HoraFin = HoraFin;
        this.km = km;
        this.LugarInicio = LugarInicio;
        this.LugarFin = LugarFin;
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

    public void setLugarFin(String LugarFin) {
        this.LugarFin = LugarFin;
    }

    @Override
    public String toString() {
        return "RutasTab{" + "Id=" + Id + ", nombre=" + nombre + ", HoraIni=" + HoraIni + ", HoraFin=" + HoraFin + ", km=" + km + ", LugarInicio=" + LugarInicio + ", LugarFin=" + LugarFin + '}';
    }
    
    
    
    
    
    
    
    
}
