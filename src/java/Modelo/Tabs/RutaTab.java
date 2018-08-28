
package Modelo.Tabs;

import java.sql.Time;

public class RutaTab {
    private int Id;
    private String nombre;
    private Time HoraIni;
    private Time HoraFin;
    private float km;
    private String LugarInicio;
    private String LusarFin;

    public RutaTab(String nombre, Time HoraIni, Time HoraFin, float km, String LugarInicio, String LusarFin) {
        this.nombre = nombre;
        this.HoraIni = HoraIni;
        this.HoraFin = HoraFin;
        this.km = km;
        this.LugarInicio = LugarInicio;
        this.LusarFin = LusarFin;
    }

    public RutaTab(int Id, String nombre, Time HoraIni, Time HoraFin, float km, String LugarInicio, String LusarFin) {
        this.Id = Id;
        this.nombre = nombre;
        this.HoraIni = HoraIni;
        this.HoraFin = HoraFin;
        this.km = km;
        this.LugarInicio = LugarInicio;
        this.LusarFin = LusarFin;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
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

    public String getLusarFin() {
        return LusarFin;
    }

    public void setLusarFin(String LusarFin) {
        this.LusarFin = LusarFin;
    }

    @Override
    public String toString() {
        return "RutasTab{" + "Id=" + Id + ", nombre=" + nombre + ", HoraIni=" + HoraIni + ", HoraFin=" + HoraFin + ", km=" + km + ", LugarInicio=" + LugarInicio + ", LusarFin=" + LusarFin + '}';
    }
    
    
    
    
    
    
    
    
}
