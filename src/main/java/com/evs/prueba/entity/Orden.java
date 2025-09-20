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
@Table(name="ordenes")
public class Orden implements Serializable {
    @Serial
    private static final long serialVersionUID = -2896531207307736057L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id", nullable = false)
    private Integer ordenId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "sucursal_id",nullable = false)
    private Sucursal sucursalId;

    @Column(nullable = false)
    private Date fecha;

    @Column(name = "total",nullable = false)
    private Float total;


}
