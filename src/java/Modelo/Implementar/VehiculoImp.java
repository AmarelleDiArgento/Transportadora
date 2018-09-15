/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Vehiculo;
import Modelo.Tabs.VehiculoTab;
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
public class VehiculoImp extends Mensajero implements Vehiculo {

    Connection con;
    final String Insert = "";
    final String Update = "";
    final String Delete = "";
    final String One = "";
    final String All = "";

    public VehiculoImp(Connection con) {
        this.con = con;
    }

    @Override
    public Msj insert(VehiculoTab o) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Insert);
            stat.setString(1, o.getPlaca());
            stat.setString(2, o.getMarca());
            stat.setInt(3, o.getModelo());
            stat.setString(4, o.getChasis());
            stat.setInt(5, o.getPasajeros());
            stat.setString(6, o.getNitEmpresa());
            if (stat.executeUpdate() == 0) {
                m = Error();
            } else {
                m = InsertOk(o.getPlaca());
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
    public Msj update(VehiculoTab o) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Update);
            stat.setString(1, o.getPlaca());
            stat.setString(2, o.getMarca());
            stat.setInt(3, o.getModelo());
            stat.setString(4, o.getChasis());
            stat.setInt(5, o.getPasajeros());
            stat.setString(6, o.getNitEmpresa());
            if (stat.executeUpdate() == 0) {
                m = Error();
            } else {
                m = UpdateOk(o.getPlaca());
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
    public Msj delete(String id) {
        VehiculoTab v = one(id);
        if (v != null) {
            PreparedStatement stat = null;
            try {
                stat = con.prepareCall(Delete);
                stat.setString(1, id);
                if (stat.executeUpdate() == 0) {
                    m = Error();
                } else {
                    m = DeleteOk(v.getPlaca());
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
    public VehiculoTab bringOff(ResultSet rs) throws SQLException {
        String Placa = rs.getString("Placa");
        String Marca = rs.getString("Marca");
        int Modelo = rs.getInt("Modelo");
        String Chasis = rs.getString("Chasis");
        int Pasajeros = rs.getInt("Pasajeros");
        String nitEmpresa = rs.getString("nitEmpresa");
        VehiculoTab v = new VehiculoTab(Placa, Marca, Modelo, Chasis, Pasajeros, nitEmpresa, Pasajeros);
        return v;
    }

    @Override
    public VehiculoTab one(String id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        VehiculoTab v = null;
        try {
            stat = con.prepareCall(One);
            stat.setString(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                v = bringOff(rs);
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
        return v;
    }

    @Override
    public List<VehiculoTab> all() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<VehiculoTab> vl = new ArrayList<>();
        try {
            stat = con.prepareCall(All);
            rs = stat.executeQuery();
            while (rs.next()) {
                vl.add(bringOff(rs));
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
        return vl;
    }

}
