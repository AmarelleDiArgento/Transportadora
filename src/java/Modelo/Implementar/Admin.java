/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Implementar;

import Modelo.Interfaz.Administrador;
import Modelo.Interfaz.Empresa;
import Modelo.Interfaz.Evento;
import Modelo.Interfaz.Rol;
import Modelo.Interfaz.Usuario;
import Modelo.Interfaz.Vehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author freyd
 */
public class Admin implements Administrador {

    Connection con;
    DataSource ds;

    final String User = "Taller1";
    final String Pass = "Taller1";
    final String DataBase = "Taller1";
    final String Url = "jdbc:mysql://localhost:3306/";

    public Admin() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(Url + DataBase, User, Pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Admin(DataSource ds) throws SQLException {
        this.ds = ds;
        this.con = ds.getConnection();
    }

    Empresa emp = null;
    Evento eve = null;
    Rol rol = null;
    Usuario usu = null;
    Vehiculo veh = null;

    @Override
    public Empresa getEmpresa() {
        if (emp == null) {
            emp = new EmpresaImp(con);
        }
        return emp;
    }

    @Override
    public Evento getEvento() {
        if (eve == null) {
            eve = new EventoImp(con);
        }
        return eve;
    }

    @Override
    public Rol getRol() {
        if (rol == null) {
            rol = new RolImp(con);
        }
        return rol;
    }

    @Override
    public Usuario getUsuario() {
        if (usu == null) {
            usu = new UsuarioImp(con);
        }
        return usu;
    }

    @Override
    public Vehiculo getVehiculo() {
        if (veh == null) {
            veh = new VehiculoImp(con);
        }
        return veh;
    }

}
