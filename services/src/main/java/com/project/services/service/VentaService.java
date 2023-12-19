package com.project.services.service;

import com.project.services.model.Producto;
import com.project.services.model.Venta;
import com.project.services.model.dto.ProductosDeVenta;
import com.project.services.repository.IVentaRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{
@Autowired
    private IVentaRepository ventaRp;
@Autowired
private IProductoService ips;
    @Override
    public void crearVenta(Venta venta) {
        ventaRp.save(venta);
        this.actualizarVenta(venta);

    }
    public String actualizarVenta(@NotNull Venta venta) {
        List<Producto> lista = venta.getListaProductos();
        Double total= 0.0;

        for(Producto p: lista){
            Producto prodBuscado = ips.obtenerProductoPorId(p.getIdProducto());
            if (prodBuscado.getCantidadDisponible()==0){
                return "ERROR";
            } else {
                prodBuscado.setCantidadDisponible(prodBuscado.getCantidadDisponible()-1);
                ips.editarProducto(prodBuscado);
                total+= prodBuscado.getPrecio();
            }
        }
        venta.setTotal(total);
        this.editarVenta(venta);
        return "exito";
    }


    @Override
    public List<Venta> obtenerLista() {
        return ventaRp.findAll();
    }

    @Override
    public Venta obtenerVentaPorId(Long id_venta) {
        return ventaRp.findById(id_venta).orElse(null);
    }

    @Override
    public void eliminarVenta(Long id_venta) {
    ventaRp.deleteById(id_venta);
    }

    @Override
    public void editarVenta(Venta venta) {
    ventaRp.save(venta);
    }

    @Override
    public List<ProductosDeVenta> obtenerProductosPorIdVenta(Long id_venta) {
        Venta v = this.obtenerVentaPorId(id_venta);
        List<Producto> productosDeVenta = v.getListaProductos();
        List<ProductosDeVenta> resultado = new ArrayList<>();
        ProductosDeVenta prods;
        for (Producto p : productosDeVenta){
            prods = new ProductosDeVenta();
            prods.setIdVenta(v.getIdVenta());
            prods.setNombreProducto(p.getNombre());
            prods.setPrecio(p.getPrecio());
            prods.setCantidadDisponible(p.getCantidadDisponible());
            resultado.add(prods);
        }
        return resultado;

    }


}
