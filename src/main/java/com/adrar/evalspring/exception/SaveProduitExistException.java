package com.adrar.evalspring.exception;

import com.adrar.evalspring.model.Produit;

public class SaveProduitExistException extends RuntimeException {
    public SaveProduitExistException(Produit produit) {

        super("Le produit : " + produit.getNom() + " existe déjà en base de données");
    }
}
