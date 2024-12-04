package com.produit.produitservice.exceptions;

public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException(String message) {
        super(message);
    }
}
