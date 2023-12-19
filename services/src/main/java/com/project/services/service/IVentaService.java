package com.project.services.service;

import com.project.services.model.Venta;
import com.project.services.model.dto.ProductosDeVenta;

import java.util.List;

public interface IVentaService {
    public void crearVenta(Venta venta);
    public List<Venta> obtenerLista();
    public Venta obtenerVentaPorId(Long id_venta);
    public void eliminarVenta(Long id_venta);
    public void editarVenta(Venta venta);
    public List<ProductosDeVenta> obtenerProductosPorIdVenta(Long id_venta);

}
