package com.evs.prueba.service;

import com.evs.prueba.dto.SucursalDto;
import com.evs.prueba.entity.Sucursal;
import com.evs.prueba.repository.SucursalesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalesServiceImpl implements SucursalesService {
    @Autowired
    private SucursalesRepository sucursalesRepository;

    public Integer guardar(SucursalDto request){
        Sucursal sucursal = new Sucursal();
        BeanUtils.copyProperties(request,sucursal);
        sucursal = sucursalesRepository.save(sucursal);
        return sucursal.getSucursalId();
    }

}
