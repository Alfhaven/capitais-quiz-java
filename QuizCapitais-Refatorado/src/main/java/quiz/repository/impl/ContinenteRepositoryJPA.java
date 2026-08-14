package quiz.repository.impl;

import jakarta.persistence.EntityManager;
import quiz.model.Continente;
import quiz.repository.IContinenteRepository;
import quiz.sql.JPAUtil;

import java.util.List;

public class ContinenteRepositoryJPA implements IContinenteRepository {

    @Override
    public void salvar(Continente continente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(continente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Continente> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Continente", Continente.class).getResultList();
        } finally {
            em.close();
        }
    }
}
