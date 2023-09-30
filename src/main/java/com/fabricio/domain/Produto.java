package com.fabricio.domain;

import com.fabricio.domain.enums.Categoria;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CATEGORIA")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Produto() {
    }

    public Produto(final UUID id, final String nome, final Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }


    public static final class Builder {
        private Produto produto;

        private Builder(final Produto produto) {
            this.produto = produto;
        }

        public static Builder create() {
            return new Builder(new Produto());
        }

        public static Builder from(final Produto produto) {
            return new Builder(produto);
        }

        public Builder id(UUID id) {
            this.produto.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.produto.nome = nome;
            return this;
        }

        public Builder categoria(Categoria categoria) {
            this.produto.categoria = categoria;
            return this;
        }

        public Produto build() {
            return produto;
        }
    }
}
