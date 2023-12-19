package com.project.services.controller;

import com.project.services.model.Venta;
import com.project.services.model.dto.ProductosDeVenta;
import com.project.services.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ivs;


    @PostMapping("/crear")
    public String crearVenta(@RequestBody Venta venta){
        ivs.crearVenta(venta);
        return "Venta creada exitosamente";
    }
    @GetMapping("/obtenerLista")
    public List<Venta> obtenerLista(){
        return ivs.obtenerLista();
    }
    @GetMapping("/obtenerVenta/{id_venta}")
    public Venta obtenerVenta(@PathVariable Long id_venta){
        return ivs.obtenerVentaPorId(id_venta);
    }
    @DeleteMapping("/eliminarVenta/{id_venta}")
    public String eliminarVenta(@PathVariable Long id_venta){
        ivs.eliminarVenta(id_venta);
        return "Venta eliminada exitosamente";
    }
    @PutMapping("/editarVenta/{id_venta}")
    public Venta editarVenta(@PathVariable Long id_venta, @RequestBody Venta venta){
        Venta v = ivs.obtenerVentaPorId(id_venta);
        v.setFechaVenta(venta.getFechaVenta());
        v.setTotal(venta.getTotal());
        v.setListaProductos(venta.getListaProductos());
        v.setCliente(venta.getCliente());
        ivs.editarVenta(v);
        return v;
    }
    @GetMapping("/obtenerProductos/{id_venta}")
    public List<ProductosDeVenta> obtenerProductos(@PathVariable Long id_venta){
        return ivs.obtenerProductosPorIdVenta(id_venta);

    }



}
