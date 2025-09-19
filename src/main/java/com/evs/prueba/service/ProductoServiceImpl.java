package com.evs.prueba.service;

import com.evs.prueba.dto.ActualizarPrecioDto;
import com.evs.prueba.entity.Producto;
import com.evs.prueba.repository.ProductosRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public void actualizarPrecio(ActualizarPrecioDto request) throws Exception {
        Optional<Producto> producto = productosRepository.findById(request.getProductoId());
        if (!producto.isPresent()) {
            throw new NoResultException();
        }

    }
}
