/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Permiso;
import Modelo.Tabs.PermisoTab;
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
public class PermisoImp extends Mensajero implements Permiso {

    Connection con;

    final String Insert = "";
    final String Update = "";
    final String Delete = "";
    final String One = "";
    final String All = "";

    public PermisoImp(Connection con) {
        this.con = con;
    }

    @Override
    public Msj insert(PermisoTab o) {
        PreparedStatement stat = null;

        try {
            stat = con.prepareCall(Insert);
            stat.setString(1, o.getNombre());
            stat.setString(2, o.getUrl());
            stat.setBoolean(3, o.isEstado());
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
    public Msj update(PermisoTab o) {
        PreparedStatement stat = null;

        try {
            stat = con.prepareCall(Update);
            stat.setLong(1, o.getID());
            stat.setString(2, o.getNombre());
            stat.setString(3, o.getUrl());
            stat.setBoolean(4, o.isEstado());
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
        PermisoTab p = one(id);
        if (p != null) {
            PreparedStatement stat = null;
            try {
                stat = con.prepareCall(Delete);
                stat.setLong(1, p.getID());
                if (stat.executeUpdate() == 0) {
                    m = Error();
                } else {
                    m = DeleteOk(p.getNombre());
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
    public PermisoTab bringOff(ResultSet rs) throws SQLException {
        Long Id = rs.getLong("ID");
        String Nombre = rs.getString("Nombre");
        String Url = rs.getString("Url");
        boolean Estado = rs.getBoolean("Estado");
        PermisoTab p = new PermisoTab(Id, Nombre, Url, Estado);
        return p;
    }

    @Override
    public PermisoTab one(Long id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        PermisoTab p = null;
        try {
            stat = con.prepareCall(One);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                p = bringOff(rs);
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
        return p;
    }

    @Override
    public List<PermisoTab> all() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<PermisoTab> pl = new ArrayList<>();
        try {
            stat = con.prepareCall(All);
            stat.executeQuery();
            while (rs.next()) {
                pl.add(bringOff(rs));
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
        return pl;
    }

}
