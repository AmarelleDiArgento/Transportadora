/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Tabs.AsignarTab;
import Servicios.Mensajes.Msj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Modelo.Interfaz.Asignar;
import Servicios.Mensajes.Mensajero;
import java.sql.Connection;

/**
 *
 * @author freyd
 */
public class AsignarImp extends Mensajero implements Asignar {

    Connection con;

    final String Insert = "";
    final String Update = "";
    final String Delete = "";
    final String one = "";
    final String All = "";

    public AsignarImp(Connection con) {
        this.con = con;
    }

    @Override
    public Msj insert(AsignarTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Msj update(AsignarTab o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Msj delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AsignarTab bringOff(ResultSet rs) throws SQLException {

        Long RolID = rs.getLong("");
        Long PerID = rs.getLong("");
        int Leer = rs.getInt("");
        boolean Nuevo = rs.getBoolean("");
        boolean Modificar = rs.getBoolean("");
        boolean Eliminar = rs.getBoolean("");
        AsignarTab a = new AsignarTab(RolID, PerID, Leer, Nuevo, Modificar, Eliminar);
        return a;
    }

    @Override
    public AsignarTab one(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AsignarTab> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
