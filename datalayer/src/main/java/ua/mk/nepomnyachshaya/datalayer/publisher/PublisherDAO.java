package ua.mk.nepomnyachshaya.datalayer.publisher;

import ua.mk.nepomnyachshaya.model.Publisher;

import java.util.List;

/**
 *
 */
public interface PublisherDAO {
     Publisher add (Publisher publisher);
     void delete(long Id);
     Publisher update(Publisher periodicals);
     Publisher get(long Id);
     List<Publisher> getAll();
     Publisher getPublisherByBookId(long id);
}
