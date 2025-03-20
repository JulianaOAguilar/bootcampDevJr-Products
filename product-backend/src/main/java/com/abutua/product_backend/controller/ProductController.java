package com.abutua.product_backend.controller;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

//aqui são os imports, que são usados quando você faz uma anotação (os @'s)
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abutua.product_backend.models.Product;

@RestController
@CrossOrigin
public class ProductController {

    // cria a lista que os produtos vão ser alocados, e ja joga os produtos direto na lista
    private List<Product> products = new ArrayList<>();


    @PostMapping("products") //salvar os produtos 
    public ResponseEntity<Product> save(@RequestBody Product product){
        product.setId(products.size()+1);
        products.add(product);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(product.getId())
        .toUri(); //construindo uma URI para cada product, junto com o ID


        return ResponseEntity.created(location).body(product);
    }

    // chama cada produto atravez de seu ID
    @GetMapping("products/{id}") // responseEnstity trata a resposta
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product prod = products.stream() //metodos para filtrar lista
                                .filter(p -> p.getId() == id) //filtrar lista pelo id
                                .findFirst() //se existir, a lista vai guardar o produto
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")); //lança a exceção

        return ResponseEntity.ok(prod); //se não lançar a exceção, ele devolve o produto

    }

    // esse comando vai retornar todos os produtos quando chamado
    @GetMapping("products")
    public List<Product> getProducts() {
        return products;
    }
}
