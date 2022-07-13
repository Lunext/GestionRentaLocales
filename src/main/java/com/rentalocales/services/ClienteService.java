package com.rentalocales.services;

import com.rentalocales.models.Cliente;
import com.rentalocales.models.Horario;

import java.util.List;

public interface ClienteService {
    public List<Cliente> listClientes();
    public Cliente saveCliente(Cliente cliente);
    public Cliente getClienteById(Integer id);
    public Cliente updateCliente(Cliente cliente);
    public void deleteCliente(Integer id);

}
