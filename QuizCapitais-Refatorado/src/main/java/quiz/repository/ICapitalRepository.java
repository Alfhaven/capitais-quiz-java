package quiz.repository;

import quiz.model.Capital;
import java.util.List;

public interface ICapitalRepository {

    void salvar(Capital capital);

    List<Capital> buscarTodasCapitaisFederais();

    List<Capital> buscarCapitaisErradas(Long idCorreta);

    List<Capital> buscarTodos();
}
