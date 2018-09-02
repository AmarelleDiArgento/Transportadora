/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Interfaz;

import Modelo.DAO;
import Modelo.Tabs.AsignarTab;
import Servicios.Mensajes.Msj;
import java.sql.ResultSet;

/**
 *
 * @author freyd
 */
public interface Asignar extends DAO<ResultSet, AsignarTab, Long> {

    public AsignarTab one(Long idPer, Long idRol);

    public Msj delete(Long idPer, Long idRol);
}
