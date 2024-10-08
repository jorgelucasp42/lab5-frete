package org.example.frete.entity;

import lombok.*;
import javax.persistence.*;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Veiculo implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numeroPlaca;

    @ManyToOne
    @NonNull
    private Filial filial;

    @ManyToOne
    @NonNull
    private TipoVeiculo tipoVeiculo;

    @Override
    public Integer getId() {
        return id;
    }
}
