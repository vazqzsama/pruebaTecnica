package com.evs.prueba.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrdenDto  {

    @NonNull
    private Integer sucursal;
    @NonNull
    private Float total;
    @NotEmpty
    private List<ProductosDto> productos;

    public OrdenDto() {
        this.productos = new ArrayList<>();
    }
}
