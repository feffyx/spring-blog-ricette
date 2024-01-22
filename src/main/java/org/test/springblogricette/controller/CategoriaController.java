package org.test.springblogricette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.test.springblogricette.model.Categoria;
import org.test.springblogricette.repository.CategoriaRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/categorie")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    // CATEGORIE
    @GetMapping
    public String listaCategorie(Model model) {
        List<Categoria> categorie = categoriaRepository.findAll();
        model.addAttribute("categorie", categorie);
                return "admin/listaCategorie";
    }

    // AGGIUNGI CATEGORIA
    @GetMapping("/nuova")
    public String formNuovaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "admin/nuovaCategoria";
    }

    //SALVA CATEGORIA
    @PostMapping("/nuova")
    public String salvaNuovaCategoria(@ModelAttribute Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/admin/categorie";
    }
    // MODIFICA CATEGORIA
    @GetMapping("/modifica/{id}")
    public String formModificaCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = null;
        try {
            categoria = categoriaRepository.findById(Math.toIntExact(id))
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("categoria", categoria);
        return "admin/modificaCategoria";
    }

    // SALVA CATEGORIA MODIFICATA
    @PostMapping("/modifica/{id}")
    public String salvaModificheCategoria(@PathVariable Long id, @ModelAttribute Categoria categoria) {
        categoria.setId(id);
        categoriaRepository.save(categoria);
        return "redirect:/admin/categorie";
    }

    // ELIMINA CATEGORIA
    @GetMapping("/elimina/{id}")
    public String eliminaCategoria(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
        return "redirect:/admin/categorie";
    }
}
