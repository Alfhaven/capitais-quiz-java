package quiz.repository.impl;

import jakarta.persistence.EntityManager;
import quiz.model.Pais;
import quiz.repository.IPaisRepository;
import quiz.sql.JPAUtil;

import java.util.List;

public class PaisRepositoryJPA implements IPaisRepository {

    @Override
    public void salvar(Pais pais) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pais);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Pais> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Pais", Pais.class).getResultList();
        } finally {
            em.close();
        }
    }
}
