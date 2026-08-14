package quiz.service;

import quiz.model.Usuario;
import quiz.repository.IUsuarioRepository;

/**
 * Regra de negócio de autenticação, extraída do método autenticar()
 * que antes vivia dentro de LoginForm (Single Responsibility Principle:
 * a tela passa a cuidar só de eventos/visual, e esta classe cuida só
 * da regra "quem pode entrar no sistema").
 *
 * Depende da abstração IUsuarioRepository (Dependency Inversion
 * Principle), não da implementação JPA — o que permite testar esta
 * classe com um repositório falso, sem banco de dados.
 */
public class AutenticacaoService {

    private final IUsuarioRepository usuarioRepository;

    public AutenticacaoService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * @return o Usuario autenticado, ou null se login/senha inválidos.
     */
    public Usuario autenticar(String login, String senha) {
        if (login == null || login.isBlank() || senha == null || senha.isBlank()) {
            return null;
        }
        return usuarioRepository.autenticar(login, senha);
    }

    public boolean isAdministrador(Usuario usuario) {
        String tipo = usuario.getTipo();
        return "admin".equalsIgnoreCase(tipo) || "administrador".equalsIgnoreCase(tipo);
    }

    public boolean isJogador(Usuario usuario) {
        String tipo = usuario.getTipo();
        return "jogador".equalsIgnoreCase(tipo) || "usuario".equalsIgnoreCase(tipo);
    }
}
