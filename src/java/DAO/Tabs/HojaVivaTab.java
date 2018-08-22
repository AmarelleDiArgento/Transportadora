
package DAO.Tabs;


public class HojaVivaTab {
    private int Id;
    private String Tecnomecanica;
    private String Soat;

    public HojaVivaTab(String Tecnomecanica, String Soat) {
        this.Tecnomecanica = Tecnomecanica;
        this.Soat = Soat;
    }

    public HojaVivaTab(int Id, String Tecnomecanica, String Soat) {
        this.Id = Id;
        this.Tecnomecanica = Tecnomecanica;
        this.Soat = Soat;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTecnomecanica() {
        return Tecnomecanica;
    }

    public void setTecnomecanica(String Tecnomecanica) {
        this.Tecnomecanica = Tecnomecanica;
    }

    public String getSoat() {
        return Soat;
    }

    public void setSoat(String Soat) {
        this.Soat = Soat;
    }

    @Override
    public String toString() {
        return "HojaVivaTab{" + "Id=" + Id + ", Tecnomecanica=" + Tecnomecanica + ", Soat=" + Soat + '}';
    }
    
    
    
}
