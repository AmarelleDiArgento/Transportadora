package Modelo;


import Servicios.Mensajes.Msj;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author freyd
 */
public interface DAO<R, O, K> {

    Msj insert(O o);

    Msj update(O o);

    Msj delete(K id);

    O one(K id);

    O gets(R rs);

    List<O> all();
}
