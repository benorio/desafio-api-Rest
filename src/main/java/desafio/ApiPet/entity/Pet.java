package desafio.ApiPet.entity;

import desafio.ApiPet.enums.Sexo;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String dataNascimento;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexoDoPet;
}
