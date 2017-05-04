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

}

