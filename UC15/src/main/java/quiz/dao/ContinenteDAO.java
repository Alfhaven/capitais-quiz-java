/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import quiz.model.Continente;
import quiz.sql.JPAUtil;

/**
 *
 * @author freit
 */
public class ContinenteDAO {
    public void salvar(Continente continente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(continente);
        em.getTransaction().commit();
        em.close();
    }

    public List<Continente> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Continente> lista =
            em.createQuery("FROM Continente", Continente.class)
              .getResultList();
        em.close();
        return lista;
    }
}
