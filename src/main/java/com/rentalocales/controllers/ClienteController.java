package com.rentalocales.controllers;

import com.rentalocales.models.Cliente;
import com.rentalocales.models.Horario;
import com.rentalocales.models.Local;
import com.rentalocales.repositories.HorarioRepository;
import com.rentalocales.repositories.LocalRepository;
import com.rentalocales.services.ClienteService;
import com.rentalocales.services.HorarioService;
import com.rentalocales.services.LocalService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Controller
public class ClienteController {
    @Autowired
    LocalService localService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    HorarioService horarioService;
    @Autowired
    LocalRepository localRepository;
    @Autowired
    HorarioRepository horarioRepository;

    @GetMapping({"clientes"})
    public String listClientes(Model model){


        model.addAttribute("clientes", clienteService.listClientes());

        return "clientes";
    }

    @GetMapping("clientes/newss")
    public String createCliente(Model model){

        Cliente c1= new Cliente();
        List<Local> localesList=localRepository.findAll();
        List<Horario> horariosList=horarioRepository.findAll();
        model.addAttribute("cliente", c1);
        model.addAttribute("localesList", localesList );
        model.addAttribute("horariosList", horariosList);

        return "create_cliente";
    }

    @PostMapping("clientes")
    public String saveLocal(@ModelAttribute("cliente") @Valid Cliente cliente, Errors error, Model model){


        if (error.hasErrors()){

        }





       /* if(c1.getClientEmail().equals(cliente.getClientEmail())){
            redirAttrs.addFlashAttribute("error", "El email ya existe.");



        }*/



        clienteService.saveCliente(cliente);
        //redirAttrs.addFlashAttribute("success", "Cliente agregado exitosamente .");
        return "redirect:clientes";
    }

    @GetMapping("/clientes/editt/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        List<Local> localesList=localRepository.findAll();
        List<Horario> horarioList =horarioRepository.findAll();
        model.addAttribute("localesList",localesList);
        model.addAttribute("horarioList", horarioList);
        model.addAttribute("cliente", clienteService.getClienteById(id));
        return "edit_cliente";
    }

    @PostMapping("/clientes/{id}")
    public String updateClienteInfo(@PathVariable Integer id, @ModelAttribute("cliente") Cliente cliente, Model model){
        List<Local> localesList=localRepository.findAll();
        List<Horario> horarioList=horarioRepository.findAll();
        Cliente existingCliente= clienteService.getClienteById(id);
        existingCliente.setId(id);
        existingCliente.setClientName(cliente.getClientName());
        existingCliente.setClientLastName(cliente.getClientLastName());
        existingCliente.setClientEmail(cliente.getClientEmail());
        existingCliente.setLocal(cliente.getLocal());
        existingCliente.setHorario(cliente.getHorario());
        model.addAttribute("localesList", localesList );
        model.addAttribute("horariosList",horarioList);

        clienteService.updateCliente(existingCliente);

        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}")

    public String deleteCliente(@PathVariable Integer id){

        try{
        clienteService.deleteCliente(id);}
        catch(ConstraintViolationException e ){
            JOptionPane.showMessageDialog(null,"No se puede borrar esta elemento porque depende de otra tabla", "Error",JOptionPane.ERROR_MESSAGE);

        }
        return "redirect:/clientes";
    }

}

