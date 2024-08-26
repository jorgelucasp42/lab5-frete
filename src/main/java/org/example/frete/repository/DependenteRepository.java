package org.example.frete.repository;

import org.example.frete.entity.Dependente;

import javax.persistence.EntityManager;
import java.util.List;

public class DependenteRepository {

    private final EntityManager manager;
    private DAOGenerico<Dependente> daoGenerico;

    public DependenteRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Dependente buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Dependente.class, id);
    }

    public List<Dependente> buscaPorNome(String nome) {
        return this.manager.createQuery("from Dependente where upper(nome) like :nome", Dependente.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Dependente salvaOuAtualiza(Dependente dependente) {
        return daoGenerico.salvaOuAtualiza(dependente);
    }

    public void remove(Dependente dependente) {
        daoGenerico.remove(dependente);
    }
}
