package quiz.dao;

import jakarta.persistence.EntityManager;
import quiz.model.ResultadoQuiz;
import quiz.sql.JPAUtil;

public class ResultadoQuizDAO {

    public void salvar(ResultadoQuiz resultado) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(resultado);
        em.getTransaction().commit();
        em.close();
    }
}
