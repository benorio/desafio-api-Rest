package desafio.ApiPet.dto;

import desafio.ApiPet.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TutorDto {


    private Long id;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nome;
    @NotEmpty
    @CPF
    private String cpf;
    @NotEmpty
    @Valid
    private List<PetDto> pets;
}
