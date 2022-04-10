package pl.sda.database;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private EntityManagerProvider(){}

    public static EntityManager getEntityManager() {
        return HibernateUtil.getSessionFactory().createEntityManager();
    }
}
