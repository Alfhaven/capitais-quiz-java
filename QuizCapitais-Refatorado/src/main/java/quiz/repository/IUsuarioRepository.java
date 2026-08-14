package quiz.repository;

import quiz.model.Usuario;

/**
 * Contrato de persistência para Usuario.
 *
 * Princípio SOLID aplicado: Dependency Inversion Principle (DIP) e
 * Interface Segregation Principle (ISP).
 * As camadas de serviço (AutenticacaoService, CadastroService) dependem
 * desta abstração, e não da implementação concreta com JPA/Hibernate.
 * Isso permite trocar a implementação (ex.: por um repositório em
 * memória usado em testes) sem alterar quem usa o repositório.
 */
public interface IUsuarioRepository {

    void salvar(Usuario usuario);

    Usuario buscarPorLogin(String login);

    Usuario autenticar(String login, String senha);

    long contarUsuarios();
}
