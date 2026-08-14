package quiz.service;

import quiz.model.Usuario;
import quiz.repository.IUsuarioRepository;

/**
 * Regra de negócio de cadastro de novos jogadores, extraída do handler
 * jbttCadastrarActionPerformed de CadastroForm. A tela agora só coleta
 * os campos digitados e delega a validação para cá.
 */
public class CadastroService {

    private final IUsuarioRepository usuarioRepository;

    public CadastroService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarJogador(String login, char[] senha, char[] confirmarSenha)
            throws CadastroInvalidoException {

        if (login == null || login.isBlank() || senha == null || senha.length == 0) {
            throw new CadastroInvalidoException("Preencha todos os campos.");
        }

        if (!java.util.Arrays.equals(senha, confirmarSenha)) {
            throw new CadastroInvalidoException("As senhas não coincidem!");
        }

        if (usuarioRepository.buscarPorLogin(login.trim()) != null) {
            throw new CadastroInvalidoException("Login já existe!");
        }

        Usuario usuario = new Usuario();
        usuario.setLogin(login.trim());
        usuario.setSenha(new String(senha)); // recomendação: aplicar hash (ex. BCrypt) antes de salvar
        usuario.setTipo("jogador");

        usuarioRepository.salvar(usuario);
        return usuario;
    }
}
