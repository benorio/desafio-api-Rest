package desafio.ApiPet.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TutorNotFoundException extends Exception {
    public TutorNotFoundException(Long id) {

        super("Tutor not found with Id " + id);

    }
}
