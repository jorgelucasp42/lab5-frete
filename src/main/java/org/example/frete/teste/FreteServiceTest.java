package org.example.frete.teste;

import org.example.frete.entity.*;
import org.example.frete.repository.*;
import org.example.frete.service.FreteService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class FreteServiceTest {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab_jpa");
    private static final EntityManager em = emf.createEntityManager();
    private static final FreteService freteService = new FreteService(em);
    private static final CidadeRepository cidadeRepository = new CidadeRepository(em);
    private static final CategoriaFreteRepository categoriaFreteRepository = new CategoriaFreteRepository(em);
    private static final DistanciaRepository distanciaRepository = new DistanciaRepository(em);
    private static final ClienteRepository clienteRepository = new ClienteRepository(em);
    private static final VeiculoRepository veiculoRepository = new VeiculoRepository(em);
    private static final TipoVeiculoRepository tipoVeiculoRepository = new TipoVeiculoRepository(em);
    private static final FilialRepository filialRepository = new FilialRepository(em);

    public static void main(String[] args) {

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            CategoriaFrete categoriaFrete = CategoriaFrete.builder().nome("Mobília").descricao("Móveis e eletrodomésticos").percentualAdicional(20).build();
            categoriaFrete = categoriaFreteRepository.salvaOuAtualiza(categoriaFrete);

            Cidade cidadeOrigem = Cidade.builder().nome("São Paulo").uf("SP").estado("São Paulo").build();
            Cidade cidadeDestino = Cidade.builder().nome("Rio de Janeiro").uf("RJ").estado("Rio de Janeiro").build();
            cidadeOrigem = cidadeRepository.salvaOuAtualiza(cidadeOrigem);
            cidadeDestino = cidadeRepository.salvaOuAtualiza(cidadeDestino);

            Distancia distancia = Distancia.builder().cidadeOrigem(cidadeOrigem).cidadeDestino(cidadeDestino).quilometros(50).build();
            distanciaRepository.salvaOuAtualiza(distancia);

            Cliente cliente = Cliente.builder().nome("João").cpf("99999999999").email("joao@example.com").ativo(true).build();
            cliente = clienteRepository.salvaOuAtualiza(cliente);

            Filial filial = Filial.builder().nome("Frete Corps").endereco("Av. Cicrano").telefone("99999-9999").build();
            filial = filialRepository.salvaOuAtualiza(filial);

            TipoVeiculo tipoVeiculo = TipoVeiculo.builder().descricao("Caminhonetes").pesoMaximo(450).build();
            tipoVeiculo = tipoVeiculoRepository.salvaOuAtualiza(tipoVeiculo);

            Veiculo veiculo = Veiculo.builder().tipoVeiculo(tipoVeiculo).numeroPlaca("AOB123").filial(filial).build();
            veiculo = veiculoRepository.salvaOuAtualiza(veiculo);

            // Exemplo: Teste de registro de frete
            Frete frete = Frete.builder().cidadeOrigem(cidadeOrigem).cidadeDestino(cidadeDestino)
                    .categoriaFrete(categoriaFrete)
                    .valorKmRodado(BigDecimal.valueOf(10))
                    .cliente(cliente)
                    .veiculo(veiculo)
                    .build();

            Frete freteRegistrado = freteService.registraFrete(frete);
            System.out.println("Frete registrado: " + freteRegistrado);


            List<Frete> fretesDoCliente = freteService.buscarFretesPorCliente(cliente);
            System.out.println("Fretes do cliente: " + fretesDoCliente);

            // Exemplo: Teste de busca de frete por ID
            Frete freteBuscado = freteService.buscaPorId(1); // Supondo que o frete com ID 1 existe
            System.out.println("Frete buscado: " + freteBuscado);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

