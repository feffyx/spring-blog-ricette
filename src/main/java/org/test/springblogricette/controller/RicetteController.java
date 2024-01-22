package org.test.springblogricette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.test.springblogricette.model.Ricetta;
import org.test.springblogricette.model.Ricetta;
import org.test.springblogricette.repository.RicettaRepository;
import org.test.springblogricette.repository.RicettaRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/ricette")
public class RicetteController {

    private final RicettaRepository ricettaRepository;

    @Autowired
    public RicetteController(RicettaRepository ricettaRepository) {
        this.ricettaRepository = ricettaRepository;
    }
    // RICETTE
    @GetMapping
    public <List> String listaRicette(Model model) {
        java.util.List<Ricetta> ricette = ricettaRepository.findAll();
        model.addAttribute("ricette", ricette);
        return "admin/listaRicette";
    }

    // AGGIUNGERE RICETTA
    @GetMapping("/nuova")
    public String formNuovaRicetta(Model model) {
        model.addAttribute("ricetta", new Ricetta());
        return "admin/nuovaRicetta";
    }

    // SALVA RICETTA
    @PostMapping("/nuova")
    public String salvaNuovaRicetta(@ModelAttribute Ricetta ricetta) {
        ricettaRepository.save(ricetta);
        return "redirect:/admin/ricette";
    }
}
