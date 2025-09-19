package com.evs.prueba.service;

import com.evs.prueba.dto.ActualizarPrecioDto;

public interface ProductoService {

    void actualizarPrecio(ActualizarPrecioDto request) throws Exception;

}
