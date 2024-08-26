package org.example.frete.repository;

import org.example.frete.entity.Cidade;

import javax.persistence.EntityManager;
import java.util.List;

public class CidadeRepository {

    private final EntityManager manager;
    private DAOGenerico<Cidade> daoGenerico;

    public CidadeRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Cidade buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Cidade.class, id);
    }

    public List<Cidade> buscaPorNome(String nome) {
        return this.manager.createQuery("from Cidade where upper(nome) like :nome", Cidade.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Cidade salvaOuAtualiza(Cidade cidade) {
        return daoGenerico.salvaOuAtualiza(cidade);
    }

    public void remove(Cidade cidade) {
        daoGenerico.remove(cidade);
    }
    public int buscaPorDistancia(Cidade origem, Cidade destino) {
        return this.manager.createQuery("select d.quilometros from Distancia d where d.cidadeOrigem = :origem and d.cidadeDestino = :destino", Integer.class)
                .setParameter("origem", origem)
                .setParameter("destino", destino)
                .getSingleResult();
    }

}
