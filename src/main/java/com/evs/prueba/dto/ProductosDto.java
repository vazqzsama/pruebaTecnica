package com.evs.prueba.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductosDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5624042824630713049L;

    @Size(max = 20)
    private String codigo;
    @Size(max = 200)
    private String descripcion;
    private Float precio;

}
