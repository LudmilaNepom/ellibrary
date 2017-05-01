package ua.mk.nepomnyachshaya.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 09.03.2017.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello() {
        System.out.println("method is working");
        return new ModelAndView("index");
    }
    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public ModelAndView getAuthors() {
        return new ModelAndView("author");
    }
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ModelAndView getBooks() {
        return new ModelAndView("book");
    }
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView getCategories() {
        return new ModelAndView("category");
    }
}
