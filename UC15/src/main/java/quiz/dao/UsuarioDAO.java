package quiz.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import quiz.model.Usuario;
import quiz.sql.JPAUtil;

public class UsuarioDAO {
    public void salvar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Usuario buscarPorLogin(String login) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT u FROM Usuario u WHERE u.login = :login",
                Usuario.class
            ).setParameter("login", login)
             .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
    public Usuario getUsuario(String login, String senha) {
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
        return null; // 👈 ISSO É ESSENCIAL
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        em.close();
    }
}
    
    public void cadastrar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public long contarUsuarios() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT COUNT(u) FROM Usuario u", Long.class).getSingleResult();
        } finally {
            em.close();
        }
    }
}
