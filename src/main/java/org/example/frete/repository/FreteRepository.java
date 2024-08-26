package org.example.frete.repository;

import org.example.frete.entity.Frete;

import javax.persistence.EntityManager;
import java.util.List;

public class FreteRepository {

    private final EntityManager manager;
    private DAOGenerico<Frete> daoGenerico;

    public FreteRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Frete buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Frete.class, id);
    }

    public List<Frete> buscaPorNumeroNotaFiscal(Integer numeroNotaFiscal) {
        return this.manager.createQuery("from Frete where numeroNotaFiscal = :numeroNotaFiscal", Frete.class)
                .setParameter("numeroNotaFiscal", numeroNotaFiscal)
                .getResultList();
    }

    public Frete salvaOuAtualiza(Frete frete) {
        return daoGenerico.salvaOuAtualiza(frete);
    }

    public void remove(Frete frete) {
        daoGenerico.remove(frete);
    }
    public List<Frete> buscarFretesPorCliente(Integer clienteId) {
        return this.manager.createQuery("from Frete where cliente.id = :clienteId", Frete.class)
                .setParameter("clienteId", clienteId)
                .getResultList();
    }

}
