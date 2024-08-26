package org.example.frete.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Set;
import java.util.LinkedHashSet;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Filial implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String endereco;
    private String telefone;

    @OneToMany(mappedBy = "filial")
    private Set<Veiculo> veiculos = new LinkedHashSet<>();

    @Override
    public Integer getId() {
        return id;
    }
}
