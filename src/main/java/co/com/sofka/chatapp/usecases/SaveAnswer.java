package co.com.sofka.chatapp.usecases;

import co.com.sofka.chatapp.model.AnswerDTO;
import co.com.sofka.chatapp.model.QuestionDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveAnswer {
    Mono<QuestionDTO> apply(@Valid AnswerDTO answerDTO);
}
