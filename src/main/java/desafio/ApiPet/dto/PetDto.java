package desafio.ApiPet.dto;

import desafio.ApiPet.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    private Long id;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nome;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String dataNascimento;
    @Enumerated(EnumType.STRING)
    private Sexo sexoDoPet;
}
