package com.adrar.evalspring.controller;

import com.adrar.evalspring.exception.NoCategorieFoundException;
import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.service.CategorieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Categorie> getAllCategories() {
        if(categorieService.countAllCategories() == 0) {
            throw new NoCategorieFoundException();
        }
        return categorieService.findAllCategories();
    }

    @GetMapping("/categorie/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categorie getCategorieById(@PathVariable Integer id) {
        return categorieService.findCategorieById(id);
    }

    @PostMapping("/categorie")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorie addCategorie(@Valid @RequestBody Categorie categorie) {
        return categorieService.saveCategorie(categorie);
    }
}
