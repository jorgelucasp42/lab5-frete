package org.example.frete.repository;

import org.example.frete.entity.TipoVeiculo;

import javax.persistence.EntityManager;
import java.util.List;

public class TipoVeiculoRepository {

    private final EntityManager manager;
    private DAOGenerico<TipoVeiculo> daoGenerico;

    public TipoVeiculoRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public TipoVeiculo buscaPor(Integer id) {
        return daoGenerico.buscaPorId(TipoVeiculo.class, id);
    }

    public List<TipoVeiculo> buscaPorDescricao(String descricao) {
        return this.manager.createQuery("from TipoVeiculo where upper(descricao) like :descricao", TipoVeiculo.class)
                .setParameter("descricao", descricao.toUpperCase() + "%")
                .getResultList();
    }

    public TipoVeiculo salvaOuAtualiza(TipoVeiculo tipoVeiculo) {
        return daoGenerico.salvaOuAtualiza(tipoVeiculo);
    }

    public void remove(TipoVeiculo tipoVeiculo) {
        daoGenerico.remove(tipoVeiculo);
    }
}

