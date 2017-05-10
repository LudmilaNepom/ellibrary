package ua.mk.nepomnyachshaya.controllers.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getBooks() {
        return new ModelAndView("book/index");
    }
}
