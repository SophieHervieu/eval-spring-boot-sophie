package com.adrar.evalspring.controller;

import com.adrar.evalspring.exception.NoProduitFoundException;
import com.adrar.evalspring.exception.ProduitNotFoundException;
import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/produits")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Produit> getAllProduits() {
        if(produitService.countProduits() == 0) {
            throw new NoProduitFoundException();
        }
        return produitService.findAllProduits();
    }

    @GetMapping("/produit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produit getProduitById(@PathVariable Integer id) {
        return produitService.findProduitById(id);
    }

    @PostMapping("/produit")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit createProduit(@Valid @RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }
}
