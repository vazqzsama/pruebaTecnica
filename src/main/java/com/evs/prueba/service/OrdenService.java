package com.evs.prueba.service;

import com.evs.prueba.dto.OrdenCreadaDto;
import com.evs.prueba.dto.OrdenDto;

public interface OrdenService {

    OrdenCreadaDto guardarOrden(OrdenDto request);

    OrdenDto obtenerOrden(Integer id) throws Exception;
}
