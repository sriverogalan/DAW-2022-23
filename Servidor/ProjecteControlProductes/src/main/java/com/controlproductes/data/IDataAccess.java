package com.controlproductes.data;

import com.controlproductes.domain.Producte;

import java.util.List;

public interface IDataAccess {

    List<Producte> llistarProductes();
    Producte cercar(Producte product);
    void afegir(Producte product);
    void actualitzar(Producte product);
    void eliminar(Producte product);

}
