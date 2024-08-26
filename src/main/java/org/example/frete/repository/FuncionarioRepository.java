package org.example.frete.repository;

import org.example.frete.entity.Funcionario;

import javax.persistence.EntityManager;
import java.util.List;

public class FuncionarioRepository {

    private final EntityManager manager;
    private DAOGenerico<Funcionario> daoGenerico;

    public FuncionarioRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Funcionario buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Funcionario.class, id);
    }

    public List<Funcionario> buscaPorNome(String nome) {
        return this.manager.createQuery("from Funcionario where upper(nome) like :nome", Funcionario.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Funcionario salvaOuAtualiza(Funcionario funcionario) {
        return daoGenerico.salvaOuAtualiza(funcionario);
    }

    public void remove(Funcionario funcionario) {
        daoGenerico.remove(funcionario);
    }
}
