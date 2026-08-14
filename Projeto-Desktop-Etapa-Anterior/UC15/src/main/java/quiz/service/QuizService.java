package quiz.service;

import quiz.dao.CapitalDAO;
import quiz.model.Capital;

import java.util.*;

public class QuizService {

    private final CapitalDAO capitalDAO = new CapitalDAO();
    private final Set<Long> capitaisUsadas = new HashSet<>();

    public PerguntaQuiz gerarPerguntaCapitalFederal() {

    List<Capital> todas = capitalDAO.buscarTodasCapitaisFederais();
    todas.removeIf(c -> capitaisUsadas.contains(c.getId()));

    if (todas.isEmpty()) return null;

    Capital correta = todas.get(new Random().nextInt(todas.size()));
    capitaisUsadas.add(correta.getId());

    // busca erradas
    List<Capital> erradas =
        capitalDAO.buscarCapitaisErradas(correta.getId());

    // 🚨 validação crítica
    if (erradas.size() < 3) {
        // não gera pergunta inválida
        return null;
    }

    // embaralha e pega só 3
    Collections.shuffle(erradas);

    List<Capital> alternativas = new ArrayList<>();
    alternativas.add(correta);
    alternativas.addAll(erradas.subList(0, 3));

    // embaralha alternativas finais
    Collections.shuffle(alternativas);

    return new PerguntaQuiz(
        "Qual é a capital de " + correta.getPais().getNome() + "?",
        correta,
        alternativas
    );
}

}
