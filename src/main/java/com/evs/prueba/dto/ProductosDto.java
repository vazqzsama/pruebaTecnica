package com.evs.prueba.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductosDto {

    @Size(max = 20)
    private Integer codigo;
    @Size(max = 200)
    private String descripcion;
    private Float precio;

}
