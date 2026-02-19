package quiz.sql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("QuizCapitaisPU");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

    // Fecha o EntityManagerFactory ao encerrar a aplicação
    public static void close() {
        if (FACTORY != null && FACTORY.isOpen()) {
            FACTORY.close();
        }
    }
}
