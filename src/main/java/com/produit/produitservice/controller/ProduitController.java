package com.produit.produitservice.controller;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

//    @GetMapping("/hello")
//    public String sayHello(){
//        return  "Hello";
//    }

    @GetMapping("/all")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit){

        return produitService.createProduit(produit);
    }
    @GetMapping("{id}")
    public Produit getProduitById(@PathVariable long id)
    {
        return produitService.getProduitById(id);
    }
    
    @DeleteMapping("{id}")
    public String deleteProduitById(@PathVariable("id") long id){
        return produitService.deleteProduitById(id);
    }

    @PutMapping("{id}")
    public Produit updateProduitById(@PathVariable("id") long id, @RequestBody Produit produit){
        return produitService.updateProduitById(id, produit);
    }
}
