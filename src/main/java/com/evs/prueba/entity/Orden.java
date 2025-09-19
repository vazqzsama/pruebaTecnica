package com.evs.prueba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Ordenes")
public class Orden implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_id", nullable = false)
    private Integer ordenId;

    @OneToMany
    @JoinColumn(name = "sucursal_id",nullable = false)
    private Sucursal sucursalId;

    @Column(nullable = false)
    private Date fecha;

    @Column(name = "total",nullable = false)
    private Integer total;

}
