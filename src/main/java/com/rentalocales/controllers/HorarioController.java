package com.rentalocales.controllers;

import com.rentalocales.models.Horario;
import com.rentalocales.models.Local;
import com.rentalocales.repositories.HorarioRepository;
import com.rentalocales.repositories.LocalRepository;
import com.rentalocales.services.HorarioService;
import com.rentalocales.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HorarioController {

    @Autowired
    LocalService localService;
    @Autowired
    HorarioService horarioService;
    @Autowired
    LocalRepository localRepository;

    @GetMapping({"horarios"})
    public String listHorarios(Model model){


        model.addAttribute("horarios", horarioService.listHorarios());

        return "horarios";
    }

    @GetMapping("horarios/news")
    public String createHorario(Model model){

        Horario h1= new Horario();
        List<Local> localesList=localRepository.findAll();
        model.addAttribute("horario", h1);
        model.addAttribute("localesList", localesList );

        return "create_horario";
    }

    @PostMapping("horarios")
    public String saveLocal(@ModelAttribute("horario") Horario horario){


        horarioService.saveHorario(horario);
        return "redirect:horarios";
    }

    @GetMapping("/horarios/editar/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("horario", horarioService.getHorarioById(id));
        return "edit_horario";
    }

    @PostMapping("/horarios/{id}")
    public String updateLocal(@PathVariable Integer id, @ModelAttribute("horario") Horario horario, Model model){
        List<Local> localesList=localRepository.findAll();
        Horario existingHorario= horarioService.getHorarioById(id);
        existingHorario.setId(id);
        existingHorario.setOpeningTime(horario.getOpeningTime());
        existingHorario.setClosingTime(horario.getClosingTime());
        existingHorario.setGivenDate(horario.getGivenDate());
        existingHorario.setReturnDate(horario.getReturnDate());
        model.addAttribute("localesList", localesList );

        horarioService.updateHorario(existingHorario);

        return "redirect:/horarios";
    }

    @GetMapping("/horarios/{id}")
    public String deleteHorario(@PathVariable Integer id){
        horarioService.deleteHorario(id);
        return "redirect:/horarios";
    }



}
