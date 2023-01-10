package com.demospring.demospring.repositories;

import com.demospring.demospring.entities.Producte;
import org.springframework.data.repository.CrudRepository;

public interface ProductRespository extends CrudRepository<Producte, Integer> {
}
