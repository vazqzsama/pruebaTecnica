package com.evs.prueba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = 794679175666767876L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @ManyToOne
    @JoinColumn(name = "orden_id",nullable = false)
    private Orden ordenId;

    @Column(nullable = false,length = 20)
    private String codigo;

    @Column(nullable = false,length = 200)
    private String descripcion;

    @Column(name = "precio",nullable = false)
    private Float precio;

}
