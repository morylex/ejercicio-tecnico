package com.morylex.customers_persons.service;

import com.morylex.customers_persons.entities.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
    List<Cliente> getAllClientes();
    Cliente getClienteById(Long id);
}
