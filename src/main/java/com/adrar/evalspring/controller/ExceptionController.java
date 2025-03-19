package com.adrar.evalspring.controller;

import com.adrar.evalspring.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ProduitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> ProduitNotFound(ProduitNotFoundException ProduitNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", ProduitNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(NoProduitFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> NoProduitFound(NoProduitFoundException NoProduitFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", NoProduitFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(SaveProduitExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, String>> SaveProduitExist(SaveProduitExistException SaveProduitExist) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", SaveProduitExist.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @ExceptionHandler(CategorieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> CategorieNotFound(CategorieNotFoundException CategorieNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", CategorieNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(NoCategorieFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> NoCategorieFound(NoCategorieFoundException NoCategorieFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", NoCategorieFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(SaveCategorieExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Map<String, String>> SaveCategorieExist(SaveCategorieExistException SaveCategorieExist) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur : ", SaveCategorieExist.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
