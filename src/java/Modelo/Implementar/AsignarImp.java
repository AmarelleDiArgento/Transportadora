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
import java.sql.PreparedStatement;
import java.util.ArrayList;

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
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Insert);
            stat.setLong(1, o.getRolId());
            stat.setLong(2, o.getPerID());
            stat.setInt(3, o.getLeer());
            stat.setBoolean(4, o.isNuevo());
            stat.setBoolean(5, o.isModificar());
            stat.setBoolean(6, o.isEliminar());
            if (stat.executeUpdate() == 0) {
                m = Error();
            } else {
                m = InsertOk("");
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
    public Msj update(AsignarTab o) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Update);
            stat.setLong(1, o.getRolId());
            stat.setLong(2, o.getPerID());
            stat.setInt(3, o.getLeer());
            stat.setBoolean(4, o.isNuevo());
            stat.setBoolean(5, o.isModificar());
            stat.setBoolean(6, o.isEliminar());
            if (stat.executeUpdate() == 0) {
                m = Error();
            } else {
                m = UpdateOk("");
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
    public Msj delete(Long idr, Long idp) {
        AsignarTab a = one(idr, idp);
        if (a != null) {
            PreparedStatement stat = null;
            try {
                stat = con.prepareCall(Delete);
                stat.setLong(1, idr);
                stat.setLong(2, idp);
                if (stat.executeUpdate() == 0) {
                    m = Error();
                } else {
                    m = DeleteOk(idr + " - " + idp);
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
            m = notFound(idr + " - " + idp);
        }
        return m;
    }

    @Override
    public AsignarTab bringOff(ResultSet rs) throws SQLException {

        Long RolID = rs.getLong("IdRol");
        Long PerID = rs.getLong("IdPer");
        int Leer = rs.getInt("Leer");
        boolean Nuevo = rs.getBoolean("Nuevo");
        boolean Modificar = rs.getBoolean("Modificar");
        boolean Eliminar = rs.getBoolean("Eliminar");
        AsignarTab a = new AsignarTab(RolID, PerID, Leer, Nuevo, Modificar, Eliminar);
        return a;
    }

    @Override
    public AsignarTab one(Long idr, Long idp) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        AsignarTab a = null;

        try {
            stat = con.prepareCall(one);
            stat.setLong(1, idr);
            stat.setLong(2, idp);
            rs = stat.executeQuery();
            if (rs.next()) {
                a = bringOff(rs);
            } else {
                m = notFound(idr + " - " + idp);
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
        return a;
    }

    @Override
    public List<AsignarTab> all() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<AsignarTab> al = new ArrayList<>();
        try {
            stat = con.prepareCall(All);
            rs = stat.executeQuery();
            while (rs.next()) {
                al.add(bringOff(rs));
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
        return al;
    }

    @Override
    public AsignarTab one(Long id) {
        throw new UnsupportedOperationException("Metodo no funcional para esta entidad"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Msj delete(Long id) {
        throw new UnsupportedOperationException("Metodo no funcional para esta entidad"); //To change body of generated methods, choose Tools | Templates.
    }

}
