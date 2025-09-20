package com.evs.prueba.service;

import com.evs.prueba.entity.Sucursal;
import com.evs.prueba.repository.SucursalesRepository;
import jakarta.persistence.NoResultException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalesServiceImpl implements SucursalesService {

    @Autowired
    private SucursalesRepository sucursalesRepository;

    public Sucursal guardarSucursal(Sucursal request) {
        sucursalesRepository.save(request);
        return request;
    }

    @Override
    public Sucursal buscarSucursal(Integer id) {
        return sucursalesRepository.findById(id).orElseThrow(NoResultException::new);
    }

}
