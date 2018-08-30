/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Empresa;
import Modelo.Tabs.EmpresaTab;
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
public class EmpresaImp extends Mensajero implements Empresa {

    Connection con;

    final String Insert = "Call taller1.InsEmp(?,?,?,?,?)";
    final String Update = "Call taller.ActuEmp(?,?,?,?,?,?)";
    final String Delete = "Call taller1.EliEmp(?)";
    final String One = "";
    final String All = "Call taller1.LisEmp()";

    public EmpresaImp(Connection con) {
        this.con = con;
    }

    @Override
    public Msj insert(EmpresaTab e) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Insert);
            stat.setString(1, e.getRazonSoc());
            stat.setString(2, e.getRepresentante());
            stat.setString(3, e.getTelefono());
            stat.setString(4, e.getDireccion());
            stat.setString(5, e.getArl());
            stat.setBoolean(6, e.isEstado());
            if(stat.executeUpdate() == 0){
                m = Error();
            } else {
                m = InsertOk(e.getRazonSoc());
            }
            
        } catch (SQLException ex) {
            m = Error(ex);
        } finally {
            StatClose(stat);
        }
        return m;
    }

    @Override
    public Msj update(EmpresaTab e) {
        PreparedStatement stat = null;
        try {
            stat = con.prepareCall(Update);
            stat.setString(1, e.getNit());
            stat.setString(2, e.getRazonSoc());
            stat.setString(3, e.getRepresentante());
            stat.setString(4, e.getTelefono());
            stat.setString(5, e.getDireccion());
            stat.setString(6, e.getArl());
            stat.setBoolean(7, e.isEstado());
            if(stat.executeUpdate() == 0){
                m = Error();
            } else {
                m = UpdateOk(e.getRazonSoc());
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
        EmpresaTab e = one(id);
        if(e != null){
            PreparedStatement stat = null;
            try {
                stat = con.prepareCall(Delete);
                stat.setString(1, e.getNit());
                if(stat.executeUpdate() == 0){
                    m = Error();
                } else {
                    m = DeleteOk(e.getRazonSoc());
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
    public EmpresaTab bringOff(ResultSet rs) throws SQLException{
        String Nit = rs.getString("Nit");
        String RazonSoc = rs.getString("RazonSoc");
        String Representante = rs.getString("Representante");
        String Telefono = rs.getString("Telefono");
        String Direccion = rs.getString("Direccion");
        String Arl = rs.getString("Arl");
        boolean Estado = rs.getBoolean("Estado");
        EmpresaTab e = new EmpresaTab(Nit, RazonSoc, Representante, Telefono, Direccion, Arl, Estado);
        return e;
    }

    @Override
    public EmpresaTab one(Long id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        EmpresaTab e = null;
        try {
            stat = con.prepareCall(One);
            stat.setString(1, e.getNit());
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
    public List<EmpresaTab> all() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<EmpresaTab> el = new ArrayList<>();
        try {
            stat = con.prepareCall(All);
            stat.executeQuery();
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
