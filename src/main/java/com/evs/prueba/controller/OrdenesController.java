package com.evs.prueba.controller;

import com.evs.prueba.config.GlobalManagerException;
import com.evs.prueba.dto.OrdenCreadaDto;
import com.evs.prueba.dto.OrdenDto;
import com.evs.prueba.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ordenes")
public class OrdenesController {

    @Autowired
    private OrdenService ordenService;

    @PostMapping
    public ResponseEntity<OrdenCreadaDto> guardarOrden(@RequestBody OrdenDto request) {
        try {
            return new ResponseEntity<OrdenCreadaDto>(ordenService.guardarOrden(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public ResponseEntity<OrdenDto> buscarOrden(@RequestParam(name = "id") Integer id) {
        return new ResponseEntity<OrdenDto>(ordenService.obtenerOrden(id), HttpStatus.OK);
    }

}
