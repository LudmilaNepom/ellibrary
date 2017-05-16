package ua.mk.nepomnyachshaya.datalayer;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 *
 */
public abstract class AbstractDAO<T> {

    @PersistenceContext
//            (type = PersistenceContextType.EXTENDED)
    protected EntityManager em;
    private Class<T> type;

    public AbstractDAO(Class<T> type) {
        this.type = type;
    }

    @Transactional
    public T add(T object) {
//        em.getTransaction().begin();
        T objectFromDB = em.merge(object);
//        em.getTransaction().commit();
        return objectFromDB;
    }
    @Transactional
    public void delete(int Id) {
//        em.getTransaction().begin();
        em.remove(get(Id));
//        em.getTransaction().commit();
    }
    @Transactional
    public T update(T b) {
//        em.getTransaction().begin();
        em.merge(b);
//        em.getTransaction().commit();
        return b;
    }
    @Transactional(readOnly = true)
    public T get(int Id) {
        return em.find(type, Id);
    }

    @Transactional(readOnly = true)
    public List<T> getAll() {
        TypedQuery<T> namedQuery = em.createNamedQuery(type.getSimpleName() + ".getAll", type);
        return namedQuery.getResultList();
    }
}
