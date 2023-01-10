package com.controlproductes.data;

import com.controlproductes.domain.Producte;

import java.util.List;

public interface IDataAccess {

    List<Producte> llistarProductes();
    Producte search(int id);
    void add(Producte product);
    void update(int id, Producte product);
    void drop(int id);

}
