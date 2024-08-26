package org.example.frete.repository;

import org.example.frete.entity.CategoriaFrete;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaFreteRepository {

    private final EntityManager manager;
    private DAOGenerico<CategoriaFrete> daoGenerico;

    public CategoriaFreteRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public CategoriaFrete buscaPor(Integer id) {
        return daoGenerico.buscaPorId(CategoriaFrete.class, id);
    }

    public List<CategoriaFrete> buscaPorNome(String nome) {
        return this.manager.createQuery("from CategoriaFrete where upper(nome) like :nome", CategoriaFrete.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public CategoriaFrete salvaOuAtualiza(CategoriaFrete categoriaFrete) {
        return daoGenerico.salvaOuAtualiza(categoriaFrete);
    }

    public void remove(CategoriaFrete categoriaFrete) {
        daoGenerico.remove(categoriaFrete);
    }
}

