package com.adrar.evalspring.repository;

import com.adrar.evalspring.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer> {
    Optional<Categorie> findByLibelle(String libelle);
}
