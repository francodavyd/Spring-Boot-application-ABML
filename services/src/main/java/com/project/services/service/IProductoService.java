package com.project.services.service;

import com.project.services.model.Producto;

import java.util.List;

public interface IProductoService {
    public void crearProducto(Producto prod);
    public List<Producto> obtenerLista();
    public Producto obtenerProductoPorId(Long id_producto);
    public void eliminarProducto(Long id_producto);
    public void editarProducto(Producto prod);

}
