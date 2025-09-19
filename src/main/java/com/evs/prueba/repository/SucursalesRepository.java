package com.evs.prueba.repository;

import com.evs.prueba.entity.Sucursal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalesRepository extends CrudRepository<Sucursal, Integer> {
}
