package com.morylex.customers_persons.service;

import com.morylex.customers_persons.entities.Cliente;
import com.morylex.customers_persons.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;
    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente clienteEncontrado = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + id));
        clienteEncontrado.setContrasena(cliente.getContrasena());
        clienteEncontrado.setEstado(cliente.isEstado());
        clienteEncontrado.setNombre(cliente.getNombre());
        clienteEncontrado.setGenero(cliente.getGenero());
        clienteEncontrado.setEdad(cliente.getEdad());
        clienteEncontrado.setIdentificacion(cliente.getIdentificacion());
        clienteEncontrado.setDireccion(cliente.getDireccion());
        clienteEncontrado.setTelefono(cliente.getTelefono());
        return clienteRepository.save(clienteEncontrado);
    }

    @Override
    public void deleteCliente(Long id) {
        Cliente clienteEncontrado = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + id));
        clienteRepository.delete(clienteEncontrado);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + id));
    }
}
