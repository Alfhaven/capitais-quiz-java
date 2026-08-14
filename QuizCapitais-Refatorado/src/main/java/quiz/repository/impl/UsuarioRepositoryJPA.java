package quiz.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import quiz.model.Usuario;
import quiz.repository.IUsuarioRepository;
import quiz.sql.JPAUtil;

/**
 * Implementação concreta de IUsuarioRepository usando JPA/Hibernate.
 * Equivale ao antigo UsuarioDAO, mas agora:
 *  - implementa uma interface (DIP);
 *  - não tem mais os dois métodos duplicados salvar()/cadastrar() que
 *    faziam exatamente a mesma coisa (code smell: Duplicate Code);
 *  - não usa mais e.printStackTrace() (code smell: log inadequado).
 */
public class UsuarioRepositoryJPA implements IUsuarioRepository {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(UsuarioRepositoryJPA.class.getName());

    @Override
    public void salvar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Usuario buscarPorLogin(String login) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT u FROM Usuario u WHERE u.login = :login",
                Usuario.class
            ).setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Usuario autenticar(String login, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha",
                Usuario.class
            );
            query.setParameter("login", login);
            query.setParameter("senha", senha);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public long contarUsuarios() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT COUNT(u) FROM Usuario u", Long.class)
                      .getSingleResult();
        } finally {
            em.close();
        }
    }
}
