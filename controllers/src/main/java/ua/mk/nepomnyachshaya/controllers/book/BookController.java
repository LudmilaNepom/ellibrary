package ua.mk.nepomnyachshaya.controllers.book;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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

@EnableGlobalMethodSecurity(securedEnabled = true)
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
        BookFromView bookFromView = new BookFromView();
        modelAndView.addObject("books", books);
        modelAndView.addObject("bookFromView", bookFromView);
        modelAndView.addObject("message", false);
        modelAndView.addObject("content", "");
        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @JsonView
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "text/html")
    public String saveNewBook(@RequestBody @Valid BookFromView bookFromView, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            List<Book> books = bookDAO.getAll();
            for (Book book1 : books) {
                Publisher publisher = publisherDAO.getPublisherByBookId(book1.getId());
                book1.setPublisher(publisher);
            }

            model.addAttribute("books", books);
            model.addAttribute("bookFromView", bookFromView);
            model.addAttribute("errors", result);
            model.addAttribute("message", true);
            model.addAttribute("content", "Sended book has errors");
        } else {
            Book book = new Book();
            book.setName(bookFromView.getName());
            book.setDescription(bookFromView.getDescription());
            book.setYear(Integer.parseInt(bookFromView.getYear()));
            book.setIsbnOrIssn(bookFromView.getIsbnOrIssn());
            book.setPublisher(publisherDAO.get(Integer.parseInt(bookFromView.getPublisherId())));
            Book bookFromDB=bookDAO.add(book);
            List<Book> books = bookDAO.getAll();
            for (Book book1 : books) {
                Publisher publisher = publisherDAO.getPublisherByBookId(book1.getId());
                book1.setPublisher(publisher);
            }
            bookFromView = new BookFromView();
            model.addAttribute("books", books);
            model.addAttribute("bookFromView", bookFromView);
            model.addAttribute("message", true);
            model.addAttribute("content", "Created:" + bookFromDB.toString());
        }
        return "book/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getBook(@PathVariable Integer id) {
        Book book = bookDAO.get(id);
        Publisher publisher = publisherDAO.getPublisherByBookId(id);
        book.setPublisher(publisher);
        BookFromView bookFromView = new BookFromView();
        bookFromView.setId(Integer.toString(id));
        bookFromView.setName(book.getName());
        bookFromView.setIsbnOrIssn(book.getIsbnOrIssn());
        bookFromView.setDescription(book.getDescription());
        bookFromView.setYear(book.getYear().toString());
        bookFromView.setPublisherId(book.getPublisher().getId().toString());
        ModelAndView modelAndView = new ModelAndView("book/bookform");
        modelAndView.addObject("bookFromView", bookFromView);
        modelAndView.addObject("message", false);
        modelAndView.addObject("content", "");
        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @JsonView
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT, consumes = "application/json", produces = "text/html;charset=UTF-8")
    public String updateBook(@RequestBody @Valid BookFromView bookFromView, BindingResult result, ModelMap model,
                             @PathVariable Integer id) {


        if (result.hasErrors()) {
            model.addAttribute("bookFromView", bookFromView);
            model.addAttribute("errors", result);
            model.addAttribute("message", true);
            model.addAttribute("content", "Sended book has errors");
        } else {
            Book book1 = new Book();
            book1.setId(id);
            book1.setName(bookFromView.getName());
            book1.setDescription(bookFromView.getDescription());
            book1.setYear(Integer.parseInt(bookFromView.getYear()));
            book1.setIsbnOrIssn(bookFromView.getIsbnOrIssn());
            book1.setPublisher(publisherDAO.get(Integer.parseInt(bookFromView.getPublisherId())));
            bookDAO.update(book1);
            model.addAttribute("bookFromView", bookFromView);
            model.addAttribute("message", true);
            model.addAttribute("content", "Book has been edited");
        }
        return "book/bookform";
    }

    @Secured("ROLE_ADMIN")
    @JsonView
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public String deleteBook(@RequestBody BookFromView bookFromView, @PathVariable Integer id,
                                   ModelMap model) throws IOException {
        Map<String, String> myMap = new HashMap<String, String>();
        String content;
        try {
            bookDAO.get(id);
            bookDAO.delete(id);
        } catch (Exception e) {
            content = "Book with such id does not exist";
            model.addAttribute("bookFromView", bookFromView)
                .addAttribute("message", true)
                .addAttribute("content", content);
            return "book/bookform";
        }
        content = "This book has been deleted";
        model.addAttribute("bookFromView", bookFromView)
                .addAttribute("message", true)
                .addAttribute("content", content);
        return "book/bookform";

    }

    /**
     * This method will provide Publisher list to views
     */
    @ModelAttribute("publ")
    public List<Publisher> initializePublishers() {
        return publisherDAO.getAll();
    }
}