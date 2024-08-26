package org.example.frete.service;

import org.example.frete.entity.Cliente;
import org.example.frete.entity.Frete;
import org.example.frete.entity.CategoriaFrete;
import org.example.frete.repository.FreteRepository;
import org.example.frete.repository.CidadeRepository;
import org.example.frete.repository.CategoriaFreteRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class FreteService {

    private final FreteRepository freteRepository;
    private final CidadeRepository cidadeRepository;
    private final CategoriaFreteRepository categoriaFreteRepository;

    public FreteService(EntityManager manager) {
        this.freteRepository = new FreteRepository(manager);
        this.cidadeRepository = new CidadeRepository(manager);
        this.categoriaFreteRepository = new CategoriaFreteRepository(manager);
    }

    /**
     * Registra um novo frete no sistema.
     */
    public Frete registraFrete(Frete frete) {

        // Certifique-se de que as cidades de origem e destino estão salvas
        if (frete.getCidadeOrigem().getId() == null) {
            frete.setCidadeOrigem(cidadeRepository.salvaOuAtualiza(frete.getCidadeOrigem()));
        }

        if (frete.getCidadeDestino().getId() == null) {
            frete.setCidadeDestino(cidadeRepository.salvaOuAtualiza(frete.getCidadeDestino()));
        }

        // Salve a CategoriaFrete se necessário
        if (frete.getCategoriaFrete().getId() == null) {
            frete.setCategoriaFrete(categoriaFreteRepository.salvaOuAtualiza(frete.getCategoriaFrete()));
        }

        BigDecimal valorFrete = calcularValorFrete(frete);
        frete.setValorKmRodado(valorFrete);

        // Agora salve o Frete com todas as relações já salvas
        return freteRepository.salvaOuAtualiza(frete);
    }

    /**
     * Calcula o valor do frete com base na distância entre as cidades de origem e destino e na categoria do frete.
     */
    private BigDecimal calcularValorFrete(Frete frete) {
        // Busca a distância entre as cidades de origem e destino
        int distancia = cidadeRepository.buscaPorDistancia(frete.getCidadeOrigem(), frete.getCidadeDestino());

        // Busca o percentual adicional da categoria do frete
        CategoriaFrete categoriaFrete = categoriaFreteRepository.buscaPor(frete.getCategoriaFrete().getId());
        BigDecimal percentualAdicional = BigDecimal.valueOf(categoriaFrete.getPercentualAdicional());

        // Calcula o valor do frete
        BigDecimal valorBase = frete.getValorKmRodado().multiply(BigDecimal.valueOf(distancia));
        return valorBase.multiply(BigDecimal.ONE.add(percentualAdicional.divide(BigDecimal.valueOf(100))));
    }

    /**
     * Retorna uma lista com todos os fretes de um determinado cliente.
     */
    public List<Frete> buscarFretesPorCliente(Cliente cliente) {
        return freteRepository.buscarFretesPorCliente(cliente.getId());
    }

    /**
     * Busca Frete por ID (Recupera os detalhes de um frete específico a partir do seu ID).
     */
    public Frete buscaPorId(Integer id) {
        return freteRepository.buscaPor(id);
    }
}
