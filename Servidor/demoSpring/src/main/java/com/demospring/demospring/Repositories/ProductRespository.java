package com.demospring.demospring.Repositories;

import com.demospring.demospring.Entities.Producte;
import org.springframework.data.repository.CrudRepository;

public interface ProductRespository extends CrudRepository<Producte, Integer> {
}
