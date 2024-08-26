package org.example.frete.entity;

import lombok.*;
import javax.persistence.*;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class TipoVeiculo implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;
    private float pesoMaximo;

    @Override
    public Integer getId() {
        return id;
    }
}

