/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Implementar.Admin;
import Modelo.Tabs.RolTab;
import Servicios.Mensajes.Mensajero;
import Servicios.Mensajes.Msj;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        Msj m = new Msj();
        try {
            Mensajero Msj = new Mensajero() {

            };
            Admin asql = new Admin();
            RolTab r = new RolTab("Tester", "Probador", true);
            m = asql.getRol().insert(r);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(m.toString());
    }
    
}
