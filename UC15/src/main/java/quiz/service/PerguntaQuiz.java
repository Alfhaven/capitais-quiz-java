package quiz.service;

import quiz.model.Capital;

import java.util.Collections;
import java.util.List;

public class PerguntaQuiz {

    private String enunciado;
    private Capital correta;
    private List<Capital> alternativas;

    public PerguntaQuiz(String enunciado, Capital correta, List<Capital> alternativas) {
        this.enunciado = enunciado;
        this.correta = correta;
        this.alternativas = alternativas;
        Collections.shuffle(this.alternativas);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<Capital> getAlternativas() {
        return alternativas;
    }

    public boolean verificarResposta(Capital escolhida) {
        return correta.getId().equals(escolhida.getId());
    }
    public Capital getCorreta() {
    return correta;
}

}
