package com.as.Economia.controllers;

import com.as.Economia.entities.Plano;
import com.as.Economia.entities.Renda;
import com.as.Economia.repositories.PlanoRepository;
import com.as.Economia.repositories.RendaRepository;
import com.as.Economia.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;

@Controller
@RequestMapping(value = "/")
public class PlanoController {

    @Autowired
    private PlanoService planoService;
    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private RendaRepository rendaRepository;

    @GetMapping
    public String getRenda(Renda renda, Model model, Model model1) {
        model.addAttribute("planos", this.planoService.showPlano());
        model1.addAttribute("rendas", this.rendaRepository.findAll());
        return "index";
    }

    @PostMapping
    public String postRenda(@Valid Renda renda, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        renda.setData(LocalDate.now(ZoneId.systemDefault()));
        planoService.salvar(renda);
        return "redirect:/";
    }

//    @PostMapping
//    public String showPlano(@ModelAttribute Plano plano, Model model){
//        model.addAttribute("plano", this.planoService.showPlano());
//        return "index";
//    }
}
