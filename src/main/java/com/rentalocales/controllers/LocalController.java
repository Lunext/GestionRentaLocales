package com.rentalocales.controllers;


import com.rentalocales.models.Local;
import com.rentalocales.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static javax.swing.JOptionPane.showMessageDialog;

@Controller
public class LocalController {


    @Autowired
    private LocalService service;




    @GetMapping({"locales", "/"})
    public String listLocales(Model model, @Param("keyWord") String keyWord){




        model.addAttribute("locales", service.listLocals(keyWord));
        model.addAttribute("keyWord", keyWord);
        return "locales";
    }

    @GetMapping("locales/news")
    public String createLocal(Model model){

        Local l1= new Local();
        model.addAttribute("local", l1);

        return "create_local";
    }

    @PostMapping("locales")
    public String saveLocal(@ModelAttribute("local") Local local, RedirectAttributes red){

        service.saveLocal(local);

        return "redirect:locales";
    }

    @GetMapping("/locales/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("local", service.getLocalById(id));
        return "edit_local";
    }

    @PostMapping("/locales/{id}")
    public String updateLocal(@PathVariable Integer id, @ModelAttribute("local") Local local, Model model){
        Local existingLocal= service.getLocalById(id);
        existingLocal.setId(id);
        existingLocal.setLocalName(local.getLocalName());



        existingLocal.setCost(local.getCost());
        existingLocal.setCity(local.getCity());
        existingLocal.setStreet(local.getStreet());

        service.updateLocal(existingLocal);

        return "redirect:/locales";
    }

    @GetMapping("/locales/{id}")
    public String deleteLocal(@PathVariable Integer id){
        service.deleteLocal(id);
        return "redirect:/locales";
    }










}
