package ua.mk.nepomnyachshaya.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.mk.nepomnyachshaya.datalayer.publisher.PublisherDAO;
import ua.mk.nepomnyachshaya.model.Publisher;

/**
 * A converter class used in views to map id's to actual Publisher objects.
 */
@Component(value = "publToPublisherConverter")
public class PublToPublisherConverter implements Converter<Object, Publisher>{

    @Autowired
    PublisherDAO publisherDAO;

    /**
     * Gets Publisher by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Publisher convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        Publisher publisher= publisherDAO.get(id);
        System.out.println(publisher);
        return publisher;
    }

}