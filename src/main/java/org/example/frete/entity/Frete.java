package org.example.frete.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.LinkedHashSet;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Frete implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int numeroNotaFiscal;
    private BigDecimal valorKmRodado;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Veiculo veiculo;

    @ManyToOne
    private Cidade cidadeOrigem;

    @ManyToOne
    private Cidade cidadeDestino;

    @ManyToOne
    private Funcionario funcionario;

    @OneToMany
    private Set<ItemFrete> itens = new LinkedHashSet<>();

    @ManyToOne
    private CategoriaFrete categoriaFrete;

    public BigDecimal calcularFrete() {
        // Lógica para calcular o frete com base na distância, valor do km rodado e percentual da categoria
        BigDecimal distancia = new BigDecimal("100"); // Exemplo estático
        return distancia.multiply(valorKmRodado).multiply(new BigDecimal(1 + categoriaFrete.getPercentualAdicional() / 100));
    }

    @Override
    public Integer getId() {
        return id;
    }
}
