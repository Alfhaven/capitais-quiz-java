package quiz.repository.impl;

import jakarta.persistence.EntityManager;
import quiz.model.ResultadoQuiz;
import quiz.repository.IResultadoQuizRepository;
import quiz.sql.JPAUtil;

public class ResultadoQuizRepositoryJPA implements IResultadoQuizRepository {

    @Override
    public void salvar(ResultadoQuiz resultado) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(resultado);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
