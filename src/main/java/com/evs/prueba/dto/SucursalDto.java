package com.evs.prueba.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SucursalDto {

    @Size(max = 50)
    private String nombre;
}
