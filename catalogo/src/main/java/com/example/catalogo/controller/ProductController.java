package com.example.catalogo.controller;
import com.example.catalogo.product.Product;
import com.example.catalogo.product.ProductRepository;
import com.example.catalogo.product.ProductRequestDTO;
import com.example.catalogo.product.ProductResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// INDICA QUE ESTA CLASSE É O CONTROLLER DA APLICAÇÃO:
@RestController
// MAPEANDO OS REQUESTS PRODUCT:
@RequestMapping("product")

public class ProductController {
    // CRIANDO INSTANCIA DE REPOSITORY:
    private ProductRepository repository;

    // MÉTODO PRA POST:
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveProduct(@RequestBody ProductRequestDTO data){
        Product productData = new Product(data);
        repository.save(productData);
        return;

    }

    // CLASSE DO TIPO LIST QUE SERÁ EXECUTADO QUANDO CHEGAR AO ENDPOINT PRODUCT E VAI RETORNAR UMA LISTA DE REPOSITORY:
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProductResponseDTO> getAll(){
        // DESENVOLVENDO UMA LIST DE PRODUTOS DE ENTIDADE PRODUCT:
        List<ProductResponseDTO> productList = repository.findAll().stream().map(ProductResponseDTO::new).toList();
        return productList;
    }
}
