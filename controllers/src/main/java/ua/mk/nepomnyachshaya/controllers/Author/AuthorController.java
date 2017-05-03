package ua.mk.nepomnyachshaya.controllers.Author;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
@RequestMapping(value ="/author" )
public class AuthorController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAuthors() {
        return new ModelAndView("author/index");
    }
}
