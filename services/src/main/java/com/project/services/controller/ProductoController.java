package com.project.services.controller;

import com.project.services.model.Producto;
import com.project.services.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService ips;
    @PostMapping("/crear")
    public String crearProducto(@RequestBody Producto prod){
        ips.crearProducto(prod);
        return "Producto creado exitosamente";
    }
    @GetMapping("/obtenerLista")
    public List<Producto> obtenerLista(){
        return ips.obtenerLista();
    }
    @GetMapping("/obtenerProducto/{id_producto}")
    public Producto obtenerProducto(@PathVariable Long id_producto){
        return ips.obtenerProductoPorId(id_producto);
    }
    @DeleteMapping("/eliminarProducto/{id_producto}")
    public String eliminarProducto(@PathVariable Long id_producto){
        ips.eliminarProducto(id_producto);
        return "Producto eliminado exitosamente";
    }
    @PutMapping("/editarProducto/{id_producto}")
    public Producto editarProducto(@PathVariable Long id_producto, @RequestBody Producto prod){
        Producto p = ips.obtenerProductoPorId(id_producto);
        p.setNombre(prod.getNombre());
        p.setMarca(prod.getMarca());
        p.setPrecio(prod.getPrecio());
        p.setCantidadDisponible(prod.getCantidadDisponible());
        ips.crearProducto(p);
        return p;
    }
}
