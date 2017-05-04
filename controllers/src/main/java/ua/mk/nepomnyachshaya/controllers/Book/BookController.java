package ua.mk.nepomnyachshaya.controllers.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.nepomnyachshaya.datalayer.book.BookDAO;
import ua.mk.nepomnyachshaya.model.Book;

import java.util.List;

/**
 *
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {
    private BookDAO bookDAO;
    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getBooks() {
        ModelAndView modelAndView=new ModelAndView("book/index");
        List<Book> books=bookDAO.getAll();
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    }
