package com.adrar.evalspring.exception;

public class NoCategorieFoundException extends RuntimeException {
    public NoCategorieFoundException() {

        super("Aucune catégorie trouvée dans la base de données");
    }
}
