package com.evs.prueba.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrdenDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5565280080025776344L;

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
