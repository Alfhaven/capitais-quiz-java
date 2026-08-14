package quiz.repository;

import quiz.model.Estado;
import java.util.List;

public interface IEstadoRepository {
    void salvar(Estado estado);
    List<Estado> buscarTodos();
}
