package desafio.ApiPet.mapper;

import desafio.ApiPet.dto.TutorDto;
import desafio.ApiPet.entity.Tutor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TutorMapper {

    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);


    Tutor toModel(TutorDto tutorDto);

    TutorDto toDTO(Tutor tutor);
}
