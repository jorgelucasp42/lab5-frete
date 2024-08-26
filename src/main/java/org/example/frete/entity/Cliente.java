package org.example.frete.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data @SuperBuilder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Cliente extends PessoaFisica {

    private String contato;
    private boolean ativo;
}

