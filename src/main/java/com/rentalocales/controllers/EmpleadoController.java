package com.rentalocales.controllers;

import com.rentalocales.models.Cliente;
import com.rentalocales.models.Empleado;
import com.rentalocales.models.Horario;
import com.rentalocales.models.Local;
import com.rentalocales.services.ClienteService;
import com.rentalocales.services.EmpleadoService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;
import java.util.List;

@Controller
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping({"empleados"})
    public String listEmpleados(Model model){


        model.addAttribute("empleados", empleadoService.listEmpleados());

        return "empleados";
    }

    @GetMapping("empleados/newsss")
    public String createEmpelado(Model model){

        Empleado e1= new Empleado();

        model.addAttribute("empleado", e1);


        return "create_empleado";
    }

    @PostMapping("empleados")
    public String saveEmpleado(@ModelAttribute("empleado") Empleado empleado){

        empleadoService.saveEmpleado(empleado);
        return "redirect:empleados";
    }

    @GetMapping("/empleados/edittt/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id));
        return "edit_empleado";
    }

    @PostMapping("/empleados/{id}")
    public String updateClienteInfo(@PathVariable Integer id, @ModelAttribute("empleado") Empleado empleado, Model model){

        Empleado existingEmpleado= empleadoService.getEmpleadoById(id);
        existingEmpleado.setId(id);
        existingEmpleado.setEmployeeName(empleado.getEmployeeName());
        existingEmpleado.setEmployeeLastName(empleado.getEmployeeLastName());
        existingEmpleado.setEmployeeEmail(empleado.getEmployeeEmail());
        existingEmpleado.setEmployeePosition(empleado.getEmployeePosition());

        empleadoService.updateEmpleado(existingEmpleado);

        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}")

    public String deleteEmpleado(@PathVariable Integer id){

        try{
            empleadoService.deleteEmpleado(id);}
        catch(ConstraintViolationException e ){
            JOptionPane.showMessageDialog(null,"No se puede borrar esta elemento porque depende de otra tabla", "Error",JOptionPane.ERROR_MESSAGE);

        }
        return "redirect:/empleados";
    }

}
