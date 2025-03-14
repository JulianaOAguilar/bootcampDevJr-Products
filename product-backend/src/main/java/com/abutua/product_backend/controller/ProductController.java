package com.abutua.product_backend.controller;


import java.util.Arrays;
import java.util.List;

//aqui são os imports, que são usados quando você faz uma anotação (os @'s)
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.abutua.product_backend.models.Product;

@RestController
public class ProductController {

    // cria a lista que os produtos vão ser alocados, e ja joga os produtos direto na lista
    private List<Product> products = Arrays.asList( 
        new Product(1, "Product 1", "descrição 1",1, 100.50, true, false),
        new Product(2, "Product 2", "descrição 2",2, 200.50, false, false),
        new Product(3, "Product 3", "descrição 3",3,  300.50, true, true));

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
