
package DAO.Tabs;

import java.sql.Date;

public class HistoricoTab {
    private String id;
    private String Placa;
    private String Conductor;
    private int Ruta;
    private int Evento;
    private String Descripcion;
    private String Lugar;
    private Date Inicio;
    private Date Final;
    private boolean Estado;

    public HistoricoTab(String Placa, String Conductor, int Ruta, int Evento, String Descripcion, String Lugar, Date Inicio, Date Final, boolean Estado) {
        this.Placa = Placa;
        this.Conductor = Conductor;
        this.Ruta = Ruta;
        this.Evento = Evento;
        this.Descripcion = Descripcion;
        this.Lugar = Lugar;
        this.Inicio = Inicio;
        this.Final = Final;
        this.Estado = Estado;
    }

    public HistoricoTab(String id, String Placa, String Conductor, int Ruta, int Evento, String Descripcion, String Lugar, Date Inicio, Date Final, boolean Estado) {
        this.id = id;
        this.Placa = Placa;
        this.Conductor = Conductor;
        this.Ruta = Ruta;
        this.Evento = Evento;
        this.Descripcion = Descripcion;
        this.Lugar = Lugar;
        this.Inicio = Inicio;
        this.Final = Final;
        this.Estado = Estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getConductor() {
        return Conductor;
    }

    public void setConductor(String Conductor) {
        this.Conductor = Conductor;
    }

    public int getRuta() {
        return Ruta;
    }

    public void setRuta(int Ruta) {
        this.Ruta = Ruta;
    }

    public int getEvento() {
        return Evento;
    }

    public void setEvento(int Evento) {
        this.Evento = Evento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public Date getInicio() {
        return Inicio;
    }

    public void setInicio(Date Inicio) {
        this.Inicio = Inicio;
    }

    public Date getFinal() {
        return Final;
    }

    public void setFinal(Date Final) {
        this.Final = Final;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "HistoricoTab{" + "id=" + id + ", Placa=" + Placa + ", Conductor=" + Conductor + ", Ruta=" + Ruta + ", Evento=" + Evento + ", Descripcion=" + Descripcion + ", Lugar=" + Lugar + ", Inicio=" + Inicio + ", Final=" + Final + ", Estado=" + Estado + '}';
    }
    
    
    
    
}
