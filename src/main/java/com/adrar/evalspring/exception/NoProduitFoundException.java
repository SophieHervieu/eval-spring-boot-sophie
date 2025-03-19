package com.adrar.evalspring.exception;

public class NoProduitFoundException extends RuntimeException {
    public NoProduitFoundException() {

        super("Aucun produit trouvé dans la base de données");
    }
}
