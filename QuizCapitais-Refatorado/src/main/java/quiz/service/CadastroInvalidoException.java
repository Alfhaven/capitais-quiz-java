package quiz.service;

/**
 * Exceção de negócio lançada quando o cadastro de um novo jogador não
 * pode ser concluído (campos vazios, senhas diferentes ou login já
 * existente). Antes, essas validações ficavam misturadas com chamadas
 * a JOptionPane dentro de CadastroForm; agora a regra vive no serviço
 * e a tela decide apenas COMO mostrar a mensagem (SRP).
 */
public class CadastroInvalidoException extends Exception {
    public CadastroInvalidoException(String mensagem) {
        super(mensagem);
    }
}
