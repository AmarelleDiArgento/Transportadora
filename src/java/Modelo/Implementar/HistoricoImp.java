package Modelo.Implementar;

import Modelo.Interfaz.Historico;
import Modelo.Tabs.HistoricoTab;
import Servicios.Mensajes.Mensajero;
import Servicios.Mensajes.Msj;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HistoricoImp extends Mensajero implements Historico {

    Connection con;

    final String Insert = "";
    final String Update = "";
    final String Delete = "";
    final String One = "";
    final String All = "";

    public HistoricoImp(Connection con) {
        this.con = con;
    }

    @Override
    public Msj insert(HistoricoTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Msj update(HistoricoTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Msj delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistoricoTab bringOff(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistoricoTab one(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistoricoTab> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
