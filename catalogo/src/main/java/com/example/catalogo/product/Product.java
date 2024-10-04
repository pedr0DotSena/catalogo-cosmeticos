package com.example.catalogo.product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

// INDICA QUE É UMA ENTIDADE NO BANCO:
@Table(name = "products")
@Entity(name = "products")

// INDICANDO PARA O LOMBOK QUE PRECISO DO MÉTODO GET PARA TODAS AS PROPRIEDADES DESSA CLASSE:
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String imagem;
    private Float preco;

    public Product(ProductRequestDTO data){
        this.imagem = data.imagem();
        this.preco = data.preco();
        this.titulo = data.titulo();
    }
}
