package com.adrar.evalspring.exception;

public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException(Integer id) {

        super("Le produit avec l'id : " + id + "n'existe pas");
    }
}
