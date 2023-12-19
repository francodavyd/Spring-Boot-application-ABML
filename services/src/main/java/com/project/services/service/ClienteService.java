package com.project.services.service;

import com.project.services.model.Cliente;
import com.project.services.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private IClienteRepository clienteRp;

    @Override
    public void crearCliente(Cliente cliente) {
        clienteRp.save(cliente);
    }

    @Override
    public List<Cliente> obtenerLista() {
        return clienteRp.findAll();
    }

    @Override
    public Cliente obtenerClientePorId(Long id_cliente) {
        return clienteRp.findById(id_cliente).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id_cliente) {
     clienteRp.deleteById(id_cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) {
    clienteRp.save(cliente);
    }
}
