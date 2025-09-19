package com.evs.prueba.repository;

import com.evs.prueba.entity.Orden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends CrudRepository<Orden,Integer> {
}
