package com.project.services.service;

import com.project.services.model.Producto;
import com.project.services.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository productoRp;
    @Override
    public void crearProducto(Producto prod) {
     productoRp.save(prod);
    }

    @Override
    public List<Producto> obtenerLista() {
        return productoRp.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Long id_producto) {
        return productoRp.findById(id_producto).orElse(null);
    }

    @Override
    public void eliminarProducto(Long id_producto) {
      productoRp.deleteById(id_producto);
    }

    @Override
    public void editarProducto(Producto prod) {
     productoRp.save(prod);
    }


}
