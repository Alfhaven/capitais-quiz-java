package quiz.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import quiz.model.Capital;
import quiz.sql.JPAUtil;

import java.util.List;
import java.util.Random;

public class CapitalDAO {

    public List<Capital> buscarTodasCapitaisFederais() {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        return em.createQuery(
            "SELECT c FROM Capital c WHERE c.tipo = 'federal'",
            Capital.class
        ).getResultList();
    } finally {
        em.close();
    }
}

    
    public Capital buscarCapitalFederalAleatoria() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Capital> query = em.createQuery(
                "SELECT c FROM Capital c WHERE c.tipo = 'federal'", Capital.class
            );

            List<Capital> capitais = query.getResultList();
            if (capitais.isEmpty()) return null;

            return capitais.get(new Random().nextInt(capitais.size()));
        } finally {
            em.close();
        }
    }

    public List<Capital> buscarCapitaisErradas(Long idCorreta) {
    EntityManager em = JPAUtil.getEntityManager();
    return em.createQuery(
        "SELECT c FROM Capital c " +
        "WHERE c.id <> :id AND c.tipo = 'federal'",
        Capital.class
    )
    .setParameter("id", idCorreta)
    .setMaxResults(10) // pega várias, o service escolhe
    .getResultList();
}
public void salvar(Capital continente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(continente);
        em.getTransaction().commit();
        em.close();
    }

    public List<Capital> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Capital> lista =
            em.createQuery("FROM Continente", Capital.class)
              .getResultList();
        em.close();
        return lista;
    }
}
