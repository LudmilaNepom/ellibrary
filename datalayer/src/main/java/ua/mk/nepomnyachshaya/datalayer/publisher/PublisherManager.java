package ua.mk.nepomnyachshaya.datalayer.publisher;

import org.springframework.stereotype.Repository;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.Publisher;

/**
 *
 */

@Repository
public class PublisherManager extends AbstractDAO<Publisher> implements PublisherDAO{

    public PublisherManager(){
        super(Publisher.class);
    }
    public Publisher getPublisherByBookId(long id){
        Publisher publisherByBookId=(Publisher) em.createNativeQuery("SELECT p.* " +
                "FROM Publisher p " +
                "JOIN  Book b on p.id=b.publisher_id " +
                "WHERE b.id=?", Publisher.class)
                .setParameter(1, id)
                .getSingleResult();
        return publisherByBookId;
    }
}

