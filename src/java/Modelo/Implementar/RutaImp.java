
package Modelo.Implementar;

import Modelo.Interfaz.Ruta;
import Modelo.Tabs.RutaTab;
import Servicios.Mensajes.Mensajero;
import Servicios.Mensajes.Msj;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RutaImp extends Mensajero implements Ruta{
    
    Connection con;
    
    final String Insert = "";
    final String Update = "";
    final String Delete = "";
    final String one = "";
    final String All = "";
    
    public RutaImp(Connection con){
        this.con = con;
    }

    @Override
    public Msj insert(RutaTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Msj update(RutaTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Msj delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RutaTab  bringOff(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RutaTab one(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RutaTab> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
