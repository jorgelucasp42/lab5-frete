package org.example.frete.repository;

import org.example.frete.entity.Veiculo;

import javax.persistence.EntityManager;
import java.util.List;

public class VeiculoRepository {

    private final EntityManager manager;
    private DAOGenerico<Veiculo> daoGenerico;

    public VeiculoRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Veiculo buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Veiculo.class, id);
    }

    public List<Veiculo> buscaPorPlaca(String numeroPlaca) {
        return this.manager.createQuery("from Veiculo where upper(numeroPlaca) like :placa", Veiculo.class)
                .setParameter("placa", numeroPlaca.toUpperCase() + "%")
                .getResultList();
    }

    public Veiculo salvaOuAtualiza(Veiculo veiculo) {
        return daoGenerico.salvaOuAtualiza(veiculo);
    }

    public void remove(Veiculo veiculo) {
        daoGenerico.remove(veiculo);
    }
}

