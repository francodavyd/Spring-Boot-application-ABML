package com.project.services.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosDeVenta {
    private Long idVenta;
    private String nombreProducto;
    private int cantidadDisponible;
    private Double precio;
}
