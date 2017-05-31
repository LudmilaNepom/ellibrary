package ua.mk.nepomnyachshaya.controllers.book;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
@EnableWebMvc
@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private PublisherDAO publisherDAO;
    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getBooks() {
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
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView saveNewBook(BookFromView bookFromClient) {
        Book book1 = new Book();
        book1.setName(bookFromClient.getName());
        book1.setDescription(bookFromClient.getDescription());
        book1.setYear(Integer.parseInt(bookFromClient.getYear()));
        book1.setIsbnOrIssn(bookFromClient.getIsbnOrIssn());
        book1.setPublisher(publisherDAO.get(Integer.parseInt(bookFromClient.getPublisherId())));
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
        BookFromView bookFromView=new BookFromView();
        bookFromView.setId(Integer.toString(id) );
        bookFromView.setName(book.getName());
        bookFromView.setIsbnOrIssn(book.getIsbnOrIssn());
        bookFromView.setDescription(book.getDescription());
        bookFromView.setYear(book.getYear().toString());
        bookFromView.setPublisherId(book.getPublisher().getId().toString());
        ModelAndView modelAndView = new ModelAndView("book/bookform");
        modelAndView.addObject("book", bookFromView);
        modelAndView.addObject("message", false);
        modelAndView.addObject("content", "");
        return modelAndView;
    }
    @Secured("ROLE_ADMIN")
    @JsonView
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT, consumes = "application/json", produces = "text/html")
    public String updateBook(@RequestBody @Valid BookFromView bookFromView, BindingResult result, ModelMap model,
                                   @PathVariable Integer id) {

        System.out.println(bookFromView.toString());
        Book book1 = new Book();
        book1.setId(id);
        book1.setName(bookFromView.getName());
        book1.setDescription(bookFromView.getDescription());
        book1.setYear(Integer.parseInt(bookFromView.getYear()));
        book1.setIsbnOrIssn(bookFromView.getIsbnOrIssn());
        book1.setPublisher(publisherDAO.get(Integer.parseInt(bookFromView.getPublisherId())));
//        Book bookFromDB = bookDAO.update(book1);
//        ModelAndView modelAndView = new ModelAndView("book/bookform");
        System.out.println(book1.toString() + "/n" + result.toString());
        if (result.hasErrors()) {
            model.addAttribute("book", bookFromView);
            model.addAttribute("errors", result);
            model.addAttribute("message", true);
            model.addAttribute("content", "Sended book has errors");

        } else {
            Book bookFromDB = bookDAO.update(book1);
            bookFromView=new BookFromView();
            bookFromView.setId(Integer.toString(id) );
            bookFromView.setName(bookFromDB.getName());
            bookFromView.setIsbnOrIssn(bookFromDB.getName());
            bookFromView.setDescription(bookFromDB.getDescription());
            bookFromView.setYear(bookFromDB.getYear().toString());
            bookFromView.setPublisherId(bookFromDB.getPublisher().getId().toString());
            model.addAttribute("book", bookFromView);
            model.addAttribute("message", true);
            model.addAttribute("content", "Book has been edited");


        }
        return "book/bookform";
    }
    @Secured("ROLE_ADMIN")
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
}