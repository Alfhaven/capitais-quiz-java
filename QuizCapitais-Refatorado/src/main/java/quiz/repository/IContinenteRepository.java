package quiz.repository;

import quiz.model.Continente;
import java.util.List;

public interface IContinenteRepository {
    void salvar(Continente continente);
    List<Continente> buscarTodos();
}
