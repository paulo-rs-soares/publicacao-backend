package com.fabricio.domain.dto;

import java.util.UUID;

public record ProdutoDTO(UUID id,
                         String nome,
                         String categoria) {
}
