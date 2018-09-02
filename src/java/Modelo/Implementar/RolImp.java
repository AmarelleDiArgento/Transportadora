/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Rol;
import Modelo.Tabs.RolTab;
import Servicios.Mensajes.Mensajero;
import Servicios.Mensajes.Msj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freyd
 */
public class RolImp extends Mensajero implements Rol {

    Connection con;

    final String Insert = "Call taller1.InsRol(?,?,?,?);";
    final String Update = "Call taller1.ActRol(?,?,?,?,?);";
    final String Delete = "Call taller1.EliRol(?);";
    final String One = "Call taller1.ConRol(?);";
    final String All = "Call taller1.LisRol();";

    public RolImp(Connection con) {
        this.con = con;
    }

    @Override
    public Msj insert(RolTab o) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Insert);
            stat.setString(1, o.getNombre());
            stat.setString(2, o.getDescripcion());
            stat.setInt(3, o.getJerarquia());
            stat.setBoolean(4, o.isEstado());
            if (stat.executeUpdate() == 0) {
                m = Error();
            } else {
                m = InsertOk(o.getNombre());
            }

        } catch (SQLException ex) {
            m = Error(ex);
        } finally {
            try {
                StatClose(stat);
            } catch (SQLException ex) {
                m = Error(ex);
            }
        }
        return m;
    }

    @Override
    public Msj update(RolTab o) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Update);
            stat.setLong(1, o.getID());
            stat.setString(2, o.getNombre());
            stat.setString(3, o.getDescripcion());
            stat.setInt(4, o.getJerarquia());
            stat.setBoolean(5, o.isEstado());
            if (stat.executeUpdate() == 0) {
                m = Error();
            } else {
                m = UpdateOk(o.getNombre());
            }

        } catch (SQLException ex) {
            m = Error(ex);
        } finally {
            try {
                StatClose(stat);
            } catch (SQLException ex) {
                m = Error(ex);
            }
        }
        return m;
    }

    @Override
    public Msj delete(Long id) {
        RolTab r = one(id);
        if (r != null) {
            PreparedStatement stat = null;
            try {
                stat = con.prepareCall(Delete);
                stat.setLong(1, id);
                if (stat.executeUpdate() == 0) {
                    m = Error();
                } else {
                    m = DeleteOk(r.getNombre());
                }

            } catch (SQLException ex) {
                m = Error(ex);
            } finally {
                try {
                    StatClose(stat);
                } catch (SQLException ex) {
                    m = Error(ex);
                }

            }
        } else {
            m = notFound(id);
        }
        return m;
    }

    @Override
    public RolTab bringOff(ResultSet rs) throws SQLException {
        Long Id = rs.getLong("ID");
        String Nombre = rs.getString("Nombre");
        String Detalles = rs.getString("Descripcion");
        int Jerarquia = rs.getInt("Jerarquia");
        boolean Estado = rs.getInt("Estado") != 0;
        RolTab r = new RolTab(Id, Nombre, Detalles, Jerarquia, Estado);
        return r;
    }

    @Override
    public RolTab one(Long id) {

        PreparedStatement stat = null;
        ResultSet rs = null;
        RolTab r = null;
        try {
            stat = con.prepareCall(One);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                r = bringOff(rs);
            } else {
                m = notFound(id);
            }

        } catch (SQLException ex) {
            m = Error(ex);
        } finally {
            try {
                StatClose(stat, rs);
            } catch (SQLException ex) {
                m = Error(ex);
            }
        }
        return r;
    }

    @Override
    public List<RolTab> all() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<RolTab> rl = new ArrayList<>();
        try {
            stat = con.prepareCall(All);
            rs = stat.executeQuery();
            while (rs.next()) {
                rl.add(bringOff(rs));
            }

        } catch (SQLException ex) {
            m = Error(ex);
        } finally {
            try {
                StatClose(stat, rs);
            } catch (SQLException ex) {
                m = Error(ex);
            }
        }
        return rl;
    }

}
