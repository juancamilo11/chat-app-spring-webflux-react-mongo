package co.com.sofka.chatapp.usecases;

import co.com.sofka.chatapp.model.QuestionDTO;
import co.com.sofka.chatapp.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class ListUseCase implements Supplier<Flux<QuestionDTO>> {
    private final QuestionRepository questionRepository;
    private final MapperUtils mapperUtils;

    public ListUseCase(MapperUtils mapperUtils, QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<QuestionDTO> get() {
        return questionRepository.findAll()
                .map(mapperUtils.mapEntityToQuestion());
    }

}
