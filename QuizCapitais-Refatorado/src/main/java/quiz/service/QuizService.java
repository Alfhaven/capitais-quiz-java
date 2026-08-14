package quiz.service;

import quiz.model.Capital;
import quiz.repository.ICapitalRepository;

import java.util.*;

/**
 * Regra de negócio de geração de perguntas do quiz.
 *
 * Diferenças em relação à versão original (quiz.dao no projeto desktop):
 *  - depende de ICapitalRepository (interface), não de CapitalDAO
 *    diretamente -> Dependency Inversion Principle;
 *  - o repositório é recebido no construtor (injeção de dependência),
 *    em vez de instanciado internamente com "new CapitalDAO()" -> mais
 *    fácil de testar e de trocar a fonte de dados;
 *  - não guarda mais estado de "pontuação"/"pergunta atual" que é
 *    responsabilidade da tela (QuizForm), mantendo a única
 *    responsabilidade desta classe: montar uma PerguntaQuiz válida.
 */
public class QuizService {

    private final ICapitalRepository capitalRepository;
    private final Set<Long> capitaisUsadas = new HashSet<>();

    public QuizService(ICapitalRepository capitalRepository) {
        this.capitalRepository = capitalRepository;
    }

    public PerguntaQuiz gerarPerguntaCapitalFederal() {

        List<Capital> todas = new ArrayList<>(capitalRepository.buscarTodasCapitaisFederais());
        todas.removeIf(c -> capitaisUsadas.contains(c.getId()));

        if (todas.isEmpty()) {
            return null;
        }

        Capital correta = todas.get(new Random().nextInt(todas.size()));
        capitaisUsadas.add(correta.getId());

        List<Capital> erradas = capitalRepository.buscarCapitaisErradas(correta.getId());

        if (erradas.size() < 3) {
            // não gera pergunta inválida com menos de 4 alternativas
            return null;
        }

        Collections.shuffle(erradas);

        List<Capital> alternativas = new ArrayList<>();
        alternativas.add(correta);
        alternativas.addAll(erradas.subList(0, 3));

        Collections.shuffle(alternativas);

        return new PerguntaQuiz(
            "Qual é a capital de " + correta.getPais().getNome() + "?",
            correta,
            alternativas
        );
    }

    public void reiniciar() {
        capitaisUsadas.clear();
    }
}
