package com.produit.produitservice.service;

import com.produit.produitservice.exceptions.ProduitNotFoundException;
import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepository produitRepository;


    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getProduitById(long id)
    {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty())
        {
            throw new ProduitNotFoundException("Desole produit inexistant");
        }
        return optionalProduit.get();
    }

    public String deleteProduitById(long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty())
        {
            throw new RuntimeException("Produit not found");
        }
        produitRepository.deleteById(id);
        return "Deleted produit with id: " + id;
    }

    public Produit updateProduitById(long id, Produit produit)
    {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty()) {
            throw new RuntimeException("Produit not found");
        }

        Produit produitAModifier = optionalProduit.get();
        produitAModifier.setName(produit.getName());
        produitAModifier.setPrice(produit.getPrice());

        return produitRepository.save(produitAModifier);

    }
}
