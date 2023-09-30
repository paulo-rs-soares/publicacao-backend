package com.fabricio.resource;

import com.fabricio.domain.Produto;
import com.fabricio.domain.dto.ProdutoDTO;
import com.fabricio.domain.mapper.ProdutoMapper;
import com.fabricio.domain.repositories.ProdutoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.spi.ContentType;

import java.util.List;

@Path("api/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    private ProdutoRepository repository;

    @GET
    public Response findAll() {
        final List<Produto> produtos = repository.findAll();
        final List<ProdutoDTO> dtos = produtos.stream()
                .map(ProdutoMapper::toDto)
                .toList();

        return Response.ok(dtos).build();
    }

    @POST
    @Transactional
    public Response create(final ProdutoDTO dto) {
        final Produto produto = ProdutoMapper.fromDto(Produto.Builder.create(), dto);
        repository.save(produto);

        return Response.status(201).build();
    }

}
