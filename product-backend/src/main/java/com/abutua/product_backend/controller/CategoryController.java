package com.abutua.product_backend.controller;
import com.abutua.product_backend.models.Category;


import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



@RestController
@CrossOrigin
public class CategoryController {
    
        private List<Category> categories = Arrays.asList(new Category(1, "Produção própria"),
                                                        new Category(2, "Nacional"),
                                                        new Category(3, "Importado"),
                                                        new Category(4, "Premium"));


    @GetMapping("categories/{id}") // responseEnstity trata a resposta
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        Category cat = categories.stream() //metodos para filtrar lista
                                .filter(p -> p.getId() == id) //filtrar lista pelo id
                                .findFirst() //se existir, a lista vai guardar o produto
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found")); //lança a exceção

        return ResponseEntity.ok(cat); //se não lançar a exceção, ele devolve o produto

    }

    // esse comando vai retornar todos os produtos quando chamado
    @GetMapping("categories")
    public List<Category> getCategories() {
        return categories;
    }
}                                              


