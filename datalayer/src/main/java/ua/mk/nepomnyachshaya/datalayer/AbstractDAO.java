package ua.mk.nepomnyachshaya.datalayer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;



/**
 *
 */
public abstract class AbstractDAO  <T> {
    @PersistenceContext
    protected EntityManager em;
    private Class<T> type;

    public AbstractDAO (Class<T> type) {
        this.type = type;
    }

    public T add(T object) {
        em.getTransaction().begin();
        T objectFromDB = em.merge(object);
        em.getTransaction().commit();
        return objectFromDB;
    }

    public void delete(long Id) {
        em.getTransaction().begin();
        em.remove(get(Id));
        em.getTransaction().commit();
    }

    public T update(T b) {
        em.getTransaction().begin();
        em.merge(b);
        em.getTransaction().commit();
        return b;
    }

    public T get(long Id) {
        return em.find(type, Id);
    }

    public List<T> getAll() {
        TypedQuery<T> namedQuery = em.createNamedQuery(type.getSimpleName()+".getAll", type);
        return namedQuery.getResultList();
    }
}
