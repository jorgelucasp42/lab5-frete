package org.example.frete.repository;

import org.example.frete.entity.Distancia;

import javax.persistence.EntityManager;
import java.util.List;

public class DistanciaRepository {

    private final EntityManager manager;
    private DAOGenerico<Distancia> daoGenerico;

    public DistanciaRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Distancia buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Distancia.class, id);
    }

    public List<Distancia> buscaPorQuilometragem(int quilometros) {
        return this.manager.createQuery("from Distancia where quilometros = :quilometros", Distancia.class)
                .setParameter("quilometros", quilometros)
                .getResultList();
    }

    public Distancia salvaOuAtualiza(Distancia distancia) {
        return daoGenerico.salvaOuAtualiza(distancia);
    }

    public void remove(Distancia distancia) {
        daoGenerico.remove(distancia);
    }
}
