package ua.mk.nepomnyachshaya.datalayer.publisher;

import ua.mk.nepomnyachshaya.model.Publisher;

import java.util.List;

/**
 *
 */
public interface PublisherDAO {
    public Publisher add (Publisher publisher);
    public void delete(long Id);
    public Publisher update(Publisher periodicals);
    public Publisher get(long Id);
    public List<Publisher> getAll();
}
