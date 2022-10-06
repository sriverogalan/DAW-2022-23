package org.example.dades;

import org.example.domini.Pelicula;

import java.sql.SQLException;
import java.util.List;

public interface IAccessDades {
    boolean exists(String titol) throws SQLException;
    List<Pelicula> list();
    void update(Pelicula pelicula, String titol);
    void create(Pelicula pelicula, String titol);
    void delete(String titol);
    void search(String titol);
}
