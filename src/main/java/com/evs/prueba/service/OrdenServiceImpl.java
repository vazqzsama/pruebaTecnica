package com.evs.prueba.service;

import com.evs.prueba.dto.OrdenCreadaDto;
import com.evs.prueba.dto.OrdenDto;
import com.evs.prueba.dto.ProductosDto;
import com.evs.prueba.entity.Orden;
import com.evs.prueba.entity.Producto;
import com.evs.prueba.entity.Sucursal;
import com.evs.prueba.repository.OrdenRepository;
import com.evs.prueba.repository.ProductosRepository;
import com.evs.prueba.repository.SucursalesRepository;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;
    @Autowired
    private SucursalesRepository sucursalesRepository;
    @Autowired
    private ProductosRepository productosRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public OrdenCreadaDto guardarOrden(OrdenDto request) throws Exception {
        Optional<Sucursal> sucursal = sucursalesRepository.findById(request.getSucursal());
        if (sucursal.isEmpty()) {
            throw new BadRequestException("No existe la sucursal");
        }
        Orden orden = new Orden();
        orden.setTotal(request.getTotal());
        orden.setSucursalId(sucursal.get());
        orden.setFecha(new Date());
        orden = ordenRepository.save(orden);
        for(ProductosDto prdct : request.getProductos()){
            productosRepository.save(Producto.builder()
                    .ordenId(orden)
                    .codigo(prdct.getCodigo())
                    .descripcion(prdct.getDescripcion())
                    .precio(prdct.getPrecio()).build()
            );
        }
        return OrdenCreadaDto.builder().ordenId(orden.getOrdenId()).fecha(orden.getFecha()).build();
    }

    @Override
    public OrdenDto obtenerOrden(Integer id) {
        Optional<Orden> orden = ordenRepository.findById(id);
        if(orden.isPresent()) {
            Orden ordenExist = orden.get();
            OrdenDto ordenResp = new OrdenDto();
            ordenResp.setTotal(ordenExist.getTotal());
            ordenResp.setSucursal(ordenExist.getSucursalId().getSucursalId());
            ordenResp.setProductos(productosRepository.findByOrderId(ordenExist.getOrdenId()).stream()
                    .map(p -> ProductosDto.builder().precio(p.getPrecio()).codigo(p.getCodigo())
                            .descripcion(p.getDescripcion()).build()).collect(Collectors.toList()));
            return ordenResp;
        }  else {
            throw new NoResultException();
        }
    }
}
