package ua.mk.nepomnyachshaya.controllers.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.nepomnyachshaya.datalayer.book.BookDAO;
import ua.mk.nepomnyachshaya.datalayer.publisher.PublisherDAO;
import ua.mk.nepomnyachshaya.model.Book;
import ua.mk.nepomnyachshaya.model.Publisher;

import javax.validation.Valid;
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
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private PublisherDAO publisherDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getBooks() {
//        Publisher publisher1=publisherDAO.get(1);
//        Book book1=new Book("first book", 2017,"12-36-9-9", null, publisher1);
//        bookDAO.add(book1);
        ModelAndView modelAndView = new ModelAndView("book/index");
        List<Book> books = bookDAO.getAll();
        for (Book book : books) {
            Publisher publisher = publisherDAO.getPublisherByBookId(book.getId());
            book.setPublisher(publisher);
        }
        BookFromView book = new BookFromView();
        modelAndView.addObject("books", books);
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", false);
        modelAndView.addObject("content", "");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView saveNewBook(BookFromView bookFromClient) {
        Book book1 = new Book();
        book1.setName(bookFromClient.getName());
        book1.setDescription(bookFromClient.getDescription());
        book1.setYear(Integer.parseInt(bookFromClient.getYear()));
        book1.setIsbnOrIssn(bookFromClient.getIsbn());
        book1.setPublisher(publisherDAO.get(Integer.parseInt(bookFromClient.getPublisher())));
        Book bookFromDB = bookDAO.add(book1);
        ModelAndView modelAndView = new ModelAndView("book/index");
        List<Book> books = bookDAO.getAll();
        for (Book book : books) {
            Publisher publisher = publisherDAO.getPublisherByBookId(book.getId());
            book.setPublisher(publisher);
        }
        BookFromView book = new BookFromView();
        modelAndView.addObject("books", books);
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", true);
        modelAndView.addObject("content", "Created:" + bookFromDB.toString());
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getBook(@PathVariable Integer id) {
        Book book = bookDAO.get(id);
        Publisher publisher = publisherDAO.getPublisherByBookId(id);
        book.setPublisher(publisher);
        ModelAndView modelAndView = new ModelAndView("book/bookform");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", false);
        modelAndView.addObject("content", "");
        return modelAndView;
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ModelAndView updateBook(@RequestBody String json, @PathVariable Integer id) throws IOException {
        Map<String, String> myMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        myMap = objectMapper.readValue(json, HashMap.class);
        Book book = new Book();
        book.setId(new Integer(myMap.get("id")));
        book.setName(myMap.get("name"));
        book.setDescription(myMap.get("description"));
        book.setYear(new Integer(myMap.get("year")));
        book.setIsbnOrIssn(myMap.get("isbnOrIssn"));
        book.setPublisher(publisherDAO.get(new Integer(myMap.get("publisherId"))));

        ModelAndView modelAndView = valid(book, new DirectFieldBindingResult(book, "book"));
        return modelAndView;
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ModelAndView deleteBook(@RequestBody String json, @PathVariable Integer id) throws IOException {
        Map<String, String> myMap = new HashMap<String, String>();
        ObjectMapper objectMapper = new ObjectMapper();
        myMap = objectMapper.readValue(json, HashMap.class);
        Book book = new Book();
        book.setId(id);
        book.setName(myMap.get("name"));
        book.setDescription(myMap.get("description"));
        book.setYear(new Integer(myMap.get("year")));
        book.setIsbnOrIssn(myMap.get("isbnOrIssn"));
        book.setPublisher(publisherDAO.get(new Integer(myMap.get("publisherId"))));
        Book bookFromDB = bookDAO.get(id);
        String content;
        bookDAO.delete(id);
        content = "Book has been deleted";
        return new ModelAndView("book/bookform")
                .addObject("book", book)
                .addObject("message", true)
                .addObject("content", content);
    }

    /**
     * This method will provide Publisher list to views
     */
    @ModelAttribute("publ")
    public List<Publisher> initializePublishers() {
        return publisherDAO.getAll();
    }


    private ModelAndView valid(@Valid Book book, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("book/bookform");
        System.out.println(result.toString());
        if (result.hasErrors()) {
            modelAndView.addObject("book", book);
            modelAndView.addObject("errors", result);
            modelAndView.addObject("message", true);
            modelAndView.addObject("content", "Sended book has errors");
        } else {
            book = bookDAO.update(book);
            modelAndView.addObject("book", book);
            modelAndView.addObject("message", true);
            modelAndView.addObject("content", "Book has been edited");
        }
        return modelAndView;
    }


}