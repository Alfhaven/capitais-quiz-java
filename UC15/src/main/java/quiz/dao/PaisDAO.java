package quiz.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import quiz.model.Pais;
import quiz.sql.JPAUtil;

public class PaisDAO {

    public void salvar(Pais pais) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(pais);
        em.getTransaction().commit();
        em.close();
    }

    public List<Pais> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Pais> lista =
            em.createQuery("FROM Pais", Pais.class)
              .getResultList();
        em.close();
        return lista;
    }
}
