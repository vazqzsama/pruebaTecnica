package com.evs.prueba.repository;

import com.evs.prueba.entity.Producto;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends CrudRepository<Producto, Integer> {

    @Query(value= "Select * From Productos p where orden_id = ?1", nativeQuery = true)
    List<Producto> findByOrderId(Integer id);

    /* Fuera de tiempo*/
    @Query(value= "Select * From Productos p where orden_id = ?1 and codigo = ?2", nativeQuery = true)
    List<Producto> findByOrderIdAndCodigo(Integer ordenId, String codigo);
    /* Fuera de tiempo*/
}
