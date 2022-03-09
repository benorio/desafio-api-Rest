package desafio.ApiPet.controller;

import desafio.ApiPet.dto.MessageResponseDto;
import desafio.ApiPet.dto.TutorDto;
import desafio.ApiPet.entity.Tutor;
import desafio.ApiPet.service.TutorService;
import desafio.ApiPet.service.exception.TutorNotFoundException;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tutor")
@AllArgsConstructor(onConstructor = @__(Autowired))
public class TutorController {

    private TutorService tutorService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createTutor(@RequestBody @Valid TutorDto tutorDto){
        return tutorService.createTutor(tutorDto);
    }

    @GetMapping
    public List<TutorDto> listAll(){
        return tutorService.listAll();
    }

    @GetMapping("/{id}")
    public TutorDto findById(@PathVariable Long id) throws TutorNotFoundException {
        return tutorService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws TutorNotFoundException {
        tutorService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDto updateById(@PathVariable Long id,@RequestBody TutorDto tutorDto) throws TutorNotFoundException {
        return tutorService.updateById(id, tutorDto);
    }
}
