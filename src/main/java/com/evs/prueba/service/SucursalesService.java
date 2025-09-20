package com.evs.prueba.service;

import com.evs.prueba.entity.Sucursal;

public interface SucursalesService {

    Sucursal guardarSucursal(Sucursal request);
    Sucursal buscarSucursal(Integer id);

}
