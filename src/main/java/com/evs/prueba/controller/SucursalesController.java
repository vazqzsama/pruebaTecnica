package com.evs.prueba.controller;

import com.evs.prueba.dto.OrdenCreadaDto;
import com.evs.prueba.dto.OrdenDto;
import com.evs.prueba.entity.Sucursal;
import com.evs.prueba.repository.SucursalesRepository;
import com.evs.prueba.service.SucursalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursales")
public class SucursalesController {

    @Autowired
    private SucursalesService sucursalesService;

    @GetMapping
    public ResponseEntity<Sucursal> buscarSucursal(@RequestParam(name = "id") Integer id) {
        return new ResponseEntity<Sucursal>(sucursalesService.buscarSucursal(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Sucursal> guardarSucursales(@RequestBody Sucursal request) {
        return new ResponseEntity<Sucursal>(sucursalesService.guardarSucursal(request), HttpStatus.OK);
    }

}
