package pl.sda.database;

import pl.sda.database.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractDao<T> {

    private final Class<T> clazz;

    protected AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findById(int id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        T record = entityManager.find(clazz, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return record;
    }

    public List<T> findAll() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        List<T> records =
            entityManager.createQuery("from " + clazz.getCanonicalName(), clazz).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return records;
    }

    public void add(T record) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(record);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(T record) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(record);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(T record) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(record);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
