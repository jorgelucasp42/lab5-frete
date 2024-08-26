package org.example.frete.entity;

import lombok.*;
import javax.persistence.*;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class ItemFrete implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;
    private float peso;

    @Override
    public Integer getId() {
        return id;
    }
}

