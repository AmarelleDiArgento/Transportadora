/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Evento;
import Modelo.Tabs.EventoTab;
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
public class EventoImp extends Mensajero implements Evento {

    Connection con;

    final String Insert = "Call taller1.InsEve(?,?)";
    final String Update = "";
    final String Delete = "Call taller1.EliEve(?)";
    final String One = "";
    final String All = "Call taller1.LisEve()";

    public EventoImp(Connection con) {
        this.con = con;
    }
    

    @Override
    public Msj insert(EventoTab e) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Insert);
            stat.setString(1, e.getNombre());
            if(stat.executeUpdate() == 0){
                m = Error();
            } else {
                m = InsertOk(e.getNombre());
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
    public Msj update(EventoTab e) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Update);
            stat.setLong(1, e.getID());
            stat.setString(2, e.getNombre());
            if (stat.executeUpdate() == 0){
                m = Error();
            } else {
                m = UpdateOk(e.getNombre());
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
        EventoTab e = one(id);
        if(e != null){
            PreparedStatement stat = null;
            try {
                stat = con.prepareCall(Delete);
                stat.setLong(1, e.getID());
                if(stat.executeUpdate() == 0){
                    m = Error();
                } else {
                    m = DeleteOk(e.getNombre());
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
    public EventoTab bringOff(ResultSet rs) throws SQLException{
        Long ID = rs.getLong("ID");
        String NombreEve = rs.getString("NombreEve");
        EventoTab e = new EventoTab(ID, NombreEve);
        return e;
        
    }

    @Override
    public EventoTab one(Long id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        EventoTab e = null;
        try {
            stat = con.prepareCall(One);
            stat.setLong(1, e.getID());
            rs = stat.executeQuery();
            if(rs.next()){
                e = bringOff(rs);
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
        return e;
    }

    @Override
    public List<EventoTab> all() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<EventoTab> el = new ArrayList<>();
        try {
            stat = con.prepareCall(All);
            rs = stat.executeQuery();
            while(rs.next()){
                el.add(bringOff(rs));
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
        return el;
        
    }

}
