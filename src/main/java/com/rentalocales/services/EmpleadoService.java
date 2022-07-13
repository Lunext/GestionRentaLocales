package com.rentalocales.services;

import com.rentalocales.models.Cliente;
import com.rentalocales.models.Empleado;

import java.util.List;

public interface EmpleadoService {

    public List<Empleado> listEmpleados();
    public Empleado saveEmpleado(Empleado empleado );
    public Empleado getEmpleadoById(Integer id);
    public Empleado updateEmpleado(Empleado empleado);
    public void deleteEmpleado(Integer id);
}
