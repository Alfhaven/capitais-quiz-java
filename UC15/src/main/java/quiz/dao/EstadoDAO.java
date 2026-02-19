/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import quiz.model.Estado;
import quiz.sql.JPAUtil;

/**
 *
 * @author freit
 */
public class EstadoDAO {
    public void salvar(Estado continente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(continente);
        em.getTransaction().commit();
        em.close();
    }

    public List<Estado> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Estado> lista =
            em.createQuery("FROM Continente", Estado.class)
              .getResultList();
        em.close();
        return lista;
    }
}
