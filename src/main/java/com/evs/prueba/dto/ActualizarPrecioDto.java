package com.evs.prueba.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ActualizarPrecioDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -7790474928353550644L;

    /* Fuera de tiempo*/
    @NotNull
    private Integer ordenId;
    @NotNull
    private String codigo;
    /* Fuera de tiempo*/
    @NotNull
    private Float precio;

}
