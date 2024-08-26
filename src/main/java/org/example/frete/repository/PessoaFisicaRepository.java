package org.example.frete.repository;

import org.example.frete.entity.PessoaFisica;

import javax.persistence.EntityManager;
import java.util.List;

public class PessoaFisicaRepository {

    private final EntityManager manager;
    private DAOGenerico<PessoaFisica> daoGenerico;

    public PessoaFisicaRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public PessoaFisica buscaPor(Integer id) {
        return daoGenerico.buscaPorId(PessoaFisica.class, id);
    }

    public List<PessoaFisica> buscaPorNome(String nome) {
        return this.manager.createQuery("from PessoaFisica where upper(nome) like :nome", PessoaFisica.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public PessoaFisica salvaOuAtualiza(PessoaFisica pessoaFisica) {
        return daoGenerico.salvaOuAtualiza(pessoaFisica);
    }

    public void remove(PessoaFisica pessoaFisica) {
        daoGenerico.remove(pessoaFisica);
    }
}
