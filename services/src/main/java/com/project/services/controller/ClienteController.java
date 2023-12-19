package com.project.services.controller;

import com.project.services.model.Cliente;
import com.project.services.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private IClienteService ics;
    @PostMapping("/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        ics.crearCliente(cliente);
        return "Cliente creado exitosamente";
    }
    @GetMapping("/obtenerLista")
    public List<Cliente> obtenerLista(){
        return ics.obtenerLista();
    }
    @GetMapping("/obtenerCliente/{id_cliente}")
    public Cliente obtenerCliente(@PathVariable Long id_cliente){
        return ics.obtenerClientePorId(id_cliente);
    }
    @DeleteMapping("/eliminarCliente/{id_cliente}")
    public String eliminarCliente(@PathVariable Long id_cliente){
        ics.eliminarCliente(id_cliente);
        return "Cliente eliminado correctamente";
    }
    @PutMapping("/editarCliente/{id_cliente}")
    public Cliente editarCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente){
        Cliente c = ics.obtenerClientePorId(id_cliente);
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        c.setDni(cliente.getDni());
        ics.crearCliente(c);
        return c;
    }
}
