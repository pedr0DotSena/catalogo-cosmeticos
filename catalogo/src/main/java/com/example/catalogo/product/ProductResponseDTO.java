package com.example.catalogo.product;

public record ProductResponseDTO(Long id, String titulo, String imagem, Float preco) {
    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getTitulo(), product.getImagem(), product.getPreco());

    }
}
