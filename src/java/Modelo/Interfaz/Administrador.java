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

    Asignar getAsignar();

    Empresa getEmpresa();

    Evento getEvento();

    Historico getHistorico();

    Permiso getPermiso();

    Rol getRol();

    Ruta getRuta();

    Usuario getUsuario();

    Vehiculo getVehiculo();

}
