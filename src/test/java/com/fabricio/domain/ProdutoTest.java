package com.fabricio.domain;

import com.fabricio.domain.enums.Categoria;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ProdutoTest {


    @Test
    public void shouldCreate() {
        final UUID id = UUID.randomUUID();
        final String nome = "TESTE";
        final Categoria categoria = Categoria.ELETRONICO;

        final Produto produto = Produto.Builder.create()
                .id(id)
                .nome(nome)
                .categoria(categoria)
                .build();

        assertNotNull(produto);
        assertEquals(id, produto.getId());
        assertEquals(nome, produto.getNome());
        assertEquals(categoria, produto.getCategoria());
    }

}
