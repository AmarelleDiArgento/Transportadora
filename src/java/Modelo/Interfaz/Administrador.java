/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Interfaz;

/**
 *
 * @author freyd
 */
public interface Administrador {

    Empresa getEmpresa();

    Evento getEvento();

    Rol getRol();

    Usuario getUsuario();

    Vehiculo getVehiculo();

    
}
