package org.example.frete.repository;

import org.example.frete.entity.ItemFrete;

import javax.persistence.EntityManager;
import java.util.List;

public class ItemFreteRepository {

    private final EntityManager manager;
    private DAOGenerico<ItemFrete> daoGenerico;

    public ItemFreteRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public ItemFrete buscaPor(Integer id) {
        return daoGenerico.buscaPorId(ItemFrete.class, id);
    }

    public List<ItemFrete> buscaPorDescricao(String descricao) {
        return this.manager.createQuery("from ItemFrete where upper(descricao) like :descricao", ItemFrete.class)
                .setParameter("descricao", descricao.toUpperCase() + "%")
                .getResultList();
    }

    public ItemFrete salvaOuAtualiza(ItemFrete itemFrete) {
        return daoGenerico.salvaOuAtualiza(itemFrete);
    }

    public void remove(ItemFrete itemFrete) {
        daoGenerico.remove(itemFrete);
    }
}

