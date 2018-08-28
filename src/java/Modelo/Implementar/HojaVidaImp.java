
package Modelo.Implementar;

import Modelo.Interfaz.HojaVida;
import Modelo.Tabs.HojaVidaTab;
import Servicios.Mensajes.Mensajero;
import Servicios.Mensajes.Msj;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HojaVidaImp extends Mensajero implements HojaVida{
    
    Connection con;
    
    final String Insert = "";
    final String Update = "";
    final String Delete = "";
    final String One = "";
    final String All = "";
    
    public HojaVidaImp(Connection con){
        this.con = con;
    }
    
    @Override
    public Msj insert(HojaVidaTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Msj update(HojaVidaTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Msj delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HojaVidaTab bringOff(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HojaVidaTab one(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HojaVidaTab> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
