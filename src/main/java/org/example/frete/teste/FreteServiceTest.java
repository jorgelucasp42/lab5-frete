package org.example.frete.teste;

import org.example.frete.entity.Cliente;
import org.example.frete.entity.Frete;
import org.example.frete.entity.Cidade;
import org.example.frete.entity.CategoriaFrete;
import org.example.frete.repository.FreteRepository;
import org.example.frete.service.FreteService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class FreteServiceTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab_jpa");
        EntityManager em = emf.createEntityManager();

        try {
            FreteService freteService = new FreteService(em);

            // Exemplo: Teste de registro de frete
            Frete frete = new Frete();
            frete.setCidadeOrigem(new Cidade());  // Substituir com instância válida
            frete.setCidadeDestino(new Cidade()); // Substituir com instância válida
            frete.setCategoriaFrete(new CategoriaFrete()); // Substituir com instância válida
            frete.setValorKmRodado(BigDecimal.valueOf(10));

            Frete freteRegistrado = freteService.registraFrete(frete);
            System.out.println("Frete registrado: " + freteRegistrado);

            // Exemplo: Teste de busca de fretes por cliente
            Cliente cliente = new Cliente();
            cliente.setId(1); // Supondo que o cliente com ID 1 existe

            List<Frete> fretesDoCliente = freteService.buscarFretesPorCliente(cliente);
            System.out.println("Fretes do cliente: " + fretesDoCliente);

            // Exemplo: Teste de busca de frete por ID
            Frete freteBuscado = freteService.buscaPorId(1); // Supondo que o frete com ID 1 existe
            System.out.println("Frete buscado: " + freteBuscado);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

