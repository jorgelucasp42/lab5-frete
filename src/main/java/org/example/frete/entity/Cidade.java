package org.example.frete.entity;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Cidade implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uf;
    private String nome;
    private String estado;

    @Override
    public Integer getId() {
        return id;
    }
}
