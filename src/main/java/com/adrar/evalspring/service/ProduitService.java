package com.adrar.evalspring.service;

import com.adrar.evalspring.exception.NoProduitFoundException;
import com.adrar.evalspring.exception.ProduitNotFoundException;
import com.adrar.evalspring.exception.SaveProduitExistException;
import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Iterable<Produit> findAllProduits() {
        if (produitRepository.count() == 0) {
            throw new NoProduitFoundException();
        }
        return produitRepository.findAll();
    }

    public Produit findProduitById(Integer id) {
        if(!produitRepository.existsById(id)) {
            throw new ProduitNotFoundException(id);
        }
        return produitRepository.findById(id).get();
    }

    public Produit saveProduit(Produit produit) {
        if(produitRepository.findByNomAndPrix(produit.getNom(), produit.getPrix()).isPresent()) {
            throw new SaveProduitExistException(produit);
        }
        return produitRepository.save(produit);
    }
}
