package quiz.repository.impl;

import jakarta.persistence.EntityManager;
import quiz.model.Estado;
import quiz.repository.IEstadoRepository;
import quiz.sql.JPAUtil;

import java.util.List;

/**
 * Equivale ao antigo EstadoDAO. Corrige o bug de copy-paste em que
 * buscarTodos() executava "FROM Continente" e mapeava o resultado
 * para Estado.class.
 */
public class EstadoRepositoryJPA implements IEstadoRepository {

    @Override
    public void salvar(Estado estado) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(estado);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Estado> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Estado", Estado.class).getResultList();
        } finally {
            em.close();
        }
    }
}
