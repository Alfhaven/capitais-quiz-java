package quiz.repository.impl;

import jakarta.persistence.EntityManager;
import quiz.model.Capital;
import quiz.model.TipoCapital;
import quiz.repository.ICapitalRepository;
import quiz.sql.JPAUtil;

import java.util.List;

/**
 * Implementação concreta de ICapitalRepository usando JPA/Hibernate.
 * Equivale ao antigo CapitalDAO, com dois bugs corrigidos:
 *  1) buscarTodasCapitaisFederais() comparava "c.tipo = 'federal'" (String
 *     minúscula) com um enum salvo como STRING em maiúsculas (FEDERAL),
 *     o que nunca retornava resultado. Agora usa o parâmetro
 *     TipoCapital.FEDERAL corretamente tipado.
 *  2) buscarTodos() fazia "FROM Continente" (JPQL copiado e colado de
 *     ContinenteDAO) mas mapeava o resultado para Capital.class — erro
 *     de execução. Agora usa "FROM Capital" corretamente.
 */
public class CapitalRepositoryJPA implements ICapitalRepository {

    @Override
    public void salvar(Capital capital) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(capital);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Capital> buscarTodasCapitaisFederais() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT c FROM Capital c WHERE c.tipo = :tipo",
                Capital.class
            ).setParameter("tipo", TipoCapital.FEDERAL).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Capital> buscarCapitaisErradas(Long idCorreta) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT c FROM Capital c WHERE c.id <> :id AND c.tipo = :tipo",
                Capital.class
            ).setParameter("id", idCorreta)
             .setParameter("tipo", TipoCapital.FEDERAL)
             .setMaxResults(10)
             .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Capital> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Capital", Capital.class).getResultList();
        } finally {
            em.close();
        }
    }
}
