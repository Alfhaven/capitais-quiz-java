package quiz.repository;

import quiz.model.Pais;
import java.util.List;

public interface IPaisRepository {
    void salvar(Pais pais);
    List<Pais> buscarTodos();
}
