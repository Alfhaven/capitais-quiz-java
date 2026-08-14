package quiz.fake;

import quiz.model.ResultadoQuiz;
import quiz.repository.IResultadoQuizRepository;

import java.util.ArrayList;
import java.util.List;

public class ResultadoQuizRepositoryFake implements IResultadoQuizRepository {

    private final List<ResultadoQuiz> resultados = new ArrayList<>();

    @Override
    public void salvar(ResultadoQuiz resultado) {
        resultados.add(resultado);
    }

    public List<ResultadoQuiz> listar() {
        return resultados;
    }
}
