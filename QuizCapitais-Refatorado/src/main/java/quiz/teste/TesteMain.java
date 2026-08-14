package quiz.teste;

import quiz.fake.CapitalRepositoryFake;
import quiz.fake.ResultadoQuizRepositoryFake;
import quiz.fake.UsuarioRepositoryFake;
import quiz.model.Capital;
import quiz.model.Usuario;
import quiz.service.*;

/**
 * Testes manuais executados no método main(), como pedido na atividade.
 *
 * Rodam totalmente em memória (repositórios fake), sem precisar de
 * MySQL configurado, o que também comprova, na prática, o Dependency
 * Inversion Principle: os mesmos serviços (AutenticacaoService,
 * CadastroService, QuizService, PontuacaoService) funcionam tanto com
 * os repositórios JPA reais quanto com estes repositórios fake, porque
 * dependem apenas das interfaces em quiz.repository.
 *
 * Para rodar: clique com o botão direito nesta classe no NetBeans e
 * escolha "Run File" (ou "Executar Arquivo").
 */
public class TesteMain {

    private static int testesOk = 0;
    private static int testesFalhou = 0;

    public static void main(String[] args) {

        UsuarioRepositoryFake usuarioRepository = new UsuarioRepositoryFake();
        CapitalRepositoryFake capitalRepository = new CapitalRepositoryFake();
        ResultadoQuizRepositoryFake resultadoRepository = new ResultadoQuizRepositoryFake();

        AutenticacaoService autenticacaoService = new AutenticacaoService(usuarioRepository);
        CadastroService cadastroService = new CadastroService(usuarioRepository);
        QuizService quizService = new QuizService(capitalRepository);
        PontuacaoService pontuacaoService = new PontuacaoService(resultadoRepository);

        System.out.println("===== TESTES MANUAIS - QuizCapitais-Refatorado =====\n");

        testeCadastroDeJogador(cadastroService);
        testeCadastroComLoginDuplicado(cadastroService);
        testeCadastroComSenhasDiferentes(cadastroService);
        testeLoginComSucesso(autenticacaoService);
        testeLoginComSenhaErrada(autenticacaoService);
        testeGeracaoDePergunta(quizService);
        testeRespostaCorretaEErrada(quizService);
        testeRegistroDePontuacao(pontuacaoService, resultadoRepository);

        System.out.println("\n===== RESULTADO FINAL: " + testesOk + " OK / " + testesFalhou + " FALHARAM =====");
        if (testesFalhou > 0) {
            System.exit(1);
        }
    }

    private static void testeCadastroDeJogador(CadastroService cadastroService) {
        try {
            Usuario u = cadastroService.cadastrarJogador("alvaro", "123456".toCharArray(), "123456".toCharArray());
            verificar("Cadastro de jogador válido", u != null && "jogador".equals(u.getTipo()));
        } catch (CadastroInvalidoException e) {
            verificar("Cadastro de jogador válido", false, e.getMessage());
        }
    }

    private static void testeCadastroComLoginDuplicado(CadastroService cadastroService) {
        try {
            cadastroService.cadastrarJogador("alvaro", "abc123".toCharArray(), "abc123".toCharArray());
            verificar("Rejeitar login duplicado", false, "deveria ter lançado CadastroInvalidoException");
        } catch (CadastroInvalidoException e) {
            verificar("Rejeitar login duplicado", "Login já existe!".equals(e.getMessage()));
        }
    }

    private static void testeCadastroComSenhasDiferentes(CadastroService cadastroService) {
        try {
            cadastroService.cadastrarJogador("outroUsuario", "111111".toCharArray(), "222222".toCharArray());
            verificar("Rejeitar senhas diferentes", false, "deveria ter lançado CadastroInvalidoException");
        } catch (CadastroInvalidoException e) {
            verificar("Rejeitar senhas diferentes", "As senhas não coincidem!".equals(e.getMessage()));
        }
    }

    private static void testeLoginComSucesso(AutenticacaoService autenticacaoService) {
        Usuario u = autenticacaoService.autenticar("alvaro", "123456");
        verificar("Login com credenciais corretas", u != null && autenticacaoService.isJogador(u));
    }

    private static void testeLoginComSenhaErrada(AutenticacaoService autenticacaoService) {
        Usuario u = autenticacaoService.autenticar("alvaro", "senhaErrada");
        verificar("Login com senha incorreta retorna null", u == null);
    }

    private static void testeGeracaoDePergunta(QuizService quizService) {
        PerguntaQuiz pergunta = quizService.gerarPerguntaCapitalFederal();
        verificar("Geração de pergunta com 4 alternativas",
                pergunta != null && pergunta.getAlternativas().size() == 4);
    }

    private static void testeRespostaCorretaEErrada(QuizService quizService) {
        quizService.reiniciar();
        PerguntaQuiz pergunta = quizService.gerarPerguntaCapitalFederal();
        Capital correta = pergunta.getCorreta();
        Capital errada = pergunta.getAlternativas().stream()
                .filter(c -> !c.getId().equals(correta.getId()))
                .findFirst().orElse(null);

        verificar("verificarResposta() aceita a alternativa correta",
                pergunta.verificarResposta(correta));
        verificar("verificarResposta() rejeita alternativa errada",
                errada != null && !pergunta.verificarResposta(errada));
    }

    private static void testeRegistroDePontuacao(PontuacaoService pontuacaoService,
                                                  ResultadoQuizRepositoryFake resultadoRepository) {
        Usuario usuario = new Usuario("alvaro", "123456", "jogador");
        pontuacaoService.registrar(usuario, 12);
        verificar("Registro de pontuação persiste um resultado",
                resultadoRepository.listar().size() == 1
                && resultadoRepository.listar().get(0).getPontuacao() == 12);
    }

    private static void verificar(String descricaoTeste, boolean condicao) {
        verificar(descricaoTeste, condicao, null);
    }

    private static void verificar(String descricaoTeste, boolean condicao, String detalheFalha) {
        if (condicao) {
            System.out.println("[OK]    " + descricaoTeste);
            testesOk++;
        } else {
            System.out.println("[FALHOU] " + descricaoTeste
                    + (detalheFalha != null ? " -> " + detalheFalha : ""));
            testesFalhou++;
        }
    }
}
