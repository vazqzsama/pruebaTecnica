package com.evs.prueba.service;

import com.evs.prueba.dto.OrdenCreadaDto;
import com.evs.prueba.dto.OrdenDto;
import com.evs.prueba.entity.Orden;
import com.evs.prueba.repository.OrdenRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;


    @Override
    public OrdenCreadaDto guardarOrden(OrdenDto request) {
        Orden orden = new Orden();
        BeanUtils.copyProperties(request, orden);
        orden.setFecha(new Date());
        orden = ordenRepository.save(orden);
        return OrdenCreadaDto.builder().ordenId(orden.getOrdenId()).fecha(orden.getFecha()).build();
    }

    @Override
    public OrdenDto obtenerOrden(Integer id) throws Exception {
        Optional<Orden> orden = ordenRepository.findById(id);
        if(orden.isPresent()) {
            OrdenDto ordenResp = new OrdenDto();
            BeanUtils.copyProperties(orden.get(), ordenResp);
            return ordenResp;
        }  else {
            throw new NoResultException();
        }
    }
}
