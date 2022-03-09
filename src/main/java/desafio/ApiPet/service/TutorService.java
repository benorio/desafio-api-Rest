package desafio.ApiPet.service;

import desafio.ApiPet.dto.MessageResponseDto;
import desafio.ApiPet.dto.TutorDto;
import desafio.ApiPet.entity.Tutor;
import desafio.ApiPet.mapper.TutorMapper;
import desafio.ApiPet.repository.TutorRepository;
import desafio.ApiPet.service.exception.TutorNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(Autowired))
public class TutorService {

    private TutorRepository tutorRepository;

    private final TutorMapper tutorMapper = TutorMapper.INSTANCE;


    public MessageResponseDto createTutor(TutorDto tutorDto){

        Tutor tutorToSave = tutorMapper.toModel(tutorDto);

        Tutor savedTutor = tutorRepository.save(tutorToSave);
        return MessageResponseDto
                .builder()
                .message("Create Tutor with ID " + savedTutor.getId())
                .build();
    }

    public List<TutorDto> listAll() {
        List<Tutor> allTutor = tutorRepository.findAll();
        return allTutor.stream()
                .map(tutorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TutorDto findById(Long id) throws TutorNotFoundException {

        Tutor tutor =  verifyIfExists(id);
//        Optional<Tutor> optionalTutor = tutorRepository.findById(id);
//

        return tutorMapper.toDTO(tutor);
    }

    public void delete(Long id) throws TutorNotFoundException {
        tutorRepository.findById(id).orElseThrow(()-> new TutorNotFoundException(id));

        tutorRepository.deleteById(id);
    }

    public MessageResponseDto updateById(Long id, TutorDto tutorDto) throws TutorNotFoundException {
        verifyIfExists(id);

        Tutor tutorToUpdate = tutorMapper.toModel(tutorDto);

        Tutor updatedTutor = tutorRepository.save(tutorToUpdate);
        return createMessageResponse(updatedTutor.getId(), "Updated tutor with id ");
    }

    private Tutor verifyIfExists(long id) throws TutorNotFoundException{
        return tutorRepository.findById(id).orElseThrow(()
                -> new TutorNotFoundException(id));
    }

    private MessageResponseDto createMessageResponse(Long id, String s) {
        return MessageResponseDto
                .builder()
                .message(s + id)
                .build();
    }
}
