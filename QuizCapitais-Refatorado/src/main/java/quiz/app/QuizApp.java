package quiz.app;

import javax.swing.UnsupportedLookAndFeelException;
import quiz.model.Usuario;
import quiz.repository.impl.UsuarioRepositoryJPA;
import quiz.service.AutenticacaoService;
import quiz.ui.LoginForm;

/**
 * Ponto de entrada da aplicação (composition root). É o único lugar
 * "autorizado" a fazer "new XyzRepositoryJPA()" para montar o grafo de
 * dependências antes de abrir a primeira tela — as demais classes
 * recebem tudo pronto via injeção de dependência pelo construtor.
 *
 * Equivale ao antigo quiz.app.QuizApp do projeto desktop, mantendo a
 * mesma responsabilidade de criar os usuários iniciais (admin/jogador)
 * na primeira execução.
 */
public class QuizApp {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(QuizApp.class.getName());

    public static void main(String[] args) {

        UsuarioRepositoryJPA usuarioRepository = new UsuarioRepositoryJPA();
        criarUsuariosIniciais(usuarioRepository);

        aplicarNimbusLookAndFeel();

        java.awt.EventQueue.invokeLater(() -> {
            LoginForm loginForm = new LoginForm(new AutenticacaoService(usuarioRepository));
            loginForm.setVisible(true);
        });
    }

    private static void criarUsuariosIniciais(UsuarioRepositoryJPA usuarioRepository) {
        if (usuarioRepository.contarUsuarios() == 0) {

            Usuario admin = new Usuario();
            admin.setLogin("admin");
            admin.setSenha("admin");
            admin.setTipo("admin");

            Usuario jogador = new Usuario();
            jogador.setLogin("jogador");
            jogador.setSenha("jogador");
            jogador.setTipo("jogador");

            usuarioRepository.salvar(admin);
            usuarioRepository.salvar(jogador);
        }
    }

    private static void aplicarNimbusLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.WARNING, "Não foi possível aplicar o Nimbus Look and Feel", ex);
        }
    }
}
