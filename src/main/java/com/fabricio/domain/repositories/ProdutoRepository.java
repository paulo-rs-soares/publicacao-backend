package com.fabricio.domain.repositories;

import com.fabricio.domain.Produto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class ProdutoRepository {

    @Inject
    private EntityManager em;

    public List<Produto> findAll() {
        return em.createQuery("select p from Produto p").getResultList();
    }

    public void save(final Produto produto) {
        em.persist(produto);
    }

}
