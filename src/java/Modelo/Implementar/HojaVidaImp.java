
package Modelo.Implementar;

import Modelo.Interfaz.HojaVida;
import Modelo.Tabs.HojaVidaTab;
import Modelo.Tabs.RolTab;
import Servicios.Mensajes.Mensajero;
import Servicios.Mensajes.Msj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import java.util.List;

public class HojaVidaImp extends Mensajero implements HojaVida{
    
    Connection con;
    
    final String Insert = "";
    final String Update = "";
    final String Delete = "";
    final String One = "";
    final String All = "";
    
    public HojaVidaImp(Connection con){
        this.con = con;
    }
    
    @Override
    public Msj insert(HojaVidaTab o) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(Insert);
            stat.setString(1, o.getTecnomecanica());
            stat.setString(2, o.getSoat());
            if (stat.executeUpdate() == 0){
                m = Error(o.getSoat());
            } else {
                m = InsertOk(o.getTecnomecanica());
            }
            
        } catch (SQLException ex) {
            m = Error(o.getTecnomecanica(), ex);
        } finally {
            StatClose(stat);
        }
        return m;
    }

    @Override
    public Msj update(HojaVidaTab o) {
        PreparedStatement stat = null;
        try {
            stat =  con.prepareStatement(Update);
            stat.setInt(1, o.getId());
            stat.setString(2, o.getTecnomecanica());
            stat.setString(3, o.getSoat());
            if(stat.executeUpdate() == 0){
                m = Error(o.getTecnomecanica());
            } else {
                m = UpdateOk(o.getTecnomecanica());
            }
            
        } catch (SQLException ex) {
            m = Error(o.getTecnomecanica(), ex);
        } finally {
            StatClose(stat);
        }
        return m;
    }

    @Override
    public Msj delete(Long id) {
        HojaVidaTab o = one(id);
        if(o != null){
            PreparedStatement stat = null;
            try {
                stat = con.prepareStatement(Delete);
                stat.setLong(1, id);
                if(stat.executeUpdate() == 0){
                    m = Error(o.getTecnomecanica());
                } else {
                    m = DeleteOk(o.getTecnomecanica());
                }
                
            } catch (SQLException ex) {
                m = Error(o.getTecnomecanica(), ex);
            } finally {
                m = StatClose(stat);
            }
            
        } else {
            m = Error();
        }
        return m;
        
    }

    @Override

    public HojaVidaTab bringOff(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    public HojaVidaTab one(Long id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        HojaVidaTab o = null;
        try {
            stat = con.prepareCall(One);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if (rs.next()){
                o = gets(rs);
            } else {
                m = oneError(id);
            }
            
        } catch (SQLException ex) {
            m = OneError(id, ex);
            
        } finally {
            StatClose(stat, rs);
        }
        return o;

    }

    @Override
    public HojaVidaTab one(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HojaVidaTab> all() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<HojaVidaTab> o = new ArrayList<>();
        try {
            stat = con.prepareCall(All); 
            rs = stat.executeQuery();
            while (rs.next()){
                o.add(gets(rs));
            }
            
        } catch (SQLException ex) {
        } finally {
            StatClose(stat, rs);
        }
        return o;
    }
    
}
