package Modelo.Implementar;

import Modelo.Interfaz.Ruta;
import Modelo.Tabs.RutaTab;
import Servicios.Mensajes.Mensajero;
import Servicios.Mensajes.Msj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class RutaImp extends Mensajero implements Ruta {

    Connection con;

    final String Insert = "";
    final String Update = "";
    final String Delete = "";
    final String one = "";
    final String All = "";

    public RutaImp(Connection con) {
        this.con = con;
    }

    @Override
    public Msj insert(RutaTab r) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Insert);
            stat.setString(1, r.getNombre());
            stat.setTime(2, r.getHoraIni());
            stat.setTime(3, r.getHoraFin());
            stat.setFloat(4, r.getKm());
            stat.setString(5, r.getLugarInicio());
            stat.setString(6, r.getLugarFin());
            if (stat.executeUpdate() == 0) {
                m = Error();
            } else {
                m = InsertOk(r.getNombre());
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
    public Msj update(RutaTab r) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Update);
            stat.setLong(1, r.getId());
            stat.setString(2, r.getNombre());
            stat.setTime(3, r.getHoraIni());
            stat.setTime(4, r.getHoraFin());
            stat.setFloat(6, r.getKm());
            stat.setString(7, r.getLugarInicio());
            stat.setString(8, r.getLugarFin());
            if (stat.executeUpdate() == 0) {
                m = Error();
            } else {
                m = UpdateOk(r.getNombre());
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
        RutaTab r = one(id);
        if (r != null) {
            PreparedStatement stat = null;
            try {
                stat = con.prepareCall(Delete);
                stat.setLong(1, r.getId());
                if (stat.executeUpdate() == 0) {
                    m = Error();
                } else {
                    m = DeleteOk(one);
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
    public RutaTab bringOff(ResultSet rs) throws SQLException {
        Long ID = rs.getLong("ID");
        String Nombre = rs.getString("Nombre");
        Time HorarioIni = rs.getTime("HorarioIni");
        Time HorarioFin = rs.getTime("HorarioFin");
        float Km = rs.getFloat("Km");
        String LugarIni = rs.getString("LugarIni");
        String LugarFin = rs.getString("LugarFin");
        RutaTab r = new RutaTab(ID, Nombre, HorarioIni, HorarioFin, Km, LugarIni, LugarFin);
        return r;
    }

    @Override
    public RutaTab one(Long id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        RutaTab r = null;
        try {
            stat = con.prepareCall(one);
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
    public List<RutaTab> all() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<RutaTab> rl = new ArrayList<>();
        try {
            stat = con.prepareCall(All);
            stat.executeQuery();
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
