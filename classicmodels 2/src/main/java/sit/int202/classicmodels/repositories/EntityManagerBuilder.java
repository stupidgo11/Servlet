package sit.int202.classicmodels.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels.entities.Environment;

public class EntityManagerBuilder {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
