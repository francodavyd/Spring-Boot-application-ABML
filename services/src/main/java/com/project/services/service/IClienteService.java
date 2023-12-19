package com.project.services.service;

import com.project.services.model.Cliente;

import java.util.List;

public interface IClienteService {
    public void crearCliente(Cliente cliente);
    public List<Cliente> obtenerLista();
    public Cliente obtenerClientePorId(Long id_cliente);
    public void eliminarCliente(Long id_cliente);
    public void editarCliente(Cliente cliente);

}
