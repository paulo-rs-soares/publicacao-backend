package com.fabricio.domain.mapper;

import com.fabricio.domain.Produto;
import com.fabricio.domain.dto.ProdutoDTO;
import com.fabricio.domain.enums.Categoria;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class ProdutoMapper {

    public static Produto fromDto(final Produto.Builder builder, final ProdutoDTO dto) {
        return builder
                .nome(dto.nome())
                .categoria(Categoria.valueOf(dto.categoria()))
                .build();
    }

    public static ProdutoDTO toDto(final Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getCategoria().name());
    }

}
