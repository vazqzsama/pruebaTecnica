package com.evs.prueba.controller;

import com.evs.prueba.dto.ActualizarPrecioDto;
import com.evs.prueba.dto.OrdenCreadaDto;
import com.evs.prueba.dto.OrdenDto;
import com.evs.prueba.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PutMapping(path = "/actualizarPrecio")
    public ResponseEntity<Void> actualizarPrecio(ActualizarPrecioDto request) {
        try {
            productoService.actualizarPrecio(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
