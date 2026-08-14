package quiz.fake;

import quiz.model.Usuario;
import quiz.repository.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação em memória de IUsuarioRepository, usada apenas nos
 * testes de TesteMain. Prova, na prática, o Liskov Substitution
 * Principle: qualquer lugar que dependa de IUsuarioRepository
 * (AutenticacaoService, CadastroService) funciona igual com esta
 * implementação fake ou com a implementação JPA real, sem precisar de
 * banco de dados para rodar os testes.
 */
public class UsuarioRepositoryFake implements IUsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public void salvar(Usuario usuario) {
        usuario.setId(proximoId++);
        usuarios.add(usuario);
    }

    @Override
    public Usuario buscarPorLogin(String login) {
        return usuarios.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Usuario autenticar(String login, String senha) {
        return usuarios.stream()
                .filter(u -> u.getLogin().equals(login) && u.getSenha().equals(senha))
                .findFirst()
                .orElse(null);
    }

    @Override
    public long contarUsuarios() {
        return usuarios.size();
    }
}
