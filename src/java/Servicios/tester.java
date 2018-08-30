/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Implementar.Admin;
import Modelo.Tabs.RolTab;
import Servicios.Mensajes.Mensaje;
import java.sql.SQLException;

/**
 *
 * @author freyd
 */
public class tester {

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args)  {
        tester t = new tester();
        t.probador();
    }
    public void probador(){
        
        Mensaje m = new Mensaje();
        try {
            Admin asql = new Admin();
            RolTab r = new RolTab("Tester", "Probador", 1, true);
            m.m = asql.getRol().insert(r);
            
            
        } catch (SQLException ex) {
            m.m = m.Error(ex);
        }
        System.out.println(m.m.toString());
    }
    
}
