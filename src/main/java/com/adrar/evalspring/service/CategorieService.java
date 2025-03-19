package com.adrar.evalspring.service;

import com.adrar.evalspring.exception.CategorieNotFoundException;
import com.adrar.evalspring.exception.NoCategorieFoundException;
import com.adrar.evalspring.exception.SaveCategorieExistException;
import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> findAllCategories() {
        if(categorieRepository.count() == 0) {
            throw new NoCategorieFoundException();
        }
        List<Categorie> categories = new ArrayList<>();
        for(Categorie categorie : categorieRepository.findAll()) {
            categories.add(categorie);
        }
        return categories;
    }

    public Long countAllCategories() {
        return categorieRepository.count();
    }

    public Categorie findCategorieById(Integer id) {
        if(!categorieRepository.existsById(id)) {
            throw new CategorieNotFoundException(id);
        }
        return categorieRepository.findById(id).get();
    }

    public Categorie saveCategorie(Categorie categorie) {
        if(categorieRepository.findByLibelle(categorie.getLibelle()).isPresent()) {
            throw new SaveCategorieExistException(categorie);
        }
        return categorieRepository.save(categorie);
    }
}
