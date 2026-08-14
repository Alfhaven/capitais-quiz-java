package quiz.service;

import quiz.model.ResultadoQuiz;
import quiz.model.Usuario;
import quiz.repository.IResultadoQuizRepository;

import java.time.LocalDateTime;

/**
 * Extraído do método privado salvarPontuacao() que existia dentro de
 * QuizForm. A tela não deveria saber montar um ResultadoQuiz nem
 * conversar diretamente com a persistência (SRP): agora ela só chama
 * pontuacaoService.registrar(usuario, pontuacao).
 */
public class PontuacaoService {

    private final IResultadoQuizRepository resultadoQuizRepository;

    public PontuacaoService(IResultadoQuizRepository resultadoQuizRepository) {
        this.resultadoQuizRepository = resultadoQuizRepository;
    }

    public void registrar(Usuario usuario, int pontuacao) {
        ResultadoQuiz resultado = new ResultadoQuiz();
        resultado.setUsuario(usuario);
        resultado.setPontuacao(pontuacao);
        resultado.setData(LocalDateTime.now());
        resultadoQuizRepository.salvar(resultado);
    }
}
