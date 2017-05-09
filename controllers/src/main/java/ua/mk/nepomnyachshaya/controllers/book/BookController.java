package ua.mk.nepomnyachshaya.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.nepomnyachshaya.datalayer.book.BookDAO;
import ua.mk.nepomnyachshaya.datalayer.publisher.PublisherDAO;
import ua.mk.nepomnyachshaya.model.Book;
import ua.mk.nepomnyachshaya.model.Publisher;

import java.util.List;

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
        modelAndView.addObject(book);
        return modelAndView;
    }

    @RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
    public String updateBook(Book book) {
        Book bookFromDB=bookDAO.update(book);
      return "/";
    }


    /**
     * This method will provide Publisher list to views
     */
    @ModelAttribute("publ")
    public List<Publisher> initializePublishers() {
        return publisherDAO.getAll();
    }

    }
