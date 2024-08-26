package org.example.frete.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Dependente implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private LocalDate dataNascimento;

    @ManyToOne
    private Funcionario funcionario;

    @Override
    public Integer getId() {
        return id;
    }
}
