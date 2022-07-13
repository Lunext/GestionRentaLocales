package com.rentalocales.controllers;

import com.rentalocales.models.Cliente;
import com.rentalocales.models.Horario;
import com.rentalocales.models.Local;
import com.rentalocales.models.TipoEvento;
import com.rentalocales.services.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TipoEventoController {
    @Autowired
    TipoEventoService tipoEventoService;

    @GetMapping({"tiposeventos"})
    public String listTiposEventos(Model model){


        model.addAttribute("tiposeventos", tipoEventoService.listTiposEventos());

        return "tiposeventos";
    }

    @GetMapping("tiposeventos/newsss")
    public String createTipoEvento(Model model){

        TipoEvento te1= new TipoEvento();

        model.addAttribute("tipoEvento", te1);


        return "create_tipoEvento";
    }

    @PostMapping("tiposeventos")
    public String saveTipoEvento(@ModelAttribute("tipoEvento") TipoEvento tipoEvento){


        tipoEventoService.saveTipoEvento(tipoEvento);
        return "redirect:tiposeventos";
    }

    @GetMapping("/tiposeventos/edittt/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("tipoEvento", tipoEventoService.getTipoEventoById(id));
        return "edit_tipoEvento";
    }

    @PostMapping("/tiposeventos/{id}")
    public String updateTipoEventoInfo(@PathVariable Integer id, @ModelAttribute("tipoEvento") TipoEvento tipoEvento, Model model){


        TipoEvento existingTipoEvento= tipoEventoService.getTipoEventoById(id);
        existingTipoEvento.setId(id);
        existingTipoEvento.setEventType(tipoEvento.getEventType());


        tipoEventoService.updateTipoEvento(existingTipoEvento);

        return "redirect:/tiposeventos";
    }

    @GetMapping("/tiposeventos/{id}")
    public String deleteTipoEvento(@PathVariable Integer id){
        tipoEventoService.deleteTipoEvento(id);
        return "redirect:/tiposeventos";
    }
}
