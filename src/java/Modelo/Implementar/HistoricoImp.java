package Modelo.Implementar;

import Modelo.Interfaz.Historico;
import Modelo.Tabs.HistoricoTab;
import Servicios.Mensajes.Mensajero;
import Servicios.Mensajes.Msj;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoImp extends Mensajero implements Historico {

    Connection con;

    final String Insert = "Call taller1.InsHis(?,?,?,?,?,?)";
    final String Update = "Call taller1.ActHis(?,?,?,?,?,?,?)";
    final String Delete = "Call taller1.EliHis(?)";
    final String One = "";
    final String All = "Call taller1.LisHis1()";

    public HistoricoImp(Connection con) {
        this.con = con;
    }

    @Override
    public Msj insert(HistoricoTab h) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Insert);
            stat.setString(1, h.getPlaca());
            stat.setString(2, h.getConductor());
            stat.setInt(3, h.getRuta());
            stat.setInt(4, h.getEvento());
            stat.setString(5, h.getDescripcion());
            stat.setString(6, h.getLugar());
            stat.setDate(7, h.getInicio());
            stat.setDate(8, h.getFinal());
            stat.setBoolean(9, h.isEstado());
            if(stat.executeUpdate() == 0){
                m = Error();
            } else {
                m = InsertOk(h.getPlaca());
            }
            
        } catch (SQLException ex) {
            m = Error(ex);
        } finally {
            StatClose(stat);
        }
        return m;
    }

    @Override
    public Msj update(HistoricoTab h) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Update);
            stat.setLong(1, h.getId());
            stat.setString(2, h.getPlaca());
            stat.setString(3, h.getConductor());
            stat.setInt(4, h.getRuta());
            stat.setInt(5, h.getEvento());
            stat.setString(6, h.getDescripcion());
            stat.setString(7, h.getLugar());
            stat.setDate(8, h.getInicio());
            stat.setDate(9, h.getFinal());
            stat.setBoolean(10, h.isEstado());
            if(stat.executeUpdate() == 0){
                m = Error();
            } else { 
                m = UpdateOk(h.getPlaca());
            }
            
        } catch (SQLException ex) {
            m = Error(ex);
        } finally {
            StatClose(stat);
        }
        return m;
    }

    @Override
    public Msj delete(Long id) {
        HistoricoTab h = one(id);
        if(h != null){
            PreparedStatement stat = null;
            try {
                stat = con.prepareCall(Delete);
                stat.setLong(1, h.getId());
                if(stat.executeUpdate() == 0){
                    m = Error();
                } else {
                    m = DeleteOk(h.getPlaca());
                }
                
            } catch (SQLException ex) {
                m = Error(ex);
            } finally {
                StatClose(stat);
            }
        } else {
            m = notFound(id);
        }
        return m;
    }

    @Override
    public HistoricoTab bringOff(ResultSet rs) throws SQLException {
        Long Id = rs.getLong("ID");
        String Placa = rs.getString("Placa");
        String Conductor = rs.getString("Conductor");
        int Ruta = rs.getInt("Ruta");
        int Evento = rs.getInt("Evento");
        String Descripcion = rs.getString("Descripcion");
        String Lugar = rs.getString("Lugar");
        Date FechaIni = rs.getDate("FechaIni");
        Date FechaFin = rs.getDate("FechaFin");
        boolean Estado = rs.getBoolean("Estado");
        HistoricoTab h = new HistoricoTab(Id, Placa, Conductor, Ruta, Evento, Descripcion, Lugar, FechaIni, FechaFin, Estado);
        return h;
 
    }

    @Override
    public HistoricoTab one(Long id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        HistoricoTab h = null;
        try {
            stat = con.prepareCall(One);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                h = bringOff(rs);
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
        return h;
    }

    @Override
    public List<HistoricoTab> all() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<HistoricoTab> hl = new ArrayList<>();
        try {
            stat = con.prepareCall(All);
            stat.executeQuery();
            while(rs.next()){
                hl.add(bringOff(rs));
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
        return hl;
    }

}
