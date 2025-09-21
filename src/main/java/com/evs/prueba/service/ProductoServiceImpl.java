package com.evs.prueba.service;

import com.evs.prueba.dto.ActualizarPrecioDto;
import com.evs.prueba.entity.Producto;
import com.evs.prueba.repository.ProductosRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductosRepository productosRepository;


    @Override
    public void actualizarPrecio(ActualizarPrecioDto request) throws Exception {
        /* Fuera de tiempo*/
        List<Producto> productos = productosRepository.findByOrderIdAndCodigo(request.getOrdenId(), request.getCodigo());
        productos.forEach( p -> {
            p.setPrecio(request.getPrecio());
            productosRepository.save(p);
        });
        /* Fuera de tiempo*/
    }
}
