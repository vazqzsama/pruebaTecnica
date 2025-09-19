package com.evs.prueba.repository;

import com.evs.prueba.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends CrudRepository<Producto, Integer> {
}
