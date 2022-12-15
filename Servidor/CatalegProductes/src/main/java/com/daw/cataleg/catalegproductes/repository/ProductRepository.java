package com.daw.cataleg.catalegproductes.repository;

import com.daw.cataleg.catalegproductes.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
