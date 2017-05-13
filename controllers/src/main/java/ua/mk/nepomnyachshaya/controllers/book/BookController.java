package ua.mk.nepomnyachshaya.controllers.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.nepomnyachshaya.datalayer.book.BookDAO;
import ua.mk.nepomnyachshaya.datalayer.publisher.PublisherDAO;
import ua.mk.nepomnyachshaya.model.Book;
import ua.mk.nepomnyachshaya.model.Publisher;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {
    @ Autowired
    private BookDAO bookDAO;
    @ Autowired
    private PublisherDAO publisherDAO;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getBooks() {
        ModelAndView modelAndView=new ModelAndView("book/index");
        List<Book> books=bookDAO.getAll();
        for (Book book:books) {
            Publisher publisher=publisherDAO.getPublisherByBookId(book.getId());
            book.setPublisher(publisher);
        }
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getBook(@PathVariable Integer id) {
        Book book=bookDAO.get(id);
        Publisher publisher=publisherDAO.getPublisherByBookId(id);
        book.setPublisher(publisher);
        ModelAndView modelAndView=new ModelAndView("book/bookform");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT )
    public ModelAndView updateBook(@RequestBody String json, @PathVariable Integer id) throws IOException {
        Map<String,String> myMap = new HashMap<String, String>();
        ObjectMapper objectMapper = new ObjectMapper();
        myMap = objectMapper.readValue(json, HashMap.class);
        Book book = new Book();
        book.setId(new Integer(myMap.get("id")));
        book.setName(myMap.get("name"));
        book.setDescription(myMap.get("description"));
        book.setYear(new Integer(myMap.get("year")));
        book.setIsbnOrIssn(myMap.get("isbnOrIssn"));
        book.setPublisher(publisherDAO.get(new Integer(myMap.get("publisherId"))));
        bookDAO.update(book);
//        List<Book> books=bookDAO.getAll();
//        for (Book b:books) {
//            Publisher publisher=publisherDAO.getPublisherByBookId(b.getId());
//            b.setPublisher(publisher);
//        }
        return  new ModelAndView("forward:/book/");
//                .addObject("books", books);
    }

    /**
     * This method will provide Publisher list to views
     */
    @ModelAttribute("publ")
    public List<Publisher> initializePublishers() {
        return publisherDAO.getAll();
    }

}