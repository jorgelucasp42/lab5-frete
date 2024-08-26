package org.example.frete.repository;

import org.example.frete.entity.Filial;
import javax.persistence.EntityManager;
import java.util.List;

public class FilialRepository {

    private final EntityManager manager;
    private DAOGenerico<Filial> daoGenerico;

    public FilialRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Filial buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Filial.class, id);
    }

    public List<Filial> buscaPorNome(String nome) {
        return this.manager.createQuery("from Filial where upper(nome) like :nome", Filial.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Filial salvaOuAtualiza(Filial filial) {
        return daoGenerico.salvaOuAtualiza(filial);
    }

    public void remove(Filial filial) {
        daoGenerico.remove(filial);
    }
}
