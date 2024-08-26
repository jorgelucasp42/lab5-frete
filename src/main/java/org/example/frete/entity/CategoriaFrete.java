package org.example.frete.entity;

import lombok.*;
import javax.persistence.*;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class CategoriaFrete implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String descricao;
    private float percentualAdicional;

    @Override
    public Integer getId() {
        return id;
    }
}

