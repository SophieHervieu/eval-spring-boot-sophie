package com.adrar.evalspring.exception;

import com.adrar.evalspring.model.Categorie;

public class SaveCategorieExistException extends RuntimeException {
    public SaveCategorieExistException(Categorie categorie) {

        super("La catégorie" + categorie.getLibelle() + "existe déjà en base de données");
    }
}
