/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.app;

import javax.swing.UnsupportedLookAndFeelException;
import quiz.dao.UsuarioDAO;
import quiz.model.Usuario;
import quiz.ui.LoginForm;

/**
 *
 * @author freit
 */
public class QuizApp {
    public static void main(String args[]) {

    // Cria usuários iniciais (roda só uma vez se já existirem)
    criarUsuariosIniciais();

    /* Look and Feel */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info :
                javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
    }

    /* Abre a tela de login */
    java.awt.EventQueue.invokeLater(() -> {
        new LoginForm().setVisible(true);
    });
}

    private static void criarUsuariosIniciais() {
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    if (usuarioDAO.contarUsuarios() == 0) {

        Usuario admin = new Usuario();
        admin.setLogin("admin");
        admin.setSenha("admin");
        admin.setTipo("admin");

        Usuario jogador = new Usuario();
        jogador.setLogin("jogador");
        jogador.setSenha("jogador");
        jogador.setTipo("jogador");

        usuarioDAO.cadastrar(admin);
        usuarioDAO.cadastrar(jogador);
    }
}


}
