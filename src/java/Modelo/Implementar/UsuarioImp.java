/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Usuario;
import Modelo.Tabs.UsuarioTab;
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
public class UsuarioImp extends Mensajero implements Usuario {

    Connection con;

    final String Insert = "";
    final String Update = "";
    final String Delete = "";
    final String One = "";
    final String All = "";

    public UsuarioImp(Connection con) {
        this.con = con;
    }

    @Override
    public Msj insert(UsuarioTab o) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Insert);
            stat.setString(1, o.getTipoDocumento());
            stat.setString(2, o.getNumDocumento());
            stat.setString(3, o.getTelefono());
            stat.setString(4, o.getDireccion());
            stat.setString(5, o.getEps());
            stat.setString(6, o.getArl());
            stat.setString(7, o.getCorreo());
            stat.setString(8, o.getContrasena());
            stat.setString(9, o.getFoto());
            stat.setLong(10, o.getIdRol());
            stat.setString(11, o.getNitEmpresa());
            stat.setBoolean(12, o.isEstado());
            if (stat.executeUpdate() == 0) {
                m = Error();
            } else {
                m = InsertOk(o.getNombres());
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
    public Msj update(UsuarioTab o) {

        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Update);
            stat.setString(1, o.getTipoDocumento());
            stat.setString(2, o.getNumDocumento());
            stat.setString(3, o.getTelefono());
            stat.setString(4, o.getDireccion());
            stat.setString(5, o.getEps());
            stat.setString(6, o.getArl());
            stat.setString(7, o.getCorreo());
            stat.setString(8, o.getContrasena());
            stat.setString(9, o.getFoto());
            stat.setLong(10, o.getIdRol());
            stat.setString(11, o.getNitEmpresa());
            stat.setBoolean(12, o.isEstado());
            if (stat.executeUpdate() == 0) {
                m = Error();
            } else {
                m = InsertOk(o.getNombres());
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
        UsuarioTab u = one(id);
        if (u != null) {
            PreparedStatement stat = null;
            try {
                stat = con.prepareCall(Delete);
                if (stat.executeUpdate() == 0) {
                    m = Error();
                } else {
                    m = DeleteOk(u.getNombres());
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
    public UsuarioTab bringOff(ResultSet rs) throws SQLException {
        String TipoDocumento = rs.getString("TipoDocumento");
        String NumDocumento = rs.getString("NumDocumento");
        String Nombres = rs.getString("Nombres");
        String Telefono = rs.getString("Telefono");
        String Direccion = rs.getString("Direccion");
        String Eps = rs.getString("Eps");
        String Arl = rs.getString("Arl");
        String Correo = rs.getString("Correo");
        String Contrasena = rs.getString("Contrasena");
        String Foto = rs.getString("Foto");
        Long idRol = rs.getLong("idRol");
        String nitEmpresa = rs.getString("nitEmpresa");
        boolean Estado = rs.getBoolean("Estado");
        UsuarioTab u = new UsuarioTab(TipoDocumento, NumDocumento, Nombres, Telefono, Direccion, Eps, Arl, Correo, Contrasena, Foto, idRol, nitEmpresa, Estado);
        return u;
    }

    @Override
    public UsuarioTab one(String id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        UsuarioTab u = null;
        try {
            stat = con.prepareCall(One);
            stat.setString(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                u = bringOff(rs);
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
        return u;
    }

    @Override
    public List<UsuarioTab> all() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<UsuarioTab> ul = new ArrayList<>();
        try {
            stat = con.prepareCall(All);
            rs = stat.executeQuery();
            while (rs.next()) {
                ul.add(bringOff(rs));
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
        return ul;
    }
}
