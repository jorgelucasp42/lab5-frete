package org.example.frete.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.util.Set;
import java.util.LinkedHashSet;

@Data @SuperBuilder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Funcionario extends PessoaFisica {

    private int matricula;

    @OneToMany(mappedBy = "funcionario")
    private Set<Dependente> dependentes = new LinkedHashSet<>();
}
