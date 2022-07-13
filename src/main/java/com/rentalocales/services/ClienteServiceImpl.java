package com.rentalocales.services;

import com.rentalocales.models.Cliente;
import com.rentalocales.models.Horario;
import com.rentalocales.repositories.ClienteRepository;
import com.rentalocales.repositories.HorarioRepository;
import com.rentalocales.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;
@Service
public class ClienteServiceImpl implements  ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    LocalRepository localRepository;
    @Autowired
    HorarioRepository horarioRepository;
    @Override
    public List<Cliente> listClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteById(Integer id) {
        return  clienteRepository.findById(id).get();
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Integer id) {

        clienteRepository.deleteById(id);

    }
}
